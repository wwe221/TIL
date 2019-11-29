from django.urls import path , include
from . import views
app_name = "boards"
urlpatterns = [
    path('', views.index,name="index"),
    path('<int:room_id>/', views.show,name="room"),   
    path('<int:room_id>/exit/', views.exit,name="exit"), 
    path('chat/', views.chat,name="chat"),   
    
]