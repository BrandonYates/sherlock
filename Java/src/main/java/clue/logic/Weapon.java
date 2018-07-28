package clue.logic;

import javax.persistence.Entity;

@Entity
public class Weapon extends Card {

    private Name name;

    public Weapon() {
        super();
    }

    public Weapon(String weapon) {
        super(weapon);

        name = Name.of(weapon);
    }

    public Weapon(Name weapon) {
        
        super(weapon.toSring());
        name = weapon;
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