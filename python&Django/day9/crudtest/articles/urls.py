from django.contrib import admin
from django.urls import path
from . import views

app_name ='articles'
urlpatterns = [
    path('', views.index,name="index"),
    path('<int:id>/',views.show,name="show"),
    path('new/',views.new,name="new"),
    path('create/',views.create,name="create"),
    path('edit/<int:id>',views.edit,name="edit"),
    path('<int:id>/update/',views.update,name="update"),
    path('<int:id>/destroy/',views.destroy,name="delete"),
]