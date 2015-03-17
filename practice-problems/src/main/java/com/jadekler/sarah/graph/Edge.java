package com.jadekler.sarah.graph;

public class Edge {
    int x, y;
    public Edge next;

    public Edge(int x, int y, Edge next) {
        this.x = x;
        this.y = y;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Edge{" +
            "x=" + x +
            ", y=" + y +
            ", next=" + next +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Edge edge = (Edge) o;

        if (x != edge.x)
            return false;
        if (y != edge.y)
            return false;
        if (next != null ? !next.equals(edge.next) : edge.next != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
