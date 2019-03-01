from django.db import models
from django.db.models.deletion import CASCADE

# Create your models here.

class ServerManager():
    
    def __init__(self):
        return

    def getServers(self):
        return ("serverWMS1", "serverWMS2", "serverWMS3", "serverWMS4")
    

class Product(models.Model):

    id          = models.CharField(db_column="id",max_length=100, primary_key=True)
    name        = models.CharField(max_length=255)
    code        = models.CharField(max_length=100, null=True)
    price       = models.FloatField()
    date_add    = models.DateField()
    date_remove = models.DateField()
    
    def __unicode__(self):
        return "{0}".format(self.code, )


class Colors(models.Model):

    id          = models.CharField(db_column="id",max_length=100, primary_key=True)
    name        = models.CharField(max_length=255)
    webTag      = models.CharField(max_length=100, null=True)
    l_red       = models.FloatField()
    l_green     = models.FloatField()
    l_blue      = models.FloatField()
    date_add    = models.DateField()
    date_remove = models.DateField()
    
    def __unicode__(self):
        return "{0}".format(self.code, )
    
    
class Fixture(models.Model):
    
    id          = models.CharField(db_column="id",max_length=100, primary_key=True)
    name        = models.CharField(max_length=255)
    l_x         = models.IntegerField()
    l_y         = models.IntegerField()
    mode        = models.CharField(max_length=255)
    direction   = models.IntegerField()
    date_add    = models.DateField()
    date_remove = models.DateField()
    
class ProjectSetup(models.Model):
    
    id          = models.CharField(db_column="id",max_length=100, primary_key=True)
    name        = models.CharField(max_length=255)
    fixtures    = models.ForeignKey(Fixture, on_delete=CASCADE)
