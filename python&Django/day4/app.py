from flask import Flask , request,render_template, redirect , url_for
import requests
import json
from bs4 import BeautifulSoup
app = Flask(__name__)
@app.route('/')
def index():
    return render_template('index.html')

# 전체 요일 적힌 페이지
@app.route('/webtoon')
def webtoonmain():
    days = {
    '월요일':'mon','화요일':'tue','수요일':'wed','목요일':'thu','금요일':'fri','토요일':'sat','일요일':'sun'
    }
    return render_template('webtoon.html',days = days)

# 각 요일에 대한 데이터 요청 
@app.route('/webtoon/<day>')
def dayilyList(day):
    url = f'http://webtoon.daum.net/data/pc/webtoon/list_serialized/{day}'
    response = requests.get(url)
    data = response.json()
    webtoon= {}    
    for toon in data["data"]:
        webtoon_title = toon["title"]
        webtoon_nickname = toon["nickname"]
        webtoon_intro = toon["introduction"]
        artists = toon["cartoon"]["artists"]
        webtoon_artists=[]
        for name in artists:
            webtoon_artists.append(name["name"])
        # webtoon[webtoon_title]={
        #     'nickname':webtoon_nickname,
        #     'intro':webtoon_intro,
        #     'artists':webtoon_artists
        # }
        webtoon[webtoon_title]= [webtoon_nickname, webtoon_intro, ", ".join(webtoon_artists)]
    return render_template('day_webtoon_list.html', webtoons= webtoon)

# 각 웹툰에 대한 세부 데이터 요청 
@app.route('/webtoon/<nick>')
def webtoon_detail(nick):
    url = f'http://webtoon.daum.net/data/pc/webtoon/view/{nick}'
    return requests.get(url).json()


#FAKE_ 검색 및 로그인
@app.route('/naver')
def fake_naver():
    return render_template('naver.html')

@app.route('/naver/search')
def fake_search():
    #검색 로직
    q = request.args.get('q')
    return render_template('search.html', q = q)

@app.route('/login')
def login_form():
    return render_template('login.html')

@app.route('/login/submit' , methods=['POST'])
def login():
    id = request.args.get('id')
    pwd = request.args.get('pwd')
    #return render_template('success.html')
    # post 방식으로 접근하는 경우에는 새로고침과 같은 경우에 "양식다시제출"
    # 적절하지? 않기 때문에 redirect를 사용하는게 좋다.
    return redirect(url_for('main'))
@app.route('/main')
def main():
    return '로그인 성공'

@app.route('/sofifa')
def sofifa():
    url = 'https://sofifa.com/'
    data = requests.get(url).text
    html = BeautifulSoup(data,'html.parser')    
    '''allp = html.select('.col-name')
    ae = html.select('td.col-ae')    
    ages = []
    for age in ae:
        ages.append(age.text)
    names=[]
    player={}    
    for tmp in allp:        
        name = tmp.select('.nowrap')        
        pos = tmp.select('.pos')        
        poss=[]
        for ptmp in pos:
            poss.append(ptmp.text)
        for ntmp in name:
            if ntmp.text=="" or ntmp.text is None:
                continue
            player[ntmp.text] = { 'position':poss }
            names.append(ntmp.text)'''
    player={}
    ages={}
    table= html.select('tr')
    for line in table:
        name = line.select_one('.col-name .nowrap')
        age = line.select_one('.col-ae')
        posi = line.select('.col-name .pos')
        ova = line.select_one('.col-oa .p')
        poten = line.select_one('.col-pt .p')
        posis =[]
        stat = []
        stat.append(age.text)
        for pos in posi:
            posis.append(pos.text)
        stat.append(posis)
        if name is None:
            continue
        stat.append(ova.text)
        stat.append(poten.text)
        player[name.text] = stat
    return render_template('sofifa.html', data=player , age = ages)