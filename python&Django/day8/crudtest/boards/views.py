from django.shortcuts import render, redirect
from .models import Boards
# Create your views here.
def index(request): # 메인페이지 전체 리스트
    b_all = Boards.objects.all()
    return render(request,'index.html', {'objects':b_all})

def new(request):
    return render(request,'new.html')

def create(request):
    title = request.GET['title']
    content = request.GET['contents']
    creator = request.GET['creator']    
    #b = Boards(title= title , contents=content, creator = creator)
    #b.save()
    b = Boards.objects.create(title= title , contents=content, creator = creator)
    context = {
        'result': b
    }
    return redirect(f'/boards/{b.id}')

def show(request, id):    
    board = Boards.objects.get(id=id)
    context={
        'result':board
    }
    return render(request,'show.html',context)
def edit(request , id):
    board = Boards.objects.get(id=id)
    context={
        'result':board
    }
    return render(request,'edit.html',context)
def update(request, id):
    board = Boards.objects.get(id=id)
    title = request.GET['title']
    content = request.GET['contents']
    creator = request.GET['creator']
    board.title = title
    board.contents =content
    board.creator = creator
    board.save()
    return redirect(f'/boards/{id}')
def destroy(request,id):
    board = Boards.objects.get(id=id)
    board.delete()
    return redirect('/boards/')