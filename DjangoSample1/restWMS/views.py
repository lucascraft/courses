from rest_framework.viewsets import ReadOnlyModelViewSet
from restWMS.serializers import ProductSerializer, ColorsSerializer,\
    FixtureSerializer
from restWMS.models import Product, Colors, Fixture, ProjectSetup

# Create your views here.

class ProductViewSet(ReadOnlyModelViewSet):
    queryset = Product.objects.all()
    serializer_class = ProductSerializer


class ColorsViewSet(ReadOnlyModelViewSet):
    queryset = Colors.objects.all()
    serializer_class = ColorsSerializer

class FixturesViewSet(ReadOnlyModelViewSet):
    queryset = Fixture.objects.all()
    serializer_class = FixtureSerializer

class SetupProjectsViewSet(ReadOnlyModelViewSet):
    queryset = ProjectSetup.objects.all()
    serializer_class = ProjectSetup
    
