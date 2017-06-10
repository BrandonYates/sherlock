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
