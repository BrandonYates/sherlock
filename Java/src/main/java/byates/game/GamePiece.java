package byates.game;

import byates.game.GameObject;

import javax.persistence.Entity;

@Entity
public class GamePiece extends GameObject {

  private int _x = -1;
  private int _y = -1;

  public GamePiece() {
    super();
  }

  public GamePiece(int x, int y) {
    super();
    _x = x;
    _y = y;
  }

  public GamePiece(String label, int x, int y) {
    super(label);
    this.label = label;
    _x = x;
    _y = y;
  }

  public GamePiece(int id, String label, int x, int y) {
    this.id = id;
    this.label = label;
    _x = x;
    _y = y;
  }   

  public int getX() {
      return _x;
  }

  public int getY() {
      return _y;
  }

  @Override
  public String toString() {
    return "(" + _x + ", " + _y + ")";
  }
}