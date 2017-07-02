package clue.logic;

public class Weapon extends Card {

    private Name name;

    public Weapon(String label, String weapon) {
        super(label);

        name = Name.of(weapon);
    }

    public enum Name {
        KNIFE("Knife"),
        REVOLVER("Revolver"),
        CANDLESTICK("Candlestick"),
        PIPE("Pipe"),
        ROPE("Rope"),
        WRENCH("Wrench");

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