"""day5 URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path

from lotto import views as lotto_views
from ascii import views as ascii_views
from opgg import views as opgg_views
urlpatterns = [
    path('admin/', admin.site.urls),
    path('lotto/',lotto_views.lotto),
    path('lotto/winning/',lotto_views.winning),
    path('ascii/',ascii_views.ascii),
    path('ascii/request/',ascii_views.request),
    path('opgg/',opgg_views.opgg),
    path('opgg/result/',opgg_views.result),

]
