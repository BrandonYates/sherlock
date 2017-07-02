#!/usr/bin/python

from .Game import GameObject

class Card(GameObject):
    cardType = "unknown"

    def __init__(self, ID, label, cardType):
        self.identifier = ID
        self.label = label
        self.cardType = cardType

    def __str__(self):
        return ''.join((
            "id: ",
            self.identifier,
            " | ",
            self.label,
            " | ",
            self.cardType
        ))
    
    def getCardType(self):
        return self.cardType

    def setCardType(self, newType):
        self.cardType = newType

class CardType:
    
    cardType = None
    character = 0
    weapon = 1
    room = 2
    types = ["CHARACTER", "WEAPON", "ROOM"]

    def __init__(self, cardType):

        index = None

        #check for numeric input then string input
        try:
            index = int(userInput)
        except ValueError:
            index = getCardType(cardType)

        if index > 0 and index < 3:
                self.cardType = types.get(index)
                return True
        else:
            return False

    @staticmethod
    def getCardType(x):

        return {
            'CHARACTER': 0,
            'WEAPON': 1,
            "ROOM": 2,
            }.get(x, -1)
    
    @property
    def character(self):
        return type(self).character
    @property
    def weapon(self):
        return type(self).weapon
    @property
    def room(self):
        return type(self).room

