package com.boardgames.piece;

/**
 * Abstract class to be used in iteration during game time
 *
 * @author Cole Glass
 */
public abstract class Piece {
    private int XCoordinate;

    private int YCoordinate;
    private int numValue;
    @Override
    public abstract String toString();

    public int getXCoordinate() {
        return XCoordinate;
    }

    public void setXCoordinate(int XCoordinate) {
        this.XCoordinate = XCoordinate;
    }

    public int getYCoordinate() {
        return YCoordinate;
    }

    public void setYCoordinate(int YCoordinate) {
        this.YCoordinate = YCoordinate;
    }

    public void setNumValue(int numValue) {
        this.numValue = numValue;
    }

    public int getNumValue() {
        return numValue;
    }

    /**
     * Moves the piece within the game board
     */
    public abstract void move();
}
