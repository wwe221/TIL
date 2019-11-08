import random
import requests
import json
import time
from flask import Flask , escape, request ,render_template
app = Flask(__name__)
if __name__ == '__main__':
    app.run(debug=True)
@app.route('/')
def index():          
    # request.args -> Dicktionary(Immutable)
    # 클라이언트로 부터 받은 파라미터를 저장하고 있다
    student = request.args.get('student')
    return student
@app.route('/daum_webtoon')
def daum_toon_index():
    days = ['mon','tue','wed','thu','fri','sat','sun'] 
    return render_template('daum_webtoon_list.html', days=days)

@app.route('/daum_webtoon/<day>')
def daum_toon(day) :    
    url = f"http://webtoon.daum.net/data/pc/webtoon/list_serialized/{day}"
    ## formating , 문자열 합치기
    data = request_json_from_url(url)    
    dayWebtoon[day] = parse_daum_webtopon_data(data)
    return dayWebtoon

def request_json_from_url(url):
    response = requests.get(url)
    data=response.json()
    return data

def parse_daum_webtopon_data(data):
    toons = []
    for toon in data["data"]:
        title = toon["title"]
        desc = toon["introduction"]
        genres = []
        for gs in toon["cartoon"]["genres"]:
            genres.append(gs["name"])
        artists = []
        for gs in toon["cartoon"]["artists"]:
            artists.append(gs["name"])
        img_url = toon["pcThumbnailImage"]["url"]
        tmp = {
            title :{
                'desc':desc,
                'genres':genres,
                'writer':artists,
                'img_url':img_url
            }
        }
        toons.append(tmp)
    return toons
dayWebtoon ={
}