package clue.logic;

import com.google.gson.Gson;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends GameObject {

    public Game() {
        super();
    }

    public Game(String aLabel) {
        super(aLabel);
    }

    public Game(String id, String label) {
        super(id, label);
    }

    public void makePlayers(String[] players) {

        _players = new ArrayList<>();
        List<CardName> names = CardName.getCharacterNames();
        Player tempPlayer;
        GamePiece tempPiece;
        for(int i = 0; i < players.length; ++i) {

            tempPlayer = new Player(players[i]);
            String characterName = names.get(i).stringify();
            Character character = new Character(characterName);
            Point startPos = character.StartPosition();

            int x = (int)startPos.getX();
            int y = (int)startPos.getY();

           tempPiece =
                    new GamePiece(String.valueOf(i), characterName, x, y);
           tempPlayer.setPiece(tempPiece);
            _players.add(tempPlayer);
        }
    }

    public void makeDeck() {
        _deck = new ArrayList<>();

        for(Room.Name name: Room.Name.values()) {
            Room roomCard = new Room(name);
            _deck.add(roomCard);
        }
        for(Character.Name name: Character.Name.values()) {
            Character characterCard = new Character(name);
            _deck.add(characterCard);
        }
        for(Weapon.Name name: Weapon.Name.values()) {
            Weapon weaponCard = new Weapon(name);
            _deck.add(weaponCard);
        }
    }

    public void assignCards() {

    }

    private List<Player> _players;
    private List<Card> _deck;

    public String toString() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }
}
