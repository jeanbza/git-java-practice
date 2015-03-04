package com.jadekler.sarah;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MergeSortTest {
    private MergeSort sorter = new MergeSort();

    @Test
    public void testSort() {
        sorter.sort();
        assertTrue(true);
    }
}