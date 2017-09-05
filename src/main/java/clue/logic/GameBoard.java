package clue.logic;

import java.util.List;
import java.lang.StringBuilder;

/**
 * 
 */
public class GameBoard {

  private int _minWidth = 0;
  private int _minHeight = 0;
  private int _maxWidth = 25;
  private int _maxHeight = 25;

  GameSquare[][] _board;
  List<GamePiece> _peices;
  
	/** 
   * Constructor
   */
  public GameBoard() {

		_board = new GameSquare[_maxWidth][_maxHeight];
		for(int x = 0; x < _maxWidth; ++x) {
			for(int y = 0; y < _maxHeight; ++y) {
				_board[x][y] = initSquare(x, y);
			}
		}
  }

	public GameSquare initSquare(int x, int y) {

		boolean isValid = isValidPosition(x, y);

		return new GameSquare(false, isValid, null);
	}

	public boolean isStartSquare(int x, int y) {

		if(x == _minWidth && (y == 7 || y == 16)) {
			return true;
		}
		else if (x == (_maxWidth - 1) && (y == 9 || y == 14)) {
			return true;
		}
		else if (y == _minHeight && (x == 5 || x == 18)) {
			return true;
		}
		else if (y == _maxHeight && (x == 6 || x == 17)) {
			return true;
		}
		return false;
	}

	public boolean isMiscClosedSquare(int x, int y) {
		if ((x == 6 || x == 8) && y == 23) {
			return true;
		} 
		else if (x == 16 && y == 23) {
			return true;
		}
		else if (x == 23 && (y == 6 || y == 17)) {
			return true;
		}
		return false;
	}

	//returns wether a given position is valid
	public boolean isValidPosition(int x, int y) {

		//start spaces are valid
		//other edges are not
		//rooms are invalid
		//all other spaces are valid

		if(isStartSquare(x, y)) {
			return true;
		}
		else if (x == _minWidth || x == (_maxWidth - 1)) {
			return false;
		}
		else if (y == _minHeight || y == (_maxHeight - 1)) {
			return false;
		}
		//Study
		else if (x < 4 && y < 7) {
			return false;
		}
		//Library 
		else if (x > 5 && x < 11 && y < 6) {
			return false;
		}
		//Library 2
		else if (x > 6 && x < 10 && y == 6) {
			return false;
		}
		//Billeard Room
		else if (x > 11 && x < 17 && y < 6) {
			return false;
		}
		//Conservatory
		else if (x > 18 && y < 5) {
			return false;
		}
		//Conservatory 2
		else if (x > 19 && y < 6) {
			return false;
		}
		//Hall
		else if (x > 0 && x < 7 && y > 8 && y < 15) {
			return false;
		}
		//Staircase/ Clue Center
		else if (x > 7 && x < 15 && y > 8 && y < 14) {
			return false;
		}
		//Ball Room
		else if (x > 16 && x < 23 && y > 7 && y < 16) {
			return false;
		}
		//Ball Room 2
		else if (x > 16 && x < _maxWidth && y > 9 && y < 14) {
			return false;
		}
		//Lounge
		else if (x > _minWidth && x < 6 && y > 16 && y < _maxHeight) {
			return false;
		}
		//Dining Room
		else if (x > 8 && x < 15 && y > 15 && y < 21) {
			return false;
		}
		//Dining Room 2
		else if (x > 8 && x < 16 && y > 18 && y < _maxHeight) {
			return false;
		}
		//Kitchen
		else if (x > 17 && x < _maxWidth && y > 17 && y < _maxHeight) {
			return false;
		}
		else if (isMiscClosedSquare(x, y)) {
			return false;
		} 
		else {
			return true;
		}
	}

	public String toString() {
		GameSquare square;
		StringBuilder builder = new StringBuilder();

		for(int x = 0; x < _maxWidth + 1; ++x) {
			for(int y = 0; y < _maxHeight + 1; ++y) {
				
				if(x == _maxWidth)  {
					builder.append("[" + y % 10 + "]");
					continue;
				}
				else if(y == _maxHeight) {
					builder.append("[" + x % 10 + "]");
					continue;
				}
						
				square = _board[x][y];					
			
				if(square.isValid()) {
					builder.append("[ ]");					
				}
				else {
					builder.append("{X}");
				}
			}
			builder.append("\n");
		}

		return builder.toString();
	}
}
