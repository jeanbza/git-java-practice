package com.jadekler.sheri;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple GameOfLife.
 */
public class SpiralNumbersTest extends TestCase {
    public SpiralNumbersTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SpiralNumbersTest.class);
    }

    public void testGetClosestOddSquare() {
        SpiralNumbers target = new SpiralNumbers();
        assertEquals(target.getClosestOddSquare(5), 3);
        assertEquals(target.getClosestOddSquare(10), 5);
    }

    public void testGetSpiralSimple() {
        SpiralNumbers target = new SpiralNumbers();

        int[][] expected = {{0,0,0},{5,0,1},{4,3,2}};
        assertTrue(deepEquals(target.getSpiral(5), expected));
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

                    System.out.println(arr1[i][j]+" "+arr2[i][j]);
                    return false;
                }
            }
        }

        return true;
    }
}
