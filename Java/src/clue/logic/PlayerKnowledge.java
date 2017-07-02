package clue.logic;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class PlayerKnowledge {

    List<Character> _characters;
    List<Weapon> _weapons;
    List<Room> _rooms;
    Map<String, Boolean> _known; 

    public PlayerKnowledge(List<Card> cards) {

        _characters = new ArrayList<>();
        _weapons = new ArrayList<>();
        _rooms = new ArrayList<>();
        _known = new HashMap<>();

        for(Character.Name name: Character.Name.values()) {
            _characters.add(new Character(name));
            _known.put(name.toString(), false);
        }
        for(Weapon.Name name: Weapon.Name.values()) {
            _weapons.add(new Weapon(name));
            _known.put(name.toString(), false);            
        }
        for(Room.Name name: Room.Name.values()) {
            _rooms.add(new Room(name));
            _known.put(name.toString(), false);
        }

        for(Card card: cards) {
            _known.put(card.toString(), true);
        }
    }
}