package com.boardgames.controller;

import com.boardgames.score.Score;
import com.boardgames.score.ScoreCard;
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
        GridPane gridPane = new GridPane();

        Font sans12 = Font.font("Sans Serif", FontWeight.NORMAL, 12);

        Text name = new Text("Name");
        name.setFont(sans12);
        gridPane.add(name, 0, 0);

        return gridPane;
    }

    public GridPane addOpponentGridPane() {
        GridPane gridPane = new GridPane();

        gridPane.setLayoutX(0);
        gridPane.setLayoutY(300);
        gridPane.setMaxWidth(507);
        gridPane.setMaxHeight(300);
        gridPane.setAlignment(Pos.BOTTOM_RIGHT);

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


}
