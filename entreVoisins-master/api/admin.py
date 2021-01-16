from django.contrib import admin

# Register your models here.

from .models import Voisin,Favoris

admin.site.register(Voisin)
admin.site.register(Favoris)