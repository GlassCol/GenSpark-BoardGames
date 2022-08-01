package com.boardgames.piece;

/**
 * Abstract class to be used in iteration during game time
 */
public abstract class Piece {
    private int numValue;
    @Override
    public abstract String toString();

    public int getNumValue() {
        return numValue;
    }

    /**
     * Moves the piece within the game board
     */
    public abstract void move();
}
