from django.contrib import admin
from django.urls import path
from . import views


app_name ='sofifa'
urlpatterns = [
    path('',views.all),
    path('dblist/', views.dblist, name='dblist'),   
    
    
    path('<position>/', views.search),
]