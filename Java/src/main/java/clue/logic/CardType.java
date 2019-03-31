package clue.logic;

public enum CardType {
  ROOM("ROOM", 0),
  WEAPON("WEAPON", 1),
  CHARACTER("CHARACTER", 2),
  UNKNOWN("UNKNOWN", 3);

  private final String label;
  private final int index;

  CardType() {
    label = "NOT SET";
    index = -1;
  }

  CardType(String str, int i) {
    label = str;
    index = i;
  }

  @Override
  public String toString() {
    return label;
  }
}