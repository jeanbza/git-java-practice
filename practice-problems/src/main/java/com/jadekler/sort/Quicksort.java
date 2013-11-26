package com.jadekler.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * This class sorts items in an array using quicksort
 */
public class Quicksort 
{
    public int[] sort(int[] numbers) {
        int[] tempArr = new int[numbers.length];
        
        int fwd = 0;
        int bck = numbers.length-1;
        
        // Grabs a pivot at the middle of the array
        int pivotPoint = (int)Math.ceil(numbers.length/2);
        int pivotNum = numbers[pivotPoint];

        // Traverses the array, moving items larger than the pivot to the right and items smaller to the left
        while (fwd < bck) {
            while (numbers[fwd] < pivotNum) {
                fwd++;
            }

            while (numbers[bck] > pivotNum) {
                bck--;
            }

            // If we move the pivot ITSELF, keep track of the pivot's index location (which has now changed)
            if (bck == pivotPoint)
                pivotPoint = fwd;
            else if (fwd == pivotPoint)
                pivotPoint = bck;

            int temp = numbers[bck];
            numbers[bck] = numbers[fwd];
            numbers[fwd] = temp;
        }

        if (numbers.length == 1) {
            return numbers;
        } else {
            int[] lower = {};
            int[] upper = {};

            if (pivotPoint > 0)
                lower = sort(Arrays.copyOfRange(numbers, 0, pivotPoint));

            if (pivotPoint < numbers.length)
                upper = sort(Arrays.copyOfRange(numbers, pivotPoint, numbers.length));

            int[][] arrs = {lower, upper};
            int[] newArr = mergeArrays(arrs);

            return newArr;
        }
    }

    /**
     * Takes an array of arrays and returns an array of merged copies
     * We do not handle de-deduping or sorting, just a simple merge
     */
    public int[] mergeArrays(int[][] arrs) {
        int length = 0;

        for (int i = 0; i < arrs.length; i++) {
            length += arrs[i].length;
        }

        int[] mergedArr = new int[length];
        int pointer = 0;

        for (int i = 0; i < arrs.length; i++) {
            System.arraycopy(arrs[i], 0, mergedArr, pointer, arrs[i].length);
            pointer += arrs[i].length;
        }

        return mergedArr;
    }
}
