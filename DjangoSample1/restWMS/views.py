from rest_framework.viewsets import ReadOnlyModelViewSet
from restWMS.serializers import ProductSerializer, ColorsSerializer
from restWMS.models import Product, Colors

# Create your views here.

class ProductViewSet(ReadOnlyModelViewSet):
    queryset = Product.objects.all()
    serializer_class = ProductSerializer


class ColorsViewSet(ReadOnlyModelViewSet):
    queryset = Colors.objects.all()
    serializer_class = ColorsSerializer

