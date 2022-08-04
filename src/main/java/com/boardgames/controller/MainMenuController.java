package com.boardgames.controller;

import com.boardgames.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    ScoreCardController scController;

    @FXML
    private Button startGameButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button settingsButton;

    @FXML
    protected void onSettingsButtonClick() throws IOException {
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        stage.close();
        Stage mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("settings-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 300);
        mainStage.setTitle("Board Games");
        mainStage.setScene(scene);
        mainStage.show();
    }


    @FXML
    protected void onStartGameButton() throws IOException {
        scController = new ScoreCardController();

        Stage stage = (Stage) startGameButton.getScene().getWindow();
        stage.close();

        Stage mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("chess-view.fxml"));

        // load the chess-view as the root node
        Parent root = fxmlLoader.load();
        // get the current chess-view controller to access its methods
        ChessDisplayController cdController = fxmlLoader.getController();
        // calls the method belonging to chess display controller to inject the score
        cdController.updateGridPane();

        Scene scene = new Scene(root, 450, 300);
        mainStage.setTitle("Board Games");
        mainStage.setScene(scene);
        mainStage.show();
    }


    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }
}