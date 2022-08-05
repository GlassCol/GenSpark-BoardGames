package com.boardgames;

public class Move {
    private final Position start, destination;
    //Constructor
    public Move(Position start, Position destination) {
        this.start = start;
        this.destination = destination;
    }
    //Methods
    public boolean isVertical() {
        return getX1() == getX2();
    }
    public boolean isNorth() {
        return getY2() - getY1() > 0;
    }
    public boolean isSouth() {
        return getY2() - getY1() < 0;
    }
    public boolean isDiagonal() {
        return Math.abs(getY2() - getY1()) == Math.abs(getX2() - getX1());
    }
    public boolean isStraight() {
		/*Test if the move up/down/left/right, ie not diagonal by checking.
		If the X’s or the Y’s are the same but not both…
	*/
        return getX1() == getX2() ^ getY1() == getY2();
    }
    /*How many squared from start to destination?  Only works with linear moves [diagonal or straight].
     */
    public int distance() {
        return Math.max(
                Math.abs(getY2() - getY1()),
                Math.abs(getX2() - getX1())
        );
    }
    //Getters
    public Position getStart() {
        return start;
    }
    public Position getDestination() {
        return destination;
    }

    public int getX1() {
        return getStart().getX();
    }
    public int getY1() {
        return getStart().getY();
    }
    public int getX2() {
        return getDestination().getX();
    }
    public int getY2() {
        return getDestination().getY();
    }

}


