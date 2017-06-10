#!/usr/bin/python

class GameBoard:
    _minWidth = 0
    _minHeight = 0
    _maxWidth = 23
    _maxHeight = 25

    _board = None
    _peices = None

    @property
    startSquares = {CharacterName.missScarlet : [_minWidth, 17],
                     CharacterName.profPlum : [6, _minHeight],
                     CharacterName.colMustard: [7, _maxHeight],
                     CharacterName.mrsPeacock : [18, _minHeight],
                     CharacterName.mrsWhite : [_maxWidth, 14],
                     CharacterName.mrGreen : [_maxWidth, 9]}

    def __init__(self):

        for x in range(_maxWidth):
            for y in range(_maxHeight):
                _board[x][y] = initSquare(x, y)
        

    def initBoard(self):
        for x in range(_maxWidth):
            for y in range(_maxHeight):
                _board[x][y] = initSquare(x, y)

    def initSquare(x, y):

        valid = isValidPosition(x,y):

        return GameSquare(False, valid, None):

    def isStartSquare(x, y):
        if x == _minWidth and y == 17:
            return True
        elif x == _maxWidth:
            if y == 14 or y == 9:
                return True
        elif y == _minHeight and x == 6:
            return True
        elif y == maxHeight:
            if x == 6 or x == 7:
                return True

        return False
            
    def isValidPosition(x, y):

        #start spaces are valid
        #other edges are not
        #rooms are invalid
        #all other spaces are valid
        if isStartSquare(x,y):
            return True
        #all other edge spaces are not
        elif x == _minWdith or x == _maxWidth:
            return False
        elif y == _minHeight or y == _maxHeight:
            return False
        #Study
        elif x < 4 and y < 7:
            return False
        #Library
        elif x > 5 and x < 11 and y < 6:
            return False
        #Library 2
        elif x > 6 and x < 10 and y == 6:
            return False
        #Billiard Room
        elif x > 11 and x < 17 and y < 6:
            return False
        #Conservatory 
        elif x > 18 and y < 5:
            return False
        #Conservatory 2
        elif x > 19 and y < 6:
            return False
        #Hall
        elif x > 0 and x < 7 and y > 8 and y < 15:
            return False
        #Staircase/ Clue center
        elif x > 7 and x < 15 and y > 8 and y < 14:
            return False
        #Ball Room
        elif x > 16 and x < 23 and y > 7 and y < 9:
            return False
        #Ball Room 2
        elif x > 16 and x < _maxWidth and y > 8 and y < 14:
            return False
        #Ball Room 3
        elif x > 16 and x < 23 and y > 13 and y < 16:
            return False
        #Lounge
        elif x > _minWidth and x < 6 and y > 16 and y < _maxHeight:
            return False
        #Dinging Room
        elif x > 8 and x < 15 and y > 17 and y < 21:
            return False
        #Dining Room 2
        elif x > 8 and x < 16 and y > 20 and y < _maxHeight:
            return False
        #Kitchen
        elif x > 17 and x < _maxWidth and y > 19 and y < _maxHeight:
            return False
        else:
            return True

    def __str__(self):

        string = ''
        for x in range(_maxWidth):
            for y in range(_maxHeight):
                square = _board[x][y]

                if square.isValid():
                    string + "[]"
                else:
                    string + "{}"
            string = "\n"
        return string
    """
    def setPeices(self, peices):

        
        

    def movePiece(self, peiceName):
    """
