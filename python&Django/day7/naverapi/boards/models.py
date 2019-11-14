from django.db import models

# Create your models here.
class Board(models.Model):
    title = models.CharField(max_length=30)
    content = models.TextField()
    creater = models.CharField(max_length=10 , null=True)
    # column 의 뼈대를 생성 한다.
