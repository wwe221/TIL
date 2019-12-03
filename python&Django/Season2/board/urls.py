from django.urls import path , include
from . import views
app_name='board'
urlpatterns = [
    path('', views.article_list, name="article_list"),
    path('<int:article_id>/',views.article_detail, name="article_detail"),
    path('new/',views.new_article,name="new_article"),
    path('<int:article_id>/edit/',views.edit_article,name="edit_article"),
]