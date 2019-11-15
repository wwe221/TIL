from django.db import models

# Create your models here.
class Boards(models.Model):
    objects = models.Manager()
    title = models.CharField(max_length=32)
    contents = models.TextField()
    creator = models.CharField(max_length=16)
    
        