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

경량화

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

pip install beutifulsoup4



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



## Day4

CSRF Token ...?

​	보안. POST방식일때 사용





아이디어톤

- 새로운거 할려고 하지마
- 기존에 있던거 활용을 잘하자
  - api , 기존데이터를 가공, 이쁘게 하는 것 만으로도 서비스가 된다.





## REST API

``Representational State Transfer``

Interface , 약속

- URI는 정보의 자원을 표현해야 한다.
- 자원에 대한 행위는 HTTP Method (GET, POST, PUT, DELETE) 로 표현한다. 각 자원에 대한 행위가 다르다.
  - CRUD 를 했을 때 각각의 Method 하나로 표현이 가능 해야 한다. (매칭)
  - C - POST, R - GET , U - PUT / PATCH , D - DELETE
  - 같은 URI를 사용하더라도 Method 에 따라 행위가 달라질 수 있다.

ㅇ

#### Django

```shell
django-admin startproject [projectname]
# 프로젝트 만들기
python manage.py runserver 
# 서버 시작, 포트는 기본적으로 8000번을 사용한다.
python manage.py migrate
python manage.py startapp [appname]
```

urls.py - 모든 urlpatterns을 관리

url (-> domain을 ip로 치환, DNS ) -> requests -> route -> controller -> model -> controller -> View -> response -> Browser

setting.py - 



## Day05

Django 시작하기

- 프로젝트 만들기
- 프로젝트 vs 어플리케이션(app)
- MVC -> MVT
- Model View Controller -> Model View(Controller)Template(View)



시작하기

```shell
django-admin startproject [projectname]
cd [project]
python manage.py startapp [appname]
#django 에서 app 단위는 하나의 모델에 대한 모든 내용잉 담겨 있다.
#예를 들어 게시판을 만든다면, Post라는 app을 만들어 그안에서 모든 처리를 한다.
```

project

- settings.py
  - INSTALLED_APPS

    - 해당 프로젝트에서 실행될 app들을 선언해준다.

    - ```python
      INSTALLED_APPS = [
          'lotto',
          ....
      ]
      ```

- urls.py

  - request가 들어온 url을 views의 method와 연결해주기 위해 app의 views를 import 한다.

    - ```python
      from lotto import views
      #lotto app 의 view를 가져온다.
      from lotto import views as lotto_views
      from ascii import views as ascii_views
      ## 만약 여러 app 을 사용 한다면 views 에 alias 를 줄수도 있다.
      ```

  - urlpatterns

    - ```python
      urlpatterns = [
          path('admin/', admin.site.urls),
          path('lotto/',lotto_views.lotto),
          path('winning/',lotto_views.winning),    
      ]
      ```

app

- views.py

  - url 을 매핑받고 수행할 method를 정의한다.

  - ```python
    # 매핑 받을 method 는 항상 request를 parameter로 받아야 한다.
    def lotto(request):
        return render(request , 'lotto.html', {'lotto':lotto} )
    # 변수를 render 의 3번째 parameter 로 전해줄 수 있다.
    ```

project 안의 templates 폴더가 파일의 기본 directory 이다.

templates

- winning.html

  - ```html
    <body>    
        <h1>당신의 숫자</h1>
        <h3>
            <!-- method 에서 건내준 변수를 사용할때-->
        {% for num in picked %}
            {{ num }}
        {% endfor %}
        </h3>
        <h1>당첨 숫자</h1>
        <h3>
            {% for n in balls %}
             {{n}}
             {% endfor %}
             + {{bonus}} <br>
        </h3>
        맞은 갯수: {{win_cnt}} <br>
        {% for n in winning_list %}
            {{n}}
        {% endfor %}    
        <h2>
            당첨금 ::{{fst}}
        </h2>
    </body>
    ```

  - 



## Day6

[kakaoDeveloper](https://developers.kakao.com/docs/restapi/)



api 문서 볼때 주의할 점

- 요청방식
- 요청을 보내야 할 주소 (End-point)
- 필수적인 Parameter

```python
json.loads(response.text)
#String daa를 json으로(dictionary로) 강제 변환
```



## Day7

네이버 datalab api 쓰기

class

python 에서의 c;ass

```python
# class 의 선언

class Human:
    ## 변수선언
    name = 'name'
    age = 'age'    
    ## 함수 선언
    def say_hello(self): #parameter에는 self가 기본으로 들어간다.         print("hiroo")
    def walk(self,para) : # 다른 변수도 parameter에 넣을 수 있다.
        print("i'm walking" + para)
    
```

#### ORM

Object-Relational Mapping

간단하게 python 코드를 통해 DB의 table과 row를 조작할 수 있다.

table에 있는 row를 python 객체처럼 사용 할 수 있다.

model.py

```python
class Board(models.Model):
    title = models.CharField(max_length=30)s
    content = models.TextField()
    created_by = models.CharField(max_length=10 , null=True)
    # column 의 뼈대를 생성 한다.
```



```shell
python manage.py makemigrations
# models.py의 내용을 바탕으로테이블의 구조를 만드는 파일을 작성한다.
# migration 파일을 만들어 준다. ex)0001_initial.py
python manage.py migrate
# migration 파일을 토대로 db 구조를 만들어 준다.

```

###### python shell 명령어

python manage.py shell

```shell
from boards.models import Board
b1 = Board()
b1.titel='제목'
b1.save()
# db에 저장한다
# 이때 db는 기본적으로 [project]/db.sqlite3 파일이다.
b_all = Board.objects.all()
#모든 오브젝트들 배열로 리턴
b2 =Board.objects.filter(title='제목').first()
# 원하는 row 검색, 배열로 리턴한다.
```



save() 하기 전엔 table에 저장하지 않기 때문에 id를 갖지 않고,

save() 이후엔 table에 저장을 하면서, table의 해당 row를 가리키게 되고 이때 id를 갖게 된다.

해당 row를 가리키고 있기 때문에 정보를 변경하고 save() 를 하게 되면 UPDATE와 같이 덮어씌우기가 된다.

```shell
>>> b1 = Board()
>>> b1.title = '테스트'
>>> b1.save()
>>> b_all = Board.objects.all()
>>> for tmp in b_all:
...     print(tmp.title)
...
지금 먹으로 갑니다
롤리폴리
테스트
>>> b1.id
3
>>> b1.title = '빢빢'
>>> b1.save()
>>> b_all = Board.objects.all()
>>> for tmp in b_all:
...     print(tmp.title)
...
지금 먹으로 갑니다
롤리폴리
빢빢
>>> b1.id
3
>>> b2.id
2
>>> b3.id
1
>>> b1 = Board()
>>> b1.id
>>>
```



## Day8

```python
#django 에서도 path-para 방식을 사용할 수 있다.
#views.py
def show(request, id):
    return
#urls.py
urlpatterns = [
	path('boards/<id>/',boards_views.show)
]
```

###### block content 를 사용한 html 간소화

중복되는 값들 (설정 등등) 을 base.html 과 같이 한 곳에 저장하고 다른 페이지에서는 내용만 작성한다.

index.html

```html
{% extends 'base.html' %}
{% block content %}
	<!-- 내용 입력-->
{% endblock %}
```

base.html

```html
<head>~~~</head>
<div class="container">
	{% block content %}
	{% endblock %}
</div>
<script>~~~</script>
```

URL 분리하기

기존에는 urls.py에 모든 주소를 명시했지만 CRUD를 위해서 필요한 페이지가 많기 때문에 분명히 하기 위해 각각의 App 마다 url.py를 만들어 관리한다.



urls.py

```python
from django.urls import path , include #include를 import

urlpatterns = [
    path('admin/', admin.site.urls),
    path('boards/',include('boards.urls'))
    #boards.urls 파일에 정의된 path들을 사용한다.
    #app 디렉토리 안에 새로운 urls.py 파일을 만들어 주었다.
]
```

boards/urls.py

```python
from django.urls import path
from . import views as boards_views
urlpatterns = [
    path('',boards_views.index),
    path('new/',boards_views.new),
    path('create/',boards_views.create),
    path('<int:id>/',boards_views.show),
    path('<int:id>/update',boards_views.update),
   	##path-para 방식 중 값의 type을 정해서 넘겨 줄 수 있다.
]
```

boards/views.py

```python
def update(request, id): ##넘겨준 값을 parameter로 받는다
    board = Boards.objects.get(id=id) ##Boards table 에서 하나의 row만을 가리키기    
    title = request.GET['title']
    content = request.GET['contents']
    board.title = title
    board.contents =content    
    board.save()
    return redirect(f'/boards/{id}')
```

