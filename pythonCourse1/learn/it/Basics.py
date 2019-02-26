import datetime
from learn.it.VUtils import VUtils
from learn.it.XMLUtils import XMLUtils

if __name__ == '__main__':
    pass

datetime.datetime.now()

print('Started @ ' + str(datetime.datetime.now().time()))

vutils = VUtils()

xmlRoot = XMLUtils().loadXML("C:/Users/lucas/git/courses/pythonCourse1/learn/tests/vproject.xml")

print("XML defined " + str(len(xmlRoot)) + " elements")

for child in xmlRoot:
    print(child.tag, child.attrib)

vutils.initColorsFromXML("C:/Users/lucas/git/courses/pythonCourse1/learn/tests/vproject.xml")

color = vutils.get_Color("#FF001D")

for k, v in vutils.getColorsRegistry().items():
    print(k, v)


