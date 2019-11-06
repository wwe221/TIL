import requests
url = "http://webtoon.daum.net/data/pc/webtoon/list_serialized/sun?"
response = requests.get(url)
print(response)
print(response.text)