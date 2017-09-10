#/usr/bin/python

class Character(Card):
    _characterId = None

    def __init__(self, ID, label, characterId):
        self._id = ID
        self._label = label
        self._cardType = CardType(CardType.character)
        self._characterId = CharacterName(characterId)

    def __str__(self):
        return ''.join((
            "id: ",
            self._id,
            " | ",
            self._label,
            " | ",
            self._characterId
        ))
    
    def getRoomId(self):
        return self._characterId

class CharacterName():
    
    _names = ["COLMUSTARD", "PROFPLUM", "MRGREEN",
              "MRSPEACOCK", "MISSSCARLET", "MRSWHITE"]
    colMustard = "COLMUSTARD"
    profPlum = "PROFPLUM"
    mrGreen = "MRGREEN"
    mrsPeacock = "MRSPEACOCK"
    missScarlet = "MISSSCARLET"
    mrsWhite = "MRSWHITE"

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
