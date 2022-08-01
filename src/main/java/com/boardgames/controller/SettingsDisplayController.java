package com.boardgames.controller;

import com.boardgames.Main;
import com.boardgames.Settings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the settings view which handles all events for the Settings
 *
 * @author Cole Glass
 */
public class SettingsDisplayController {
    @FXML
    Button mainButton;
    @FXML
    Slider numberOfPlayersSlider;
    @FXML
    ToggleButton chessButton;
    @FXML
    public void backToMain() throws IOException {
        setSettings();
        Stage stage = (Stage) mainButton.getScene().getWindow();
        stage.close();
        Stage mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 300);
        mainStage.setTitle("Bully Conquest");
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void setSettings(){
        Settings.setNumOfPlayers((int) numberOfPlayersSlider.getValue());
        if(chessButton.isSelected())Settings.setPlayingChess(true);
        else Settings.setPlayingChess(false);
    }
}
