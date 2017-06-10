#!/usr/bin/python

class CharacterName:
    
    _names = ["COLMUSTARD", "PROFPLUM", "MRGREEN",
              "MRSPEACOCK", "MISSSCARLET", "MRSWHITE"]
    @property
    colMustard = "COLMUSTARD"
    @property
    profPlum = "PROFPLUM"
    @property
    mrGreen = "MRGREEN"
    @property
    mrsPeacock = "MRSPEACOCK"
    @property
    missScarlet = "MISSSCARLET"
    @property
    mrsWhite = "MRSWHITE"

    def __init__(self, name);

        index = None

        #check for numeric input then string input
        try:
            index = int(name)
        except ValueError:
            index = getCharacterNameIndex(name)

        if index > 0 and index < 3:
                self._characterName = _names.get(index)
                return True
        else:
            return False

    @staticmethod
    def getCharacterNameIndex(x):

        return {
            "COLMUSTARD" : 0,
            "PROFPLUM" : 1,
            "MRGREEN" : 2,
            "MRSPEACOCK" : 3,
            "MISSSCARLET" : 4,
            "MRSWHITE" : 5,
            }.get(x, -1)

    @staticmethod
    def getNames():
        return _names
