package clue.logic;

public class Card extends GameObject {
    private CardType cardType = CardType.UNKNOWN;

    public Card(String label) {
        super(label);
    }

    public Card(String label, CardType type) {
        super(label);
        cardType = type;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType newType) {
        cardType = newType;
    }
}