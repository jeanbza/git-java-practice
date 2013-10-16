package com.jadekler.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class Quicksort 
{
    Random generator;

    public static void main( String[] args )
    {
        Quicksort sorter = new Quicksort();
        int[] tempArr = {1,7,3,5,8,4,9,2,6};
        
        System.out.println("Final result: "+Arrays.toString(sorter.sort(tempArr)));
        
    }

    public Quicksort() {
        this.generator = new Random();
    }

    public int[] sort(int[] numbers) {
        int pivotPoint = (int)Math.ceil(numbers.length/2);
        int pivotNum = numbers[pivotPoint];
        int fwd = 0;
        int bck = numbers.length-1;

        System.out.println(pivotNum);
        System.out.println(Arrays.toString(numbers));

        while (fwd < bck) {
            while (numbers[fwd] < pivotNum) {
                fwd++;
            }

            while (numbers[bck] > pivotNum) {
                bck--;
            }

            int temp = numbers[bck];
            numbers[bck] = numbers[fwd];
            numbers[fwd] = temp;

            System.out.println(Arrays.toString(numbers));
        }


        if (numbers.length == 1) {
            return numbers;
        } else {
            int[] lower = sort(Arrays.copyOfRange(numbers, 0, pivotPoint-1));
            int[] pivotNumArr = {pivotNum};
            int[] upper = sort(Arrays.copyOfRange(numbers, pivotPoint+1, numbers.length));
            int[][] arrs = {lower, pivotNumArr, upper};
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