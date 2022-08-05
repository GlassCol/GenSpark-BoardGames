package com.boardgames.piece.chesspiece;

import com.boardgames.Tile;
import com.boardgames.piece.Piece;

public class King extends Piece {
    @Override
    public String toString() {
        return "King";
    }

    @Override
    public boolean move(Tile[][] board, int xPos, int yPos) {
    return false;
    }
}
