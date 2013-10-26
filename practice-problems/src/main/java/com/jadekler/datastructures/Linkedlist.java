package com.jadekler.datastructures;

import java.util.Arrays;
import java.util.Random;

/**
 * This class holds items in a FIFO manner, similar to a queue - first in, first out
 */
public class Linkedlist 
{
    Node[] list;

    class Node {
        private Node fwd;
        private int num;

        public Node(int num) {
            this.num = num;
        }

        public void setFwdLink(Node fwd) {
            this.fwd = fwd;
        }

        public Node next() {
            return this.fwd;
        }

        public int getNum() {
            return num;
        }
    }

    public Linkedlist() {
        this.list = new Node[0];
    }

    /**
     * Pushes an item onto the linkedlist
     * @param   num  Number to push onto the linkedlist
     * @return  void
     */
    public void push(int num) {
        Node[] tempArr = new Node[this.list.length+1];
        Node item = new Node(num);

        // Copy over to new list
        for (int i = 0; i < this.list.length; i++) {
            tempArr[i] = this.list[i];
        }

        // Set current
        tempArr[tempArr.length-1] = item;

        // Set previous
        if (tempArr.length > 1) {
            tempArr[tempArr.length-2].setFwdLink(item);            
        }

        // Set list
        this.list = tempArr;
    }

    /**
     * Removes and returns item at end of the list
     * @return  Node Node at end of the list
    */ 
    public Node pop() {
        Node firstNode = getFirst();

        if (this.list.length > 0)
            this.list = Arrays.copyOfRange(this.list, 0, this.list.length-1);

        return firstNode;
    }

    /**
     * Gets the first node in the list
     * @return  Node The first node in the linkedlist
     */
    public Node getFirst() {
        return this.list[this.list.length-1];
    }

    /**
     * Gets the last node in the list
     * @return  Node Gets the last node in the list
     */
    public Node getLast() {
        return this.list[0];
    }
}
