package com.boardgames.piece.checkerpiece;

import com.boardgames.Tile;
import com.boardgames.piece.Piece;

public class CheckerPiece extends Piece {
    @Override
    public String toString() {
        return "Checker Piece";
    }

    @Override
    public boolean move(Tile[][] board, int xPos, int yPos) {
        return false;
    }
}
