package clue.logic;

import javax.persistence.Entity;
import java.awt.Point;

@Entity
public class Character extends Card {

    private Identity identity;

    public Character() {
        super();
    }

    public Character(String character) {
        
        super(character);
        identity = Identity.of(character);
    }

    public Character(Identity character) {
        
        super(character.toSring());
        identity = character;
    }

    public enum Identity {
        MUSTARD("Col. Mustard", 7, 0),
        PLUM("Prof. Plum", 5, 24),
        MRGREEN("Mr. Green", 24, 14),
        PEACOCK("Mrs. Peacock", 18, 24),
        SCARLET("Miss Scarlet", 0, 7),
        WHITE("Mrs. White", 24, 9);

        private final String label;
        public final int startX;
        public final int startY;

        Identity(String name, int x, int y) {
            label = name;
            startX = x;
            startY = y;
        }

        public static Identity of(String aName) {
            for (Identity identity : Identity.values()) {
                if(aName.equals(identity.toSring())) {
                    return identity;
                }
            }

            return null;
        }
        public String toSring() {
            return label;
        }
    }

    public Point StartPosition() {

        return new Point(identity.startX, identity.startY);
    }
}