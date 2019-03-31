package byates.game;

import clue.logic.Character;
import byates.game.GameBoard;
import byates.game.GamePiece;
import byates.game.GameSquare;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameBoardTest {

  @Test
  public void testInitSquare() {

    GameBoard tBoard = new GameBoard();
    GameSquare tExample = tBoard.initSquare(0,0);

    Assert.assertNotNull(tExample);
    Assert.assertFalse(tExample.isOccupied());
  }

  @Test
  public void testIsValid() {

    Character.Identity[] tIdentities = Character.Identity.values();

    // Assert that the start position of each Character Identity is valid.
    for(int i = 0; i < tIdentities.length; ++i) {
      Assert.assertTrue(GameBoard.isValidPosition(tIdentities[i].startX, tIdentities[i].startY));
    }
  }

  @Test
  public void testGameBoardToString() {

    List<GamePiece> tPieces = new ArrayList<>();

    Character.Identity[] tIdentities = Character.Identity.values();

    for(int i = 0; i < tIdentities.length; ++i) {
      GamePiece piece = new GamePiece(tIdentities[i].startX, tIdentities[i].startY);

      tPieces.add(piece);
    }

    GameBoard board = new GameBoard();

    System.out.println(board.toString());

    board = new GameBoard(tPieces);

    System.out.println("Squares for pieces");
    for(GamePiece tPiece : tPieces) {
      GameSquare tSquare = board.getSquare(tPiece.getX(), tPiece.getY());

      System.out.println(tSquare);

      Assert.assertTrue(tSquare.isOccupied());
      Assert.assertTrue(tSquare.isValid());
    }

    System.out.println("\n\n");
    System.out.println(board.toString());

    Assert.assertTrue(true);
  }
}
