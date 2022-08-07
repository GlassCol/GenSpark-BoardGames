package com.boardgames.controller;

import com.boardgames.Tile;
import com.boardgames.piece.Piece;
import com.boardgames.piece.chesspiece.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
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


    /**
     * Places all Pieces into their designated tile for the start of the game
     * @return tileArray : Tile[][], The tile set in the starting game state
     */
    public Tile[][] setUpPieces(){
        setUpPawns();
        setUpRooks();
        setUpBishops();
        setUpKnights();
        setUpQueens();
        setUpKings();
        return tileArray;
    }
    /**
     * Places all Kings into their designated tile for the start of the game
     */
    public void setUpKings(){
        Piece blackKing = new King();
        blackKing.setColor("Black");
        setPieceImage(blackKing, blackKing.toString().toLowerCase(), "black");

        Piece whiteKing = new King();
        whiteKing.setColor("White");
        setPieceImage(whiteKing, whiteKing.toString().toLowerCase(), "white");

        tileArray[4][0] = new Tile();
        tileArray[4][7] = new Tile();

        tileArray[4][0].getPieceList().add(blackKing);
        tileArray[4][7].getPieceList().add(whiteKing);

        setABoardTile(blackKing.getImage(), 4, 0);
        setABoardTile(whiteKing.getImage(), 4, 7);

    }
    /**
     * Places all Queens into their designated tile for the start of the game
     */
    public void setUpQueens(){
        Piece blackQueen = new Queen();
        blackQueen.setColor("Black");
        setPieceImage(blackQueen, blackQueen.toString().toLowerCase(), "black");

        Piece whiteQueen = new Queen();
        whiteQueen.setColor("White");
        setPieceImage(whiteQueen, whiteQueen.toString().toLowerCase(), "white");

        tileArray[3][0] = new Tile();
        tileArray[3][7] = new Tile();

        tileArray[3][0].getPieceList().add(blackQueen);
        tileArray[3][7].getPieceList().add(whiteQueen);

        setABoardTile(blackQueen.getImage(), 3, 0);
        setABoardTile(whiteQueen.getImage(), 3, 7);

    }
    /**
     * Places all Bishops into their designated tile for the start of the game
     */
    public void setUpBishops(){
        Piece blackBishop = new Bishop();
        blackBishop.setColor("Black");
        setPieceImage(blackBishop, blackBishop.toString().toLowerCase(), "black");

        Piece whiteBishop = new Bishop();
        whiteBishop.setColor("White");
        setPieceImage(whiteBishop, whiteBishop.toString().toLowerCase(), "white");

        tileArray[2][0] = new Tile();
        tileArray[5][0] = new Tile();
        tileArray[2][7] = new Tile();
        tileArray[5][7] = new Tile();

        tileArray[2][0].getPieceList().add(blackBishop);
        tileArray[5][0].getPieceList().add(blackBishop);
        tileArray[2][7].getPieceList().add(whiteBishop);
        tileArray[5][7].getPieceList().add(whiteBishop);

        setABoardTile(blackBishop.getImage(), 2, 0);
        setABoardTile(blackBishop.getImage(), 5, 0);
        setABoardTile(whiteBishop.getImage(), 2, 7);
        setABoardTile(whiteBishop.getImage(), 5, 7);

    }
    /**
     * Places all Knights into their designated tile for the start of the game
     */
    public void setUpKnights(){
        Piece blackKnight = new Knight();
        blackKnight.setColor("Black");
        setPieceImage(blackKnight, blackKnight.toString().toLowerCase(), "black");

        Piece whiteKnight = new Knight();
        whiteKnight.setColor("White");
        setPieceImage(whiteKnight, whiteKnight.toString().toLowerCase(), "white");

        tileArray[1][0] = new Tile();
        tileArray[6][0] = new Tile();
        tileArray[1][7] = new Tile();
        tileArray[6][7] = new Tile();

        tileArray[1][0].getPieceList().add(blackKnight);
        tileArray[6][0].getPieceList().add(blackKnight);
        tileArray[1][7].getPieceList().add(whiteKnight);
        tileArray[6][7].getPieceList().add(whiteKnight);

        setABoardTile(blackKnight.getImage(), 1, 0);
        setABoardTile(blackKnight.getImage(), 6, 0);
        setABoardTile(whiteKnight.getImage(), 1, 7);
        setABoardTile(whiteKnight.getImage(), 6, 7);

    }
    /**
     * Places all Rooks into their designated tile for the start of the game
     */
    public void setUpRooks(){
        Piece blackRook = new Rook();
        blackRook.setColor("Black");
        setPieceImage(blackRook, blackRook.toString().toLowerCase(), "black");

        Piece whiteRook = new Rook();
        whiteRook.setColor("White");
        setPieceImage(whiteRook, whiteRook.toString().toLowerCase(), "white");

        tileArray[0][0] = new Tile();
        tileArray[7][0] = new Tile();
        tileArray[0][7] = new Tile();
        tileArray[7][7] = new Tile();

        tileArray[0][0].getPieceList().add(blackRook);
        tileArray[7][0].getPieceList().add(blackRook);
        tileArray[0][7].getPieceList().add(whiteRook);
        tileArray[7][7].getPieceList().add(whiteRook);

        setABoardTile(blackRook.getImage(), 0, 0);
        setABoardTile(blackRook.getImage(), 7, 0);
        setABoardTile(whiteRook.getImage(), 0, 7);
        setABoardTile(whiteRook.getImage(), 7, 7);

    }
    /**
     * Places all Pawns into their designated tile for the start of the game
     */
    public void setUpPawns(){
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Pawn();
            pawn.setColor("Black");
            setPieceImage(pawn, pawn.toString().toLowerCase(), "black");

            tileArray[1][i] = new Tile();
            tileArray[1][i].getPieceList().add(pawn);

            setABoardTile(pawn.getImage(), i, 1);
        }
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Pawn();
            pawn.setColor("White");
            setPieceImage(pawn, pawn.toString().toLowerCase(), "white");

            tileArray[6][i] = new Tile();
            tileArray[6][i].getPieceList().add(pawn);

            setABoardTile(pawn.getImage(), i, 6);
        }
    }
    /**
     * Creates a backdrop fo the board which the game will be played on
     */
    public void colorBoard() {
        // Declares new board
        board = new Rectangle[8][8];

        // Initializes new board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Rectangle();
                board[i][j].setWidth(100);
                board[i][j].setHeight(100);
                board[i][j].setStroke(Color.TRANSPARENT);
                board[i][j].setStrokeType(StrokeType.INSIDE);
                board[i][j].setStrokeWidth(1);
            }
        }
        // Generates colours for the chessboard backgrounds
        for(int i=0; i < 8; i++){
            for(int j=0; j < 8; j++){
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
    /**
     * Set the board tile properties for an image
     */
    private void setABoardTile(Image image, int col, int row) {
        board[col][row].setFill(new ImagePattern(image));
        board[col][row].setWidth(100);
        board[col][row].setHeight(100);
        board[col][row].setStroke(Color.TRANSPARENT);
        board[col][row].setStrokeType(StrokeType.INSIDE);
        board[col][row].setStrokeWidth(1);
    }

    /**
     * sets the piece image
     */
    public <T extends Piece> void setPieceImage(T piece, String pieceName, String pieceColor) {
        piece.setImage("src\\main\\resources\\com\\boardgames\\graphics\\"+pieceColor+"_"+pieceName+".png");
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

