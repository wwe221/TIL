from django.db import models
import datetime
# Create your models here.
class Article(models.Model):
    title = models.CharField(max_length=16)
    contents = models.TextField()
    creator = models.CharField(max_length=8)
    created_at = models.DateTimeField(auto_now_add=True , null=True)
    #비어있어도 상관 없는 내용으로 넣어준거에요
    updated_at = models.DateTimeField(auto_now=True , null=True)
    def datetime_to_str(self):
        return self.created_at.strftime("%Y-%m-%d")
    def created_by(self):
        return f'{self.creator} at {self.created_at}'
    def __str__(self):
        return f'[{self.title}] - created by {self.creator}'