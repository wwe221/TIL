from django.shortcuts import render
import random
from bs4 import BeautifulSoup
import requests
# Create your views here.
def lotto(request):
    return render(request , 'lotto.html')
def winning(request):
    # 1 ~ 45 중 n개 숫자 추출
    # 1 ~ 45 가진 배열 생성,
    numbs = list(range(1,46))    
    count = int(request.GET['count'])   
    picked_numbs = random.sample(numbs,count)
    picked_numbs.sort()
    # 지난주 당첨번호 가져오기
    url = "https://dhlottery.co.kr/gameResult.do?method=byWin"
    data = requests.get(url).text
    html = BeautifulSoup(data,'html.parser')    
    balls = html.select('.content_wrap .win .ball_645')
    bonus = html.select_one('.content_wrap .bonus .ball_645').text
    fst = html.select_one('.tar .color_key1').text
    ball =[]
    winning_cnt = 0
    winning_list =[]
    for tmp in balls:
        ball.append(int(tmp.text))
    for tmp in ball:
        if tmp in picked_numbs:
            winning_cnt +=1
            winning_list.append(tmp)        
    return render(request, 'winning.html',{'picked':picked_numbs , 'balls':ball , 
    'bonus':bonus , 'fst':fst ,'win_cnt':winning_cnt, 'winning_list':winning_list} )

