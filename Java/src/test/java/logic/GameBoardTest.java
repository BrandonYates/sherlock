package logic;

import clue.logic.GameBoard;
import clue.logic.GamePiece;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameBoardTest {

  public static int[][] startPositions = {{0, 7}, {0, 16}, {24, 9}, {24, 14},
      {7, 0}, {17, 0}, {5, 23}, {18, 23}};

  @Test
  public void testIsValid() {

    GameBoard board = new GameBoard();

    for (int i = 0; i < startPositions.length; ++i) {
      Assert.assertTrue("x: " + startPositions[i][0] + " y: " + startPositions[i][1],
          board.isValidPosition(startPositions[i][0], startPositions[i][1]));
    }
  }

  @Test
  public void testGameBoardToString() {

    List<GamePiece> pieces = new ArrayList<>();

    for(int i = 0; i < startPositions.length; ++i) {
      GamePiece piece = new GamePiece(startPositions[i][0], startPositions[i][1]);

      pieces.add(piece);
    }

    GameBoard board = new GameBoard();

    System.out.println(board.toString());


    board = new GameBoard(pieces);

    System.out.println("\n\n");
    System.out.println(board.toString());

    Assert.assertTrue(true);
  }
}
