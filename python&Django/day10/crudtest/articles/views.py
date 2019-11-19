from django.shortcuts import render,redirect
import requests
from .models import Article
# Create your views here.
def index(request):
    articles = Article.objects.all()
    context={
        'articles':articles
    }
    return render(request,'index.html',context)

def show(request,id):
    article = Article.objects.get(id=id)
    context={
        'article':article
    }
    return render(request,'show.html',context)

def new(request):
    print(request.method)
    if request.method == 'POST':
        title= request.POST['title']
        contents=request.POST['contents']
        creator=request.POST['creator']
        crsf=request.POST['csrfmiddlewaretoken']
        article=Article.objects.create(title=title,contents=contents,creator=creator)    
        return redirect('/articles/')
    return render(request , 'new.html')

# def create(request):
#     title= request.GET['title']
#     contents=request.GET['contents']
#     creator=request.GET['creator']    
#     article=Article.objects.create(title=title,contents=contents,creator=creator)    
#     return redirect('/articles/')

def edit(request,id):
    if request.method == 'POST':
        article = Article.objects.get(id=id)
        title= request.POST['title']
        contents=request.POST['contents']
        article.title=title
        article.contents=contents
        article.save()
        return redirect('/articles/')
    else :
        article = Article.objects.get(id=id)
        context={
            'article':article
        }
        return render(request,'edit.html',context)

# def update(request,id):
#     article = Article.objects.get(id=id)
#     title= request.GET['title']
#     contents=request.GET['contents']
#     article.title=title
#     article.contents=contents
#     article.save()
#     return redirect('/articles/')

def destroy(request,id):
    article = Article.objects.get(id=id)
    article.delete()
    return redirect('/articles/')