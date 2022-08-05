package com.boardgames.piece.chesspiece;

import com.boardgames.Tile;
import com.boardgames.piece.Piece;

public class Queen extends Piece {
    @Override
    public String toString() {
        return "Queen";
    }

    @Override
    public boolean move(Tile[][] board, int xPos, int yPos) {
        return false;
    }
}
