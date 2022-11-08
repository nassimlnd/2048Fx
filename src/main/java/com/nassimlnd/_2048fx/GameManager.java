package com.nassimlnd._2048fx;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

import java.util.*;

public class GameManager {

    private HashMap<Location, Tile> grid;
    private Grid gridPane;
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
                tile.setLocation(key);
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

    public Location getKey(Location location) {
        for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
            String locationStr = location.toString();
            String entryLocation = entry.getKey().toString();
            if (locationStr.equals(entryLocation)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void move(KeyCode keyCode) {
        tilesMove(keyCode);
        addRandomTile();
    }

    public void tilesMove(KeyCode keyCode) {
        switch (keyCode) {
            case UP:
                for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
                    Location location = entry.getKey();
                    Tile tile = entry.getValue();
                    if (entry.getValue() != null) {
                        tile.setLocation(location);
                        if (entry.getValue().isMovable(Direction.UP, this, entry.getKey())) {
                            Tile testTile = this.grid.get(entry.getKey());
                            while (testTile.isMovable(Direction.UP, this, testTile.getLocation())) {
                                System.out.println("ok");
                                Location newLocation = new Location(testTile.getLocation().getX(), testTile.getLocation().getY()-1);
                                Location key = getKey(newLocation);
                                this.grid.replace(tile.getLocation(), null);
                                this.grid.replace(key, tile);
                                System.out.println("Key:" + key);
                                tile.setLocation(key);
                                System.out.println(grid);
                            }
                        }
                    }
                }
                for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
                    if (entry.getValue() != null) {
                        if (entry.getValue().isMovable(Direction.UP, this, entry.getValue().getLocation())) {
                            move(KeyCode.UP);
                        }
                    }
                }
                break;
            case DOWN:
                for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
                    Location location = entry.getKey();
                    Tile tile = entry.getValue();
                    if (entry.getValue() != null) {
                        tile.setLocation(location);
                        if (entry.getValue().isMovable(Direction.DOWN, this, entry.getKey())) {
                            Tile testTile = this.grid.get(entry.getKey());
                            while (testTile.isMovable(Direction.DOWN, this, testTile.getLocation())) {
                                System.out.println("ok");
                                Location newLocation = new Location(testTile.getLocation().getX(), testTile.getLocation().getY()+1);
                                Location key = getKey(newLocation);
                                this.grid.replace(tile.getLocation(), null);
                                this.grid.replace(key, tile);
                                System.out.println("Key:" + key);
                                tile.setLocation(key);
                                System.out.println(grid);
                            }
                        }
                    }
                }
                for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
                    if (entry.getValue() != null) {
                        if (entry.getValue().isMovable(Direction.DOWN, this, entry.getValue().getLocation())) {
                            move(KeyCode.DOWN);
                        }
                    }
                }
                break;
            case LEFT:
                for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
                    Location location = entry.getKey();
                    Tile tile = entry.getValue();
                    if (entry.getValue() != null) {
                        tile.setLocation(location);
                        if (entry.getValue().isMovable(Direction.LEFT, this, entry.getKey())) {
                            Tile testTile = this.grid.get(entry.getKey());
                            while (testTile.isMovable(Direction.LEFT, this, testTile.getLocation())) {
                                System.out.println("ok");
                                Location newLocation = new Location(testTile.getLocation().getX()-1, testTile.getLocation().getY());
                                Location key = getKey(newLocation);
                                this.grid.replace(tile.getLocation(), null);
                                this.grid.replace(key, tile);
                                System.out.println("Key:" + key);
                                tile.setLocation(key);
                                System.out.println(grid);
                            }
                        }
                    }
                }
                for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
                    if (entry.getValue() != null) {
                        if (entry.getValue().isMovable(Direction.LEFT, this, entry.getValue().getLocation())) {
                            move(KeyCode.LEFT);
                        }
                    }
                }
                break;
            case RIGHT:
                for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
                    Location location = entry.getKey();
                    Tile tile = entry.getValue();
                    if (entry.getValue() != null) {
                        tile.setLocation(location);
                        if (entry.getValue().isMovable(Direction.RIGHT, this, entry.getKey())) {
                            Tile testTile = this.grid.get(entry.getKey());
                            while (testTile.isMovable(Direction.RIGHT, this, testTile.getLocation())) {
                                System.out.println("ok");
                                Location newLocation = new Location(testTile.getLocation().getX()+1, testTile.getLocation().getY());
                                Location key = getKey(newLocation);
                                this.grid.replace(tile.getLocation(), null);
                                this.grid.replace(key, tile);
                                System.out.println("Key:" + key);
                                tile.setLocation(key);
                                System.out.println(grid);
                            }
                        }
                    }
                }
                for (Map.Entry<Location, Tile> entry : this.grid.entrySet()) {
                    if (entry.getValue() != null) {
                        if (entry.getValue().isMovable(Direction.RIGHT, this, entry.getValue().getLocation())) {
                            move(KeyCode.RIGHT);
                        }
                    }
                }
                break;
        }
    }

    public Grid getGridPane() {
        return gridPane;
    }

    public void setGridPane(Grid gridPane) {
        this.gridPane = gridPane;
    }

    public void resetGrid() {
        setGridPane(new Grid());
    }

    public void refreshGrid() {
        setGridPane(new Grid());
        gridPane.getStylesheets().add(String.valueOf(GamePane.class.getResource("game.css")));
        HashMap<Location, Tile> grid = getGrid();

        gridPane.setMinSize(500,500);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                Tile tile = getTile(new Location(i, j));
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
    }
}
