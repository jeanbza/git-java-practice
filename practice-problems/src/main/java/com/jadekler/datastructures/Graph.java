package com.jadekler.datastructures;

/**
 * This class holds items in a binary tree fashion, without balancing
 */
public class Graph 
{
    public Node[] vertices;

    class Node {
        public int num;
        public Node nextEdge;

        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String args[]) {
        int[][] adjacencyList = {{1,2,5},{0,2},{0,1,3,4},{2,4,5},{2,3}};

        Graph graph = new Graph(adjacencyList);
    }

    public Graph(int[][] adjacencyList) {
        vertices = new Node[adjacencyList.length];

        for (int i = 0; i < adjacencyList.length-1; i++) {
            vertices[i] = new Node(i);

            for (int j = 0; j < adjacencyList[i].length-1; j++) {
                initEdge(i, adjacencyList[i][j]);
            }
        }
    }

    public void initEdge(int x, int y) {
        Node newNode = new Node(y);
        newNode.nextEdge = vertices[x].nextEdge;

        // Insert at head of list
        vertices[x].nextEdge = newNode;
    }    
}