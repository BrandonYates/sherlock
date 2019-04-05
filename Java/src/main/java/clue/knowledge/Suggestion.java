package clue.knowledge;

import clue.logic.Character;
import clue.logic.Player;
import clue.logic.Room;
import clue.logic.Weapon;

import javax.persistence.*;

@Entity
public class Suggestion {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @OneToOne
  private Player player;

  @OneToOne
  private CluedoScenario suggestedScenario;

  public Suggestion() {

  }

  public Suggestion(Player aPlayer, Character aCharacter, Room aRoom, Weapon aWeapon) {
    player = aPlayer;
    suggestedScenario = new CluedoScenario(aCharacter, aRoom, aWeapon);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public clue.logic.Player getPlayer() {
    return player;
  }

  public void setPlayer(clue.logic.Player player) {
    this.player = player;
  }

  public CluedoScenario getSuggestedScenario() {
    return suggestedScenario;
  }
  public void setSuggestedScenario(CluedoScenario suggestedScenario) {
    this.suggestedScenario = suggestedScenario;
  }
}
