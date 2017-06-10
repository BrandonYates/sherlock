#!/usr/bin/python

class GameObject:
    _id = 0;
    _label = "default label"

    def __init__(self, ID, label):
        self._id = ID
        self._label = label
        
    def __str__(self):
        return ''.join((
            "id: ",
            self._id,
            " | ",
            self._label
        ))

    def getId(self):
        return self._id

    def getLabel(self):
        return self._label
