from django import forms
# from django.db import model 와 유사
from .models import Article, Comment

class ArticleForm(forms.ModelForm):
    # html 에서 1차적으로 막아주고, 서버 단 작업에서도 is_valis() 를 이용해서 이를 막아 줄 수 있다.
    title = forms.CharField(min_length=2,strip=True)
    email = forms.EmailField()
    keyword = forms.CharField(min_length=1,max_length=10)    
    class Meta:
        model = Article
        fields = '__all__' # model 에 정의한 field들을 __all__ 이라고 쓴다.
       #fields = ('title','content') tuple or list 로 쓰고자 하는 field만 정의할 수 있다.
        exclude = ['datetime']
        #제외 하고자 하는 field를 설정할수 있다.