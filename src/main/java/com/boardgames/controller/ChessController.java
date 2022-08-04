package com.boardgames.controller;

import com.boardgames.Tile;
import com.boardgames.piece.Piece;
import com.boardgames.piece.chesspiece.Knight;
import com.boardgames.piece.chesspiece.Rook;
import com.boardgames.score.Score;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

/**
 * Class to handle any utility for the Chess game and store the current game of a chess game
 *
 * @author Cole Glass
 */
public class ChessController {

    private static Tile[][] gameBoard = new Tile[8][8];

    /**
     * Sets the gameBoard to the starting state of the game
     * @return gameBoard : Tile[][] the initialized gameBoard
     */
    public static Tile[][] initializeGameBoard(){
        Piece blackRook = new Rook();
        Piece blackKnight = new Knight();
        gameBoard[0][0].getPieceList().add(blackRook);
        gameBoard[1][0].getPieceList().add(blackKnight);
        return gameBoard;
    }

    public static Tile[][] getGameBoard() {
        return gameBoard;
    }

}
