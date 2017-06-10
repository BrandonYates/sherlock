#!/usr/bin/python

class Weapon(Card):
    _weaponId = None

    def __init__(self, ID, label, weaponId):
        self._id = ID
        self._label = label
        self._cardType = CardType(CardType.weapon)
        self._weaponId = WeaponName(weaponId)

    def __str__(self):
        return ''.join((
            "id: ",
            self._id,
            " | ",
            self._label,
            " | ",
            self._weaponId
        ))
    
    def getWeaponId(self):
        return self._weaponId
