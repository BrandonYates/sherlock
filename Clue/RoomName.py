#!/usr/bin/python

class RoomName:
    
    _roomName = None
    _names = ["HALL", "LOUNGE", "DININGROOM", "KITCHEN",
              "BALLROOM", "CONSERVATORY", "BILLIARDROOM",
              "LIBRARY", "STUDY"]

    def __init__(self, name);

        index = None

        #check for numeric input then string input
        try:
            index = int(name)
        except ValueError:
            index = getRoomNameIndex(name)

        if index > 0 and index < 3:
                self._roomName = _names.get(index)
                return True
        else:
            return False

    @staticmethod
    def getRoomNameIndex(x):

        return {
            "HALL" : 0,
            "LOUNGE" : 1,
            "DININGROOM" : 2,
            "KITCHEN" : 3,
            "BALLROOM" : 4,
            "CONSERVATORY" : 5,
            "BILLIARDROOM" : 6,
            "LIBRARY" : 7,
            "STUDY" : 8,
            }.get(x, -1)
    
    def getRoomName(self):
        return self._weaponName

    @staticmethod
    def getNames():
        return _names
