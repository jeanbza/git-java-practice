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

    public void add(int vertexA, int vertexB, boolean directed) {
        Edge newEdge = new Edge(vertexA, vertexB, null);

        if (edges[vertexA] != null) {
            newEdge.next = edges[currentIndex];
        }

        edges[vertexA] = newEdge;

        if (directed) {
            add(vertexB, vertexA, false);
        } else {

        }
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
