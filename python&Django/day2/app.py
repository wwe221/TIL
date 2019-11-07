import random
import requests
import json
import time
from flask import Flask , escape, request
# 기본으로 flask 의 port 는 5000번 이다.
app = Flask(__name__)
if __name__ == '__main__':
    app.run(debug=True)
    #debug mode - 서버를 재시작 하지 않아도 브라우저에서 새로고침만으로 갱신이 가능하다.
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
@app.route('/')
def index():
    dd='mon'
    url = f"http://webtoon.daum.net/data/pc/webtoon/list_serialized/{dd}"
    ## formating , 문자열 합치기
    data = request_json_from_url(url)    
    dayWebtoon[dd] = parse_daum_webtopon_data(data)
    print(dayWebtoon[dd])
    return dayWebtoon