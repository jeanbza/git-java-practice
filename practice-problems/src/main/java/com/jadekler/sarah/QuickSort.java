package com.jadekler.sarah;

import java.util.Random;

public class QuickSort implements Sort {
    Random random = new Random();

    @Override
    public int[] sort(int[] input) {
        return inplaceSort(input, 0, input.length - 1);
    }

    private int[] inplaceSort(int[] input, int low, int high) {
        if (high - low <= 1) {
            return input;
        }

        int storedIndex = 0;
        int pivot = random.nextInt(high - low) + low;

        int swapValue = input[high];
        input[high] = input[pivot];
        input[pivot] = swapValue;

        for (int i = low; i < high - 1; i++) {
            if (input[i] < input[high]) {
                swapValue = input[storedIndex];
                input[storedIndex] = input[i];
                input[i] = swapValue;

                storedIndex++;
            }
        }

        swapValue = input[high];
        input[high] = input[storedIndex];
        input[storedIndex] = swapValue;

        inplaceSort(input, low, storedIndex);
        inplaceSort(input, storedIndex, high);

        return input;
    }
}
