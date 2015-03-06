package com.jadekler.sarah;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HeapSortTest {
    private static final int[] BASE_HEAP = new int[]{1492, 1783, 1776, 1804, 1865, 1945, 1963, 1918, 2001, 1941};

    private HeapSort sorter = new HeapSort(BASE_HEAP, BASE_HEAP.length);

    @Test
    public void testInsert() {
        doTestInsert(new int[]{1, 3, 5, 10}, new int[]{1, 3, 5, 10});
        doTestInsert(new int[]{11, 10}, new int[]{10, 11});

        doTestInsert(new int[]{5}, new int[]{5});
        doTestInsert(new int[]{5, 9}, new int[]{5, 9});
        doTestInsert(new int[]{5, 9, 11}, new int[]{5, 9, 11});
        doTestInsert(new int[]{5, 9, 11, 3}, new int[]{3, 5, 11, 9});
        doTestInsert(new int[]{5, 9, 11, 3, 18}, new int[]{3, 5, 11, 9, 18});
        doTestInsert(new int[]{5, 9, 11, 3, 18, 1}, new int[]{1, 5, 3, 9, 18, 11});
        doTestInsert(new int[]{5, 9, 11, 3, 18, 1, 2}, new int[]{1, 5, 2, 9, 18, 11, 3});
    }

    public void doTestInsert(int[] itemsToInsert, int[] expectedResult) {
        sorter = new HeapSort(new int[itemsToInsert.length], 0);

        for (int i = 0; i < itemsToInsert.length; i++) {
            sorter.insert(itemsToInsert[i]);
        }

        assertThat(sorter.getHeap(), equalTo(expectedResult));
    }

    @Test
    public void testGetParent() {
        assertThat(sorter.getParent(0), equalTo(-1));
        assertThat(sorter.getParent(1), equalTo(1492));
        assertThat(sorter.getParent(2), equalTo(1492));
        assertThat(sorter.getParent(3), equalTo(1783));
        assertThat(sorter.getParent(4), equalTo(1783));
        assertThat(sorter.getParent(5), equalTo(1776));
        assertThat(sorter.getParent(6), equalTo(1776));
        assertThat(sorter.getParent(7), equalTo(1804));
        assertThat(sorter.getParent(8), equalTo(1804));
        assertThat(sorter.getParent(9), equalTo(1865));
    }

    @Test
    public void testGetParentIndex() {
        assertThat(sorter.getParentIndex(0), equalTo(-1));
        assertThat(sorter.getParentIndex(1), equalTo(0));
        assertThat(sorter.getParentIndex(2), equalTo(0));
        assertThat(sorter.getParentIndex(3), equalTo(1));
        assertThat(sorter.getParentIndex(4), equalTo(1));
        assertThat(sorter.getParentIndex(5), equalTo(2));
        assertThat(sorter.getParentIndex(6), equalTo(2));
        assertThat(sorter.getParentIndex(7), equalTo(3));
        assertThat(sorter.getParentIndex(8), equalTo(3));
        assertThat(sorter.getParentIndex(9), equalTo(4));
    }

    @Test
    public void testGetLeftChildIndex() {
        assertThat(sorter.getLeftChildIndex(0), equalTo(1));
        assertThat(sorter.getLeftChildIndex(1), equalTo(3));
        assertThat(sorter.getLeftChildIndex(2), equalTo(5));
        assertThat(sorter.getLeftChildIndex(3), equalTo(7));
        assertThat(sorter.getLeftChildIndex(4), equalTo(9));
        assertThat(sorter.getLeftChildIndex(5), equalTo(-1));
        assertThat(sorter.getLeftChildIndex(6), equalTo(-1));
        assertThat(sorter.getLeftChildIndex(7), equalTo(-1));
        assertThat(sorter.getLeftChildIndex(8), equalTo(-1));
        assertThat(sorter.getLeftChildIndex(9), equalTo(-1));
    }
}
