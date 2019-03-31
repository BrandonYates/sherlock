package byates.game;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

@Entity
public abstract class GameBoard extends GameObject {

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
  private List<GameSquare> board;

  @OneToMany
  private List<GamePiece> pieces;

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

  //returns whether a given position is valid
  abstract public boolean isValidPosition(int x, int y);

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
      Thread.dumpStack();
    }
    return board.get(y * maxWidth + x);
  }

  public String toString() {
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

        GameSquare square = getSquare(x, y);

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
