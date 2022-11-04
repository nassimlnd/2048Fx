package com.nassimlnd._2048fx;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class Tile extends Label {

    private int value;
    private Location location;
    private Boolean merged;

    public static Tile newRandomTile() {
        int value = Math.random() < 0.9 ? 2 : 4;
        return new Tile(value);
    }

    public static Tile newTile(int value) {
        if (value % 2 != 0) {
            throw new IllegalArgumentException("Tile value must be multiple of 2");
        }

        return new Tile(value);
    }

    public Tile(Integer value) {
        final int squareSize = Board.CELL_SIZE - 13;
        setMinSize(squareSize, squareSize);
        setMaxSize(squareSize, squareSize);
        setPrefSize(squareSize, squareSize);
        setAlignment(Pos.CENTER);

        this.value = value;
        this.merged = false;
        setText(value.toString());
        getStyleClass().addAll("game-label", "game-title-" + value);
    }

    public void merge(Tile anotherTile) {
        getStyleClass().remove("game-tile-" + value);
        this.value += anotherTile.getValue();
        setText(String.valueOf(value));
        this.merged = true;
        getStyleClass().add("game-tile-" + value);
    }

    public int getValue() {
        return value;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isMerged() {
        return merged;
    }

    public void clearMerge() {
        this.merged = false;
    }

    public boolean isMergeable(Tile anotherTile) {
        return this.getValue() == anotherTile.getValue();
    }

    @Override
    public String toString() {
        return "Tile{" + "value=" + this.getValue() + ", x=" + this.location.getX() + ", y=" + this.location.getY() + "}";
    }
}
