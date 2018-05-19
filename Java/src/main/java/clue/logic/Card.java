package clue.logic;

import javax.persistence.Entity;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Entity
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
        sb.append(this.id);
        sb.append(" | ");
        sb.append(this.label);
        sb.append(" | ");
        sb.append(this._cardType);
        
        return sb.toString();
    }

    public static List<Card> constructDeck(CardType type, List<String> cardNames) {

        List<Card> newCards = new ArrayList<>();
        cardNames.forEach(cName -> {
            Card temp = new Card(cName, type);
            newCards.add(temp);
        });

        return newCards;
    }

    public static List<Card> constructDeck(Class<Card> cardClass, List<String> cardNames, CardType cardType) {

        List<Card> newCards = new ArrayList<>();
        Constructor<Card> cardConstructor = null;
        try {
            cardConstructor = cardClass.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            System.out.println("Class: " + cardClass.getName() +
                    " has no constructor method for String.class");
        }

        if(cardConstructor == null) {
            return newCards;
        }
        else {
            newCards = new ArrayList<>();
            for(String cName: cardNames) {

                try {
                    Card temp = cardConstructor.newInstance(cName);
                    temp.setCardType(cardType);
                    newCards.add(temp);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.getMessage();
                    e.getStackTrace();
                }
            }
        }

        return newCards;
    }
}