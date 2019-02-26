import xml.etree.ElementTree as ET  

class XMLUtils(object):

    #
    # Constructor
    #
    def __init__(self):
        return
        
    #
    # load XML
    #
    def loadXML(self, filename):
        xmlRef = ET.parse(str(filename))
        return xmlRef.getroot()
    
        
