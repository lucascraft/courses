import unittest

import numpy as np
from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt
from learn.it.XMLUtils import XMLUtils
from learn.it.VUtils import VUtils
from matplotlib.pyplot import hsv
import numpy as np
from cv2 import cv2

#
# Test utils
#

class Plot3DTest(unittest.TestCase):

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



    def randrange(self, n, vmin, vmax):
        '''
        Helper function to make an array of random numbers having shape (n, )
        with each number distributed Uniform(vmin, vmax).
        '''
        return (vmax - vmin)*np.random.rand(n) + vmin

    #
    # test color registry
    #
    
    def testNumpyNoise3DPlot2(self):
        fig = plt.figure()
        
        ax = fig.add_subplot(111, projection='3d')
        
        vUtils = VUtils()
        
        vUtils.initColorsFromXML("C:/Users/lucas/git/courses/pythonCourse1/learn/tests/vproject.xml")
        
        xs = []
        ys = []
        zs = []
        
        for color in vUtils.colorRegistry.items():
            xs.append(color[1].lab_l)
            ys.append(color[1].lab_a)
            zs.append(color[1].lab_b)
            
        # For each set of style and range settings, plot n random points in the box
        # defined by x in [23, 32], y in [0, 100], z in [zlow, zhigh].
        for c, m, zlow, zhigh in [('r', 'o', -50, -25), ('b', '^', -30, -5)]:
            ax.scatter(xs, ys, zs, c=c, marker=m)
        
        ax.set_xlabel('X Label')
        ax.set_ylabel('Y Label')
        ax.set_zlabel('Z Label')
        
        #plt.show()
        
        
if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()