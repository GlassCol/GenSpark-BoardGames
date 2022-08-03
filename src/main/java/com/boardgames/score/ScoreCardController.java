package com.boardgames.score;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class ScoreCardController {

    public GridPane addGridPane() {
        GridPane gridPane = new GridPane();

        gridPane.setHgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(0, 10, 0, 10));
        Font arial20 = Font.font("Arial", FontWeight.BOLD, 20);

        Text name = new Text("Name:");
        name.setFont(arial20);
        gridPane.add(name, 1, 0);

        Text win = new Text("Win:");
        win.setFont(arial20);
        gridPane.add(win, 2, 0);

        Text winValue = new Text("10");
        winValue.setFont(arial20);
        gridPane.add(winValue, 2, 1);

        Text loss = new Text("Loss:");
        loss.setFont(arial20);
        gridPane.add(loss, 2, 3);

        Text lossValue = new Text("2");
        lossValue.setFont(arial20);
        gridPane.add(lossValue, 2, 4);

        Text winPercent = new Text("W%:");
        winPercent.setFont(arial20);
        gridPane.add(winPercent, 2, 5);

        Text winPercentValue = new Text("80%");
        winPercentValue.setFont(arial20);
        gridPane.add(winPercentValue, 2, 6);

        return gridPane;
    }

}

//<GridPane fx:id="scorecard"
//        gridLinesVisible="true"
//        opacity="0.31"
//        prefHeight="144.0"
//        prefWidth="288.0"
//        AnchorPane.bottomAnchor="0.0"
//        AnchorPane.leftAnchor="0.0"
//        AnchorPane.rightAnchor="0.0"
//        AnchorPane.topAnchor="0.0">
