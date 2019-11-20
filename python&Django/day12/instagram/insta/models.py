from django.db import models
from django.contrib.postgres.fields import ArrayField

# Create your models here.
class Article(models.Model):
    contents = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    def comments(self):
        return Comment.objects.filter(article_id=self.id)

class Comment(models.Model):
    contents = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    article = models.ForeignKey(Article,on_delete=models.CASCADE)