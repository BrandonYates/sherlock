package clue.logic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

@Entity
public class GameBoard extends GameObject {

  public static final int minWidth = 0;
  public static final int minHeight = 0;
  public static final int maxWidth = 25;
  public static final int maxHeight = 25;

  /**
   * board is a 2d array. Here it is represented as a list
   * so that it will map better in the database. The index
   * is calculated by the following equation.
   * index = rowNumber * maxWidth + columnNumber;
   */
  @OneToMany
  List<GameSquare> board;

  @OneToMany
  List<GamePiece> pieces;

  /**
   * Constructor
   */
  public GameBoard() {
    this(new ArrayList<>());
  }

  public GameBoard(List<GamePiece> pieces) {
    label = "GameBoard";
    board = new ArrayList<>();
    for(int x = 0; x < maxWidth; ++x) {
      for(int y = 0; y < maxHeight; ++y) {
        board.add(initSquare(x, y));
      }
    }

    for (GamePiece piece: pieces) {
      getSquare(piece.getX(), piece.getY()).setPiece(piece);
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
    else if (y == minHeight && (x == 7 || x == 17)) {
      return true;
    }
    else if (y == (maxHeight -1) && (x == 5 || x == 18)) {
      return true;
    }
    return false;
  }

  public boolean isMiscClosedSquare(int x, int y) {

    if (x == 23 && (y == 6 || y == 17)) {
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
      System.out.println("isStartSquare(" + x + ", " + y +")");
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

  public GameSquare getSquare(int x, int y) {
    if((y * maxWidth + x) > board.size()) {
      System.out.println("x: " + x + " y: " + y);
      Thread.dumpStack();
    }
    return board.get(y * maxWidth + x);
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

        square = getSquare(x, y);

        if(square == null) {
          System.out.println("square == null");
        }

        String squareContent = "{X}";
        if(square.isValid()) {
          if(square.isOccupied()) {
            squareContent = "[i]";
          } else {
            squareContent = "[ ]";
          }
        }
        builder.append(squareContent);
      }
      builder.append("\n");
    }

    return builder.toString();
  }
}
