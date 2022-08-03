package com.boardgames;

import com.boardgames.controller.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // pass the stage object into the main controller
        // so other controllers have access to this stage instance - if required
        MainMenuController MMController = new MainMenuController(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
