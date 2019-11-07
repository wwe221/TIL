import random
import requests
import json
import time
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
day = [
    'mon','tue','wed','thu','fri','sat','sun'
]
dayWebtoon ={
}
for dd in day:
    url = f"http://webtoon.daum.net/data/pc/webtoon/list_serialized/{dd}"
    ## formating , 문자열 합치기
    data = request_json_from_url(url)    
    dayWebtoon[dd] = parse_daum_webtopon_data(data)
    print(dayWebtoon[dd])
    time.sleep(3)


