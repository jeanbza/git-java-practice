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
        bt.push(10);
        bt.push(6);
        bt.push(4);
        bt.push(5);
        bt.push(7);

        bt.emitGraph();
    }

    public void emitGraph() {
        Stack stack = treeToStack();

        emitGraph(stack, getDepth((Node)stack.peek()), "  ");
    }

    public void emitGraph(Stack stack, int currentLevel, String preSpaces) {
        if (stack.isEmpty()) {
            System.out.print("\n");
        } else {
            Node node = (Node)stack.pop();

            if (getDepth(node) < currentLevel) {
                System.out.print("\n");
                currentLevel--;
                preSpaces += "  ";
            }

            System.out.print(preSpaces+node.getNum());

            emitGraph(stack, currentLevel, preSpaces);
        }
    }

    public Stack treeToStack() {
        Stack stack = new Stack();
        Queue queue = treeToQueue();

        while (!queue.isEmpty()) {
            Node node = (Node)queue.poll();
            stack.push(node);
        }

        return stack;
    }

    public Queue treeToQueue() {
        Queue tempQueue = new java.util.LinkedList();
        Queue queue = new java.util.LinkedList();
        tempQueue.offer(getRoot());
        queue.offer(getRoot());
        treeToQueue(tempQueue, queue);
        return queue;
    }

    public void treeToQueue(Queue tempQueue, Queue queue) {
        Node node = (Node)tempQueue.poll();

        if (node != null && node.getRight() != null) {
            tempQueue.offer(node.getRight());
            queue.offer(node.getRight());
        }

        if (node != null && node.getLeft() != null) {
            tempQueue.offer(node.getLeft());
            queue.offer(node.getLeft());
        }

        if (!tempQueue.isEmpty()) {
            treeToQueue(tempQueue, queue);
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

    public int getDepth(Node node) {
        return getDepth(node, 0);
    }

    public int getDepth(Node node, int depth) {
        if (node.getParent() == null) {
            return depth;
        } else {
            return getDepth(node.getParent(), ++depth);
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

    /**
     * Pushes a num into the binary tree starting at some node (usually root)
     * @param   Node node Node to push down from
     * @param   int  num  Number to push into tree
     * @return  void
     */
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

    /**
     * Recursively searches for num in stack (depth first search)
     * @param   int   num   Number to search for
     * @return  Node        Node in which the number resides
     */
    public Node depthFirstSearch(int num) {
        Stack stack = new Stack();
        stack.push(getRoot());
        return depthFirstSearch(stack, num);
    }

    /**
     * Recursively searches for num in stack (depth first search)
     * @param   Stack stack Stack to pop and push from / to
     * @param   int   num   Number to search for
     * @return  Node        Node in which the number resides
     */
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

    /**
     * Recursively searches for num in queue (breadth first search)
     * @param   int   num  Number to search for
     * @return  Node  node The node in which the number resides
     */
    public Node breadthFirstSearch(int num) {
        Queue queue = new java.util.LinkedList();
        queue.offer(getRoot());
        return breadthFirstSearch(queue, num);
    }

    /**
     * Recursively searches for num in queue (breadth first search)
     * @param   Queue  queue Queue to pop and push from / to
     * @param   int    num   Number to search for
     * @return  Node         Node in which the number resides
     */
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

    /**
     * Returns the tree as string
     * @return  String String format version of tree
     */
    public String toString() {
        return toString(getRoot());
    }

    /**
     * Returns the tree as string
     * @param   Node   Node from which to return all children
     * @return  String String format of tree
     */
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

    /**
     * Returns the binary tree in array format
     * @return  int[] Array format for tree
     */
    public int[] toArray() {
        return toArray(getRoot());
    }

    /**
     * Returns the binary tree in array format
     * @param   Node   Node from which to return all children
     * @return  int[]  Array format of tree
     */
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

    /**
     * Merges an array of arrays into one array
     * @param   int[][] Arrays to merge
     * @return  int[]   Merged array
     */
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

    /**
     * Sets the root for this binary tree
     * @param   node Root
     * @return  void
     */
    public void setRoot(Node node) {
        this.root = node;
    }

    /**
     * Gets the root of this binary tree
     * @return  node Root node
     */
    public Node getRoot() {
        return this.root;
    }
}