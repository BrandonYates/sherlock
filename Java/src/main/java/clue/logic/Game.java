package clue.logic;

import clue.knowledge.SuggestionHistory;
import com.google.gson.Gson;

import javax.persistence.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Game extends GameObject {

    public Game() {
        super(null, null);
    }

    public Game(String aLabel) {
        super(null, aLabel);
    }

    public Game(String aId, String aLabel) {
        super(aId, aLabel);
        suggestionHistory = new SuggestionHistory();
    }

    public void makePlayers(String[] players) {

        this.players = new ArrayList<>();
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
            this.players.add(tempPlayer);
        }
    }

    public void makeDeck() {
        deck = new ArrayList<>();
        confidential = new ArrayList<>();

        //Create
        chooseCard(Room.class, Room.Name.class, CardType.ROOM);
        chooseCard(Character.class, Character.Name.class, CardType.CHARACTER);
        chooseCard(Weapon.class, Weapon.Name.class, CardType.WEAPON);
    }

    private <E extends Enum<E>> void chooseCard(Class cardClass, Class<E> enumClass, CardType cardType)
        throws InternalError {

        List<String> cardNames = Arrays.stream(enumClass.getEnumConstants())
            .map(Enum<E>::toString)
            .collect(Collectors.toList());

        List<Card> tempDeck = Card.constructDeck(cardClass, cardNames, cardType);

        if(tempDeck.isEmpty()) {
            throw new InternalError("Failed to Construct deck for " + cardClass.getName());
        }
        Card card = tempDeck.get(0);
        confidential.add(card);
        tempDeck.remove(0);
        deck.addAll(tempDeck);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public List<Card> getConfidential() {
        return confidential;
    }

    public void setConfidential(List<Card> confidential) {
        this.confidential = confidential;
    }

    public SuggestionHistory getSuggestionHistory() {
        return suggestionHistory;
    }

    public void setSuggestionHistory(SuggestionHistory suggestionHistory) {
        this.suggestionHistory = suggestionHistory;
    }

    @OneToMany
    @JoinColumn(name = "CARD_ID")
    private List<Card> deck;
    @OneToMany
    @JoinColumn(name = "CARD_ID")
    private List<Card> confidential;
    @OneToMany
    @JoinColumn(name = "PLAYER_ID")
    private List<Player> players;

    @OneToOne
    @JoinColumn(name = "SUGGESTION_HISTORY_ID")
    private SuggestionHistory suggestionHistory;

    public String toString() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }
}
