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
    return render(request,'new.html')

def create(request):
    title= request.GET['title']
    contents=request.GET['contents']
    creator=request.GET['creator']    
    article=Article.objects.create(title=title,contents=contents,creator=creator)    
    return redirect('/articles/')

def edit(request,id):
    article = Article.objects.get(id=id)
    context={
        'article':article
    }
    return render(request,'edit.html',context)

def update(request,id):
    article = Article.objects.get(id=id)
    title= request.GET['title']
    contents=request.GET['contents']
    article.title=title
    article.contents=contents
    article.save()
    return redirect('/articles/')

def destroy(request,id):
    article = Article.objects.get(id=id)
    article.delete()
    return redirect('/articles/')