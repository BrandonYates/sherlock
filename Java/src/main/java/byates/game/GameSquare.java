package byates.game;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * 
 */
@Entity
public class GameSquare extends GameObject {

    @Transient
    private boolean occupied = false;
    @Transient
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

      return this.piece;
    }

    public boolean isValid() {
        return valid;
    }
    
    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public String toString() {

        String tPieceString = (piece == null) ? "piece: null" : piece.toString();

        return tPieceString + " isValid: " + valid + " | isOccupied: " + occupied;
    }
}
