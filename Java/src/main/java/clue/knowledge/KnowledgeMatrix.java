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
  Player ownPlayer;
  @OneToMany
  List<Player> players;
  @OneToMany
  Map<String, PlayerKnowledge> matrix;
  @OneToMany
  List<CardName> possibleCharacters;
  @OneToMany
  List<CardName> possibleWeapons;
  @OneToMany
  List<CardName> possibleRooms;

  @OneToOne
  Character solutionCharacter = null;
  @OneToOne
  Weapon solutionWeapon = null;
  @OneToOne
  Room solutionRoom = null;

  //get the players from the game and set up their knowledge
  //at the beginning of the game we don't know anything about
  //all player knowledge, we will fill it in as the game progresses
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

    CardName.getCharacterNames().forEach(c -> possibleCharacters.add(c));
    CardName.getWeaponNames().forEach(w -> possibleWeapons.add(w));
    CardName.getRoomNames().forEach(r -> possibleRooms.add(r));


    String tLabel;
    CardType type;
    for(Card card: ownPlayer.getCards()) {

      tLabel = card.getLabel();
      type = card.getCardType();
      switch (type) {
        case CHARACTER:
          possibleCharacters.remove(tLabel);
          break;
        case WEAPON:
          possibleWeapons.remove(tLabel);
          break;
        case ROOM:
          possibleRooms.remove(tLabel);
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
}