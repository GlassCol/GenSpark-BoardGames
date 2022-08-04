package com.boardgames.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class ChessDisplayController {

    @FXML
    private GridPane playerScoreCard;
    @FXML
    private GridPane opponentScoreCard;

    public void updateGridPane() {
        ScoreCardController scController = new ScoreCardController();
        playerScoreCard = scController.addGridPane(playerScoreCard);
        opponentScoreCard = scController.addOpponentGridPane(opponentScoreCard);
    }

}
