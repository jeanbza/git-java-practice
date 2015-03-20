package com.jadekler.sarah;

import java.util.*;

public class QuickSort implements Sort {
    Random random = new Random();

    @Override
    public int[] sort(int[] input) {
        return inplaceSort(input, 0, input.length - 1);
    }

    private int[] inplaceSort(int[] input, int low, int high) {
        if (low < high) {
            int storedIndex = low;
            int pivot = random.nextInt(high - low) + low;
            
            swap(input, pivot, high);

            for (int i = low; i < high; i++) {
                if (input[i] < input[high]) {
                    swap(input, storedIndex, i);

                    storedIndex++;
                }
            }

            swap(input, high, storedIndex);

            inplaceSort(input, low, storedIndex - 1);
            inplaceSort(input, storedIndex + 1, high);
        }

        return input;
    }

    private void swap(int[] input, int indexA, int indexB) {
        int swapValue;
        swapValue = input[indexA];
        input[indexA] = input[indexB];
        input[indexB] = swapValue;
    }
}
