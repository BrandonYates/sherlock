package clue.logic;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * 
 */
@Entity
public class GameSquare extends GameObject {

    boolean occupied = false;
    boolean valid = false;
    @OneToOne
    GamePiece piece = null;

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
        
        if(!this.occupied && piece != null) {

        }
        else if (piece == null) {
            occupied = false;
            this.piece = piece;
        }

        return this.piece;
    }

    public boolean isValid() {
        return valid;
    }
    
    public boolean isOccupied() {
        return occupied;
    }
}
