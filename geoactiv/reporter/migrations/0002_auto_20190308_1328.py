# Generated by Django 2.1.7 on 2019-03-08 13:28

import django.contrib.gis.db.models.fields
from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('reporter', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='incidences',
            name='location',
            field=django.contrib.gis.db.models.fields.PointField(srid=4236),
        ),
    ]
