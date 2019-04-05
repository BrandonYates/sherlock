package clue.knowledge;

import clue.logic.Card;
import clue.logic.Character;
import clue.logic.Room;
import clue.logic.Weapon;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CluedoScenario {

  public CluedoScenario() {

    this.character = null;
    this.room = null;
    this.weapon = null;
  }

  public CluedoScenario(Character aCharacter, Room aRoom, Weapon aWeapon) {
    this.character = aCharacter;
    this.room = aRoom;
    this.weapon = aWeapon;
  }

  public Card getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }

  public Card getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Card getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  @OneToOne
  private Character character;

  @OneToOne
  private Room room;

  @OneToOne
  private Weapon weapon;
}
