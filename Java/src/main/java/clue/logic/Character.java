package clue.logic;

import javax.persistence.Entity;
import java.awt.Point;

@Entity
public class Character extends Card {

    private Name name;

    public Character() {
        super();
    }

    public Character(String character) {
        
        super(character);
        name = Name.of(character);
    }

    public Character(Name character) {
        
        super(character.toSring());
        name = character;
    }

    public enum Name {
        MUSTARD("Col. Mustard", 0, 0),
        PLUM("Prof. Plum", 1, 1),
        MRGREEN("Mr. Green", 2, 2),
        PEACOCK("Mrs. Peacock", 3, 3),
        SCARLET("Miss Scarlet", 4, 4),
        WHITE("Mrs. White", 5, 5);

        private final String label;
        public final int startX;
        public final int startY;

        Name(String name, int x, int y) {
            label = name;
            startX = x;
            startY = y;
        }

        public static Name of(String aName) {
            for (Name name : Name.values()) {
                if(aName.equals(name.toSring())) {
                    return name;
                }
            }

            return null;
        }
        public String toSring() {
            return label;
        }
    }

    public Point StartPosition() {

        return new Point(name.startX, name.startY);
    }
}