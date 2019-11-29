from django.shortcuts import render , redirect
from .models import Room,Message
from django.http.response import HttpResponse
import secrets
import json
import pusher
pusher_client = pusher.Pusher(
  app_id='908807',
  key='b103533a85ecae4e3e14',
  secret='##############', ### NEVER UPLOAD TO GIT
  cluster='ap3',
  ssl=True
)
def index(request):
    if request.method =="POST":
        title = request.POST["room-title"]
        max_count = request.POST["room-max-count"]
        code = secrets.token_urlsafe(16)
        room = Room()
        room.title = title
        room.max_connection= max_count
        room.code = code
        room.master_id = request.user.id
        room.save()
        room.users.add(request.user)
        current_con = room.current_con()
        context = {
            'id':room.id,
            'title':title,
            'master': room.master.username,
            'max_count':max_count,
            'current_con':current_con   
        }
        pusher_client.trigger('main', 'room-created', json.dumps(context))
        return HttpResponse('',status=204)
    else:
        # 트리거(채널, 이벤트,값)
        # 해당 채널을 구독하고 있는 녀석에게 이벤트와 값을 넘겨준다.
        rooms = Room.objects.all()
        context={
            'rooms':rooms
        }    
        return render(request , 'index.html' , context)

def show(request, room_id):
    if request.user.is_authenticated :
        room = Room.objects.get(id=room_id)
        room.users.add(request.user)
        join_message = {
            'user': request.user.username,
            'message': '님이 방에 들어왔습니다.'
        }
        pusher_client.trigger(room.code, 'chat', json.dumps(join_message))
        messages= Message.objects.filter(room_id=room.id).order_by("created_at")            
        r = room.current_con()
        con = {
            'room_id': room_id,
            'current_con': r
        }
        pusher_client.trigger('main', 'room-update', json.dumps(con))
        context={     
            'room':room,
            'messages':messages,
        }
        return render(request , 'show.html',context)
    else:
        return redirect('boards:login')
def exit(request, room_id):
    room = Room.objects.get(id=room_id)
    room.users.remove(request.user)
    r = room.current_con()
    con = {
        'room_id': room_id,
        'current_con': r
    }
    pusher_client.trigger('main', 'room-update', json.dumps(con))
    join_message = {
            'user': request.user.username,
            'message': '님이 방에서 나갔습니다.'
        }
    pusher_client.trigger(room.code, 'chat', json.dumps(join_message))
    return redirect('boards:index')
def chat(request):
    id = request.user.id
    contents = request.POST["text"]
    room = Room.objects.get(id=request.POST["room_id"])
    message = Message()
    message.contents=contents
    message.user_id=id
    message.room_id=room.id
    message.save()
    context={
        'user':request.user.username,
        'message':message.contents,        
    }
    pusher_client.trigger(room.code, 'chat', json.dumps(context))
    return HttpResponse('',status=204)