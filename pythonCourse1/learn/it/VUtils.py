from builtins import classmethod
 
#
# Visual utils
#

class VUtils(object):

    from colormath.color_objects import LabColor

    #
    # default color
    #
    defaultlab = LabColor(0.903, 16.296, -2.22)
    
    #
    # color registry
    #
    colorRegistry = dict()
    
    #
    # constructor
    #
    def __init__(self):
        return
        
    @classmethod
    #
    # register color
    #
    def register_Color(self, k):
        self.get_Color(k)

    @classmethod
    #
    # get color
    #
    def get_Color(self, k):
        if str(k).startswith("#"):
            
            rr = '0x' + str(k)[1:3]
            gg = '0x' + str(k)[3:5]
            bb = '0x' + str(k)[5:7]
            
            frr = 1.0 * int(rr, 16)            
            fgg = 1.0 * int(gg, 16)                   
            fbb = 1.0 * int(bb, 16)                  
            
            if self.colorRegistry.get(str(k)) is None:
                self.colorRegistry[str(k)] = self.LabColor(frr, fgg, fbb)
                print("Added color " + str(k))
            
            return self.colorRegistry[k]
        else:
            return self.defaultlab

    @classmethod
    #
    # get keys
    #
    def getKeys(self):
        return self.colorRegistry.keys()

    @classmethod
    #
    # get colors
    #
    def getColors(self):
        return self.colorRegistry.values()

    @classmethod
    #
    # get colors registry
    #
    def getColorsRegistry(self):
        return self.colorRegistry
            
