from django.db import models
from django.contrib.postgres.fields import ArrayField

# Create your models here.
class Player(models.Model):
    psa = models.CharField(max_length=50)
    name = models.CharField(max_length=50, primary_key=True)
    nick = models.CharField(max_length=50)    
    age = models.CharField(max_length=50) 
    overAll = models.CharField(max_length=50) 
    potential = models.CharField(max_length=50) 
    id = models.CharField(max_length=50) 
    team_flag = models.CharField(max_length=200)
    team = models.CharField(max_length=50)
    nation = models.CharField(max_length=50)
    nation_flag = models.CharField(max_length=40)
    position = models.CharField(max_length=50)
    def __str__(self):
        return self.name
class Comment(models.Model):
    contents = models.TextField()
    target = models.ForeignKey(Player,on_delete=models.CASCADE)
