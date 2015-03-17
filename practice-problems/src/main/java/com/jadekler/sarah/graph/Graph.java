package com.jadekler.sarah.graph;

import java.util.*;

import static java.util.Collections.emptyList;

public class Graph {
    Edge[] edges;
    int currentIndex = 0;

    public Graph(int size) {
        this.edges = new Edge[size];
        currentIndex = 0;
    }

    public void addDirected(int vertexA, int vertexB) {
        for (int i = 0; i < currentIndex; i++) {
            if (edges[i].x == vertexA) {
                Edge newEdge = new Edge(vertexA, vertexB, edges[i]);
                edges[i] = newEdge;

                return;
            }
        }

        edges[currentIndex++] = new Edge(vertexA, vertexB, null);
    }

    public void addUndirected(int vertexA, int vertexB) {
        for (int i = 0; i < currentIndex; i++) {
            if (edges[i].x == vertexA) {
                Edge newEdge = new Edge(vertexA, vertexB, edges[i]);
                edges[i] = newEdge;

                addDirected(vertexB, vertexA);

                return;
            }
        }

        edges[currentIndex++] = new Edge(vertexA, vertexB, null);
        addDirected(vertexB, vertexA);
    }

    public List<Integer> traverseBreadthFirst() {
        return emptyList();
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
