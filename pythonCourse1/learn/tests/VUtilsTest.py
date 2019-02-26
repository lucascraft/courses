import unittest

from learn.it.VUtils import VUtils
from test.test_deque import fail

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
        del self.color
        pass

    #
    # test color registry
    #
    
    def testColorRegistryInit(self):
        print("Test registry")
        if len(VUtils.getColorsRegistry().keys()) != 5:
            fail("Color registry length should have been 5")
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


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()