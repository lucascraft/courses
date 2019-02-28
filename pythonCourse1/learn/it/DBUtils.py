import mysql.connector
from mysql.connector import Error
from learn.it.VUtils import VUtils
from datetime import date
from ipykernel.kernelbase import now



DB_SETTINGS = {
        'ENGINE': 'django.db.backends.mysql',
        'DB': 'restwms',
        'USER': 'root',
        'PASSWORD': 'mysql4EVER',
        'HOST': '127.0.0.1', # Or an IP Address that your DB is hosted on
        'PORT': '3306',
}

try:
    connection = mysql.connector.connect(host=DB_SETTINGS.get('HOST', '17.0.0.1'),
                                database=DB_SETTINGS.get('DB'),
                                 user=DB_SETTINGS.get('USER'),
                                 password=DB_SETTINGS.get('PASSWORD'))
    if connection.is_connected():
        db_Info = connection.get_server_info()   
        print("Connected to MySQL database... MySQL Server version on ",db_Info)
        cursor = connection.cursor()
        cursor.execute("select database();")
        record = cursor.fetchone()
        print ("Your connected to - ", record)
        
        
        vutils = VUtils()
        
        xmlRoot = vutils.initColorsFromXML("C:/Users/lucas/git/courses/pythonCourse1/learn/tests/vproject.xml")
        idx = 1 
        for c in xmlRoot:
            colorTag = str(c.attrib.get("webTag"))
            color = vutils.get_Color(colorTag)
            lRed = color.get_value_tuple()[0]
            lGreen = color.get_value_tuple()[1]
            lBlue = color.get_value_tuple()[2]
            row = """insert into restwms.restwms_colors(id, name, webtag, l_red, l_green, l_blue) values (' """ + str(idx) + """', '""" + colorTag + """', '""" + colorTag + """', """ + str(lRed) + """, """ + str(lGreen) + """, """ + str(lBlue) + """);"""
            print(row)
            cursor.execute(row)
           
            idx = int(idx) + 1

        
        
except Error as e :
    print ("Error while connecting to MySQL", e)
finally:
    #closing database connection.
    if(connection.is_connected()):
        cursor.close()
        connection.close()
        print("MySQL connection is closed")

if __name__ == '__main__':
    pass