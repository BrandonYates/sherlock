package clue.logic;

import byates.game.GameObject;
import byates.game.GamePiece;
import clue.knowledge.CluedoScenario;
import clue.knowledge.SuggestionHistory;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Game extends GameObject {

    public Game() {
        super();
    }

    public Game(String aLabel) {
        super(aLabel);
    }

    public Game(int aId, String aLabel) {
        super(aId, aLabel);
        logger.trace("Creating Game with Id: " + aId);
        suggestionHistory = new SuggestionHistory();
    }

    /**
     * Using a list of player names create all necessary Objects to represent the player in the game.
     *
     * @param aPlayers
     */
    public void makePlayers(String[] aPlayers) {

        logger.trace("makePlayers(String[] aPlayers)");

        this.players = new ArrayList<>();

        List<CardName> tNames = CardName.getCharacterNames();

        Collections.shuffle(tNames);

        Player tempPlayer;
        GamePiece tempPiece;

        for(int i = 0; i < aPlayers.length; ++i) {

            tempPlayer = new Player(aPlayers[i]);
            String characterName = tNames.get(i).stringify();
            Character character = new Character(characterName);
            Point startPos = character.StartPosition();

            int x = (int)startPos.getX();
            int y = (int)startPos.getY();

            tempPiece =
                new GamePiece(i, characterName, x, y);
            tempPlayer.setPiece(tempPiece);
            this.players.add(tempPlayer);
        }

        this.players.forEach(p -> logger.info("added " + p.getLabel()));
    }

    /**
     * Seeds the game's player and confidential decks with randomly arranged cards.
     */
    public void makeDeck() {

        logger.trace("makeDeck()");
        deck = new ArrayList<>();
        //Create
        Character tCharacter = (Character) makeSubDeck(Character.class, Character.Identity.class, CardType.CHARACTER);
        Room tRoom = (Room) makeSubDeck(Room.class, Room.Name.class, CardType.ROOM);
        Weapon tWeapon = (Weapon) makeSubDeck(Weapon.class, Weapon.Name.class, CardType.WEAPON);

        confidential = new CluedoScenario(tCharacter, tRoom, tWeapon);
    }

    /**
     * For the given card information seed the game and confidential deck with that type of card.
     *
     * @param cardClass
     * @param enumClass
     * @param cardType
     * @param <E>
     * @throws InternalError
     */
    private <E extends Enum<E>> Card makeSubDeck(Class cardClass, Class<E> enumClass, CardType cardType)
        throws InternalError {

        logger.trace("makeSubDeck for... " + cardType);
        List<String> cardNames = Arrays.stream(enumClass.getEnumConstants())
            .map(Enum::toString)
            .collect(Collectors.toList());

        List<Card> tempDeck = Card.constructDeck(cardClass, cardNames, cardType);

        if(tempDeck.isEmpty()) {
            throw new InternalError("Failed to Construct deck for " + cardClass.getName());
        }
        Card card = tempDeck.get(0);
        tempDeck.remove(0);
        deck.addAll(tempDeck);

        return card;
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

    public CluedoScenario getConfidential() {
        return confidential;
    }

    public void setConfidential(CluedoScenario confidential) {
        this.confidential = confidential;
    }

    public SuggestionHistory getSuggestionHistory() {
        return suggestionHistory;
    }

    public void setSuggestionHistory(SuggestionHistory suggestionHistory) {
        this.suggestionHistory = suggestionHistory;
    }

    @OneToMany(targetEntity=Card.class, fetch= FetchType.EAGER, cascade = {CascadeType.ALL})
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
        name="GameDeck",
        joinColumns = @JoinColumn( name="game_id"),
        inverseJoinColumns = @JoinColumn( name="card_id")
    )
    private List<Card> deck;

    @OneToOne(cascade = {CascadeType.ALL})
    private CluedoScenario confidential;

    @OneToMany(targetEntity=Player.class, fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
        name="GamePlayers",
        joinColumns = @JoinColumn( name="game_id"),
        inverseJoinColumns = @JoinColumn( name="player_id")
    )
    private List<Player> players;

    @OneToOne(cascade = {CascadeType.ALL})
    private SuggestionHistory suggestionHistory;

    @Transient
    private Logger logger = LogManager.getLogger(Game.class);

    public String toString() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }
}
