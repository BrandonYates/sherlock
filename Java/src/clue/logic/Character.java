package clue.test;

public class Character extends Card {

    CharacterName name;

    public Character(String label, CharacterName character) {
        super(label);

        name = character;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("id: ");
        sb.append(_id);
        sb.append(" | ");
        sb.append(label);
        sb.append(" | ");
        sb.append(_cardType);
        
        return sb.toString();
    }

    public enum Name() {
        MUSTARD("Colonel Mustard"),
        PLUM("Professor Plum"), 
        MRGREEN("Mr. Green"), 
        PEACOCK("Mrs. Peacock"),
        SCARLET("Miss Scarlet"), 
        WHITE("Mrs. White");

        private final label;

        private CharacterName(String name) {
            label = name;
        }

        public String toSring() {
            return label;
        }
    }
}