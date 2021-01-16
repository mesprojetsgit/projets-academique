from django.shortcuts import render
# Create your views here.
from rest_framework import viewsets
from .models import Voisin,Favoris
from .serializers import VoisinSerializer,FavoriSerializer
from rest_framework.response import Response
from django.shortcuts import get_object_or_404
from django.http import JsonResponse



#viewset du voisin
class VoisinViewSet(viewsets.ViewSet):
    #queryset = Blog.objects.all()
    serializer_class = VoisinSerializer

    def get_object(self, pk):
        try:
            return Voisin.objects.get(pk=pk)
        except ObjectDoesNotExist:
            raise Http404

    def list(self, request):
        queryset = Voisin.objects.all()
        serializer = VoisinSerializer(queryset, many=True)
        return Response(serializer.data)

    
    def create(self, request):

        serializer = VoisinSerializer(data=request.data)

        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)



    def update(self, request, pk=None):
        instance = self.get_object(pk)
        serializer = VoisinSerializer(instance, data=request.data, partial=True)

        # On verifie si tous les champs sont renseigne
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        else:
            return Response(
                serializer.errors,
                status=status.HTTP_400_BAD_REQUEST
            )

    def retrieve(self, request, pk=None):
        queryset = Voisin.objects.all()
        user = get_object_or_404(queryset, pk=pk)
        serializer = VoisinSerializer(user)

        return Response(serializer.data)

    def destroy(self, request, pk=None):
        instance = self.get_object(pk)
        instance.delete()

        return Response({'message': " voisin has been deleted"})



#viewset du favori
class FavoriViewSet(viewsets.ViewSet):
    #queryset = Blog.objects.all()
    serializer_class = FavoriSerializer

    def get_object(self, pk):
        try:
            return Favoris.objects.get(pk=pk)
        except ObjectDoesNotExist:
            raise Http404

    def list(self, request):
        queryset = Favoris.objects.all()
        serializer = FavoriSerializer(queryset, many=True)
        return Response(serializer.data)

    def create(self, request):

        serializer = FavoriSerializer(data=request.data)

        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)

    def update(self, request, pk=None):
        instance = self.get_object(pk)
        serializer = FavoriSerializer(instance, data=request.data, partial=True)

        # On verifie si tous les champs sont renseigne
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        else:
            return Response(
                serializer.errors,
                status=status.HTTP_400_BAD_REQUEST
            )

    def retrieve(self, request, pk=None):
        queryset = Favoris.objects.all()
        user = get_object_or_404(queryset, pk=pk)
        serializer = FavoriSerializer(user)

        return Response(serializer.data)

    def destroy(self, request, pk=None):
        instance = self.get_object(pk)
        instance.delete()

        return Response({'message': " favori has been deleted"})
