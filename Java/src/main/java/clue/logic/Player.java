package clue.logic;

import byates.game.GamePiece;
import clue.knowledge.PlayerKnowledge;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

@Entity
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private long id;
  @Column(insertable = true, updatable = true, nullable = false)
  private String label;
  @OneToOne(cascade = {CascadeType.ALL})
  private GamePiece piece;
  @OneToMany(cascade = {CascadeType.ALL})
  List<Card> cards;
  @OneToOne(cascade = {CascadeType.ALL})
  PlayerKnowledge knowledge;

  public Player() {
    label = "Not Set";
  }

  public Player(String aLabel) {
    this.label = aLabel;
  }

  public long getId() {
    return id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String aLabel) {
    label = aLabel;
  }

  public GamePiece getPiece() {
    return piece;
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