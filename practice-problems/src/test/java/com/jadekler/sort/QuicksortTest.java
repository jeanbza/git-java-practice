package com.jadekler.sort;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.Random;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class QuicksortTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QuicksortTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( QuicksortTest.class );
    }

    public void testQuicksort() {
        int[] numbers = generateNumbers(20, 100);
        Quicksort sorter = new Quicksort();
        assertTrue(isSorted(sorter.sort(numbers)));
    }

    public void testQuicksortSmall() {
        int[] numbers = generateNumbers(1, 100);
        Quicksort sorter = new Quicksort();
        assertTrue(isSorted(sorter.sort(numbers)));
    }

    public void testQuicksortHuge() {
        int[] numbers = generateNumbers(10000, 10000000);
        Quicksort sorter = new Quicksort();
        assertTrue(isSorted(sorter.sort(numbers)));
    }

    public void testQuicksortHugest() {
        int[] numbers = generateNumbers(100000, 100000000);
        Quicksort sorter = new Quicksort();
        assertTrue(isSorted(sorter.sort(numbers)));
    }

    public boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] > numbers[i+1]) {
                return false;
            }
        }

        return true;
    }

    public boolean inArray(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val)
                return true;
        }

        return false;
    }

    public int[] generateNumbers(int size, int max) {
        int[] numbers = new int[size];
        Random generator = new Random();
        int nextInt;
        int i = 0;

        while (i < numbers.length) {
            nextInt = generator.nextInt(max);
            if (!inArray(numbers, nextInt)) {
                numbers[i] = nextInt;
                i++;
            }
        }

        return numbers;
    }
}