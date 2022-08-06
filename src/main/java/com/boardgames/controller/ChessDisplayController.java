package com.boardgames.controller;

import com.boardgames.Tile;
import com.boardgames.piece.Piece;
import com.boardgames.piece.chesspiece.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.net.URL;
import java.util.ResourceBundle;

public class ChessDisplayController implements Initializable {

    @FXML
    BorderPane borderPane;

    @FXML
    VBox scoreBoardVBoxPane;

    @FXML
    GridPane boardGridPane;

    Rectangle[][] board;
    Tile[][] tileArray = new Tile[8][8];
    final int borderPaneHeight = 800;  // temp

    /**
     * Places all Pieces into their designated tile for the start of the game
     * @return tileArray : Tile[][], The tile set in the starting game state
     */
    public Tile[][] setUpPieces(){
        setUpPawns();
//        setUpRooks();
//        setUpBishops();
//        setUpKnights();
//        setUpQueens();
//        setUpKings();
        return tileArray;
    }
    /**
     * Places all Kings into their designated tile for the start of the game
     */
    public void setUpKings(){
        Piece blackKing = new King();
        blackKing.setColor("Black");
        Piece whiteKing = new King();
        blackKing.setColor("White");
        tileArray[4][0].getPieceList().add(blackKing);
        tileArray[4][7].getPieceList().add(whiteKing);
    }
    /**
     * Places all Queens into their designated tile for the start of the game
     */
    public void setUpQueens(){
        Piece blackQueen = new Queen();
        blackQueen.setColor("Black");
        Piece whiteQueen = new Queen();
        blackQueen.setColor("White");
        tileArray[3][0].getPieceList().add(blackQueen);
        tileArray[3][7].getPieceList().add(whiteQueen);
    }
    /**
     * Places all Bishops into their designated tile for the start of the game
     */
    public void setUpBishops(){
        Piece blackBishop = new Bishop();
        blackBishop.setColor("Black");
        Piece whiteBishop = new Bishop();
        blackBishop.setColor("White");
        tileArray[2][0].getPieceList().add(blackBishop);
        tileArray[5][0].getPieceList().add(blackBishop);
        tileArray[2][7].getPieceList().add(whiteBishop);
        tileArray[5][7].getPieceList().add(whiteBishop);
    }
    /**
     * Places all Knights into their designated tile for the start of the game
     */
    public void setUpKnights(){
        Piece blackKnight = new Knight();
        blackKnight.setColor("Black");
        Piece whiteKnight = new Knight();
        blackKnight.setColor("White");
        tileArray[1][0].getPieceList().add(blackKnight);
        tileArray[6][0].getPieceList().add(blackKnight);
        tileArray[1][7].getPieceList().add(whiteKnight);
        tileArray[6][7].getPieceList().add(whiteKnight);
    }
    /**
     * Places all Rooks into their designated tile for the start of the game
     */
    public void setUpRooks(){
        Piece blackRook = new Rook();
        blackRook.setColor("Black");
        Piece whiteRook = new Rook();
        blackRook.setColor("White");
        tileArray[0][0].getPieceList().add(blackRook);
        tileArray[7][0].getPieceList().add(blackRook);
        tileArray[0][7].getPieceList().add(whiteRook);
        tileArray[7][7].getPieceList().add(whiteRook);
    }
    /**
     * Places all Pawns into their designated tile for the start of the game
     */
    public void setUpPawns(){
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Pawn();
            pawn.setColor("Black");
            tileArray[1][i] = new Tile();
            tileArray[1][i].getPieceList().add(pawn);
        }
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Pawn();
            pawn.setColor("White");
            tileArray[6][i] = new Tile();
            tileArray[6][i].getPieceList().add(pawn);
        }
    }
    /**
     * Creates a backdrop fo the board which the game will be played on
     */
    public void colorBoard() {
        // Declares new board
        board = new Rectangle[8][8];

        // Initializes new board
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = new Rectangle();
                board[i][j].setWidth(100);
                board[i][j].setHeight(100);
                board[i][j].setStroke(Color.TRANSPARENT);
                board[i][j].setStrokeType(StrokeType.INSIDE);
                board[i][j].setStrokeWidth(1);
            }
        }
        // Generates colours for the chessboard backgrounds
        for(int i=0; i < 7; i++){
            for(int j=0; j < 7; j++){
                if((i%2==0 && j%2==1) || (i%2==1 && j%2==0)){
                    board[i][j].setFill(Color.WHITE);
                }
                else if((i%2==0 && j%2==0) || (i%2==1 && j%2==1)){
                    board[i][j].setFill(Color.DARKGREEN);
                }
                boardGridPane.add(board[i][j], i, j);
            }
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boardGridPane.setPadding(new Insets(0,0,0,0));
        colorBoard();
        setUpPieces();

        ScoreCardController scController = new ScoreCardController();
        scController.showScoreBoard(scoreBoardVBoxPane, boardGridPane.getHeight());
    }
}

