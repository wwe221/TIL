이름

전공

관심분야	

프로젝트

MVC

MVVM

크롤링







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
import requests
url = "http://ticket.melon.com/offer/ajax/offerList.json?offerPosType=MAIN_B_CO_2"
# 정상적인(브라우져를 통한) 방식 이 아닌 접근이기 때문에 406 에러가 뜬다.
# 한마디로 외부 접근을 막아논 것. 
header = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36'}
# #브라우저의 접근이라고 말해주기 위해 User-Agent 속성을 추가해서 보내준다.
response = requests.get(url,headers=header)
print(response.text)
```

