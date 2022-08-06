package com.boardgames.controller;

import com.boardgames.score.Score;
import com.boardgames.score.ScoreCard;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScoreCardController {

    private ScoreCard sCard;

    public ScoreCardController() {
        sCard = new ScoreCard();
    }

    public GridPane addPlayerGridPane() {
        GridPane gridPane = createGPane(0, 0, 200, 200, 300, 300);

        Font sans16B = Font.font("Sans Serif", FontWeight.BOLD, 16);

        Text name = new Text("Name");
        name.setFont(sans16B);
        gridPane.add(name, 0, 0);

        return gridPane;
    }

    public GridPane addOpponentGridPane() {
        GridPane gridPane = createGPane(0, 0, 200, 200, 300, 300);

        Font sans16 = Font.font("Sans Serif", FontWeight.BOLD, 16);

        Text name = new Text("Name");
        name.setFont(sans16);
        gridPane.add(name, 6, 0);

        return gridPane;
    }

    public GridPane createGPane(int layoutX, int layoutY, int prefWidth, int prefHeight, int maxWidth, int maxHeight) {
        GridPane gPane = new GridPane();

        gPane.setLayoutX(layoutX);
        gPane.setLayoutY(layoutY);
        gPane.setPrefWidth(prefWidth);
        gPane.setPrefHeight(prefHeight);
        gPane.setMaxWidth(maxWidth);
        gPane.setMaxHeight(maxHeight);
        gPane.setAlignment(Pos.TOP_LEFT);
        gPane.setHgap(10);
        gPane.setVgap(10);
        gPane.setPadding(new Insets(10, 10, 10, 10));
        return gPane;
    }

    public GridPane gridToCollectName(String textHeading) {
        GridPane gridPane = createGPane(0, 0, 200, 200, 300, 300);

        // set font style
        Font sans24B = Font.font("Sans Serif", FontWeight.BOLD, 16);
        int colSpan = 20;
        int rowSpan = 2;

        // create input box
        Text name = new Text(textHeading);
        name.setFont(sans24B);
        gridPane.add(name, 0, 0, colSpan, rowSpan);

        // text field to accept name input
        TextField textField = new TextField();
        textField.setFont(sans24B);;
        textField.setPromptText("What is your name ...");
        gridPane.add(textField, 0, 2, colSpan, rowSpan);

        // button to submit name
        Button button = new Button("SUBMIT");
        button.setFont(sans24B);
        gridPane.add(button, 0, 4, colSpan, rowSpan);

        return gridPane;
    }

    public Score[] findScoreBy(String name) {
        Score[] score = sCard.getScoreHistoryBy(name);
        return score;
    }

}
