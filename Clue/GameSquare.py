#!/usr/bin/python

class GameSquare:
    _occupied = False
    _valid = False
    _peice = None

    def __init__(self, occupied, valid, peice):

        self._occupied = occupied
        self._valid = valid
        self._peice = peice

    def setValid(self):
        self._valid = True

    def setPeice(self, peice):

        if not self._occupied and
        not peice is None:
           self._peice = peice
           self._occupied = True
        elif peice is None:
            self._occupied = False
            self._peice = peice

        #update square if unoccupied
        #returns None if occupied
        #returns the correct state of the object
        return self._peice

    def isValid():
        return self._valid

    def isOccupied():
        return self._occupied
        
