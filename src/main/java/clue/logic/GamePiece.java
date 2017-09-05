package clue.logic;

public class GamePiece extends GameObject {

  private int _x;
  private int _y;

  public GamePiece(int x, int y) {
    super();
    _x = x;
    _y = y;
  }

  public GamePiece(String label, int x, int y) {
    super(label);
    _label = label;
    _x = x;
    _y = y;
  }

  public GamePiece(String id, String label, int x, int y) {
    _id = id;
    _label = label;
    _x = x;
    _y = y;
  }   

  public int getX() {
      return _x;
  }

  public int getY() {
      return _y;
  }
}