studnet= {
    "수학":80,
    "국어":90,
    "음악":100
}
sum = 0
for a in studnet.values():
    sum+=a
print(sum/len(studnet))

#각 학생의 평균 점수와 반 평균을 구하세오
score = {
    "a학생":{
        "수학":80,
        "국어":90,
        "음악":100
    },
    "b학생":{
        "수학":80,
        "국어":75,
        "음악":58
    },
    "c학생":{
        "수학":40,
        "국어":100,
        "음악":80
    },
    "d학생":{
        "수학":90,
        "국어":98,
        "음악":88
    },
    "e학생":{
        "수학":87,
        "국어":99,
        "음악":10
    }
}
avg = {

}
for std ,itm in score.items(): 
    sum =0
    for a in itm.values():
        sum+=a
    avg[std]=round(sum/len(itm),1)
print(avg)

import requests
url = "http://webtoon.daum.net/data/pc/webtoon/list_serialized/sun?"
response = requests.get(url)

