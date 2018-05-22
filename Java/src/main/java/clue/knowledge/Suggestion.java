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
  private Player Player;
  @OneToOne
  private Room room;
  @OneToOne
  private Weapon weapon;
  @OneToOne
  private Character character;

  public Suggestion(Player aPlayer, Room aRoom, Weapon aWeapon, Character aCharacter) {
    Player = aPlayer;
    room = aRoom;
    weapon = aWeapon;
    character = aCharacter;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public clue.logic.Player getPlayer() {
    return Player;
  }

  public void setPlayer(clue.logic.Player player) {
    Player = player;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public Character getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }
}
