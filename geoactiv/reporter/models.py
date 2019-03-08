from django.db import models
from django.contrib.gis.db import models as gisModel
from django.db.models import Manager as GeoManager
# Create your models here.
class Incidences(models.Model):
    
    name = models.CharField(max_length=20)
    location = gisModel.PointField(srid=4236)
    objects = GeoManager()
    
def __unicode__(self):
    return self.name
