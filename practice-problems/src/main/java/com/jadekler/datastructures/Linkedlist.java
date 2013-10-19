package com.jadekler.datastructures;

import java.util.Arrays;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class LinkedList 
{
    LinkedItem[] list;

    class LinkedItem {
        private LinkedItem fwd;
        private int num;

        public LinkedItem(int num) {
            this.num = num;
        }

        public void setFwdLink(LinkedItem fwd) {
            this.fwd = fwd;
        }

        public LinkedItem next() {
            return this.fwd;
        }

        public int getNum() {
            return num;
        }
    }

    public LinkedList() {
        this.list = new LinkedItem[0];
    }

    public void push(int num) {
        LinkedItem[] tempArr = new LinkedItem[this.list.length+1];
        LinkedItem item = new LinkedItem(num);

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

    public LinkedItem getFirst() {
        return this.list[0];
    }
}