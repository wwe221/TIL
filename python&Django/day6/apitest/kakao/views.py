from django.shortcuts import render
import requests
import json
# Create your views here.
def main(request):    
    return render(request , 'kakao.html')    
def find_address(request):
    address = request.GET['addr']
    url = "https://dapi.kakao.com//v2/local/search/address.json"
    params ={
        'query':address,
        'size':10
    }
    key ='06a6894cff657ed007cc2c7b30bd6db8'
    headers ={
        'Authorization':f'KakaoAK {key}'
    }
    response = requests.get(url, params = params , headers= headers)
    addr_data = json.loads(response.text)['documents']
    return render(request , 'address.html',{'addr_data':addr_data})
def keyword_result(request):
    url = "https://dapi.kakao.com/v2/local/search/keyword.json"    
    keyword = request.GET['keyword']
    position = request.GET['position']
    posi=[]
    posi=position.split('&')
    print(posi)
    params ={        
        'query':keyword,
        'x':posi[0],
        'y':posi[1],
        'radius': 10000
    }
    key ='06a6894cff657ed007cc2c7b30bd6db8'
    headers ={
        'Authorization':f'KakaoAK {key}'
    }
    response = requests.get(url, params = params , headers= headers)
    data = json.loads(response.text)['documents']
    result = {
        'data':data,
        'keyword':keyword
    }
    return render(request , 'result.html', result)