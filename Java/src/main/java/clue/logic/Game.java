package clue.logic;

import com.google.gson.Gson;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

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
        _confidential = new ArrayList<>();

        //Create
        chooseCard(Room.class, Room.Name.class);
        chooseCard(Character.class, Character.Name.class);
        chooseCard(Weapon.class, Weapon.Name.class);
    }


    private <E extends Enum<E>> void chooseCard(Class cardClass, Class<E> enumClass)
    throws InternalError {

        List<String> cardNames = Arrays.stream(enumClass.getEnumConstants())
                .map(Enum<E>::toString)
                .collect(Collectors.toList());

        List<Card> tempDeck = Card.constructDeck(cardClass, cardNames);

        if(tempDeck.isEmpty()) {
            throw new InternalError("Failed to Construct deck for " + cardClass.getName());
        }
        Card card = tempDeck.get(0);
        _confidential.add(card);
        tempDeck.remove(0);
        _deck.addAll(tempDeck);
    }

    private List<Player> _players;
    private List<Card> _deck;
    private List<Card> _confidential;

    public String toString() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }
}
