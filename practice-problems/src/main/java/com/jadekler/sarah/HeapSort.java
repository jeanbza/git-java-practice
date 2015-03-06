package com.jadekler.sarah;

import java.util.Arrays;

// min-heap
public class HeapSort {
    private int[] heap;
    private int elementCount = 0;

    public HeapSort(int[] heap, int elementCount) {
        this.heap = heap;
        this.elementCount = elementCount;
    }

    public int extractMin() {
        int root = heap[0];
        heap[0] = heap[elementCount];
        heap[elementCount] = 0;
        elementCount--;

        bubbleDown(0);

        return root;
    }

    public void bubbleDown(int bubbleIndex) {
//        if (leftChildIndex != -1 && (
//            heap[bubbleIndex] > heap[leftChildIndex] || (
//                rightChildIndex != -1 && heap[bubbleIndex] > heap[rightChildIndex]))) {
//            int tmp = heap[bubbleIndex];
//
//            if (rightChildIndex != -1 && heap[leftChildIndex] > heap[rightChildIndex]) {
//                heap[bubbleIndex] = heap[rightChildIndex];
//                heap[rightChildIndex] = tmp;
//
//                bubbleDown(rightChildIndex);
//            } else {
//                heap[bubbleIndex] = heap[leftChildIndex];
//                heap[leftChildIndex] = tmp;
//
//                bubbleDown(leftChildIndex);
//            }
//        }
    }

    public void insert(int element) {
        bubbleUp(element, elementCount);

        elementCount++;
    }

    public void bubbleUp(int element, int bubbleIndex) {
        int parentIndex = getParentIndex(bubbleIndex);

        if (parentIndex != -1 && heap[parentIndex] > element) {
            heap[bubbleIndex] = heap[parentIndex];
            heap[parentIndex] = element;

            bubbleUp(heap[parentIndex], parentIndex);
        } else {
            heap[bubbleIndex] = element;
        }
    }

    public int getParent(int childIndex) {
        if (childIndex == 0) {
            return -1;
        }

        return heap[getParentIndex(childIndex)];
    }

    public int getParentIndex(int childIndex) {
        if (childIndex == 0) {
            return -1;
        }

        return (childIndex-1) / 2;
    }

    public int getLeftChildIndex(int parentIndex) {
        int childIndex = parentIndex * 2 + 1;

        return childIndex > heap.length || childIndex > elementCount ? -1 : parentIndex * 2 + 1;
    }

    public int[] getHeap() {
        return heap;
    }
}
