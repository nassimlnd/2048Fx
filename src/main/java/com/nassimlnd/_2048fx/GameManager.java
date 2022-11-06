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
        Location key = availableCells().get(random.nextInt(availableCells().size()));
        System.out.println(this.grid.containsKey(key));
        this.grid.replace(key, tile);
    }

    public boolean cellAvailable(Location location) {
        System.out.println(grid);
        for(Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
            Location key = entry.getKey();
            System.out.println(key);
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

}
