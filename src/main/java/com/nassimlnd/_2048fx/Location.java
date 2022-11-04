package com.nassimlnd._2048fx;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Location{" + "x=" + x + ", y=" + y + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.x != other.getX()) {
            return false;
        }
        return this.y == other.getY();
    }

    public double getLayoutY(int CELL_SIZE) {
        if (y == 0) {
            return CELL_SIZE / 2;
        }
        return (y * CELL_SIZE) + CELL_SIZE / 2;
    }

    public double getLayoutX(int CELL_SIZE) {
        if (x == 0) {
            return CELL_SIZE / 2;
        }
        return (x * CELL_SIZE) + CELL_SIZE / 2;
    }
}
