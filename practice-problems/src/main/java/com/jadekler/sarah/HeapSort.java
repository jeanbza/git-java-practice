package com.jadekler.sarah;

// min-heap
public class HeapSort {
    private int[] heap;
    private int elementCount = 0;

    public HeapSort(int[] heap, int elementCount) {
        this.heap = heap;
        this.elementCount = 0;
    }

    public void insert(int element) {
        bubble(element, elementCount);

        elementCount++;
    }

    public void bubble(int element, int bubbleIndex) {
        int parentIndex = getParentIndex(bubbleIndex);

        if (parentIndex != -1 && heap[parentIndex] > element) {
            heap[bubbleIndex] = heap[parentIndex];
            heap[parentIndex] = element;

            bubble(heap[parentIndex], parentIndex);
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

        return childIndex > heap.length ? -1 : parentIndex * 2 + 1;
    }

    public int[] getHeap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }
}
