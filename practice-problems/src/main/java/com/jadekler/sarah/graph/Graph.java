package com.jadekler.sarah.graph;

import java.util.*;

public class Graph {
    List<Edge> edges;

    public Graph() {
        this.edges = new ArrayList<>();
    }

    public void add(int edgeA, int edgeB, int vertexInfo) {
        edges.add(new Edge(edgeA, edgeB, null));
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
