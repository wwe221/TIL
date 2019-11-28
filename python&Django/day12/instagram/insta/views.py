from django.shortcuts import render , redirect
from django.http.response import HttpResponse
import requests , json
from .models import Article, Comment , ArticleImages, Board , HashTag

def js_test(request):
    return render(request , 'js_test.html')
    
def jq_test(request):
    boards = Board.objects.all().order_by("created_at").reverse()
    context = {
        'boards': boards
    }
    return render(request, 'jq_test.html', context)
def index(request):
    if request.method == 'POST':
        if request.user.is_authenticated:
            art = Article()
            art.contents = request.POST["contents"]
            art.user_id = request.user.id
            art.save()
            tags = request.POST["tags"]
            for tag in tags.split(','):
                tag = tag.strip()
                if not HashTag.objects.filter(tag=tag):
                    tag = HashTag.objects.create(tag=tag)
                else:
                    tag = HashTag.objects.filter(tag=tag)[0]
                art.tags.add(tag)
            #art.image = request.FILES["image"]
            #art.image_resized = request.FILES["image"]
            for image in request.FILES.getlist("image"):
                ArticleImages.objects.create(article_id=art.id,image=image)
            return redirect('/insta/')
        else:
            return redirect('accounts:login')
    else:
        articles = Article.objects.all().order_by("create_at").reverse()
        context={
            'articles':articles
        }
    return render(request,'index.html',context)
def comments(request):
    if request.method == "POST":
        if request.user.is_authenticated:
            contents = request.POST['contents']
            article_id=request.POST['article_id']
            this_com = Comment()
            this_com.user_id = request.user.id
            this_com.contents= contents
            this_com.article_id=article_id
            this_com.save()
        else:
            return redirect('accounts:login')
    return redirect('articles')

def delete_comment(request,comment_id):
    id = comment_id
    target = Comment.objects.get(id=id)    
    return redirect('articles')
def edit_comment(request,comment_id):
    target = Comment.objects.get(id=comment_id)
    if request.method =="POST" :
        contents = request.POST['contents']                
        target.contents= contents
        target.save()
        return redirect('articles')
    else:
        context ={
            'comment':target
        }
        return render(request,'comment/edit.html', context)
def delete_art(request,article_id):    
    target = Article.objects.get(id=article_id)
    if target.is_permitted(request.user.id):
        target.delete()
        return redirect('articles')
    else:
        return redirect('articles')
def edit_art(request,article_id):
    target = Article.objects.get(id=article_id)
    if target.is_permitted(request.user.id):
        if request.method =="POST" :
            contents = request.POST['contents']
            target.contents= contents
            target.save()
            return redirect('articles')
        else:
            context ={
                'article':target
            }
            return render(request,'article/edit.html', context)
    else:
        return redirect('articles')

def submit_boards(request):
    if request.method == "POST":
        contents = request.POST["board"]
        board = Board.objects.create(contents=contents)
        context = {
            'board': board
        }
        return render(request, 'empty.html', context)
def delete_boards(request):
    if request.method == "POST":
        id = request.POST["board_id"]
        board = Board.objects.get(id=id)
        board.delete()
        context = {
            'board_id':id
        }
        # 삭제를 하면 network 탭에 delete가 오고 preview로 보면 json형식으로 온것을 확인할 수 있음.
        return HttpResponse(json.dumps(context), content_type="appication/json")
def edit_boards(request):
    if request.method == "POST":
        id = request.POST["board_id"]
        contents = request.POST["contents"]
        board = Board.objects.get(id=id)
        board.contents = contents
        board.save()
        return HttpResponse('', status=204)

def jq_comment(request):
    if request.method == "POST":
        if request.user.is_authenticated:
            contents = request.POST['contents']
            article_id=request.POST['article_id']
            this_com = Comment()
            this_com.contents= contents
            this_com.article_id=article_id
            this_com.user_id = request.user.id
            this_com.save()
            context={
                'comments':this_com
            }
            return render(request, 'comment.html', context)
        else:
            context = {
                'status': 401,
                'message': '로그인이 필요합니다.'
            }
            return HttpResponse(json.dumps(context), status=401, content_type='application/json')
def jq_comment_edit(request):
    if request.method == "POST":
        id = request.POST["id"]
        contents = request.POST["contents"]
        board = Comment.objects.get(id=id)
        board.contents = contents
        board.save()
        return HttpResponse('', status=204)
def jq_comment_delete(request):
     if request.method == "POST":
        id = int(request.POST["comment_id"])
        print(id)
        board = Comment.objects.get(id=id)
        if board.user_id == request.user.id:            
            board.delete()
            context = {
                'board_id':id
            }
            # 삭제를 하면 network 탭에 delete가 오고 preview로 보면 json형식으로 온것을 확인할 수 있음.
            return HttpResponse(json.dumps(context), content_type="appication/json")
        else:
            return HttpResponse('',status=401)
def likes(request):
    if request.user.is_authenticated and request.method =="POST":        
        article_id =request.POST["article_id"]
        article = Article.objects.get(id=article_id)
        if request.user in article.user_likes.all():
            article.user_likes.remove(request.user)
        else:
            article.user_likes.add(request.user)
        likes_count = len(article.user_likes.all())
        context={
            'cnt':likes_count
        }
        return HttpResponse(json.dumps(context),status=200,content_type='application/json')
    else:
        return HttpResponse('',status=403)
