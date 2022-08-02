package com.boardgames.controller;

import com.boardgames.Tile;

/**
 * Class to handle any utility for the Chess game and store the current game state of a chess game
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

        return gameBoard;
    }

    public static Tile[][] getGameBoard() {
        return gameBoard;
    }
}
