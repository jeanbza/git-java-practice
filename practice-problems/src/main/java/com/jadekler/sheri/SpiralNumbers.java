package com.jadekler.sheri;

/**
 * Write some code that accepts an integer and prints the integers from 0 to that input integer in a spiral format.
 * For example, if I supplied 24 the output would be:
 * 20 21 22 23 24
 * 19 6 7 8 9
 * 18 5 0 1 10
 * 17 4 3 2 11
 * 16 15 14 13 12
 */
public class SpiralNumbers {
    public int[][] getSpiral(int num) {
        int closestSquare = getClosestOddSquare(num);
        int grid[][] = new int[closestSquare][closestSquare];
        int center = (int) Math.ceil(closestSquare / 2);
        int direction = 0;
        int x = center;     // left/right
        int y = center;     // up/down

        grid[center][center] = -1;

        // Basically rotates whenever there is an empty spot
        for (int i = 1; i <= num; i++) {
            if (direction % 4 == 0) {
                // If you can go right, go right.
                // Otherwise go up
                if (grid[y][x+1] == 0) {
                    direction++;
                    x++;
                } else {
                    y--;
                }
            } else if (direction % 4 == 1) {
                // If you can go down, go down.
                // Otherwise go right
                if (grid[y+1][x] == 0) {
                    direction++;
                    y++;
                } else {
                    x++;
                }
            } else if (direction % 4 == 2) {
                // If you can go left, go left.
                // Otherwise go down
                if (grid[y][x-1] == 0) {
                    direction++;
                    x--;
                } else {
                    y++;
                }
            } else if (direction % 4 == 3) {
                // If you can go up, go up.
                // Otherwise go left
                if (grid[y-1][x] == 0) {
                    direction++;
                    y--;
                } else {
                    x--;
                }
            }

            grid[y][x] = i;
        }

        grid[center][center] = 0;

        return grid;
    }

    public void emitGrid(int[][] grid) {
        String line;

        for (int i = 0; i < grid.length; i++) {
            line = "";

            for (int j = 0; j < grid[i].length; j++) {
                line += String.format("% 3d", grid[i][j])+" ";
            }

            System.out.println(line);
        }
    }

    public int getClosestOddSquare(int num) {
        int closestSquare = (int) Math.ceil(Math.sqrt(num));

        if (closestSquare % 2 == 0) {
            closestSquare ++;
        }

        return closestSquare;
    }
}