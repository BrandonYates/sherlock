package clue.logic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

@Entity
public class GameBoard extends GameObject {

  private int minWidth = 0;
  private int minHeight = 0;
  private int maxWidth = 25;
  private int maxHeight = 25;

  /**
   * board is a 2d array. Here it is represented as a list
   * so that it will map better in the database. The index
   * is calculated by the following equation.
   * index = rowNumber * maxWidth + columnNumber;
   */
  @OneToMany @JoinColumn(name = "GAME_OBJECT_ID")
  List<GameSquare> board;

  @OneToMany @JoinColumn(name = "GAME_OBJECT_ID")
  List<GamePiece> pieces;

  /**
   * Constructor
   */
  public GameBoard() {

    label = "GameBoard";
    board = new ArrayList<>();
    for(int x = 0; x < maxWidth; ++x) {
      for(int y = 0; y < maxHeight; ++y) {
        board.add(initSquare(x, y));
      }
    }
  }

  public GameSquare initSquare(int x, int y) {

    boolean isValid = isValidPosition(x, y);

    return new GameSquare(false, isValid, null);
  }

  public boolean isStartSquare(int x, int y) {

    if(x == minWidth && (y == 7 || y == 16)) {
      return true;
    }
    else if (x == (maxWidth - 1) && (y == 9 || y == 14)) {
      return true;
    }
    else if (y == minHeight && (x == 5 || x == 18)) {
      return true;
    }
    else if (y == maxHeight && (x == 6 || x == 17)) {
      return true;
    }
    return false;
  }

  public boolean isMiscClosedSquare(int x, int y) {
    if ((x == 6 || x == 8) && y == 23) {
      return true;
    }
    else if (x == 16 && y == 23) {
      return true;
    }
    else if (x == 23 && (y == 6 || y == 17)) {
      return true;
    }
    return false;
  }

  //returns whether a given position is valid
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
    //Study
    else if (x < 4 && y < 7) {
      return false;
    }
    //Library
    else if (x > 5 && x < 11 && y < 6) {
      return false;
    }
    //Library 2
    else if (x > 6 && x < 10 && y == 6) {
      return false;
    }
    //Billeard Room
    else if (x > 11 && x < 17 && y < 6) {
      return false;
    }
    //Conservatory
    else if (x > 18 && y < 5) {
      return false;
    }
    //Conservatory 2
    else if (x > 19 && y < 6) {
      return false;
    }
    //Hall
    else if (x > 0 && x < 7 && y > 8 && y < 15) {
      return false;
    }
    //Staircase/ Clue Center
    else if (x > 7 && x < 15 && y > 8 && y < 14) {
      return false;
    }
    //Ball Room
    else if (x > 16 && x < 23 && y > 7 && y < 16) {
      return false;
    }
    //Ball Room 2
    else if (x > 16 && x < maxWidth && y > 9 && y < 14) {
      return false;
    }
    //Lounge
    else if (x > minWidth && x < 6 && y > 16 && y < maxHeight) {
      return false;
    }
    //Dining Room
    else if (x > 8 && x < 15 && y > 15 && y < 21) {
      return false;
    }
    //Dining Room 2
    else if (x > 8 && x < 16 && y > 18 && y < maxHeight) {
      return false;
    }
    //Kitchen
    else if (x > 17 && x < maxWidth && y > 17 && y < maxHeight) {
      return false;
    }
    else if (isMiscClosedSquare(x, y)) {
      return false;
    }
    else {
      return true;
    }
  }

  public int getMinWidth() {
    return minWidth;
  }

  public void setMinWidth(int minWidth) {
    this.minWidth = minWidth;
  }

  public int getMinHeight() {
    return minHeight;
  }

  public void setMinHeight(int minHeight) {
    this.minHeight = minHeight;
  }

  public int getMaxWidth() {
    return maxWidth;
  }

  public void setMaxWidth(int maxWidth) {
    this.maxWidth = maxWidth;
  }

  public int getMaxHeight() {
    return maxHeight;
  }

  public void setMaxHeight(int maxHeight) {
    this.maxHeight = maxHeight;
  }

  public List<GameSquare> getBoard() {
    return board;
  }

  public void setBoard(List<GameSquare> board) {
    this.board = board;
  }

  public List<GamePiece> getPieces() {
    return pieces;
  }

  public void setPieces(List<GamePiece> pieces) {
    this.pieces = pieces;
  }

  public String toString() {
    GameSquare square;
    StringBuilder builder = new StringBuilder();

    for(int x = 0; x < maxWidth + 1; ++x) {
      for(int y = 0; y < maxHeight + 1; ++y) {

        if(x == maxWidth)  {
          builder.append("[" + y % 10 + "]");
          continue;
        }
        else if(y == maxHeight) {
          builder.append("[" + x % 10 + "]");
          continue;
        }

        square = board.get(y * maxWidth + x);

        if(square.isValid()) {
          builder.append("[ ]");
        }
        else {
          builder.append("{X}");
        }
      }
      builder.append("\n");
    }

    return builder.toString();
  }
}
