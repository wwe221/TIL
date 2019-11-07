import random
import requests
import json
a = {
    "이경헌":"8276" 
}
b = {
    "백승엽":a["이경헌"] 
}
print(b["백승엽"])
print(a.get("이경헌"))

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


#random.choice()    여러개 중에 한개
#random.sample()    여러개 중에 여러개
print(random.choice(list(keys)))
print(random.sample(list(keys),2))
'''
if 조건:

elif 조건:

else:
'''
