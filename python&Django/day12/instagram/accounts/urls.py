from django.urls import path
from . import views as accounts_view

app_name ='accounts'
urlpatterns = [
    path('login/',accounts_view.login, name='login'),
    path('logout/',accounts_view.logout, name='logout'),
    path('signup',accounts_view.signup, name='signup'),
]
