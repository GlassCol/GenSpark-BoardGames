package com.boardgames.controller;

import com.boardgames.score.Score;
import com.boardgames.score.ScoreCard;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Arrays;

public class ScoreCardController {

    private ScoreCard sCard;

    public ScoreCardController() {
        sCard = new ScoreCard();
    }

    public GridPane addPlayerGridPane(String id) {
        GridPane gridPane = createGPane(12, 12, 0, 0, 200, 500, 300, 500);
        gridPane.setId(id);

        Font sans16B = Font.font("Sans Serif", FontWeight.BOLD, 16);

        Text name = new Text("Name");
        name.setFont(sans16B);
        gridPane.addRow(0, name);

        return gridPane;
    }

    public GridPane addOpponentGridPane(String id) {
        GridPane gridPane = createGPane(12, 12, 0, 0, 200, 500, 300, 500);
        gridPane.setId(id);

        Font sans16 = Font.font("Sans Serif", FontWeight.BOLD, 16);

        Text name = new Text("Name");
        name.setFont(sans16);
        gridPane.addRow(0, name);

        return gridPane;
    }

    // creates a grid pane
    public GridPane createGPane(int cols, int rows, int layoutX, int layoutY, int prefWidth, int prefHeight, int maxWidth, int maxHeight) {
        GridPane gPane = new GridPane();

        gPane.setGridLinesVisible(true);
        gPane.setLayoutX(layoutX);
        gPane.setLayoutY(layoutY);
        gPane.setPrefWidth(prefWidth);
        gPane.setPrefHeight(prefHeight);
        gPane.setMaxWidth(maxWidth);
        gPane.setMaxHeight(maxHeight);
        gPane.setAlignment(Pos.TOP_LEFT);

        addConstraints(gPane, cols, true);
        addConstraints(gPane, rows, false);

        return gPane;
    }

    // configures row or column constraints for a grid pane
    private void addConstraints(GridPane gPane, int qty, boolean isColumn) {
        for (int i = 0; i < qty; i++) {
            if (isColumn) {
                ColumnConstraints cStraint = new ColumnConstraints();
                cStraint.setPercentWidth(100);
                cStraint.setHgrow(Priority.ALWAYS);
                gPane.getColumnConstraints().add(cStraint);
            } else {
                RowConstraints rStraint = new RowConstraints();
                rStraint.setPercentHeight(100);
                rStraint.setVgrow(Priority.ALWAYS);
                gPane.getRowConstraints().add(rStraint);
            }
        }
    }

    // configures the vBox properties
    public VBox setVboxProps(VBox vBox, int layoutX, int layoutY, double prefWidth, double prefHeight, double spacing) {

        String cssLayout = "-fx-border-color: red;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-border-style: dashed;\n";

        vBox.setLayoutX(layoutX);
        vBox.setLayoutY(layoutY);
        vBox.setPrefWidth(prefWidth);
        vBox.setPrefHeight(prefHeight);

        vBox.setSpacing( spacing );
        vBox.setPadding(new Insets(90, 20, 20, 20));
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setStyle(cssLayout);
        return vBox;
    }

    // configures the grid pane for collecting names
    public GridPane gridToCollectName(String textHeading) {
        GridPane gridPane = createGPane(12, 12, 0, 0, 200, 200, 300, 300);
        gridPane.setId(textHeading);

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
        gridPane.add(button, 0, 6, colSpan, rowSpan);

        return gridPane;
    }

    public Score[] findScoresBy(String name) {
        Score[] scores = sCard.getScoreHistoryBy(name);
        return scores;
    }

}
