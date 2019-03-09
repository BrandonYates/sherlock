package clue.logic;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * 
 */
@Entity
public class GameSquare extends GameObject {

    private boolean occupied = false;
    private boolean valid = false;
    @OneToOne
    private GamePiece piece = null;

    public GameSquare() {
      super();
    }
   /** 
    * Constructor
    */
    public GameSquare(boolean occupied, boolean valid, GamePiece piece) {

        this.occupied = occupied;
        this.valid = valid;
        this.piece = piece;
    }

    public void setValid() {
        valid = true;
    }

    public GamePiece setPiece(GamePiece piece) {

      System.out.println("valid: " + valid);
      if(!this.valid) {
        return null;
      }

      if(!this.occupied && piece != null) {
        this.occupied = true;
        this.piece = piece;
      }
      else if(piece == null) {
        occupied = false;
        this.piece = null;
      }

      System.out.println("occupied: " + occupied);

      return this.piece;
    }

    public boolean isValid() {
        return valid;
    }
    
    public boolean isOccupied() {
        return occupied;
    }
}
