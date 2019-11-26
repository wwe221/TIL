from django.shortcuts import render
from bs4 import BeautifulSoup
from selenium import webdriver
import requests
import json
# Create your views here.
def main(request):
    lives= getYoutube()
    # context= {
    #     'lives':lives,
    # }    
    # return render(request, 'main.html',context)
    data = getAfreeca()
    context = {
        'data': data
    }
    return render(request, 'all.html',context)

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
        'Client-ID': 'u9b5xmjbfx2meuntk2a2r5gj9ax7vc'
    }
    data = requests.get(url, params = params , headers= headers)
    jsons = data.json()['streams']
    lives= []
    for tmp in jsons:
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
def getAfreeca():
    url = "http://www.afreecatv.com/"
    header={
        'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3',
        'Accept-Encoding': 'gzip, deflate',
        'Accept-Language': 'ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7',
        'Cache-Control': 'max-age=0',
        'Connection': 'keep-alive',
        'Cookie': '_au=0xfb99b58bfed612ba; OAX=3mvuJF3bayQAAuqN; _ga=GA1.2.1925135739.1574660873; _gid=GA1.2.1276319739.1574660873; __gads=ID=cf7905910b6d74ea:T=1574666877:S=ALNI_MZTYZ_jAwx5x2Vwad72QvCIW6Ksuw; bjStationHistory=%0213865507%027301897; _ausb=0x55de367a; AbroadChk=FAIL; AbroadVod=FAIL; _gat=1; _ausa=0x930e0abe',
        'Host': 'www.afreecatv.com',
        'Referer': 'http://www.afreecatv.com/?hash=game',
        'Upgrade-Insecure-Requests': '1',
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36'
    }
    data = requests.get(url,params=header).text
    print()
    html = BeautifulSoup(data,'html.parser')
    broads= html.select_one('#broadlist_area')    
    return html
def seleTest():
    driver = webdriver.Chrome('C:\chromedriver')
    url = "http://www.afreecatv.com/"
    driver.get(url)
    return
