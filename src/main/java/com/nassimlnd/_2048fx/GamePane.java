package com.nassimlnd._2048fx;

import com.almasb.fxgl.core.collection.grid.Grid;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;

public class GamePane {

    public GamePane(Stage stage, GameManager gameManager) {
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = showGrid(gameManager);
        Pane pane = new Pane();
        Label gameTitle = new Label("2048");
        VBox scoreBox = new VBox();
        VBox bestScoreBox = new VBox();
        Font font = Font.loadFont("file:resources/fonts/TenaliRamakrishna-Regular.ttf", 80);
        pane.setMaxHeight(150);
        pane.getChildren().add(gameTitle);
        pane.getChildren().add(scoreBox);
        pane.getChildren().add(bestScoreBox);

        /* BestScore */
        Label bestScoreTitle = new Label("RECORD");
        Label bestScore = new Label("64709");
        bestScoreTitle.getStyleClass().add("game-score");
        bestScore.getStyleClass().add("game-score-points");
        bestScore.setTextFill(Color.WHITE);
        bestScoreBox.setAlignment(Pos.CENTER);
        bestScoreBox.setLayoutX(449);
        bestScoreBox.setLayoutY(75);
        bestScoreBox.setPadding(new Insets(10,10,10,10));
        bestScoreBox.getStyleClass().add("game-vbox");
        bestScoreBox.getChildren().add(bestScoreTitle);
        bestScoreBox.getChildren().add(bestScore);

        /* Score */
        Label score = new Label("SCORE");
        Label nbScore = new Label("0");
        score.getStyleClass().add("game-score");
        nbScore.getStyleClass().add("game-score-points");
        nbScore.setTextFill(Color.WHITE);
        scoreBox.setAlignment(Pos.CENTER);
        scoreBox.setLayoutX(348);
        scoreBox.setLayoutY(75);
        scoreBox.setPadding(new Insets(10,10,10,10));
        scoreBox.getStyleClass().add("game-vbox");
        scoreBox.getChildren().add(score);
        scoreBox.getChildren().add(nbScore);

        /* GameTitle */
        gameTitle.setLayoutX(59.0);
        gameTitle.setLayoutY(53.0);
        gameTitle.getStyleClass().add("game-title");
        gameTitle.setFont(font);
        /* BorderPane */
        //borderPane.getStyleClass().add("game-backGrid");
        borderPane.setPrefHeight(800);
        borderPane.setPrefWidth(600);
        borderPane.setTop(pane);
        borderPane.setCenter(gridPane);
        borderPane.getStyleClass().add("game-root");
        BorderPane.setAlignment(gridPane, Pos.CENTER);

        /* GridPane */
        gridPane.setMaxSize(400,400);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        //gridPane.setStyle("-fx-background-color: red;");
        gridPane.getStyleClass().add("game-backGrid");

        Scene scene = new Scene(borderPane, 600,800);
        scene.getStylesheets().add(String.valueOf(GamePane.class.getResource("game.css")));
        stage.setScene(scene);
        stage.setTitle("2048");
        stage.setResizable(false);
        stage.show();
    }

    public GridPane showGrid(GameManager gameManager) {
        GridPane gridPane = new GridPane();
        gridPane.getStylesheets().add(String.valueOf(GamePane.class.getResource("game.css")));
        HashMap<Location, Tile> grid = gameManager.getGrid();

        gridPane.setMinSize(500,500);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        for (int i = 0; i < gameManager.getSize(); i++) {
            for (int j = 0; j < gameManager.getSize(); j++) {
                Tile tile = gameManager.getTile(new Location(i, j));
                if (!(tile == null)) {
                    tile.setAlignment(Pos.CENTER);
                    tile.setPrefSize(100,100);
                    tile.setMaxSize(100,100);
                    System.out.println(tile);
                    gridPane.add(tile, i, j);
                } else {
                    Label label = new Label("");
                    label.setAlignment(Pos.CENTER);
                    label.setPrefSize(100,100);
                    label.setMaxSize(100,100);
                    label.getStylesheets().add(getClass().getResource("game.css").toExternalForm());
                    label.getStyleClass().add("game-tile-0");
                    gridPane.add(label, i, j);
                }
            }
        }

        return gridPane;
    }
}
