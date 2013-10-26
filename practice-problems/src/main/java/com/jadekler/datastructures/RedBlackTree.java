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

        public boolean leftAndRightBlack() {
            return (left == null || !left.isRed()) && (right == null || !right.isRed());
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

        public Node getSibling() {
            if (this.parent != null) {
                if (this.parent.getLeft() != this) {
                    return this.parent.getLeft();
                } else {
                    return this.parent.getRight();
                }
            } else {
                return null;
            }
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
        rbt.push(10);
        rbt.push(85);
        rbt.push(15);
        rbt.push(70);
        rbt.push(20);
    }

    public void push(int num) {
        push(getRoot(), num);
        emitTree();
        System.out.println("\n\n\n\n");
    }

    public void push(Node node, int num) {
        Node newNode = new Node(num);
        newNode.setParent(node);

        if (node == null) {
            newNode.setIsRed(false);
            setRoot(newNode);
        } else {
            if (num > node.getNum()) {
                if (node.getRight() != null) {
                    push(node.getRight(), num);
                } else {
                    insertNode(node, newNode, true);
                }
            } else {
                if (node.getLeft() != null) {
                    push(node.getLeft(), num);
                } else {
                    insertNode(node, newNode, false);
                }
            }
        }
    }

    public void insertNode(Node parent, Node child, boolean insertRightSide) {
        Node grandParent = parent.getParent();

        if (parent.isRed()) {
            if (parent.getSibling() != null && parent.getSibling().isRed()) {
                // insert as red, turn uncle and father black, turn grandfather red
                
                child.setIsRed(true);
                parent.setIsRed(false);
                parent.getSibling().setIsRed(false);
                parent.getParent().setIsRed(true);

                if (insertRightSide) {
                    parent.setRight(child);
                } else {
                    parent.setLeft(child);
                }
            } else {
                if (grandParent != null && !grandParent.isRed()) {
                    // grandparent is black, parent is red, node is red
                    // make child new grandparent, grandparent child's left, parent child's right
                    
                    Node newParent;
                    Node newLeft;
                    Node newRight;

                    if (child.getNum() < grandParent.getNum()) {
                        newParent = child;
                        newRight = parent;
                        newLeft = grandParent;
                    } else {
                        newRight = parent;
                        newParent = parent;
                        newLeft = child;
                    }
                    
                    parent.setIsRed(false);

                    if (grandParent.getParent() != null) {
                        newParent.setParent(grandParent.getParent());

                        if (grandParent.getParent().getLeft() == grandParent) {
                            grandParent.getParent().setLeft(newParent);
                        } else {
                            grandParent.getParent().setRight(newParent);
                        }
                    }

                    grandParent.setParent(newParent);
                    newParent.setLeft(grandParent);
                    grandParent.setIsRed(true);

                    if (grandParent == getRoot()) {
                        setRoot(newParent);
                    }

                    newRight.setParent(newParent);
                    newRight.setIsRed(true);
                    newParent.setRight(newRight);
                }
            }
        } else {
            child.setIsRed(true);

            if (insertRightSide) {
                parent.setRight(child);
            } else {
                parent.setLeft(child);
            }
        }

        if (getRoot().leftAndRightBlack()) {
            getRoot().setIsRed(false);
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

        int errorCounter = 0;

        int emptyLeaf = 32; // Just a guess at how wide this tree should be. Increase for larger trees
        boolean isRowEmpty = false;

        while(isRowEmpty == false && errorCounter < 500) {

            Stack localStack = new Stack();
            
            isRowEmpty = true;
            
            for(int j = 0; j<emptyLeaf; j++)
                System.out.print(' ');

            while(globalStack.isEmpty() == false && errorCounter < 500) {
                errorCounter++;

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
                
                for(int j = 0; j < emptyLeaf * 2 - 2 && errorCounter < 500; j++)
                    System.out.print(' ');
            }
            
            System.out.println();
            
            emptyLeaf /= 2;
            
            while(localStack.isEmpty() == false && errorCounter < 500)
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