package clue.logic;

import clue.knowledge.PlayerKnowledge;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

@Entity
public class Player extends GameObject {

  @OneToOne
  private GamePiece piece;
  @OneToMany
  List<Card> cards;
  @OneToOne
  PlayerKnowledge knowledge;

  public Player() {
    super();
  }

  public Player(String label) {
    super(label);
  }

  public void setPiece(GamePiece newPiece) {
    piece = newPiece;
  }

  public void setCards(List<Card> newHand) {
    cards = new ArrayList<>(newHand);
    knowledge = new PlayerKnowledge(newHand);
  }

  public List<Card> getCards() {
    return cards;
  }

  //randomly return the evidence the player has
  //don't want to show the same order of info
  //for every evidence
  public Card getEvidence(Character suspect, Room scene, Weapon weapon) {
    List<Card> results = new ArrayList<>();

    if(cards.contains(suspect)) {
      results.add(suspect);
    }
    if(cards.contains(scene)) {
      results.add(scene);
    }
    if(cards.contains(weapon)) {
      results.add(weapon);
    }

    int numResults = results.size();

    if(numResults == 0) {
      return null;
    }
    else if (numResults == 1) {
      return results.get(0);
    }
    else {
      Random rand = new Random();
      int value = rand.nextInt(numResults);

      return results.get(value);
    }
  }
}