package com.jadekler.datastructures;

import java.util.Arrays;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class Linkedlist 
{
    Linkeditem[] list;

    class Linkeditem {
        private Linkeditem fwd;
        private int num;

        public Linkeditem(int num) {
            this.num = num;
        }

        public void setFwdLink(Linkeditem fwd) {
            this.fwd = fwd;
        }

        public Linkeditem next() {
            return this.fwd;
        }

        public int getNum() {
            return num;
        }
    }

    public static void main(String args[]) {
        Linkedlist ll = new Linkedlist();
    }

    public Linkedlist() {
        this.list = new Linkeditem[0];
    }

    public void push(int num) {
        Linkeditem[] tempArr = new Linkeditem[this.list.length+1];
        Linkeditem item = new Linkeditem(num);

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

    public void pop() {
        if (this.list.length > 0)
            this.list = Arrays.copyOfRange(this.list, 0, this.list.length-1);
    }

    public Linkeditem getFirst() {
        return this.list[0];
    }
}