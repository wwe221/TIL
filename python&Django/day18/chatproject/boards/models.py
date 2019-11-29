from django.db import models
from django.conf import settings
from django.contrib.auth.models import User
# Create your models here.
class Room(models.Model):
    title = models.CharField(max_length=32)
    code = models.CharField(max_length=16, unique=True)
    max_connection = models.IntegerField()
    master = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    users = models.ManyToManyField(settings.AUTH_USER_MODEL, related_name="rooms")
    def current_con(self):
        return len(self.users.all())
class Message(models.Model):
    contents = models.TextField()
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    room = models.ForeignKey(Room , on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)