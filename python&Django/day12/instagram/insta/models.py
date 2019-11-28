from django.db import models
from django.contrib.postgres.fields import ArrayField
from imagekit.models import ImageSpecField, ProcessedImageField
from imagekit.processors import ResizeToFill , Thumbnail

from django.conf import settings
from django.contrib.auth.models import User
# Create your models here.
class Article(models.Model):
    contents = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    user = models.ForeignKey(settings.AUTH_USER_MODEL , on_delete=models.CASCADE)
    user_likes = models.ManyToManyField(settings.AUTH_USER_MODEL, related_name="article_likes")

    def comments(self):
        return Comment.objects.filter(article_id=self.id)
    def images(self):
        return ArticleImages.objects.filter(article_id=self.id)
    def is_permitted(self, target_id):
        return self.user_id == target_id 
    #image = models.ImageField(blank=True)
    # image_thumbnail = ImageSpecField(
    #     source='image',
    #     processors=[Thumbnail(200,200)],
    #     format='JPEG',
    #     options={ 'quality':100 }
    # )
    # image_resized = ProcessedImageField(
    #     upload_to='insta/images',
    #     processors=[ResizeToFill(200,200)],
    #     format='JPEG',
    #     options={'quality': 90}
    # )
class ArticleImages(models.Model):
    image = models.ImageField(blank=True)
    image_thumbnail = ImageSpecField(
        source='image',
        processors=[Thumbnail(200,200)],
        format='JPEG',
        options={ 'quality':100 }
    )
    article = models.ForeignKey(Article,on_delete=models.CASCADE)
    
class Comment(models.Model):
    contents = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    article = models.ForeignKey(Article,on_delete=models.CASCADE)
    user = models.ForeignKey(settings.AUTH_USER_MODEL , on_delete=models.CASCADE)
class Board(models.Model):
    contents = models.CharField(max_length=16)
    created_at = models.DateTimeField(auto_now_add=True)
class HashTag(models.Model):
    tag = models.CharField(max_length=16 , unique=True)
    articles = models.ManyToManyField(Article , related_name="tags")