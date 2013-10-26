package com.jadekler.datastructures;

import java.util.Stack;

/**
 * This class holds items in a binary tree fashion, with red/black balancing
 */
public class RedBlackTree
{
    private Node root;
    private int numBlackNodesToDescendant;
    
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

        public Node(int num, boolean isRed) {
            this.num = num;
            this.isRed = isRed;
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

        public void setIsRed(boolean isRed) {
            this.isRed = isRed;
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
        RedBlackTree rbt = new RedBlackTree();
        rbt.push(19);

        rbt.emitTree();
    }

    public void push(int num) {
        push(getRoot(), num);
    }

    public void push(Node node, int num) {
        Node newNode = new Node(num);
        newNode.setParent(node);

        if (node == null) {
            newNode.setIsRed(false);
            setRoot(newNode);
        } else {
            
        }
    }

    /**
     * Emits the tree visually in cli
     * This function is based on camluca's 4954a1ad1d9b034abbd3c23c4581324fb6b8fa57
     */
    public void emitTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(getRoot());

        int emptyLeaf = 32; // Just a guess at how wide this tree should be. Increase for larger trees
        boolean isRowEmpty = false;

        while(isRowEmpty == false) {

            Stack localStack = new Stack();
            
            isRowEmpty = true;
            
            for(int j = 0; j<emptyLeaf; j++)
                System.out.print(' ');

            while(globalStack.isEmpty() == false) {
                Node temp = (Node)globalStack.pop();

                if(temp != null) {
                    this.emitNode(temp);
                    
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    
                    if(temp.getLeft() != null || temp.getRight() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                
                for(int j = 0; j < emptyLeaf*2-2; j++)
                    System.out.print(' ');
            }
            
            System.out.println();
            
            emptyLeaf /= 2;
            
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }
    }

    /**
     * Emits the node with system.out
     * @param   Node Node to emit
     * @return  void
     */
    public void emitNode(Node node) {
        if (node.isRed()) {
            System.out.print(" "+node.getNum()+" ");
        } else {
            System.out.print("."+node.getNum()+".");
        }

    }

    public Node getRoot() {
        return this.root;
    }

    /**
     * Sets the root for this binary tree
     * @param   node Root
     * @return  void
     */
    public void setRoot(Node node) {
        this.root = node;
    }
}