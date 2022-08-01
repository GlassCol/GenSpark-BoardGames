package com.boardgames.controller;

import com.boardgames.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
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
    protected void onExitButtonClick() {
        System.exit(0);
    }
}