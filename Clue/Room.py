#!/usr/bin/python

class Room(Card):
    _roomId = None

    def __init__(self, ID, label, roomId):
        self._id = ID
        self._label = label
        self.cardType = CardType(CardType.room)
        self._roomId = RoomName(roomId)

    def __str__(self):
        return ''.join((
            "id: ",
            self._id,
            " | ",
            self._label,
            " | ",
            self._roomId
        ))
    
    def getRoomId(self):
        return self._roomId
