from django.db import models

# Create your models here.

class ServerManager():
    
    def __init__(self):
        return

    def getServers(self):
        return ("serverWMS1", "serverWMS2", "serverWMS3", "serverWMS4")
    

class Product(models.Model):

    name     = models.CharField(max_length=255)
    code     = models.CharField(max_length=100, null=True)
    price    = models.FloatField()

    def __unicode__(self):
        return "{0}".format(self.code, )

