from django.shortcuts import render
import requests
from bs4 import BeautifulSoup
# Create your views here.
def opgg(request):
    #아이디 입력 받고 전달
    return render(request,'opgg.html')
def result(request):
    # op.gg 크롤링, 소환사에 대한 전적정보 가져오기
    id = request.GET['id']
    url=f"https://www.op.gg/summoner/userName={id}"
    data = requests.get(url).text
    html = BeautifulSoup(data,'html.parser')
    solo = html.select_one('.SummonerRatingMedium')
    tier = solo.select_one('.TierRank').text
    winlose = solo.select_one('.WinLose')
    if winlose is None:
        context = {
            'msg':'소환사가 없거나 언랭입니다.'
        }
        return render(request,'opgg_result.html' , context)
    win = winlose.select_one('.wins').text
    lost = winlose.select_one('.losses').text
    ratio = winlose.select_one('.winratio').text
    champBox = html.select('.ChampionBox')
    print(champBox)
    champs = {}
    for ctmp in champBox:
        cname = ctmp.select_one('.ChampionName a').text
        ckda = ctmp.select_one('.PersonalKDA .KDA').text.strip()
        cratio = ctmp.select_one('.Played .WinRatio').text.strip()
        cplayed = ctmp.select_one('.Played .Title').text
        ckda = ckda.replace("KDA","")
        ckda = ckda.replace("\n","")
        print(ckda)
        champs[cname] = {
            'kda':ckda,
            'ratio':cratio,
            'played':cplayed,            
        }
    context = {
        'id':id,
        'tier':tier,
        'win':win,
        'lost':lost,
        'ratio':ratio,
        'champs':champs
    }
    return render(request,'opgg_result.html' , context)