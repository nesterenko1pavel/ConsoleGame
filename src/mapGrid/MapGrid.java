package mapGrid;

import data.Person;

public class MapGrid {
    private int size;
    private final int sizeMiniMap;
    private int[][] grid;
    private int lastX = -1;
    private int lastY = -1;
    private int event = 0;

    public MapGrid(int size, int sizeMiniMap) {
        this.size = size;
        this.sizeMiniMap = sizeMiniMap;
        this.grid = new int[size][size];
    }

    public MapGrid() {
        this.size = 201;
        this.sizeMiniMap = 5;
        this.grid = new int[size][size];
    }

    public int getSizeMiniMap() {
        return sizeMiniMap;
    }

    public int getSize() {
        return size;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void printGrid(Person person) {
        int cutXStart = 0;
        int cutXEnd = 0;
        int cutYStart = 0;
        int cutYEnd = 0;

        if ((lastX - (sizeMiniMap - 1) / 2) < 0) {
            cutXStart = Math.abs(lastX - (sizeMiniMap - 1) / 2);
        }
        if ((lastX + (sizeMiniMap - 1) / 2) >= size) {
            cutXEnd = lastX + (sizeMiniMap - 1) / 2 - size + 1;
        }

        if ((lastY - (sizeMiniMap - 1) / 2) < 0) {
            cutYStart = Math.abs(lastY - (sizeMiniMap - 1) / 2);
        }
        if ((lastY + (sizeMiniMap - 1) / 2) >= size) {
            cutYEnd = lastY + (sizeMiniMap - 1) / 2 - size + 1;
        }

        if (person.getIsOnMap()) {
            for (int i = lastX - (sizeMiniMap - 1) / 2 + cutXStart; i <= lastX + (sizeMiniMap - 1) / 2 - cutXEnd; i++) {
                for (int j = lastY - (sizeMiniMap - 1) / 2 + cutYStart; j <= lastY + (sizeMiniMap - 1) / 2 - cutYEnd; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.print('\n');
            }
        } else {
            for (int i = (size - 1) / 2 - (sizeMiniMap - 1) / 2; i <= (size - 1) / 2 + (sizeMiniMap - 1) / 2; i++) {
                for (int j = (size - 1) / 2 - (sizeMiniMap - 1) / 2; j <= (size - 1) / 2 + (sizeMiniMap - 1) / 2; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.print('\n');
            }
        }

//        System.out.println("buffer:");
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.print('\n');
//        }
    }

    public int pos(int x, int y) {
        if (lastX == -1 && lastY == -1) {
            if ((size - 1) / 2 - (sizeMiniMap - 1) / 2 + x >= 0 && (size - 1) / 2 - (sizeMiniMap - 1) / 2 + x < size && (size - 1) / 2 - (sizeMiniMap - 1) / 2 + y >= 0 && (size - 1) / 2 - (sizeMiniMap - 1) / 2 + y < size) {
                lastX = (size - 1) / 2 - (sizeMiniMap - 1) / 2 + x;
                lastY = (size - 1) / 2 - (sizeMiniMap - 1) / 2 + y;
            } else {
                System.out.println("incorrect coordinates entered");
                return 401;                                             // (error) shows that x and y is wrong
            }
        }

        if ((lastX == (size - 1) / 2 - (sizeMiniMap - 1) / 2 + x) && (lastY == (size - 1) / 2 - (sizeMiniMap - 1) / 2 + y) && grid[lastX][lastY] != 0) {      // saving from setting player to an object
            System.out.println("you cannot set the player to an object");
            lastX = -1;
            lastY = -1;
            return 400;                                 // (error) shows that the player wanted to place himself on another object
        }

        if (event == 5) {
            grid[lastX][lastY] = 5;     // saving an NPC after meeting him
        } else {
            grid[lastX][lastY] = 0;
        }

        event = grid[(size - 1) / 2 - (sizeMiniMap - 1) / 2 + x][(size - 1) / 2 - (sizeMiniMap - 1) / 2 + y];             // event - information about who you met
        grid[(size - 1) / 2 - (sizeMiniMap - 1) / 2 + x][(size - 1) / 2 - (sizeMiniMap - 1) / 2 + y] = 1;

        lastX = (size - 1) / 2 - (sizeMiniMap - 1) / 2 + x;
        lastY = (size - 1) / 2 - (sizeMiniMap - 1) / 2 + y;

        return event;
    }

    public void generateResources(int[][] grid, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Math.random() > 0.91) {
                    grid[i][j] = 6;                             // set SUPERSTAR
                } else if (Math.random() > 0.6) {                          // field filling frequency
                    grid[i][j] = 2 + (int) (Math.random() * 4);
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        if (lastX == -1 && lastY == -1) {
            grid[(size - 1) / 2][(size - 1) / 2] = 0;
        } else {
            grid[lastX][lastY] = 1;
        }
    }

    public void expandSize() {
        int[][] newGrid = new int[size * 2 + 1][size * 2 + 1];

        generateResources(newGrid, size * 2 + 1);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newGrid[i + (size * 2 - 1) / 4 + 1][j + (size * 2 - 1) / 4 + 1] = grid[i][j];
            }
        }

        size = size * 2 + 1;
        grid = newGrid;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 1) {
                    lastX = i;
                    lastY = j;
                }
            }
        }

//        lastX = lastX + (size * 2 + 1) / 2;
//        lastY = lastY + (size * 2 + 1) / 2;
    }
}
