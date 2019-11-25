from django.shortcuts import render
import requests
from bs4 import BeautifulSoup
import json
# Create your views here.
def main(request):
    lives= getYoutube()
    context= {
        'lives':lives,
    }    
    return render(request, 'main.html',context)
    
def allHTML(request):    
    html = getTwitch()
    context ={
        'lives':html
    }
    return render(request, 'twitch.html',context)

def getYoutube():
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
    return lives
def getTwitch():    
    url = "https://api.twitch.tv/kraken/streams/"
    params ={
        'language':'ko',
        'stream_type':'all',
        'limit':100,
    }  
    headers = {
        'Accept': 'application/vnd.twitchtv.v5+json',        
        'Client-ID': ''
    }
    data = requests.get(url, params = params , headers= headers)
    jsons = data.json()['streams']
    lives= []
    for tmp in jsons:
        print(tmp)
        c = tmp['channel']['display_name']
        g = tmp['game']
        name = tmp['channel']['name']
        logo = tmp['channel']['logo']
        title = tmp['channel']['status']
        thumbnail = tmp['preview']['medium']
        profile_banner = tmp['channel']['profile_banner']
        u = tmp['channel']['url']
        total_views = tmp['channel']['views']
        now_views = tmp['viewers']
        followers = tmp['channel']['followers']
        bang = {            
            'title':title,
            'embed':u,
            'link':u,   
            'channel':c,
            'viewer':now_views,
            'img':thumbnail,
        }
        lives.append(bang)    
    return lives