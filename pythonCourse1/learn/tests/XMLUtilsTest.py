import unittest

from test.test_deque import fail
from learn.it.XMLUtils import XMLUtils

#
# Test XML utils
#

class XMLUtilsTest(unittest.TestCase):

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
    
    def testXMLParser(self):
        print("Test XML parsing")
        
        try:
            xmlRoot = XMLUtils().loadXML("C:/Users/lucas/git/courses/pythonCourse1/learn/tests/vproject.xml")
            if xmlRoot is None:
                fail("XML parsing failed")
            else:                
                if len(xmlRoot) == 12:
                    pass
                else:
                    fail("XML document should have defined color 12 items")
        except ValueError as e:
            print(e)
            fail(e)
            
    

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()