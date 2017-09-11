package clue.logic;

import java.util.ArrayList;
import java.util.List;

public class Room extends Card {

    private Name name;

    public Room(String label) {

        super(label);
        name = Name.of(label);
    }

    public Room(Name aName) {
        
        super(aName.toSring());
        name = aName;
    }

    public enum Name {
        LIBRARY("Library"),
        HALL("Hall"),
        BALLROOM("Ball Room"),
        KITCHEN("Kitchen"),
        CONSERVATORY("Conservatory"),
        STUDY("Study"),
        LOUNGE("Lounge"),
        BILLIARDROOM("Billiard Room"),
        DININGROOM("Dining Room");

        private final String label;

        private Name(String name) {
            label = name;
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
}