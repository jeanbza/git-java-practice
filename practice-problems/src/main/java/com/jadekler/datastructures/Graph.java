package com.jadekler.datastructures;

import java.util.Stack;
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
        int[][] adjacencyList = {{1,2},{4},{2},{4},{0}};

        Graph graph = new Graph(adjacencyList);
        graph.bfs(4);
        graph.dfs(4);
    }

    public Graph(int[][] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public void bfs(int numToFind) {
        System.out.println("Breadth first search");

        Queue queue = new LinkedList();
        boolean[] discovered = new boolean[this.adjacencyList.length];

        for (int i = 0; i < discovered.length; i++) {
            discovered[i] = false;
        }

        queue.offer(0);
        discovered[0] = true;

        this.bfs(queue,discovered,numToFind);
    }

    public void bfs(Queue queue, boolean[] discovered, int numToFind) {
        while (!queue.isEmpty()) {
            int curNum = (int)queue.poll();

            System.out.println("At: "+curNum);

            if (curNum == numToFind) {
                System.out.println("Found "+curNum+"!");
                return;
            }

            for (int i = 0; i < this.adjacencyList[curNum].length; i++) {
                int adjacentNum = this.adjacencyList[curNum][i];

                if (!discovered[adjacentNum]) {
                    queue.offer(adjacentNum);
                    discovered[adjacentNum] = true;
                }
            }
        }
    }

    public void dfs(int numToFind) {
        System.out.println("Depth first search");

        Stack stack = new Stack();
        boolean[] discovered = new boolean[this.adjacencyList.length];

        for (int i = 0; i < discovered.length; i++) {
            discovered[i] = false;
        }

        stack.push(0);
        discovered[0] = true;

        this.dfs(stack,discovered,numToFind);
    }

    public void dfs(Stack stack, boolean[] discovered, int numToFind) {
        while (!stack.isEmpty()) {
            int curNum = (int)stack.pop();

            System.out.println("At: "+curNum);

            if (curNum == numToFind) {
                System.out.println("Found "+curNum+"!");
                return;
            }

            for (int i = 0; i < this.adjacencyList[curNum].length; i++) {
                int adjacentNum = this.adjacencyList[curNum][i];

                if (!discovered[adjacentNum]) {
                    stack.push(adjacentNum);
                    discovered[adjacentNum] = true;
                }
            }
        }
    }
}
