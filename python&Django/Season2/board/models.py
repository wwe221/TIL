from django.db import models
from faker import Faker
f= Faker()
# Create your models here.
class Article(models.Model):
    title = models.CharField(max_length=100)
    keyword = models.CharField(max_length=50)
    email = models.CharField(max_length=200)    
    content = models.TextField()
    datetime = models.DateField(blank=True,null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    @classmethod
    def dummy(cls, n):
        for i in range(n):
            cls.objects.create(
                title= f.text(10),
                email= f.email(),
                keyword= f.company(),
                content= f.text(),
            )
class Comment(models.Model):
    content = models.CharField(max_length=300)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)