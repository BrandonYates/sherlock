#!/usr/bin/python

class GamePeice(GameObject):
    _x = None
    _y = None

    def __init__(self, ID, label, x, y):
        self._id = ID
        self._label = label
        self._x = x
        self._y = y

    def getX(self):
        return self._x

    def getY(self):
        return self._y

    def move(self, newX, newY):
        self._x = newX
        self._y = newY
