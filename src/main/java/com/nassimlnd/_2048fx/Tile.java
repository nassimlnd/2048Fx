package com.nassimlnd._2048fx;

public class Tile {

    private int value;
    private Location location;
    private Boolean merged;

    public Tile() {
        this.value = Math.random() < 0.9 ? 2 : 4;
    }

}
