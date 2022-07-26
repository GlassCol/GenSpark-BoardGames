package com.boardgames;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainMenuController {
    @FXML
    private Button startGameButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button settingsButton;

    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }
}