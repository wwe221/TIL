from django.urls import path
from . import views as boards_views
urlpatterns = [
    path('',boards_views.index),
    path('new/',boards_views.new),
    path('create/',boards_views.create),
    path('<int:id>/',boards_views.show),
    path('<int:id>/edit/',boards_views.edit),
    path('<int:id>/update/',boards_views.update),
    path('<int:id>/destroy/',boards_views.destroy),
]