package com.boardgames.piece.chesspiece;

import com.boardgames.Tile;
import com.boardgames.piece.Piece;

public class Rook extends Piece {
    @Override
    public String toString() {
        return "Rook";
    }

    @Override
    public boolean move(Tile[][] board, int xPos, int yPos) {
        return false;
    }
}
