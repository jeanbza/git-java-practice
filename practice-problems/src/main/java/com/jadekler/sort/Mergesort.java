package com.jadekler.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * This class sorts items in an array using mergesort
 */
public class Mergesort 
{
    public static void main(String args[]) {
        int arrSize = 10;
        Mergesort ms = new Mergesort();
        Random rand = new Random();
        int[] myArr = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            myArr[i] = rand.nextInt(10000)+1;
        }

        System.out.println(ms.arrToString(myArr));
        myArr = ms.sort(myArr);
        System.out.println(ms.arrToString(myArr));
    }

    public String arrToString(int[] arr) {
        String s = "";

        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                s += " ";
            }
            s += arr[i];
        }

        return s;
    }

    public int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        } else {
            int[] leftArr = Arrays.copyOfRange(arr, 0, (int)Math.floor(arr.length/2));
            leftArr = this.sort(leftArr);

            int[] rightArr = Arrays.copyOfRange(arr, (int)Math.ceil(arr.length/2), arr.length);
            rightArr = this.sort(rightArr);

            return merge(leftArr, rightArr);
        }
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length+arr2.length];
        int x = 0;
        int y = 0;

        for (int i = 0; i < newArr.length; i++) {
            if (y >= arr2.length || (x < arr1.length && arr1[x] < arr2[y])) {
                newArr[i] = arr1[x];
                x++;
            } else {
                newArr[i] = arr2[y];
                y++;
            }
        }

        return newArr;
    }
}