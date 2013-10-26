package com.jadekler.datastructures;

import java.util.Arrays;
import java.util.Random;

/**
 * This class holds items in a LIFO manner - last in (on the stack), first out
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

    /**
     * Constructor
     * @return  void
     */
    public Stack() {
        this.list = new Node[0];
    }

    /**
     * Pushes an item onto the stack
     * @param   int num The number to push onto the stack
     * @return  void
     */
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

    /**
     * Removes the top node from the stack and returns it
     * @return  Node Top node
     */
    public Node pop() {
        Node topNode = getTop();

        if (this.list.length > 0)
            this.list = Arrays.copyOfRange(this.list, 1, this.list.length);

        return topNode;
    }

    /**
     * Returns (without removing) the top node from the stack
     * @return  Node The top node on the stack
     */
    public Node getTop() {
        if (this.list.length > 0)
            return this.list[0];
        else
            return null;
    }

    /**
     * Alias for getTop
     * @return  Node The top node on the stack
     */
    public Node peek() {
        return this.getTop();
    }

    /**
     * Returns (without removing) the bottom node from the stack
     * @return  Node The bottom node on the stack
     */
    public Node getBottom() {
        return this.list[this.list.length-1];
    }

    /**
     * Checks if the stack is empty
     * @return  boolean True/false whether the stack is empty or not
     */
    public boolean isEmpty() {
        return getTop() == null;
    }
}