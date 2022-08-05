package com.boardgames.piece.chesspiece;

import com.boardgames.Tile;
import com.boardgames.piece.Piece;

public class Bishop extends Piece {
    @Override
    public String toString() {
        return "Bishop";
    }

    @Override
    public boolean move(Tile[][] board, int xPos, int yPos) {
        return false;
    }
}
