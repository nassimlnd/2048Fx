package com.nassimlnd._2048fx;

import com.almasb.fxgl.core.collection.grid.Grid;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;

public class GamePane {

    public GamePane(Stage stage, GameManager gameManager) {
        VBox vBox = new VBox();
        GridPane gridPane = showGrid(gameManager);
        Scene scene = new Scene(vBox, 500,500);
        stage.setScene(scene);
        stage.setTitle("2048");
        stage.show();
    }

    public GridPane showGrid(GameManager gameManager) {
        GridPane gridPane = new GridPane();
        HashMap<Location, Tile> grid = gameManager.getGrid();

        gridPane.setMinSize(500,500);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        for (int i = 0; i < gameManager.getSize(); i++) {
            for (int j = 0; j < gameManager.getSize(); j++) {
                Tile tile = grid.get(new Location(i,j));
                gridPane.add(tile, i, j);
            }
        }

        return gridPane;
    }
}
