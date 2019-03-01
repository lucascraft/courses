from rest_framework import serializers
from restWMS.models import Product, Colors, ProjectSetup, Fixture

class ProductSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Product
        fields = ('date_add', 'name', 'code', 'price')

class ColorsSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Colors
        fields = ('date_add', 'name', 'webTag', 'l_red', 'l_green', 'l_blue')

class ProjectSetupSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = ProjectSetup
        fields = ('name', 'fixtures_id')

class FixtureSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Fixture
        fields = ('date_add', 'name', 'l_x', 'l_y', 'direction', 'mode')

