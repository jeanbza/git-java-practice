package com.jadekler.datastructures;

import java.util.Arrays;
import java.util.Random;
import java.util.Queue;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class BinaryTree 
{
    private TreeItem root;
    
    class TreeItem {
        private TreeItem left;
        private TreeItem right;
        private int num;

        public TreeItem(int num) {
            this.num = num;
            this.left = null;
            this.right = null;
        }

        public int getNum() {
            return this.num;
        }

        public TreeItem getLeft() {
            return this.left;
        }

        public TreeItem getRight() {
            return this.right;
        }

        public void setLeft(TreeItem treeItem) {
            this.left = treeItem;
        }

        public void setRight(TreeItem treeItem) {
            this.right = treeItem;
        }
    }

    public void push(int num) {
        push(this.getRoot(), num);
    }

    public void push(TreeItem treeItem, int num) {
        TreeItem newTreeItem = new TreeItem(num);

        if (treeItem == null) {
            setRoot(newTreeItem);
        } else {
            if (num > treeItem.getNum()) {
                if (treeItem.getRight() != null) {
                    push(treeItem.getRight(), num);
                } else {
                    treeItem.setRight(newTreeItem);
                }
            } else {
                if (treeItem.getLeft() != null) {
                    push(treeItem.getLeft(), num);
                } else {
                    treeItem.setLeft(newTreeItem);
                }
            }
        }
    }

    public TreeItem depthFirstSearch(int num) {
        Stack stack = new Stack();
        stack.push(getRoot());
        return depthFirstSearch(stack, num);
    }

    public TreeItem depthFirstSearch(Stack stack, int num) {
        if (stack.empty())
            return null;

        TreeItem treeItem = (TreeItem)stack.pop();

        if (treeItem != null && treeItem.getNum() == num)
            return treeItem;

        if (treeItem != null && treeItem.getLeft() != null)
            stack.push(treeItem.getLeft());

        if (treeItem != null && treeItem.getRight() != null)
            stack.push(treeItem.getRight());

        return depthFirstSearch(stack, num);
    }

    public TreeItem breadthFirstSearch(int num) {
        Queue queue = new java.util.LinkedList();
        queue.offer(getRoot());
        return breadthFirstSearch(queue, num);
    }

    public TreeItem breadthFirstSearch(Queue queue, int num) {
        if (queue.isEmpty())
            return null;

        TreeItem treeItem = (TreeItem)queue.poll();

        if (treeItem != null && treeItem.getNum() == num)
            return treeItem;

        if (treeItem != null && treeItem.getRight() != null)
            queue.offer(treeItem.getRight());

        if (treeItem != null && treeItem.getLeft() != null)
            queue.offer(treeItem.getLeft());

        return breadthFirstSearch(queue, num);
    }

    public String toString() {
        return toString(getRoot());
    }

    public String toString(TreeItem treeItem) {
        String str = "";

        if (treeItem == null) {
            str += "Tree is empty";
        } else {
            if (treeItem.getLeft() != null)
                str += toString(treeItem.getLeft());

            str += Integer.toString(treeItem.getNum())+" ";

            if (treeItem.getRight() != null)
                str += toString(treeItem.getRight());
        }

        return str;
    }

    public int[] toArray() {
        return toArray(getRoot());
    }

    public int[] toArray(TreeItem treeItem) {
        int[] arr = new int[0];

        if (treeItem == null) {
            arr = new int[0];
        } else {
            if (treeItem.getLeft() != null) {
                int[][] leftArrs = {toArray(treeItem.getLeft()), arr};
                arr = mergeArrays(leftArrs);
            }

            int[] numArr = {treeItem.getNum()};
            int[][] numArrs = {arr, numArr};
            arr = mergeArrays(numArrs);

            if (treeItem.getRight() != null) {
                int[][] rightArrs = {arr, toArray(treeItem.getRight())};
                arr = mergeArrays(rightArrs);
            }
        }

        return arr;
    }

    public int[] mergeArrays(int[][] arrs) {
        int length = 0;

        for (int i = 0; i < arrs.length; i++) {
            length += arrs[i].length;
        }

        int[] mergedArr = new int[length];
        int pointer = 0;

        for (int i = 0; i < arrs.length; i++) {
            System.arraycopy(arrs[i], 0, mergedArr, pointer, arrs[i].length);
            pointer += arrs[i].length;
        }

        return mergedArr;
    }

    public void setRoot(TreeItem treeItem) {
        this.root = treeItem;
    }

    public TreeItem getRoot() {
        return this.root;
    }
}