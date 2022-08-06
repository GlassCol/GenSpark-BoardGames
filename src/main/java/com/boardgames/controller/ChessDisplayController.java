package com.boardgames.controller;

import com.boardgames.Tile;
import com.boardgames.piece.Piece;
import com.boardgames.piece.chesspiece.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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

    // sets up the vBox container for collecting names
    public void showGetPlayerNames(VBox vBox) {
        ScoreCardController scController = new ScoreCardController();
        GridPane challenger = scController.gridToCollectName("Player 1");
        GridPane opponent = scController.gridToCollectName("Player 2");

        // set the button actions on each grid pane - requires access to scoreboard fxml field
        setSubmitActionOn(challenger);
        setSubmitActionOn(opponent);

        // add all panes to the vBox
        vBox.getChildren().addAll(challenger, opponent);
        scController.setVboxProps(vBox, 0, 0,
                300,
                boardGridPane.getHeight() - 100,
                (boardGridPane.getHeight()/2) + 100.0);

    }

    // sets the actions on the button node within the grid pane
    private void setSubmitActionOn(GridPane gridPane) {
        Button button = (Button) gridPane.getChildren().get(gridPane.getChildren().size()-1);
        button.setOnAction(e -> {
            addScoreBoard(scoreBoardVBoxPane, gridPane);
        });
    }

    // returns the string value of the text field node of the pane
    private <T extends Pane> String getTextFieldValueFrom(T pane) {
        List<Node> nodes = pane.getChildren();
        return nodes.stream()
                .filter(node -> node instanceof TextField)
                .map(node -> ((TextField) node).getText())
                .collect(Collectors.joining());
    }

    public void addScoreBoard(VBox stack, GridPane gridPane)  {
        ScoreCardController scController = new ScoreCardController();
        double paneSpacing = borderPane.getHeight() / 2;

        // remove existing nodes from stack when text from
        String textField = getTextFieldValueFrom(gridPane);

        if (!textField.isEmpty()) {
            String id = gridPane.getId(); // get the id before removing grid pane
            stack.getChildren().remove(gridPane);  // remove the current grid pane from the stack

            gridPane = scController.addPlayerGridPane(id); // create a new grid pane with id
            stack.getChildren().add(gridPane);  // add the new grid pane to the stack

            // set the position of the pane
            if (gridPane.getId().equals("Player 1")) {
                StackPane.setMargin(gridPane, new Insets( 90, 32, 0, 0));
            } else {
                StackPane.setMargin(gridPane, new Insets( paneSpacing - 100, 32, 100, 0));
            }
        }
    }

    private void handleSubmitName(String text) {
        String name = text;
        System.out.println(name);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boardGridPane.setPadding(new Insets(0,0,0,0));
        showGetPlayerNames(scoreBoardVBoxPane);
        colorBoard();
        setUpPieces();
    }
}

