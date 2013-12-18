package com.jadekler.app;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;


/**
 * Given a tree of the form:
 *      1
 *    2   3
 *   4 5 6 7
 *
 * Emit 1 3 2 4 5 6 7
 */
public class FlippingTreeTraversal {
    public Node root;

    public class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main( String[] args ) {
        FlippingTreeTraversal treeTraverser = new FlippingTreeTraversal();
        treeTraverser.traverse();
    }

    public FlippingTreeTraversal(Node root) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        this.root = root;
    }

    public void traverse() {
        Queue queue = new LinkedList();
        Stack stack = new Stack();

        queue.offer(this.root);

        while (!queue.isEmpty()) {
            Node curNode = (Node)queue.poll();

            stack.push(curNode.right);
            stack.push(curNode.left);
            System.out.println(curNode.val);

            if (queue.isEmpty() && !stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    Node otherDirectionNode = (Node)stack.pop();
                    System.out.println(otherDirectionNode.val);
                    queue.offer(otherDirectionNode.left);
                    queue.offer(otherDirectionNode.right);
                }
            }
        }
    }
}