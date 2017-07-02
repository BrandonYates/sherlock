#!/usr/bin/python

class Player:

    #just a string identifier
    _name = None

    #array of card objects given at game init
    _cards = None

    #player objects created at game init
    _opponents = None

    #map of cards associated with each opponent
    #opponens is like a set of keys
    #_knowledge.get(_opponents[0]) returns the knowledge
    # for the zeroth opponent
    _knowledge = {}

    def __init__(self, name):
        self._name = name

    def getName(self):
        return self_name

    def getCards(self):
        return self._cards

    def getOpponents(self):
        return self._opponents

    def setCards(self, cards):
        self._cards = cards

    def setOpponents(self, opponents):
        self._opponents = opponents


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
