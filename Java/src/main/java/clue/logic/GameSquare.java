package clue.logic;

/**
 * 
 */
public class GameSquare {

    boolean _occupied = false;
    boolean _valid = false;
    GamePiece _piece = null;

   /** 
    * Constructor
    */
    public GameSquare(boolean occupied, boolean valid, GamePiece piece) {

        _occupied = occupied;
        _valid = valid;
        _piece = piece;
    }

    public void setValid() {
        _valid = true;
    }

    public GamePiece setPiece(GamePiece piece) {
        
        if(!this._occupied && piece != null) {

        }
        else if (piece == null) {
            _occupied = false;
            _piece = piece;
        }

        return _piece;
    }

    public boolean isValid() {
        return _valid;
    }
    
    public boolean isOccupied() {
        return _occupied;
    }
}
