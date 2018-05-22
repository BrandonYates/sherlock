package clue.knowledge;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import clue.logic.Card;
import clue.logic.Character;
import clue.logic.Room;
import clue.logic.Weapon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlayerKnowledge {

    public enum Info {
        HAS, HASNOT, UNKNOWN
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private List<Character> characters;
    private List<Weapon> weapons;
    private List<Room> rooms;

    //maps the name of a card to what an external player
    //could know about their knowledge
    //example: Player 1 was handed the Rope card as evidence
    //against an accusation. Thus in the Rope card is mapped to HAS 
    //Because Player 1 knows that Player 2 HAS that card
    private Map<String, Info> known;

    public PlayerKnowledge(List<Card> cards) {

        characters = new ArrayList<>();
        weapons = new ArrayList<>();
        rooms = new ArrayList<>();
        known = new HashMap<>();

        for(Character.Name name: Character.Name.values()) {
            characters.add(new Character(name));
            known.put(name.toString(), Info.UNKNOWN);
        }
        for(Weapon.Name name: Weapon.Name.values()) {
            weapons.add(new Weapon(name));
            known.put(name.toString(), Info.UNKNOWN);
        }
        for(Room.Name name: Room.Name.values()) {
            rooms.add(new Room(name));
            known.put(name.toString(), Info.UNKNOWN);
        }

        for(Card card: cards) {
            known.put(card.toString(), Info.HAS);
        }
    }

    public Info knowledgeState(String item) {
        return known.get(item);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Map<String, Info> getKnown() {
        return known;
    }

    public void setKnown(Map<String, Info> known) {
        this.known = known;
    }
}