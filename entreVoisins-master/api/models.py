from django.db import models

# Create your models here.

class Voisin(models.Model):
    id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=100, blank=False, null=True) 
    phone = models.CharField(max_length=100, blank=False, null=True) 
    address = models.CharField(max_length=100, blank=False, null=True) 
    #photo = models.ImageField(upload_to="photos/")
    about_me = models.TextField(blank=False, null=False)

    def __str__(self):
        return self.name

class Favoris(models.Model):
    id = models.AutoField(primary_key=True)
    id_voisin = models.IntegerField()  
    favoris = models.ForeignKey(Voisin,on_delete=models.CASCADE)

    def __str__(self):
        return str(self.id_voisin)