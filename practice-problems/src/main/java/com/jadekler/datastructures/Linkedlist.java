package com.jadekler.datastructures;

import java.util.Arrays;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class LinkedList 
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

    public LinkedList() {
        this.list = new Node[0];
    }

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

    public Node pop() {
        Node firstNode = getFirst();

        if (this.list.length > 0)
            this.list = Arrays.copyOfRange(this.list, 0, this.list.length-1);

        return firstNode;
    }

    public Node getFirst() {
        return this.list[this.list.length-1];
    }

    public Node getLast() {
        return this.list[0];
    }
}