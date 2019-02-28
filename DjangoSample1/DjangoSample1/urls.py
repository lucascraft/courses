from django.contrib.admin import AdminSite
from django.conf.urls import url
from DjangoSample1.views import UserViewSet, GroupViewSet
from restWMS.views import ProductViewSet

"""from django.contrib import admin
"""
from django.urls import include, path
from django.contrib import admin

from django.conf.urls import url, include
from django.contrib.auth.models import User
from rest_framework import routers, serializers, viewsets

# Routers provide an easy way of automatically determining the URL conf.

router = routers.DefaultRouter()
router.register(r'users', UserViewSet)
router.register(r'groups', GroupViewSet)
router.register(r'wmsMaps', ProductViewSet)

urlpatterns = [
    url(r'^', include(router.urls)),
    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework')),
    path('polls/', include('polls.urls')),
    path('wms2map/', include('wms2map.urls')),
#    path('restWMS/', include('restWMS.urls')),
    path('admin/', admin.site.urls),
]
