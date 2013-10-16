package com.jadekler.sort;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.Random;

/**
 * Unit test for simple App.
 */
public class QuicksortTest extends TestCase
{
    private int[] numbers;
    private int size = 20;
    private int max = 100;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QuicksortTest( String testName )
    {
        super( testName );

        this.numbers = new int[this.size];
        Random generator = new Random();
        for (int i = 0; i < this.numbers.length; i++) {
            this.numbers[i] = generator.nextInt(this.max);
        }
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( QuicksortTest.class );
    }

    public void testQuicksort() {
        Quicksort sorter = new Quicksort();
        assertTrue(isSorted(sorter.sort(this.numbers)));
    }

    public void testMergeArrays() {
        int[] a = {1,2,3};
        int[] b = {6};
        int[] c = {4,2,5};
        int[][] arrs = {a,b,c};
        int[] expected = {1,2,3,6,4,2,5};

        Quicksort sorter = new Quicksort();
        assertArrayEquals(expected, sorter.mergeArrays(arrs));
    }

    public boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] > numbers[i+1]) {
                return false;
            }
        }

        return true;
    }
}