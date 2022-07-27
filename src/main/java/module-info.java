module com.boardgames.genspark_group_boardgames {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.boardgames to javafx.fxml;
    exports com.boardgames;
}