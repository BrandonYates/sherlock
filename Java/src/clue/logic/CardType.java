package clue.logic;

public enum CardType {
    ROOM("ROOM", 0), 
    WEAPON("WEAPON", 1), 
    CHARACTER("CHARACTER", 2), 
    UNKNOWN("UNKNOWN", 3);

    private final String label;
    private final int index;

    CardType(String str, int i) {
        label = str;
        index = i;
    }

    public String toString() {
        return this.label;
    }
}