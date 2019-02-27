from test.test_deque import fail
import unittest

from learn.it.VUtils import VUtils
from learn.it.VMain import VMain


#
# Test utils
#
class VMainTest(unittest.TestCase):

    #
    # setup
    #
    
    def setUp(self):
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
        print("Test colors XML load and registering")
        VMain().initColorsFromXML("C:/Users/lucas/git/courses/pythonCourse1/learn/tests/vproject.xml")
        pass
    

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()