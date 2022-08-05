package com.boardgames.piece.chesspiece;

import com.boardgames.Tile;
import com.boardgames.piece.Piece;

public class Knight extends Piece {
    @Override
    public String toString() {
        return "Knight";
    }

    @Override
    public boolean move(Tile[][] board, int xPos, int yPos) {
        return false;
    }
}
