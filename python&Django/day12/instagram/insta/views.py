from django.shortcuts import render , redirect
import requests
from .models import Article, Comment , ArticleImages
def index(request):
    if request.method == 'POST':
        art = Article()
        art.contents = request.POST["contents"]
        #art.image = request.FILES["image"]
        #art.image_resized = request.FILES["image"]
        art.save()
        for image in request.FILES.getlist("image"):
            ArticleImages.objects.create(article_id=art.id,image=image)
        return redirect('/insta/')
    else:
        articles = Article.objects.all().order_by("create_at").reverse()
        context={
            'articles':articles
        }
    return render(request,'index.html',context)
def comments(request):
    if request.method == "POST":
        contents = request.POST['contents']
        article_id=request.POST['article_id']
        this_com = Comment()
        this_com.contents= contents
        this_com.article_id=article_id
        this_com.save()
    return redirect('articles')

def delete_comment(request,comment_id):
    id = comment_id
    target = Comment.objects.get(id=id)
    target.delete()
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
    target.delete()
    return redirect('articles')
def edit_art(request,article_id):
    target = Article.objects.get(id=article_id)
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