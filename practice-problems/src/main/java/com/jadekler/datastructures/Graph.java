package com.jadekler.datastructures;

/**
 * This class holds items in a binary tree fashion, without balancing
 */
public class Graph 
{
    public int[][] adgacencyList;

    class Node {
        private int num;

        public Node(int num) {
            this.num = num;
        }

        public int getNum() {
            return this.num;
        }
    }

    public static void main(String args[]) {
        int[][] adgacencyList = new int[5][5];

        adgacencyList = {{1,2,5},{0,2},{0,1,3,4},{2,4,5},{2,3},{0,3}};
    }

    public Graph(int[][] adgacencyList) {
        this.adgacencyList = adgacencyList;
    }
}