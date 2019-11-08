이름

전공

관심분야	

프로젝트

MVC

MVVM

크롤링





## Day01

GraphQL

sql과 같이 쿼리 언어다.

**웹 클라이언트**가 데이터를 서버로 부터 효율적으로 가져오는 것이 목적입니다.



클릭 -> 화면바꿔 -> 데이터 채워



response 의미

| 번대 | 의미                  |
| ---- | --------------------- |
| 200  | 정상                  |
| 300  | redirection           |
| 400  | Client Error (사용자) |
| 500  | Server Error (개발자) |

```python
import requests #주석 처리는 #으로 한다.
url = "http://ticket.melon.com/offer/ajax/offerList.json?offerPosType=MAIN_B_CO_2"
# 정상적인(브라우져를 통한) 방식 이 아닌 접근이기 때문에 406 에러가 뜬다.
# 한마디로 외부 접근을 막아논 것. 
header = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36'}
# #브라우저의 접근이라고 말해주기 위해 User-Agent 속성을 추가해서 보내준다.
response = requests.get(url,headers=header)
print(response.text)
```



###### Notion - 정리하기 좋은 툴





## Day02

- 파이썬 딕셔너리
  - 딕셔너리?
  - 어떻게 쓰나 
  - JSON과의 차이
  - 활용해서 문제 풀기



#### Dictionary

​	Key - Value , 쌍으로 데이터를 저장하는 방식,

Java의 HashMap 과 같다. 

Key 값은 고유해야한다, 중복 되면 안된다 이말이다. o

```python
lunch_menu={
    "20층_식당" : {
        "A코스" : "돈까스",
        "B코스" : "육개장"        
    },
    "양자강":{
        "점심메뉴":"탕짬면",
        "특선메뉴":"군만두"
    },
    "대동집":{
        "밥안주":"비빔면",
        "술안주":"오돌뼈"
    }
}
print(lunch_menu)
print(lunch_menu["20층_식당"]["B코스"])
print(lunch_menu.get("20층_식당").get("A코스"))
lunch_menu["경성불백"] = {
    "한식":"불고기백반",
    "특식":"돈까스"
}
print(lunch_menu)
lunch_menu["양자강"] = "짜장면"
print(lunch_menu)
print("----------------")
#모든 Key , value 뽑아내기
keys = lunch_menu.keys()
vals = lunch_menu.values()
items = lunch_menu.items()
print(keys)
#for in 방식을 사용해 반복한다.
#공백 (tab) 을 통해 반복문임을 구분한다.

for key, value in items:    
    print(key)
    print(value)
# 한번에 key, value 를 뽑을 수 있다. 간편하다.
print("----------------")
```



#### Random

```python
#random.choice()    여러개 중에 한개
#random.sample()    여러개 중에 여러개
print(random.choice(list(keys)))
print(random.sample(list(keys),2))
```



#### 덕타이핑 duck Typing

꽥꽥 울고 뒤뚱뒤뚱 걸으면 오리다,

객체의 변수 및 메소드의 집합이 객체의 타입을 결정한다.

```python
print(random.choice(list(keys)))
```

#### 조건문

```python

if 조건:
	조건실행문
elif 조건:
	조건실행문2
else :
    나머지
```

#### 함수정의하기

```python
def func(param):
    print(param)
```



다음웹툰에서 정보 크롤링 하기

```python
import random
import requests
import json

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
print(dayWebtoon)
```

##### Sleep

```python
import time
time.sleep(3)
```

##### flask

python을 이용하여 웹 요청을 처리할 수 있도록 해주는 , 서버를 구동시키게 해주는 프레임워크

```python
from flask import Flask , escape, request
# 기본으로 flask 의 port 는 5000번 이다.
app = Flask(__name__)
if __name__ == '__main__':
    app.run(debug=True)
    #debug mode - 서버를 재시작 하지 않아도 브라우저에서 새로고침만으로 갱신이 가능하다.
@app.route('/')
def index():
    return {'method': 'Hello'}

$env:FLASK_DEBUG="TRUE"
$env:FLASK_ENV="Development"
#위 명령어로 디버그 모드, 개발자모드로 환경설정을 해준다.

```

## Day3

- parameter
  - query string
  - path parameter
- html 파일로 view 만들기 (render template)
- Beautiful soup
  - 사이트 구조 분석 (html)
  - URL 구조(query string) 분석



```python
@app.route('/')
def index():          
    # request.args -> Dicktionary(Immutable)
    # 클라이언트로 부터 받은 파라미터를 저장하고 있다
    student = request.args.get('student')
    return student

## Spring 의 그것과 같이 해당 url로 접속시 화면을 연결 해 준다.
## /daum_webtoon/ 뒤에 오는 값을 day에 담아 사용한다.
@app.route('/daum_webtoon/<day>')
def daum_toon(day) :    
    url = f"http://webtoon.daum.net/data/pc/webtoon/list_serialized/{day}"
    ## formating , 문자열 합치기
    data = request_json_from_url(url)    
    dayWebtoon[day] = parse_daum_webtopon_data(data)
    return dayWebtoon

@app.route('/daum_webtoon')
def daum_toon_index():
    days = ['mon','tue','wed','thu','fri','sat','sun']
    msg = "alone"
    return render_template('daum_webtoon_list.html', **locals())
## **locals() 로 해당 html 에 지역 번수들을 전달해줄 수 있다.
## 만약 원하는 데이터만 전달해 주고 싶다면, (~~.html' , days = days , msg = msg) 로도 가능하다.
```

#### BeutifulSoup

html 속에서 원하는 정보들을 find , select 할 수 있다.



```python
from bs4 import BeautifulSoup
import requests
url = "http://www.saramin.co.kr/zf_user/jobs/list/job-category?cat_cd=404&panel_type=&search_optional_item=n&search_done=y&panel_count=y"
response = requests.get(url)
html = BeautifulSoup(response.text,'html.parser')
## 받아온 데이터를 파싱한다.
company_names = html.select('.company_name')
# company_name 클래스를 list 형태로 모두 가져온다

###############################################

html = BeautifulSoup(response.text,'html.parser')
 ## html 내 상위 클래스 안에 있는 것들에 대해 따로 처리가 가능하다.
company = html.select('.part_top')
for com in company:
    name = com.select_one('.company_name')
    rec = com.select_one('.recruit_name')
    cond  = com.select_one('.list_recruit_condition')
    print(f'{name.text} :: {rec.text} -{cond.text}')
 #################################################
    

## 회사 공고 상세보기 페이지에서 데이터 크롤링하기
company_list = html.select('ul.product_list li')
for com in company_list:
    company_info_url =f"http://www.saramin.co.kr{com.select_one('a')['href']}"
    idx = company_info_url.split('=')[-1]    
    company_info_url = 'http://www.saramin.co.kr/zf_user/jobs/relay/view-ajax'
    company_info_param = { 'rec_idx':idx }
    #post 방식을 사용하는 url 이기 때문에 parameter 들을 변수를 통해 넘겨준다.
    company_response = requests.post(company_info_url, params = company_info_param)
    #
    company_html = BeautifulSoup(company_response.text,'html.parser')
    company_title = company_html.select_one('.company_name').text
    print(company_title.strip())
    # strip() 함수를 통해 공백을 모두 없에준다.
    break
```



