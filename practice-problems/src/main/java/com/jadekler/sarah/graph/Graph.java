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
        int[] order = new int[vertices.length];
        int orderIndex = 0;
        boolean[] discovered = new boolean[vertices.length];

        List<Vertex> queue = new LinkedList<>();
        queue.add(vertices[startingVertex]);
        discovered[0] = true;

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.remove(0);
            List<Integer> adjacentVertices = currentVertex.getAdjacentVertices();

            for (int i = 0; i < adjacentVertices.size(); i++) {
                int adjacentVertexPosition = vertices[adjacentVertices.get(i)].getPosition();

                if (!discovered[adjacentVertexPosition]) {
                    queue.add(vertices[adjacentVertexPosition]);
                    discovered[adjacentVertexPosition] = true;
                }
            }

            order[orderIndex] = currentVertex.getPosition();
            orderIndex++;
        }

        return order;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public static class Vertex {
        private List<Integer> adjecentVertices;
        private int position;

        public Vertex(int position) {
            this.position = position;
            adjecentVertices = new LinkedList<>();
        }

        public List<Integer> getAdjacentVertices() {
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
