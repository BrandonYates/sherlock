#!/usr/bin/python

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
