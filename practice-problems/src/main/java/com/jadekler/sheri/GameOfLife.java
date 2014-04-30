package com.jadekler.sheri;

/**
 * Write some code that evolves generations through the "game of life". The input will be a game board of
 * cells, either alive (1) or dead (0). The code should take this board and create a new board for the 
 * next generation based on the following rules:
 * 1) Any live cell with fewer than two live neighbours dies (underpopulation)
 * 2) Any live cell with two or three live neighbours lives on to the next generation (survival)
 * 3) Any live cell with more than three live neighbours dies (overcrowding)
 * 4) Any dead cell with exactly three live neighbours becomes a live cell (reproduction)
 * As an example, this game board as input:
 * 0 1 0 0 0
 * 1 0 0 1 1
 * 1 1 0 0 1
 * 0 1 0 0 0
 * 1 0 0 0 1
 * Will have a subsequent generation of:
 * 0 0 0 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 0 1 0 0 0
 * 0 0 0 0 0
 */
public class GameOfLife {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    public int[][] nextGeneration(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] == 0) {
                    if (numNeighbours(board, x, y) == 3) {
                        newBoard[y][x] = 1;
                    }
                } else {
                    if (numNeighbours(board, x, y) == 2 || numNeighbours(board, x, y) == 3) {
                        newBoard[y][x] = 1;
                    }
                }
            }
        }

        return newBoard;
    }

    public int numNeighbours(int[][] grid, int x, int y) {
        int numNeighbours = 0;
        int tempX;
        int tempY;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                tempX = x+i;
                tempY = y+j;

                if (tempX >= 0 && tempX < grid[0].length && tempY >= 0 && tempY < grid.length && !(tempX == x && tempY == y)) {
                    numNeighbours += grid[tempY][tempX];
                }
            }
        }

        return numNeighbours;
    }

    public int[][] generateRandomBoard(int length) {
        return generateRandomBoard(length, length);
    }

    public int[][] generateRandomBoard(int width, int height) {
        int[][] board = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = (int)(Math.random()*10)%2;
            }
        }

        return board;
    }
}