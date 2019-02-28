from rest_framework.viewsets import ReadOnlyModelViewSet
from restWMS.serializers import ProductSerializer
from restWMS.models import Product

# Create your views here.

class ProductViewSet(ReadOnlyModelViewSet):
    queryset = Product.objects.all()
    serializer_class = ProductSerializer

