from django.db import models
from django.contrib.postgres.fields import ArrayField

# Create your models here.
class Player(models.Model):
    #primary key 는 name 인데 id 를 찾고 있다.
    #
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
    def getPosition(self):
        ret = ''
        posis=self.position.split('/')
        for tmp in posis:
            ret+= tmp+" "
        return ret
    def comments(self):
        return Comment.objects.filter(target_id=self.name)
class Comment(models.Model):
    contents = models.TextField()
    target = models.ForeignKey(Player,on_delete=models.CASCADE)
