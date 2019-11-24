from django.shortcuts import render
import requests
from bs4 import BeautifulSoup
import json
# Create your views here.
def main(request):
    url = 'https://www.youtube.com/channel/UC4R8DWoMoI7CAwX8_LjQHig'    
    data = requests.get(url).text
    html = BeautifulSoup(data,'html.parser')
    # lives = html.select('#items .style-scope .yt-horizontal-list-renderer')
    test=html.select('.channels-content-item')
    contents = html.select('.feed-item-main-content')
    print(len(contents))
    lives =[]
    for tmp in test:
        img = tmp.select_one('img')['data-thumb']
        t = (tmp.select_one('.yt-lockup-title a')['title'])
        embed =  "https://www.youtube.com/embed/"
        link  = tmp.select_one('.yt-lockup-title a')['href']
        key = link.split('=')
        embed = f'{embed}{key[1]}'
        l = (f"https://www.youtube.com{tmp.select_one('.yt-lockup-title a')['href']}")        
        c = (tmp.select_one('.yt-user-name').text)
        v = (tmp.select_one('ul .yt-lockup-meta-info li').text)        
        bang = {
            'title':t,
            'embed':embed,
            'link':l,
            'channel':c,
            'viewer':v,
            'img':img
        }
        lives.append(bang)
    context= {
        'data':test,
        'lives':lives,
    }
    return render(request, 'main.html',context)
    
def allHTML(request):
    url = 'https://www.youtube.com/channel/UC4R8DWoMoI7CAwX8_LjQHig'    
    data = requests.get(url).text
    html = BeautifulSoup(data,'html.parser')    
    context ={
        'data':html
    }
    return render(request, 'all.html',context)