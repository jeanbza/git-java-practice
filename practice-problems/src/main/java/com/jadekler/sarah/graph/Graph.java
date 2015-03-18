package com.jadekler.sarah.graph;

import java.util.*;

public class Graph {
    Edge[] edges;
    int currentIndex = 0;

    public Graph(int size) {
        this.edges = new Edge[size];
        currentIndex = 0;
    }

    public void add(int vertexA, int vertexB, boolean directed) {
        Edge newEdge = new Edge(vertexA, vertexB, null);

        if (edges[vertexA] != null) {
            newEdge.next = edges[currentIndex];
        }

        edges[vertexA] = newEdge;

        if (directed) {
            currentIndex++;
        } else {
            add(vertexB, vertexA, false);
        }
    }

    public int[] traverseBreadthFirst(int startingVertex) {
        boolean[] discovered = new boolean[currentIndex];
        int[] order = new int[currentIndex];
        int orderIndex = 0;

        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(edges[startingVertex]);

        while (!queue.isEmpty()) {
            Edge currentEdge = queue.remove();
            Edge connection = currentEdge.next;

            while (connection != null) {
                connection = currentEdge.next;

                if (!discovered[connection.x]) {
                    queue.add(currentEdge);
                    discovered[connection.x] = true;
                }
            }

            order[orderIndex++] = currentEdge.x;
        }

        return order;
    }

    public Edge[] getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "Graph{" +
            "edges=" + Arrays.toString(edges) +
            ", currentIndex=" + currentIndex +
            '}';
    }
}
