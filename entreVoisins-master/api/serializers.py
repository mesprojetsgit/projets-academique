from rest_framework import serializers
from .models import Voisin,Favoris

class VoisinSerializer(serializers.ModelSerializer):
    class Meta:
        model = Voisin
        fields = ('id','name','phone','address','about_me')


class FavoriSerializer(serializers.ModelSerializer):
    #favoris = VoisinSerializer()

    class Meta:
        model = Favoris
        fields = ('id','id_voisin', 'favoris')