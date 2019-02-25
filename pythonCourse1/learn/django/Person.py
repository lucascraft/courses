from django.db import models

class MyClass(models.Model):

    first_name = models.CharField(max_length=30)
    last_name = models.CharField(max_length=30)

