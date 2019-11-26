from django.urls import path
from . import views as article_views

urlpatterns = [
    path('',article_views.index, name="articles"),
    path('js-test/',article_views.js_test),
    path('jq-test/',article_views.jq_test),
    path('commnets/',article_views.comments,name="comments"),
    path('commnets/jq_comment',article_views.jq_comment,name="submit_comments"),
    path('commnets/jq_comment/edit',article_views.jq_comment_edit,name="edit_comments"),
    path('commnets/jq_comment/delete',article_views.jq_comment_delete,name="delete_comments"),

    path('comments/<int:comment_id>/delete/',article_views.delete_comment,name="delete_com"),
    path('comments/<int:comment_id>/edit/',article_views.edit_comment,name="edit_com"),
    path('<int:article_id>/delete/',article_views.delete_art,name="delete_art"),
    path('<int:article_id>/edit/',article_views.edit_art,name="edit_art"),
    
    path('jq-test/boards/', article_views.submit_boards, name="submit_boards"),
    path('jq-test/boards/delete', article_views.delete_boards, name="delete_boards"),
    path('jq-test/boards/edit', article_views.edit_boards, name="edit_boards"),


]