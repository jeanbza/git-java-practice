package com.jadekler.datastructures;

import java.util.Queue;
import java.util.LinkedList;

/**
 * This class holds items in a binary tree fashion, without balancing
 * Please note: ideas for this implementation influenced by Skiena's 'The Algorithm Design Manual'
 */
public class Graph 
{
    public int[][] adjacencyList;

    public static void main(String args[]) {
        int[][] adjacencyList = {{1,2,5},{0,2},{0,1,3,4},{2,4,5},{2,3},{1,3}};

        Graph graph = new Graph(adjacencyList);

        System.out.println(graph.breadthFirstSearch(3));
    }

    public Graph(int[][] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public int breadthFirstSearch(int numToFind) {
        if (numToFind > this.adjacencyList.length-1) {
            return -1;
        } else {
            boolean[] discovered = new boolean[this.adjacencyList.length];
            Queue queue = new LinkedList();
            queue.offer(0);

            for (int x = 0; x < discovered.length-1; x++) {
                discovered[x] = false;
            }

            discovered[0] = true;

            return breadthFirstSearch(numToFind, queue, discovered);
        }
    }

    private int breadthFirstSearch(int numToFind, Queue queue, boolean[] discovered) {
        int currentNum;

        while (!queue.isEmpty()) {
            currentNum = (int)queue.poll();
            System.out.println("Current: "+currentNum);

            if (currentNum == numToFind) {
                return currentNum;
            } else {
                for (int x = 0; x < this.adjacencyList[currentNum].length; x++) {
                    int adjacentNum = this.adjacencyList[currentNum][x];
                    if (!discovered[adjacentNum]) {
                        queue.offer(adjacentNum);
                        discovered[adjacentNum] = true;
                    }
                }
            }
        }

        return -1;
    }
}
