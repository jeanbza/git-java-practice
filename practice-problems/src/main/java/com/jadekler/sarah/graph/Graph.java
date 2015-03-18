package com.jadekler.sarah.graph;

import java.util.*;

public class Graph {
    private Vertex[] vertices;

    public Graph(int size) {
        this.vertices = new Vertex[size];
    }

    public void add(int from, int to, boolean directed) {
        if (vertices[from] == null) {
            vertices[from] = new Vertex(from);
        }

        vertices[from].adjecentVertices.add(to);

        if (!directed) {
            add(to, from, true);
        }
    }

    public int[] traverseBreadthFirst(int startingVertex) {
        Queue<Vertex> queue = new PriorityQueue<>();
        queue.add(vertices[startingVertex]);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.remove();


        }

        return new int[]{};
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public static class Vertex {
        private List adjecentVertices;
        private int position;

        public Vertex(int position) {
            this.position = position;
            adjecentVertices = new LinkedList<>();
        }

        public List getAdjecentVertices() {
            return adjecentVertices;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Vertex vertex = (Vertex) o;

            if (position != vertex.position)
                return false;
            if (adjecentVertices != null ? !adjecentVertices.equals(vertex.adjecentVertices) : vertex.adjecentVertices != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = adjecentVertices != null ? adjecentVertices.hashCode() : 0;
            result = 31 * result + position;
            return result;
        }
    }
}
