package com.jadekler.sarah;

import java.util.Arrays;

public class MergeSort implements Sort {
    public int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        } else {
            int[] left = sort(Arrays.copyOfRange(arr, 0, arr.length / 2));
            int[] right = sort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

            return merge(left, right);
        }
    }

    private int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (mergedIndex < left.length + right.length) {
            if (rightIndex == right.length || (leftIndex < left.length && left[leftIndex] < right[rightIndex])) {
                merged[mergedIndex] = left[leftIndex];
                leftIndex++;
            } else {
                merged[mergedIndex] = right[rightIndex];
                rightIndex++;
            }

            mergedIndex++;
        }

        return merged;
    }
}