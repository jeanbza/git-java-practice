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
        int pivotPoint = (int)Math.ceil(numbers.length/2);
        int pivotNum = numbers[pivotPoint];
        int fwd = 0;
        int bck = numbers.length-1;

        while (fwd < bck) {
            while (numbers[fwd] < pivotNum) {
                fwd++;
            }

            while (numbers[bck] > pivotNum) {
                bck--;
            }

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