package clue.logic;

public class Character extends Card {

    private Name name;

    public Character(String label, String character) {
        super(label);

        name = Name.of(character);
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