package com.jadekler.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * This class sorts items in an array using mergesort
 */
public class Mergesort 
{
    public int[] sort(int[] numbers) {
        if (numbers.length == 1) {
            return numbers;
        } else {
            int pivotPoint = (int)Math.ceil(numbers.length/2);
            int[] lower = Arrays.copyOfRange(numbers, 0, pivotPoint);
            int[] upper = Arrays.copyOfRange(numbers, pivotPoint, numbers.length);

            return merge(sort(lower), sort(upper));
        }
    }

    public int[] merge(int[] a, int[] b) {
        int[] newArr = new int[a.length+b.length];
        int a_i = 0;
        int b_i = 0;
        int na_i = 0;

        while (na_i < newArr.length) {
            if (b_i >= b.length || (a_i < a.length && a[a_i] < b[b_i])) {
                newArr[na_i] = a[a_i];
                a_i++;
            } else {
                newArr[na_i] = b[b_i];
                b_i++;
            }
            na_i++;
        }

        return newArr;
    }
}