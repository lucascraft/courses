from rest_framework import serializers
from restWMS.models import Product, Colors

class ProductSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Product
        fields = ('date_add', 'name', 'code', 'price')

class ColorsSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Colors
        fields = ('date_add', 'name', 'webTag', 'l_red', 'l_green', 'l_blue')

