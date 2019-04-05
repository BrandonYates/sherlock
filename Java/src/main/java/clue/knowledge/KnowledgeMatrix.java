package clue.knowledge;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import clue.logic.Card;
import clue.logic.CardName;
import clue.logic.CardType;
import clue.logic.Character;
import clue.logic.Player;
import clue.logic.Room;
import clue.logic.Weapon;

import javax.persistence.*;

@Entity
public class KnowledgeMatrix {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @OneToOne
  private Player ownPlayer;

  @ElementCollection
  private List<Player> players;
  @ElementCollection
  private Map<String, PlayerKnowledge> matrix;
  @ElementCollection
  private List<CardName> possibleCharacters;
  @ElementCollection
  private List<CardName> possibleWeapons;
  @ElementCollection
  private List<CardName> possibleRooms;

  @OneToOne
  private CluedoScenario solutionScenario;

  public KnowledgeMatrix() {
    matrix = new HashMap<>();
    possibleCharacters = new ArrayList<>();
    possibleRooms = new ArrayList<>();
    possibleWeapons = new ArrayList<>();
    solutionScenario = new CluedoScenario();
  }

  // Get the players from the game and set up their knowledge.
  // At the beginning of the game we don't know anything about
  // all player knowledge, we will fill it in as the game progresses.
  public KnowledgeMatrix(Player aPlayer, List<Player> otherPlayers) {
    ownPlayer = aPlayer;
    players = otherPlayers;

    matrix = new HashMap<>();

    for(Player player: players) {
      matrix.put(player.getLabel(), new PlayerKnowledge(null));
    }

    possibleCharacters = new ArrayList<>();
    possibleWeapons = new ArrayList<>();
    possibleRooms = new ArrayList<>();

    possibleCharacters.addAll(CardName.getCharacterNames());
    possibleRooms.addAll(CardName.getRoomNames());
    possibleWeapons.addAll(CardName.getWeaponNames());

    CardType type;
    for(Card card: ownPlayer.getCards()) {

      type = card.getCardType();
      CardName tCardName = CardName.getNameEnum(card.getLabel());
      switch (type) {
        case CHARACTER:
          possibleCharacters.remove(tCardName);
          break;
        case WEAPON:
          possibleWeapons.remove(tCardName);
          break;
        case ROOM:
          possibleRooms.remove(tCardName);
          break;
      }
    }

  }

  public void updateMatrix() {

    // for(CardName name: CardName.values())
    //     int numKnown = 0;
    //     int numNotHas = 0;
    //     for(Player player; _players) {
    //         PlayerKnowledge knowledgeSet = matrix.get(player.getLabel());
    //         if(knowledgeSet.knowledgeState(_cardNames[i]) == Info.HAS) {
    //             ++numKnown;
    //         }
    //         if(knowledgeSet.knowledgeState(_cardNames[i]) == Info.HASNOT) {
    //             ++numNotHas;
    //         }
    //     }

    //     if(numNotHas == _players.size()) {
    //         if()
    //     }
    // }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Player getOwnPlayer() {
    return ownPlayer;
  }

  public void setOwnPlayer(Player ownPlayer) {
    this.ownPlayer = ownPlayer;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public Map<String, PlayerKnowledge> getMatrix() {
    return matrix;
  }

  public void setMatrix(Map<String, PlayerKnowledge> matrix) {
    this.matrix = matrix;
  }

  public List<CardName> getPossibleCharacters() {
    return possibleCharacters;
  }

  public void setPossibleCharacters(List<CardName> possibleCharacters) {
    this.possibleCharacters = possibleCharacters;
  }

  public List<CardName> getPossibleWeapons() {
    return possibleWeapons;
  }

  public void setPossibleWeapons(List<CardName> possibleWeapons) {
    this.possibleWeapons = possibleWeapons;
  }

  public List<CardName> getPossibleRooms() {
    return possibleRooms;
  }

  public void setPossibleRooms(List<CardName> possibleRooms) {
    this.possibleRooms = possibleRooms;
  }

  public CluedoScenario getSolutionScenario() {
    return solutionScenario;
  }
  public void setSolutionScenario(CluedoScenario solutionScenario) {
    this.solutionScenario = solutionScenario;
  }
}