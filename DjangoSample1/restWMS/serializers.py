from rest_framework import serializers
from restWMS.models import Product

class ProductSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Product
        fields = ('date_add', 'name', 'code', 'price')

