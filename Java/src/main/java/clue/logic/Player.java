package clue.logic;

import clue.knowledge.PlayerKnowledge;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Player extends GameObject {

    private GamePiece _piece;
    List<Card> _cards;
    PlayerKnowledge _knowledge;

    public Player(String label) {
        super(label);
    }

    public void setPiece(GamePiece newPiece) {
        _piece = newPiece;
    }

    public void setCards(List<Card> newHand) {
        _cards = new ArrayList<>(newHand);
        _knowledge = new PlayerKnowledge(newHand);
    }

    public List<Card> getCards() {
        return _cards;
    }

    //randomly return the evidence the player has
    //don't want to show the same order of info
    //for every evidence
    public Card getEvidence(Character suspect, Room scene, Weapon weapon) {
        List<Card> results = new ArrayList<>();

        if(_cards.contains(suspect)) {
            results.add(suspect);
        }
        if(_cards.contains(scene)) {
            results.add(scene);
        }
        if(_cards.contains(weapon)) {
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