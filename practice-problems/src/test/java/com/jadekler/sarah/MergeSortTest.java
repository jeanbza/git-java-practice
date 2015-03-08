package com.jadekler.sarah;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MergeSortTest {
    private MergeSort sorter = new MergeSort();

    @Test
    public void testMergeSort() {
        assertThat(sorter.sort(new int[]{3, 5, 1, 2, 4}), equalTo(new int[]{1, 2, 3, 4, 5}));
    }
}
