import unittest
from test.test_deque import fail
from learn.it.VUtils import VUtils

#
# Test utils
#

class VUtilTest(unittest.TestCase):

    #
    # setup
    #
    
    def setUp(self):
        self.colors = ["#AABBCC", "#FF00AA", "#123456", "#EE2312", "#AACCFF"]
        for c in self.colors:
            VUtils.register_Color(c)
        pass


    #
    # tear down
    #
    
    def tearDown(self):
        pass

    #
    # test color registry
    #
    
    def testColorRegistryInit(self):
        print("Test registry")
        if len(VUtils.getColorsRegistry().keys()) != 5 and len(VUtils.getColorsRegistry().keys()) != 18:
            print("Color registry length should have been 5 but was " + str(len(VUtils.getColorsRegistry().keys())))
            fail()
        else:
            pass
    
    #
    # test color
    #
    
    def testColorFromRGBHex(self):
        self.color =  VUtils.get_Color("#AABBCC");
        print("Test #AABBCC exist")
        if int(self.color.get_value_tuple()[0]) < 0 or int(self.color.get_value_tuple()[0]) > 255:
            fail("red value should have been on range [0-255] and is " + str(self.color.get_value_tuple()[0]))
        if int(self.color.get_value_tuple()[1]) < 0 or int(self.color.get_value_tuple()[1]) > 255:
            fail("green value should have been on range [0-255] and is " + str(self.color.get_value_tuple()[1]))
        if int(self.color.get_value_tuple()[2]) < 0 or int(self.color.get_value_tuple()[2]) > 255:
            fail("blue value should have been on range [0-255] and is " + str(self.color.get_value_tuple()[2]))
        else:
            pass

    #
    # test color registry initialization from XML
    #
    def testInitColorRegistryFromXML(self):
        xmlColors = ["#123FFF", "#AA34DD", "#33DDFF", "#AAEEDE", "#FF0013", "#000023", "#EF47EA", "#FF2354", "#7899FF", "#00E3DE", "#9912E4", "#EF54FE", "#FF001D"]
        xmlRoot= VUtils.initColorsFromXML("C:/Users/lucas/git/courses/pythonCourse1/learn/tests/vproject.xml")
        for c in xmlRoot:
            colorTag = str(c.attrib.get("webTag"))
            if not xmlColors.index(colorTag) >= 0:
                fail("Color registry initialization from XML definition failed")
        pass

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()