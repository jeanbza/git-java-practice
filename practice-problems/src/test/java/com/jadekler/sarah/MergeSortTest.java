package com.jadekler.sarah;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MergeSortTest {
    private MergeSort sorter = new MergeSort();

    @Test
    public void testSort() {
        int[] input = {5, 9, 4, 33, 1, 7, 14};
        int[] expected = {1, 4, 5, 7, 9, 14, 33};

        assertThat(sorter.sort(input), equalTo(expected));
    }
}