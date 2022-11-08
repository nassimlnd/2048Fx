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
        this.value = value;
        this.merged = false;
        setText(value.toString());
        getStylesheets().add(getClass().getResource("game.css").toExternalForm());
        getStyleClass().addAll( "game-tile-" + value);
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

    public boolean isMovable(Direction direction, GameManager gameManager) {
        if (direction == Direction.UP) {
            if (this.location.getY() == 0) {
                return false;
            } else if (gameManager.cellAvailable(new Location(this.location.getX(), (this.location.getY() - 1)))) {
                return true;
            }
        } else if (direction == Direction.DOWN) {
            if (this.location.getY() == 3) {
                return false;
            } else if (gameManager.cellAvailable(new Location(this.location.getX(), (this.location.getY() + 1)))) {
                return true;
            }
        } else if (direction == Direction.LEFT) {
            if (this.location.getX() == 0) {
                return false;
            } else if (gameManager.cellAvailable(new Location((this.location.getX() - 1), this.location.getY()))) {
                return true;
            }
        } else if (direction == Direction.RIGHT) {
            if (this.location.getX() == 3) {
                return false;
            } else if (gameManager.cellAvailable(new Location((this.location.getX() + 1), this.location.getY()))) {
                return true;
            }
        }
        return false;
    }
}
