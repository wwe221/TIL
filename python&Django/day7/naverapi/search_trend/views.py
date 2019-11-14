from django.shortcuts import render
import json
import requests
def search(request):
    return render(request , 'search.html')

def trend(request):
    url = "https://openapi.naver.com/v1/datalab/search"
    keyword = request.GET['keywords']
    
    data = {
        'startDate':request.GET['startDate'],
        'endDate':request.GET['endDate'],
        'timeUnit':request.GET['timeUnit'],
        'keywordGroups':[
            {
            'groupName':request.GET['groupName'],
            'keywords':keyword.split(',')
            }
        ]
    }    
    cliId = 'EVrA1qiKaDKxmrXTJOB7'
    cliScrt ='86ybLxFc9i'
    headers = {
        'X-Naver-Client-Id':cliId,
        'X-Naver-Client-Secret': cliScrt
    }
    params = json.dumps(data)
    result = requests.post(url,data=params,headers=headers).text
    context = {
        "result":result
    }
    return render(request , 'result.html' , context)