package clue.knowledge;

import clue.logic.Player;
import clue.logic.Room;
import clue.logic.Weapon;

public class Suggestion {

    private Player _suggestionPlayer;
    private Room _room;
    private Weapon _weapon;
    private Character _character;

    public Suggestion(Player aPlayer, Room aRoom, Weapon aWeapon, Character aCharacter) {
        _suggestionPlayer = aPlayer;
        _room = aRoom;
        _weapon = aWeapon;
        _character = aCharacter;
    }

    public Player getPlayer() {
        return _suggestionPlayer;
    }

    public Room getRoom() {
        return _room;
    }

    public Weapon getWeapon() {
        return _weapon;
    }

    public Character getCharacter() {
        return _character;
    }
}
