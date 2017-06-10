#!/usr/bin/python

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
