import unittest

from learn.it.VUtils import VUtils
from test.test_deque import fail

class VUtilTest(unittest.TestCase):

    def setUp(self):
        self.color =  VUtils.get_Color("#AABBCC");
        pass


    def tearDown(self):
        del self.color
        pass

    def testColorFromRGBHex(self):
        
        print("Test #AABBCC")
        
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