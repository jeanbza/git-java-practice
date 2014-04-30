package com.jadekler.sheri;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple GameOfLife.
 */
public class GameOfLifeTest extends TestCase {
    public GameOfLifeTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(GameOfLifeTest.class);
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

    public boolean deepEquals(int[][] arr1, int[][] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].length != arr2[i].length) {
                return false;
            }

            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void testNumNeightboursZero() {
        GameOfLife target = new GameOfLife();
        int expected = 0;
        int[][] grid = {{1,0},{0,0}};
        int x = 0;
        int y = 0;

        assertEquals(target.numNeighbours(grid, x, y), expected);
    }

    public void testNumNeightboursSimple() {
        GameOfLife target = new GameOfLife();
        int expected = 1;
        int[][] grid = {{1,0},{0,1}};
        int x = 0;
        int y = 0;

        assertEquals(expected, target.numNeighbours(grid, x, y));

        expected = 3;
        int[][] newgrid = {{0,1},{1,1}};
        x = 0;
        y = 0;

        assertEquals(expected, target.numNeighbours(newgrid, x, y));
    }

    public void testNumNeightboursStandard() {
        GameOfLife target = new GameOfLife();
        int expected = 5;
        int[][] grid = {{1,0,1,1},{0,1,0,0},{1,1,0,1}};
        int x = 2;
        int y = 1;

        assertEquals(expected, target.numNeighbours(grid, x, y));
    }

    // This uses the prompt's board
    public void testNumNeighboursPrompt() {
        GameOfLife target = new GameOfLife();
        int[][] grid = {{0, 1, 0, 0, 0},{1, 0, 0, 1, 1},{1, 1, 0, 0, 1},{0, 1, 0, 0, 0},{1, 0, 0, 0, 1}};

        assertEquals(2, target.numNeighbours(grid, 3, 0));
        assertEquals(2, target.numNeighbours(grid, 0, 0));
        assertEquals(2, target.numNeighbours(grid, 4, 1));
    }

    public void testStandard() {
        GameOfLife target = new GameOfLife();

        int[][] board = {{0, 1, 0, 0, 0},{1, 0, 0, 1, 1},{1, 1, 0, 0, 1},{0, 1, 0, 0, 0},{1, 0, 0, 0, 1}};
        int[][] expected = {{0, 0, 0, 0, 0},{1, 0, 1, 1, 1},{1, 1, 1, 1, 1},{0, 1, 0, 0, 0},{0, 0, 0, 0, 0}};

        assertTrue(deepEquals(target.nextGeneration(board), expected));
    }
}
