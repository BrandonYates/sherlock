package clue.test;

import clue.logic.GameBoard;
import clue.logic.Player;

public class GameTest {


    public static void run() {
        System.out.println("#######################");
        System.out.println("#### Run GameTest  ####");
        System.out.println("#######################");
        newGameTest();
        System.out.println("#######################");
    }

    public static void newGameTest() {

        System.out.println(tab + "###############");
        System.out.println(tab + "###############");
        System.out.println(tab + "# newGameTest #");

        System.out.println(tab + "Creating GameBoard..");
        GameBoard board = new GameBoard();

        Player firstPlayer = new Player("Player 1");

        System.out.println(tab + "###############");
    }

    private static final String tab = "  ";
}
