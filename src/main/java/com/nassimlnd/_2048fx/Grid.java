package com.nassimlnd._2048fx;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Grid extends GridPane {

    public Grid() {
        super();
    }

    public void refreshGrid(GameManager gameManager) {
        getChildren().clear();
        System.out.println(this.getChildren());

        for (int i = 0; i < gameManager.getSize(); i++) {
            for (int j = 0; j < gameManager.getSize(); j++) {
                Tile tile = gameManager.getTile(new Location(i, j));
                if (!(tile == null)) {
                    tile.setAlignment(Pos.CENTER);
                    tile.setPrefSize(100,100);
                    tile.setMaxSize(100,100);
                    System.out.println(tile);
                    add(tile, i, j);
                } else {
                    Label label = new Label("");
                    label.setAlignment(Pos.CENTER);
                    label.setPrefSize(100,100);
                    label.setMaxSize(100,100);
                    label.getStylesheets().add(getClass().getResource("game.css").toExternalForm());
                    label.getStyleClass().add("game-tile-0");
                    add(label, i, j);
                }
            }
        }

        System.out.println(getChildren());
    }

}
