package clue.knowledge;

import clue.logic.Character;
import clue.logic.Room;
import clue.logic.Weapon;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CluedoScenario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Character character;
    @OneToOne
    private Room room;
    @OneToOne
    private Weapon weapon;

    public CluedoScenario(Character aCharacter, Room aRoom, Weapon aWeapon) {
        this.character = aCharacter;
        this.room = aRoom;
        this.weapon = aWeapon;
    }

    public Character getCharacter() {
        return character;
    }

    // Used by Hibernate. Do not use for other purposes.
    private void setCharacter(Character character) {
        this.character = character;
    }

    public Room getRoom() {
        return room;
    }

    // Used by Hibernate. Do not use for other purposes.
    private void setRoom(Room room) {
        this.room = room;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    // Used by Hibernate. Do not use for other purposes.
    private void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
