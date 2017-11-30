package clue.knowledge;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import clue.logic.Card;
import clue.logic.Character;
import clue.logic.Room;
import clue.logic.Weapon;

public class PlayerKnowledge {

    public enum Info {
        HAS, HASNOT, UNKNOWN
    }

    private List<Character> _characters;
    private List<Weapon> _weapons;
    private List<Room> _rooms;

    //maps the name of a card to what an external player
    //could know about their knowledge
    //example: Player 1 was handed the Rope card as evidence
    //against an accusation. Thus in the Rope card is mapped to HAS 
    //Because Player 1 knows that Player 2 HAS that card
    private Map<String, Info> _known;

    public PlayerKnowledge(List<Card> cards) {

        _characters = new ArrayList<>();
        _weapons = new ArrayList<>();
        _rooms = new ArrayList<>();
        _known = new HashMap<>();
        
        for(Character.Name name: Character.Name.values()) {
            _characters.add(new Character(name));
            _known.put(name.toString(), Info.UNKNOWN);
        }
        for(Weapon.Name name: Weapon.Name.values()) {
            _weapons.add(new Weapon(name));
            _known.put(name.toString(), Info.UNKNOWN);            
        }
        for(Room.Name name: Room.Name.values()) {
            _rooms.add(new Room(name));
            _known.put(name.toString(), Info.UNKNOWN);
        }

        for(Card card: cards) {
            _known.put(card.toString(), Info.HAS);
        }
    }

    public Info knowledgeState(String item) {
        return _known.get(item);
    }
}