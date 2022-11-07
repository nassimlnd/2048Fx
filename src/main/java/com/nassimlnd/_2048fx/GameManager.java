package com.nassimlnd._2048fx;

import java.util.*;

public class GameManager {

    private HashMap<Location, Tile> grid;
    private final static int startingTiles = 2;
    private int size;

    public GameManager(int size) {
        this.size = size;
        this.grid = setup();

        for (int i = 0; i < startingTiles; i++) {
            this.addRandomTile();
        }
        System.out.println(grid);
    }

    public HashMap<Location, Tile> setup() {
        HashMap<Location, Tile> grid = new HashMap<>();

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                grid.put(new Location(i, j), null);
            }
        }
        return grid;
    }

    public void addRandomTile() {
        Tile tile = Tile.newRandomTile();
        Random random = new Random();
        Location location = availableCells().get(random.nextInt(availableCells().size()));
        for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
            String locationStr = location.toString();
            String entryLocation = entry.getKey().toString();
            if (locationStr.equals(entryLocation)) {
                Location key = entry.getKey();
                this.grid.replace(key, tile);
            }
        }
    }

    public boolean cellAvailable(Location location) {
        for(Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
            if (location.equals(entry.getKey())) {
                if (entry.getValue() == null) {
                    return true;
                } else return false;
            }
        }
        return false;
    }

    public List<Location> availableCells() {
        List<Location> availableCells = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Location location = new Location(i, j);
                if (cellAvailable(location)) {
                    availableCells.add(location);
                }
            }
        }
        return availableCells;
    }

    public HashMap<Location, Tile> getGrid() {
        return this.grid;
    }

    public int getSize() {
        return this.size;
    }

    public Tile getTile(Location location) {
        for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
            String locationStr = location.toString();
            String entryLocation = entry.getKey().toString();
            if (locationStr.equals(entryLocation)) {
                return entry.getValue();
            }
        }
        return null;
    }

}
