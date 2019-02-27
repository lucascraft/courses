from learn.it.VUtils import VUtils
from learn.it.XMLUtils import XMLUtils

#
# multiple inheritance
#
class VMain(VUtils, XMLUtils):

    def __init__(self):
        super().__init__()
        return
    
    
    def readColors(self, filename):
        xmlRoot = super().loadXML(str(filename))
        colors = dict()
        for c in xmlRoot:
            webTag = str(c.get("webtag"))
            colors[webTag] = super().get_Color(webTag)
        return colors