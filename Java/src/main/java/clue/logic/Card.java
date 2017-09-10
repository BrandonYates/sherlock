package clue.logic;

import java.util.ArrayList;
import java.util.List;

public class Card extends GameObject {
    protected CardType _cardType = CardType.UNKNOWN;

    public Card(String label) {
        super(label);
    }

    public Card(String label, CardType type) {
        super(label);
        _cardType = type;
    }

    public CardType getCardType() {
        return _cardType;
    }

    public void setCardType(CardType newType) {
        _cardType = newType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("id: ");
        sb.append(this._id);
        sb.append(" | ");
        sb.append(this._label);
        sb.append(" | ");
        sb.append(this._cardType);
        
        return sb.toString();
    }

    public List<Card> constructDeck(CardType type, List<String> cardNames) {

        List<Card> newCards = new ArrayList<>();
        cardNames.forEach(cName -> {
            Card temp = new Card(cName, type);
            newCards.add(temp);
        });

        return newCards;
    }
}