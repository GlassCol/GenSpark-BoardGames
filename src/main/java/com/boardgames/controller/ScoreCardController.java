package com.boardgames.controller;

import com.boardgames.score.Score;
import com.boardgames.score.ScoreCard;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * finds all the scores belonging to the name
     * @param name
     * @return
     */
    private Score[] findScoresBy(String name) {
        return sCard.getScoreHistoryBy(name);
    }

    /**
     * adds score history when name of player exists and their accum win loss stats
     * @param gridPane
     * @param name
     * @return
     */
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

    // PANEL VIEW HELPERS

    /**
     * creates panel for displaying the players score stats within a scorecard
     * @param name
     * @param id
     * @return Grid Pane
     */
    public GridPane addScorePaneFor(String name, String id) {
        GridPane gridPane = createGPane(6, 8, 0, 0, 240, 200, 300, 200);
        gridPane.setId(id);
        return addScoreTo(gridPane, name);
    }

    /**
     * creates the pane for collecting names
     * @param textHeading
     * @return
     */
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

    /**
     * sets the actions of the button node belonging to the grid pane
     * @param vBox
     * @param gridPane
     */
    private void setSubmitActionOn(VBox vBox, GridPane gridPane) {
        Button button = (Button) gridPane.getChildren().get(gridPane.getChildren().size()-1);
        button.setOnAction(e -> {
            showScoreBoard(vBox, gridPane);
        });
    }

    /**
     * returns the string value of the text field node of the pane
     * @param pane
     * @return String
     * @param <T> extends Pane
     */
    private <T extends Pane> String getTextFieldValueFrom(T pane) {
        List<Node> nodes = pane.getChildren();
        return nodes.stream()
                .filter(node -> node instanceof TextField)
                .map(node -> ((TextField) node).getText())
                .collect(Collectors.joining());
    }

    // END - PANEL VIEW HELPERS

    // PANEL VIEWS

    /**
     * adds node elements to the vBox container for collecting names
     * @param vBox
     * @param bgPaneHeight
     */
    private void showViewToCollectPlayerNames(VBox vBox, double bgPaneHeight) {
        GridPane challenger = getPaneToCollectNameFor("Player 1");
        GridPane opponent = getPaneToCollectNameFor("Player 2");

        // set the button actions on each grid pane - requires access to scoreboard fxml field
        setSubmitActionOn(vBox, challenger);
        setSubmitActionOn(vBox, opponent);

        // add all panes to the vBox
        vBox.getChildren().addAll(challenger, opponent);
        setVboxProps(vBox, 0, 0,
                300,
                bgPaneHeight - 100,
                (bgPaneHeight/2) + 100.0);

    }

    /**
     * show and adds elements to the Vbox container for a scorecard belonging to a name
     * @param vBox
     * @param gridPane
     */
    public void showScoreBoard(VBox vBox, GridPane gridPane) {
        // gets the text value from the text field
        String name = getTextFieldValueFrom(gridPane);

        if (!name.isEmpty()) {
            String id = gridPane.getId(); // get the id before removing grid pane
            vBox.getChildren().remove(gridPane);  // remove the current grid pane from the vBox

            GridPane scoreCard = addScorePaneFor(name, id); // create a new grid pane with id
            // set the position of the pane
            if (scoreCard.getId().equals("Player 1")) {
                vBox.getChildren().add(0, scoreCard);  // add the new grid pane to the vBox
            } else {
                vBox.getChildren().add(1, scoreCard);  // add the new grid pane to the vBox
            }
        }

    }

    /**
     * calls the method for showing the view to collect names
     * @param vBox
     * @param bgPaneHeight
     */
    public void showScoreBoard(VBox vBox, double bgPaneHeight)  {
        showViewToCollectPlayerNames(vBox, bgPaneHeight);
    }

    // END - PANEL VIEWS

    // GENERAL PANEL CONFIGS AND SETUP

    /**
     * create a generic grid pane with col and row constraints
     * @param cols
     * @param rows
     * @param layoutX
     * @param layoutY
     * @param prefWidth
     * @param prefHeight
     * @param maxWidth
     * @param maxHeight
     * @return
     */
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

    /**
     * sets general column and row constraints for a grid pane
     * @param gPane
     * @param qty
     * @param isColumn
     */
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

    /**
     * configures the vBox Pane container for the scoreboard view
     * @param vBox
     * @param layoutX
     * @param layoutY
     * @param prefWidth
     * @param prefHeight
     * @param spacing
     * @return
     */
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

    // GENERAL PANEL CONFIGS AND SETUP

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
