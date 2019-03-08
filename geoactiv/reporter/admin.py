from django.contrib import admin
from .models import Incidences
from leaflet.admin import LeafletGeoAdmin

# Create your models here.
class IncidencesAdmin(LeafletGeoAdmin):
    list_display = ('name', 'location')

def __unicode__(self):
    return self.name

    class Meta:
        verbose_name_plural =" Incidences"

admin.site.register(Incidences, IncidencesAdmin)