package com.boardgames.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class ChessDisplayController {

    @FXML
    private GridPane playerGridPane;
    @FXML
    private GridPane opponentGridPane;

    public void updateGridPane() {
        ScoreCardController scController = new ScoreCardController();
        playerGridPane = scController.addGridPane(playerGridPane);
        opponentGridPane = scController.addOpponentGridPane(opponentGridPane);
    }

}
