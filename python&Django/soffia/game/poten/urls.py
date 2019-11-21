from django.contrib import admin
from django.urls import path
from . import views


app_name ='sofifa'
urlpatterns = [
    path('',views.dblist,name='dblist'),
    path('load/', views.all, name='load'),    
    path('<position>/', views.search,name='search'),
]