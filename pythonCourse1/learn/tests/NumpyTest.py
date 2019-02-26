import numpy as np
from test.test_deque import fail
import unittest

class NumpyTest(unittest.TestCase):

    #
    # NpArray sanity check
    #
    def testNumpyArray(self):
        npArray = np.array(object, dtype=None, copy=True, order='K', subok=False, ndmin=0) 
         
        print(type(npArray))        
        
        if npArray is None or not str(type(npArray)) == "<class 'numpy.ndarray'>":
            fail("Numpy array initialization failed")
            
        pass
    

    
    if __name__ == "__main__":
        #import sys;sys.argv = ['', 'Test.testName']
        unittest.main()
        