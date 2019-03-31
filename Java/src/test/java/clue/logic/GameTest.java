package clue.logic;

import clue.knowledge.CluedoScenario;
import byates.game.GameBoard;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {


    @Test
    public void testMakePlayers() {

        Game tExampleGame = new Game("Example Game");

        String[] tPlayerLabels = {"Player 0", "Player 1", "Player 2", "Player 3", "Player 4", "Player 5"};

        tExampleGame.makePlayers(tPlayerLabels);

        List<Player> tPlayers = tExampleGame.getPlayers();

        Assert.assertEquals(tPlayers.size(), tPlayerLabels.length);

        System.out.println("lol wut");
        // Assert that the players begin on valid squares
        tPlayers.forEach(tPlayer -> {
            int x = tPlayer.getPiece().getX();
            int y = tPlayer.getPiece().getY();
            System.out.println("(" + x + ", " + y + ")");
            Assert.assertTrue(GameBoard.isValidPosition(x, y));
        });
    }

    @Test
    public void testMakeDeck() {
        Game tExampleGame = new Game("Example Game");

        tExampleGame.makeDeck();

        CluedoScenario tConfidential = tExampleGame.getConfidential();

        // Assert that the confidential cards are not in the main deck.
        Assert.assertEquals(-1, tExampleGame.getDeck().indexOf(tConfidential.getCharacter()));
        Assert.assertEquals(-1, tExampleGame.getDeck().indexOf(tConfidential.getRoom()));
        Assert.assertEquals(-1, tExampleGame.getDeck().indexOf(tConfidential.getWeapon()));
    }
}
