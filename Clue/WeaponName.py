#!/usr/bin/python

class WeaponName:
    
    _weaponName = None
    _names = ["REVOLVER", "CANDLESTICK", "LEADPIPE",
              "KNIFE", "ROPE", "WRENCH"]

    def __init__(self, name);

        index = None

        #check for numeric input then string input
        try:
            index = int(name)
        except ValueError:
            index = getWeaponNameIndex(name)

        if index > 0 and index < 3:
                self._weaponName = _names.get(index)
                return True
        else:
            return False

    @staticmethod
    def getWeaponNameIndex(x):

        return {
            "REVOLVER" : 0,
            "CANDLESTICK" : 1,
            "LEADPIPE" : 2,
            "KNIFE" : 3,
            "ROPE" : 4,
            "WRENCH" : 5,
            }.get(x, -1)
    
    def getWeaponName(self):
        return self._weaponName

    @staticmethod
    def getNames():
        return _names
