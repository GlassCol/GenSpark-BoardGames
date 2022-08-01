package com.boardgames;
import com.boardgames.piece.Piece;

import java.util.ArrayList;

/**
 * This class contain a list of pieces since an instance may have either 1 or 0 pieces on it at any given time
 *
 * @author Cole Glass
 */
public class Tile {
    private ArrayList<Piece> pieceList = new ArrayList<>();

    public ArrayList<Piece> getPieceList() {
        return pieceList;
    }
}
