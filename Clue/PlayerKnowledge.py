#!/usr/bin/python

class PlayerKnowledge:
    _playerName = None
    _cardKnowledge = {}

    def __init__(self, name):
        self._playerName = name
        
        characterNames = CharacterName.getNames()
        weaponNames = WeaponName.getNames()
        roomNames = RoomName.getNames()

        for x in range(0, characterNames.len):
            name = characterNames[x]
            self._cardKnowledge[name] = False
            
        for x in range(0, weaponNames.len):
            name = weaponNames[x]
            self._cardKnowledge[name] = False

        for x in range(0, roomNames.len):
            name = roomNames[x]
            self._cardKnowledge[name] = False

    def updateKnowledge(self, key, value):
        self._cardKnowledge.update({key: value})
        
    def getPlayerName(self):
        return self_playerName
