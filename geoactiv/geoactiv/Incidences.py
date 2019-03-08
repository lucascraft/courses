'''
Created on Mar 8, 2019

@author: lucas
'''
from django.db import models

class Incidences(models.Model):
    '''
    classdocs
    '''
    
    name = models.CharField(max_length=20)
    desc = models.CharField(max_length=20)

    def __init__(self, params):
        '''
        Constructor
        '''
        