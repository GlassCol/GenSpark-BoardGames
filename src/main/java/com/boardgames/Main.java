package com.boardgames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 350);
        stage.setTitle("Board Games");
        stage.setScene(scene);
        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("stylesheet.css")).toExternalForm());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}