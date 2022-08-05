package com.boardgames.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.net.URL;
import java.util.ResourceBundle;

public class ChessDisplayController implements Initializable {

    @FXML
    StackPane scoreBoardStackPane;

    @FXML
    GridPane boardGridPane;

    Rectangle[][] board;

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

    public void addScoreBoard(StackPane stack)  {
        ScoreCardController scController = new ScoreCardController();

        GridPane playerGridPane = scController.addPlayerGridPane();
        GridPane opponentGridPane = scController.addOpponentGridPane();

        stack.getChildren().addAll(playerGridPane, opponentGridPane);
        // Add offset to right for question mark to compensate for RIGHT
        // alignment of all nodes
        StackPane.setMargin(playerGridPane, new Insets(0, 200, 0, 0));
        StackPane.setMargin(opponentGridPane, new Insets(0, 200, 0, 0));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boardGridPane.setPadding(new Insets(0,0,0,0));
        addScoreBoard(scoreBoardStackPane);
        colorBoard();
    }
}

