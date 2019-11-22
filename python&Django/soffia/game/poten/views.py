from django.shortcuts import render , redirect
import requests
from bs4 import BeautifulSoup
from .models import Player,Comment
import logging
logger = logging.getLogger(__name__)

# Create your views here.
def all(request):
    url = 'https://sofifa.com/'
    data = requests.get(url).text
    html = BeautifulSoup(data,'html.parser')    
    player={}
    ages={}
    table= html.select('tr')
    titles = []
    ## 일단 선수의 정보를 dictionary 로 넣자
    for line in table:       
        name = line.select_one('.col-name .nowrap')
        age = line.select_one('.col-ae')
        posi = line.select('.col-name .pos')
        ova = line.select_one('.col-oa .p')
        poten = line.select_one('.col-pt .p')
        posis =[]
        for pos in posi:
            posis.append(pos.text)
        if name is None:
            continue
        pic = line.select_one('.col-avatar .player-check')
        flag = line.select('td .bp3-text-overflow-ellipsis a')        
        nation = flag[0]['title']
        nation_flag = flag[0].select_one('img')['data-src']
        team_flag = line.select_one('img.team')['data-src']
        team_name = flag[2].text
        id = name['href']
        ids = id.split('/')
        id = ids[2]
        player[name['title']] = {
            'nick':name.text,
            'pos':posis,
            'ova':ova.text,
            'poten':poten.text,
            'age':age.text,
            'img':pic['data-src'],
            'id':id,
            'nation':nation,
            'nation_flag':nation_flag,
            'team_name':team_name,
            'team_flag':team_flag
        }
        pos_str=""
        for tmp in posis:
            pos_str+='/'+tmp
        this= Player()
        this.psa = pic['data-src']
        this.name = name['title']
        this.nick=name.text      
        this.age = age.text
        this.overAll=ova.text
        this.potential = poten.text
        this.id=id
        this.team_flag=team_flag
        this.team=team_name
        this.nation = nation
        this.position = pos_str
        this.save()
    context = {
        'data':player
    }
    return render(request, 'sofifa.html', context)
def search(request,position):
    all_players= Player.objects.all()
    targetPlayer=[]
    for tmp in all_players:
        posis = tmp.position.split('/')        
        for p_tmp in posis:
            if p_tmp == position:
                targetPlayer.append(tmp)    
    context = {
        'players':targetPlayer
    }    
    return render(request, 'fifa/sofifaList.html', context)

def getStat(id):
    url =f'https://sofifa.com/player/{id}'
    data = requests.get(url).text
    html = BeautifulSoup(data,'html.parser')
    special = html.select_one('.bp3-card .teams')
    li = special.select('li')
    # print(li[1])
    # print(li[2])
    # print(li[3])
    # print(li[4])
    stat={}
    return li[0]
def dblist(request):
    players = Player.objects.all()
    # logger.debug(players)
    context={
        'players': players,
        'size':len(players)
    }
    return render(request, 'fifa/sofifaList.html', context)

def player_deleteAll():
    players = Player.objects.all()
    for tmp in players:
        tmp.delete()
    return 
def comment_deleteAll():
    comments = Comment.objects.all()
    for tmp in comments:
        tmp.delete()
    return 

def comment(request):
    print("---------------")
    id=request.POST['id']
    txt=request.POST['contents']
    target_p = Player.objects.get(name=id)
    comment= Comment()
    comment.target_id=target_p
    comment.contents=txt
    comment.save()
    print(comment.target_id)
    return redirect('/sofifa/')
    