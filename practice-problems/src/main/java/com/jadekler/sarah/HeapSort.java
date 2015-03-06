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
        int leftChildIndex = getLeftChildIndex(bubbleIndex);
        int rightChildIndex = leftChildIndex + 1;

        if (leftChildIndex >= elementCount || leftChildIndex == -1) {
            return;
        }

        if (rightChildIndex >= elementCount || rightChildIndex == -1) {
            if (heap[leftChildIndex] < heap[bubbleIndex]) {
                swap(bubbleIndex, leftChildIndex);
                bubbleDown(leftChildIndex);
            }
        }

        if (heap[leftChildIndex] < heap[bubbleIndex] || heap[rightChildIndex] < heap[bubbleIndex]) {
            if (heap[leftChildIndex] < heap[rightChildIndex]) {
                swap(bubbleIndex, leftChildIndex);
                bubbleDown(leftChildIndex);
            } else {
                swap(bubbleIndex, rightChildIndex);
                bubbleDown(rightChildIndex);
            }
        }
    }

    private void swap(int a, int b) {
        int tmp = heap[a];

        heap[a] = heap[b];
        heap[b] = tmp;
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
