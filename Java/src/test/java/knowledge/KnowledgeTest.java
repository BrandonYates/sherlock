package knowledge;

import clue.logic.Card;
import clue.logic.CardName;
import clue.logic.Character;
import clue.logic.Game;
import clue.logic.Player;
import clue.logic.Room;
import clue.logic.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeTest {

  @Before
  public void setup() {

    ownPlayer1 = new Player("Own Player 1");
    otherPlayers1 = new ArrayList<>();

    for(int i = 0; i < 4; ++i) {
      otherPlayers1.add(new Player("Other Player " + i));
    }

    testDeck1 = new ArrayList<>();

    for(Character.Name name: Character.Name.values()) {
      testDeck1.add(new Character(name));
    }

    for(Room.Name name : Room.Name.values()) {
      testDeck1.add(new Room(name));
    }

    for(Weapon.Name name: Weapon.Name.values()) {
      testDeck1.add(new Weapon(name));
    }

  }


  @Test
  public void TestMcTest() {
    System.out.println("TestMcTest");

    Assert.assertTrue(true);
    Assert.assertFalse(false);
  }


  private Player ownPlayer1;
  private List<Player> otherPlayers1;
  private List<Card> testDeck1;
  private Character solutionCharacter1 = new Character(Character.Name.MRGREEN);
  private Room solutionRoom1 = new Room(Room.Name.LOUNGE);
  private Weapon SolutionWeapon1 = new Weapon(Weapon.Name.REVOLVER);
}