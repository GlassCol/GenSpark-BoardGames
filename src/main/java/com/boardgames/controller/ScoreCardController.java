package com.boardgames.controller;

import com.boardgames.score.Score;
import com.boardgames.score.ScoreCard;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Arrays;

/**
 * Scorecard controller for loading existing scores and creating panels for displaying score
 * @author pygna
 */
public class ScoreCardController {

    private ScoreCard sCard;

    public ScoreCardController() {
        sCard = new ScoreCard();
    }

    // SCORE HELPER METHODS
    private Score[] findScoresBy(String name) {
        return sCard.getScoreHistoryBy(name);
    }

    // adds score history when it exists for the name
    private GridPane addScoreTo(GridPane gridPane, String name) {
        Score[] scores = findScoresBy(name);
        double wins = 0, losses = 0, percent = 0;

        if (scores.length > 0) {
            wins = Arrays.stream(scores).filter(Score::getIsWin).count();
            losses = scores.length - wins;
            percent = wins/losses;
        }

        Label lblName = setUpLabel("Name");
        Label lblWins = setUpLabel("Wins");
        Label lblLoss = setUpLabel("Losses");
        Label lblPercent = setUpLabel("w/l %");

        Text txtName = setUpText(name);
        Text txtWins = setUpText(String.format("%d", (int) wins));
        Text txtLosses = setUpText(String.format("%d", (int) losses));
        Text txtPercent = setUpText(String.format("%.2f", percent));

        gridPane.addColumn(0, lblName);
        gridPane.addColumn(2, lblWins);
        gridPane.addColumn(4, lblLoss);
        gridPane.addColumn(6, lblPercent);

        gridPane.add(txtName, 0, 1);
        gridPane.add(txtWins, 2, 1);
        gridPane.add(txtLosses, 4, 1);
        gridPane.add(txtPercent, 6, 1);

        gridPane.setHgap(1);
        gridPane.setVgap(1);

        return gridPane;
    }

    // END - SCORE HELPER METHODS

    // PANELS FOR VIEW

    // configures the panel for displaying the players score
    public GridPane addScorePaneFor(String name, String id) {
        GridPane gridPane = createGPane(6, 8, 0, 0, 240, 200, 300, 200);
        gridPane.setId(id);
        return addScoreTo(gridPane, name);
    }

    // configures the grid pane for collecting names
    public GridPane getPaneToCollectNameFor(String textHeading) {
        GridPane gridPane = createGPane(6, 8, 0, 0, 240, 200, 300, 200);
        gridPane.setId(textHeading);

        // set font style
        Font sans24B = Font.font("Sans Serif", FontWeight.BOLD, 16);

        // create input box
        Text name = new Text(textHeading);
        name.setFont(sans24B);
        gridPane.add(name, 0, 0);

        // text field to accept name input
        TextField textField = new TextField();
        textField.setFont(sans24B);;
        textField.setPromptText("What is your name ...");
        gridPane.add(textField, 0, 1);

        // button to submit name
        Button button = new Button("SUBMIT");
        button.setFont(sans24B);
        gridPane.add(button, 0, 2);

        return gridPane;
    }

    // END - PANELS FOR VIEW


    // PANEL CONFIGS AND SETUP

    // creates a grid pane
    public GridPane createGPane(int cols, int rows, int layoutX, int layoutY, int prefWidth, int prefHeight, int maxWidth, int maxHeight) {
        GridPane gPane = new GridPane();

//        gPane.setGridLinesVisible(true);
        gPane.setLayoutX(layoutX);
        gPane.setLayoutY(layoutY);
        gPane.setPrefWidth(prefWidth);
        gPane.setPrefHeight(prefHeight);
        gPane.setMaxWidth(maxWidth);
        gPane.setMaxHeight(maxHeight);
        gPane.setAlignment(Pos.TOP_LEFT);
        gPane.setHgap(10);
        gPane.setVgap(10);
        gPane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        addConstraints(gPane, cols, true);
        addConstraints(gPane, rows, false);

        return gPane;
    }

    // configures row or column constraints for a grid pane
    private void addConstraints(GridPane gPane, int qty, boolean isColumn) {
        for (int i = 0; i < qty; i++) {
            if (isColumn) {
                ColumnConstraints cStraint = new ColumnConstraints();
                cStraint.setHgrow(Priority.ALWAYS);
                cStraint.setHalignment(HPos.LEFT);
                gPane.getColumnConstraints().add(cStraint);
            } else {
                RowConstraints rStraint = new RowConstraints();
                rStraint.setVgrow(Priority.ALWAYS);
                rStraint.setValignment(VPos.BOTTOM);
                gPane.getRowConstraints().add(rStraint);
            }
        }
    }

    // configures the vBox properties
    public VBox setVboxProps(VBox vBox, int layoutX, int layoutY, double prefWidth, double prefHeight, double spacing) {

//        Border for debugging
//        String cssLayout = "-fx-border-color: red;\n" +
//                "-fx-border-insets: 5;\n" +
//                "-fx-border-width: 3;\n" +
//                "-fx-border-style: dashed;\n";
//        vBox.setStyle(cssLayout);

        vBox.setLayoutX(layoutX);
        vBox.setLayoutY(layoutY);
        vBox.setPrefWidth(prefWidth);
        vBox.setPrefHeight(prefHeight);

        vBox.setSpacing( spacing );
        vBox.setPadding(new Insets(90, 20, 20, 20));
        vBox.setAlignment(Pos.TOP_LEFT);

        return vBox;
    }

    // CONTROL ASSETS

    // setup text with default font
    private Text setUpText(String _text) {
        Font sans = Font.font("Sans Serif", FontWeight.NORMAL, 16);
        Text text = new Text(_text);
        text.setTextAlignment(TextAlignment.JUSTIFY);
        text.setFont(sans);
        GridPane.setHalignment(text, HPos.RIGHT);
        GridPane.setMargin(text, new Insets(0, 12, 0, 0));
        return text;
    }

    // setup label with default font
    private Label setUpLabel(String text) {
        Font sans = Font.font("Sans Serif", FontWeight.BOLD, 16);
        Label label = new Label(text);
        label.setAlignment(Pos.BOTTOM_CENTER);
        label.setPadding(new Insets(5, 8, 5, 5));
        label.setFont(sans);
        return label;
    }

    // END - CONTROL ASSETS


}
