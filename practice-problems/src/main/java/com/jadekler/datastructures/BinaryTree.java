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
    private Node root;
    
    class Node {
        private Node left;
        private Node right;
        private Node parent;
        private int num;

        public Node(int num) {
            this.num = num;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public int getNum() {
            return this.num;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public Node getParent() {
            return this.parent;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right = node;
        }

        public void setParent(Node node) {
            this.parent = node;
        }
    }

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        bt.push(5);
        bt.push(4);
        bt.push(2);
        bt.push(3);
        bt.push(9);
        bt.push(7);
        bt.push(6);
        bt.push(8);
        bt.push(15);
        bt.push(14);
        bt.push(13);
        bt.push(12);
        bt.push(11);

        bt.emitGraph();
    }

    public void emitGraph() {
        Queue queue = new java.util.LinkedList();
        queue.offer(getRoot());
        emitGraph(queue, 0, "");
    }

    // Try: 
    // get furthest left
    // get furthest right
    // put root in middle
    // newline
    // put left middle-2
    // put right middle+2
    // newline
    // etc
    public void emitGraph(Queue queue, int currentLevel, String preSpaces) {
        if (queue.isEmpty()) {
            System.out.print("\n");
        } else {
            Node node = (Node)queue.poll();

            if (getDistFromTop(node) > currentLevel) {
                System.out.print("\n");
                currentLevel++;
            }

            String postSpaces = "  ";

            for (int i = 0; i < getLeftCount(node, 0); i++) {
                preSpaces += "  ";
            }

            if (node.getParent() != null && getSiblingLeft(node) != node && getSiblingLeft(node) == null)
                preSpaces += "  ";

            if (node.getParent() != null && getSiblingRight(node) != node && getSiblingRight(node) == null)
                postSpaces += "  ";

            System.out.print(preSpaces+node.getNum()+postSpaces);

            if (node != null && node.getLeft() != null)
                queue.offer(node.getLeft());

            if (node != null && node.getRight() != null)
                queue.offer(node.getRight());

            emitGraph(queue, currentLevel, preSpaces);
        }
    }

    public Node getSiblingLeft(Node node) {
        if (node.getParent() != null)
            return node.getParent().getLeft();
        else 
            return null;
    }

    public Node getSiblingRight(Node node) {
        if (node.getParent() != null)
            return node.getParent().getRight();
        else
            return null;
    }

    public int getDistFromTop(Node node) {
        return getDistFromTop(node, 0);
    }

    public int getDistFromTop(Node node, int depth) {
        if (node.getParent() == null) {
            return depth;
        } else {
            return getDistFromTop(node.getParent(), ++depth);
        }
    }

    public int getLeftCount() {
        return getLeftCount(getRoot(), 0);
    }

    public int getLeftCount(Node node, int leftCount) {
        if (node.getLeft() != null) {
            return getLeftCount(node.getLeft(), ++leftCount);
        } else {
            return leftCount;
        }
    }

    public void push(int num) {
        push(getRoot(), num);
    }

    public void push(Node node, int num) {
        Node newNode = new Node(num);
        newNode.setParent(node);

        if (node == null) {
            setRoot(newNode);
        } else {
            if (num > node.getNum()) {
                if (node.getRight() != null) {
                    push(node.getRight(), num);
                } else {
                    node.setRight(newNode);
                }
            } else {
                if (node.getLeft() != null) {
                    push(node.getLeft(), num);
                } else {
                    node.setLeft(newNode);
                }
            }
        }
    }

    public Node depthFirstSearch(int num) {
        Stack stack = new Stack();
        stack.push(getRoot());
        return depthFirstSearch(stack, num);
    }

    public Node depthFirstSearch(Stack stack, int num) {
        if (stack.empty())
            return null;

        Node node = (Node)stack.pop();

        if (node != null && node.getNum() == num)
            return node;

        if (node != null && node.getLeft() != null)
            stack.push(node.getLeft());

        if (node != null && node.getRight() != null)
            stack.push(node.getRight());

        return depthFirstSearch(stack, num);
    }

    public Node breadthFirstSearch(int num) {
        Queue queue = new java.util.LinkedList();
        queue.offer(getRoot());
        return breadthFirstSearch(queue, num);
    }

    public Node breadthFirstSearch(Queue queue, int num) {
        if (queue.isEmpty())
            return null;

        Node node = (Node)queue.poll();

        if (node != null && node.getNum() == num)
            return node;

        if (node != null && node.getRight() != null)
            queue.offer(node.getRight());

        if (node != null && node.getLeft() != null)
            queue.offer(node.getLeft());

        return breadthFirstSearch(queue, num);
    }

    public String toString() {
        return toString(getRoot());
    }

    public String toString(Node node) {
        String str = "";

        if (node == null) {
            str += "Tree is empty";
        } else {
            if (node.getLeft() != null)
                str += toString(node.getLeft());

            str += Integer.toString(node.getNum())+" ";

            if (node.getRight() != null)
                str += toString(node.getRight());
        }

        return str;
    }

    public int[] toArray() {
        return toArray(getRoot());
    }

    public int[] toArray(Node node) {
        int[] arr = new int[0];

        if (node == null) {
            arr = new int[0];
        } else {
            if (node.getLeft() != null) {
                int[][] leftArrs = {toArray(node.getLeft()), arr};
                arr = mergeArrays(leftArrs);
            }

            int[] numArr = {node.getNum()};
            int[][] numArrs = {arr, numArr};
            arr = mergeArrays(numArrs);

            if (node.getRight() != null) {
                int[][] rightArrs = {arr, toArray(node.getRight())};
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

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return this.root;
    }
}