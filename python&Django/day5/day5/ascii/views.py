from django.shortcuts import render
import requests
def ascii(request):
    #입력하려는 text 와
    # artii 에서 제공하는 폰트 중 선택
    url = "http://artii.herokuapp.com/fonts_list"
    html = requests.get(url).text
    fonts = html.split("\n")
    context ={
        'fonts':fonts
    }
    return render(request , 'ascii.html', context)
def request(request):
    #입력받은 값과 선택한 폰트를 artii에 보내 결과값을 받아서 보여준다.
    text = request.GET['text']
    font = request.GET['font']
    url = f"http://artii.herokuapp.com/make?text={text}&font={font}"
    html = requests.get(url).text
    result = html.split("\n")
    context = {
        'result':html,
       'data':result
    }
    return render(request , 'request.html',context)
