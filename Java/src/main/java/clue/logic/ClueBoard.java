package clue.logic;

import byates.game.GameBoard;

public class ClueBoard extends GameBoard {

    public boolean isValidPosition(int x, int y) {

    //start spaces are valid
    //other edges are not
    //rooms are invalid
    //all other spaces are valid
    if(isStartSquare(x, y)) {
      return true;
    }
    else if (x == minWidth || x == (maxWidth - 1)) {
      return false;
    }
    else if (y == minHeight || y == (maxHeight - 1)) {
      return false;
    }
    //Lounge
    else if (x < 6 && y < 7) {
      return false;
    }
    //Dining Room 1
    else if (x > 8 && x < 15 && y < 8) {
      return false;
    }
    //Dining Room 2
    else if (x == 15 && y < 5) {
      return false;
    }
    //Kitchen
    else if (x > 17 && y < 6) {
      return false;
    }
    //Hall
    else if (x < 7 && y > 8 && y < 15) {
      return false;
    }
    //clue
    else if (x > 7 && x < 15 && y > 9 && y < 15) {
      return false;
    }
    //Ball Room 1
    else if (x > 16 && x < 23 && y > 7 && y < 16) {
      return false;
    }
    // Ball Room 2
    else if (x > 22 && y > 9 && y < 14) {
      return false;
    }
    //Study
    else if (x < 4 && y > 16) {
      return false;
    }
    //Library 1
    else if (x > 5 && x < 11 && y > 17) {
      return false;
    }
    //Library 2
    else if (x > 6 && x < 10 && y == 17) {
      return false;
    }
    //Billiard Room
    else if (x > 11 && x < 17 && y > 17) {
      return false;
    }
    //Conservatory 1
    else if (x > 18 && y > 18) {
      return false;
    }
    //Conservatory 2
    else if (x > 19 && y == 18) {
      return false;
    }
    else if (isMiscClosedSquare(x, y)) {
      return false;
    }
    else {
      return true;
    }
  }

  private boolean isMiscClosedSquare(int aX, int aY) {

  }

  private boolean isStartSquare(int aX, int aY) {

  }
}
