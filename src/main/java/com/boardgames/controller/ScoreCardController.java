package com.boardgames.controller;

import com.boardgames.FileUtil;
import com.boardgames.score.ScoreCard;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.nio.file.Path;

public class ScoreCardController {

    private ScoreCard sCard;

    public ScoreCardController() {
        sCard = new ScoreCard();
    }

    public GridPane addGridPane(GridPane gridPane) {
//        GridPane gridPane = new GridPane();

//        gridPane.setGridLinesVisible(true);
        gridPane.setLayoutX(0);
        gridPane.setLayoutY(0);
        gridPane.setPrefWidth(300);
        gridPane.setPrefHeight(180);
        gridPane.setId("gridPane");

        gridPane.setHgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(0, 10, 0, 10));
        Font sans16 = Font.font("Sans Serif", FontWeight.BOLD, 16);
        Font sans12 = Font.font("Sans Serif", FontWeight.NORMAL, 12);

        Text name = new Text("Name");
        name.setFont(sans16);
        gridPane.add(name, 0, 0);

        Text win = new Text("Win");
        win.setFont(sans16);
        gridPane.add(win, 2, 0);

        Text loss = new Text("Loss");
        loss.setFont(sans16);
        gridPane.add(loss, 4, 0);

        Text winPercent = new Text("W%");
        winPercent.underlineProperty();
        winPercent.setFont(sans16);
        gridPane.add(winPercent, 6, 0);

        Text nameValue = new Text("Alice");
        nameValue.setFont(sans12);
        gridPane.add(nameValue, 0, 2);

        Text winValue = new Text("10");
        winValue.setFont(sans12);
        gridPane.add(winValue, 2, 2);

        Text lossValue = new Text("2");
        lossValue.setFont(sans12);
        gridPane.add(lossValue, 4, 2);

        Text winPercentValue = new Text("80%");
        winPercentValue.setFont(sans12);
        gridPane.add(winPercentValue, 6, 2);

        return gridPane;
    }

    public GridPane addOpponentGridPane(GridPane gridPane) {
//        GridPane gridPane = new GridPane();

//        gridPane.setGridLinesVisible(true);

        gridPane.setLayoutX(225);
        gridPane.setLayoutY(0);
        gridPane.setPrefWidth(300);
        gridPane.setPrefHeight(180);
        gridPane.setId("gridPane");

        gridPane.setHgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(0, 10, 0, 10));
        Font sans16 = Font.font("Sans Serif", FontWeight.BOLD, 16);
        Font sans12 = Font.font("Sans Serif", FontWeight.NORMAL, 12);

        Text name = new Text("Name");
        name.setFont(sans16);
        gridPane.add(name, 6, 0);

        Text win = new Text("Win");
        win.setFont(sans16);
        gridPane.add(win, 4, 0);

        Text loss = new Text("Loss");
        loss.setFont(sans16);
        gridPane.add(loss, 2, 0);

        Text winPercent = new Text("W%");
        winPercent.underlineProperty();
        winPercent.setFont(sans16);
        gridPane.add(winPercent, 0, 0);

        // values on row 2
        Text nameValue = new Text("Bob");
        nameValue.setFont(sans12);
        gridPane.add(nameValue, 6, 2);

        Text winValue = new Text("5");
        winValue.setFont(sans12);
        gridPane.add(winValue, 4, 2);

        Text lossValue = new Text("5");
        lossValue.setFont(sans12);
        gridPane.add(lossValue, 2, 2);

        Text winPercentValue = new Text("50%");
        winPercentValue.setFont(sans12);
        gridPane.add(winPercentValue, 0, 2);

        return gridPane;
    }


}
