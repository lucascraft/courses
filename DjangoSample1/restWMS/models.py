from django.db import models

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

