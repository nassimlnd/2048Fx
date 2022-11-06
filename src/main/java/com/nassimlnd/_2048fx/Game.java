package com.nassimlnd._2048fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GameManager gameManager = new GameManager(4);
        GamePane gamePane = new GamePane(stage, gameManager);
    }
}
