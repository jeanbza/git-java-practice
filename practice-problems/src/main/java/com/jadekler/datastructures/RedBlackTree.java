package com.jadekler.datastructures;

/**
 * This class holds items in a binary tree fashion, with red/black balancing
 */
public class RedBlackTree extends BinaryTree
{
    private Node root;
    
    class Node {
        private Node left;
        private Node right;
        private Node parent;
        private int num;
        private boolean isRed;

        public Node(int num) {
            this.num = num;
            this.isRed = false;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public boolean isRed() {
            return this.isRed;
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
        bt.push(8);

        bt.emitTree();
    }

    public void push(int num) {

    }

    public void push(Node node, int num) {

    }
}