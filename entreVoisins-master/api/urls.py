from django.urls import path
from .views import VoisinViewSet,FavoriViewSet
from rest_framework.routers import DefaultRouter

router = DefaultRouter()
router.register('voisin', VoisinViewSet, basename='voisin')
router.register('favoris', FavoriViewSet, basename='favoris')


urlpatterns = router.urls