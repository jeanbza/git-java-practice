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

    public SortTest() {
        List<Integer> unsortedList = new ArrayList<>();

        Random generator = new Random();

        for (int i = 0; i < sortedArr.length; i++) {
            sortedArr[i] = i;
            unsortedList.add(i);
        }

        for (int i = 0; i < sortedArr.length; i++) {
            int nextRandomIndex = generator.nextInt(unsortedList.size());
            unsortedArr[i] = unsortedList.get(nextRandomIndex);
            unsortedList.remove(nextRandomIndex);
        }
    }

    @Test
    public void testSort() {
        for (int i = 0; i < sorters.size(); i++) {
            Sort sorter = sorters.get(i);
            assertThat(sorter.sort(unsortedArr), equalTo(sortedArr));
        }
    }
}