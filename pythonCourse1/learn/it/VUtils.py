from builtins import classmethod
 
class VUtils(object):

    from colormath.color_objects import LabColor

    defaultlab = LabColor(0.903, 16.296, -2.22)
    
    colorRegistry = dict()
    
    def __init__(self):
        return
    
    @classmethod
    def get_Color(self, k):
        if str(k).startswith("#"):
            
            rr = '0x' + str(k)[1:3]
            gg = '0x' + str(k)[3:5]
            bb = '0x' + str(k)[5:7]
            
            frr = 1.0 * int(rr, 16)            
            fgg = 1.0 * int(gg, 16)                   
            fbb = 1.0 * int(bb, 16)                  
            
            self.colorRegistry[str(k)] = self.LabColor(frr, fgg, fbb)
            
            return self.colorRegistry[k]
        else:
            return self.defaultlab

    @classmethod
    def getKeys(self):
        return self.colorRegistry.keys()

    @classmethod
    def getColors(self):
        return self.colorRegistry.values()

    @classmethod
    def getColorsRegistry(self):
        return self.colorRegistry
            
