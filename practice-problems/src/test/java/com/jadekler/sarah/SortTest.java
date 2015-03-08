package com.jadekler.sarah;

import org.junit.*;

import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortTest {
    private int[] unsortedArr = new int[1000];
    private int[] sortedArr = new int[1000];

    private List<Sort> sorters = asList(new MergeSort(), new HeapSort());

    private MergeSort sorter = new MergeSort();

    public SortTest() {
        List<Integer> unsortedList = new ArrayList<>();

        Random generator = new Random();
        int nextRandomInt;

        for (int i = 0; i < sortedArr.length; i++) {
            sortedArr[i] = i;
            unsortedList.add(i);
        }

        for (int i = 0; i < sortedArr.length; i++) {
            unsortedArr[i] = unsortedList.get(generator.nextInt(unsortedList.size()));
        }
    }

    int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    @Test
    public void testSort() {
        for (int i = 0; i < sorters.size(); i++) {
            Sort sorter = sorters.get(i);
            assertThat(sorter.sort(unsortedArr), equalTo(sortedArr));
        }
    }
}