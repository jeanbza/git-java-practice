package com.jadekler.datastructures;

import java.util.Arrays;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class Stack 
{
    Node[] list;

    class Node {
        private int num;

        public Node(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }

    public Stack() {
        this.list = new Node[0];
    }

    public void push(int num) {
        Node[] tempArr = new Node[this.list.length+1];
        Node item = new Node(num);

        // Set current
        tempArr[0] = item;

        // Copy over to new list
        for (int i = 0; i < this.list.length; i++) {
            tempArr[i+1] = this.list[i];
        }

        // Set list
        this.list = tempArr;
    }

    public Node pop() {
        Node topNode = getTop();

        if (this.list.length > 0)
            this.list = Arrays.copyOfRange(this.list, 1, this.list.length);

        return topNode;
    }

    public Node getTop() {
        return this.list[0];
    }

    public Node getBottom() {
        return this.list[this.list.length-1];
    }
}