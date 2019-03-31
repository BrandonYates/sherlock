package clue.knowledge;

import clue.logic.Character;
import clue.logic.Player;
import clue.logic.Room;
import clue.logic.Weapon;

import javax.persistence.*;

@Entity
public class Suggestion extends CluedoScenario {

  @OneToOne
  private Player player;

  public Suggestion(Player aPlayer, Character aCharacter, Room aRoom, Weapon aWeapon) {
    super(aCharacter, aRoom, aWeapon);
    player = aPlayer;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }
}
