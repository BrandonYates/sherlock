package clue.logic;

public class Character extends Card {

    private Name name;

    public Character(String character) {
        
        super(character);
        name = Name.of(character);
    }

    public Character(Name character) {
        
        super(character.toSring());
        name = character;
    }

    public enum Name {
        MUSTARD("Colonel Mustard"),
        PLUM("Professor Plum"), 
        MRGREEN("Mr. Green"), 
        PEACOCK("Mrs. Peacock"),
        SCARLET("Miss Scarlet"), 
        WHITE("Mrs. White");

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