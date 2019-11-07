import random
import requests
import json
import time

def request_json_from_url(url):
    response = requests.get(url)
    data=response.json()
    return data
url="https://map.naver.com/v5/api/dir/findpt?start=127.0485663,37.5148428,name=%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C%20%EA%B0%95%EB%82%A8%EA%B5%AC%20%EC%82%BC%EC%84%B1%EB%8F%99%2026-12&goal=126.9551533,37.6027666,placeid=11591565,name=%EC%83%81%EB%AA%85%EB%8C%80%ED%95%99%EA%B5%90%EC%84%9C%EC%9A%B8%EC%BA%A0%ED%8D%BC%EC%8A%A4&crs=EPSG:4326&departureTime=2019-11-07T15:38:07&isStatic=null&mode=TIME&lang=ko"
data = request_json_from_url(url)
print(data["paths"][0])