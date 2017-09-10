/*
    Tile Types
    0  : Study
    1  : Hall
    2  : Lounge
    3  : Library
    4  : Dining Room
    5  : Billiard Room
    6  : Conservatory
    7  : Ballroom
    8  : Kitchen
    9  : MoveableSpace
    10 : NonMoveableSpace
    11 : Middle
*/

export class Tile{

    typeArray = [  
        'Study',
        'Hall',
        'Lounge',
        'Library',
        'Dining Room',
        'Billiard Room',
        'Conservatory',
        'BallRoom',
        'Kitchen',
        'MoveableSpace',
        'NonMoveableSpace',
        'Middle'
    ]

    constructor(x,y,maxWidth,maxHeight){
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
		this.minWidth = 0;
		this.minHeight = 0;

        let _maxHeight = this.maxHeight;
        let _maxWidth = this.maxWidth;
        let _minHeight = this.minHeight;
        let _minWidth = this.minWidth;

        if(this.isStartSquare(x, y)) {
			this.type = 9;
		}
		else if (x === _minWidth || x === (_maxWidth - 1)) {
			this.type = 10;
		}
		else if (y === _minHeight || y === (_maxHeight - 1)) {
			this.type = 10;
		}
		//Study
		else if (x < 4 && y < 7) {
			this.type = 0;
		}
		//Library 
		else if (x > 5 && x < 11 && y < 6) {
			this.type = 3;
		}
		//Library 2
		else if (x > 6 && x < 10 && y === 6) {
			this.type = 3;
		}
		//Billeard Room
		else if (x > 11 && x < 17 && y < 6) {
			this.type = 5;
		}
		//Conservatory
		else if (x > 18 && y < 5) {
			this.type = 6;
		}
		//Conservatory 2
		else if (x > 19 && y < 6) {
			this.type = 6;
		}
		//Hall
		else if (x > 0 && x < 7 && y > 8 && y < 15) {
			this.type = 1;
		}
		//Staircase/ Clue Center
		else if (x > 7 && x < 15 && y > 8 && y < 14) {
			this.type = 11;
		}
		//Ball Room
		else if (x > 16 && x < 23 && y > 7 && y < 16) {
			this.type = 7;
		}
		//Ball Room 2
		else if (x > 16 && x < _maxWidth && y > 9 && y < 14) {
			this.type = 7;
		}
		//Lounge
		else if (x > _minWidth && x < 6 && y > 16 && y < _maxHeight) {
			this.type = 2;
		}
		//Dining Room
		else if (x > 8 && x < 15 && y > 15 && y < 21) {
			this.type = 4;
		}
		//Dining Room 2
		else if (x > 8 && x < 16 && y > 18 && y < _maxHeight) {
			this.type = 4;
		}
		//Kitchen
		else if (x > 17 && x < _maxWidth && y > 17 && y < _maxHeight) {
            this.type = 8;
		}
		else if (this.isMiscClosedSquare(x, y)) {
			this.type = 10;
		} 
		else {
			this.type = 9;
		}
    }

    getType(){
        return this.typeArray[this.type];
    }

    isValidMove(){
        if(this.type === 10 || this.type === 11){
            return true;
        }else{
            return false;
        }
    }

    isStartSquare(x,y) {

		if(x === this.minWidth && (y === 7 || y === 16)) {
			return true;
		}
		else if (x === (this.maxWidth - 1) && (y === 9 || y === 14)) {
			return true;
		}
		else if (y === this.minHeight && (x === 5 || x === 18)) {
			return true;
		}
		else if (y === this.maxHeight && (x === 6 || x === 17)) {
			return true;
		}
		return false;
	}

    isMiscClosedSquare(x, y) {
		if ((x === 6 || x === 8) && y === 23) {
			return true;
		} 
		else if (x === 16 && y === 23) {
			return true;
		}
		else if (x === 23 && (y === 6 || y === 17)) {
			return true;
		}
		return false;
	}
}