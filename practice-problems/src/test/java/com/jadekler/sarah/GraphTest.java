package com.jadekler.sarah;

import com.jadekler.sarah.graph.*;
import org.junit.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GraphTest {
    Graph graph;

    @Before
    public void setup() {
        this.graph = new Graph(8);
    }

    @Test
    public void testAddDirected() {
        this.graph = new Graph(2);

        graph.addDirected(0, 1);
        graph.addDirected(0, 3);
        graph.addDirected(1, 3);

        Edge first0Edge = new Edge(0, 1, null);
        Edge second0Edge = new Edge(0, 3, first0Edge);
        Edge first1Edge = new Edge(1, 3, null);

        assertThat(graph.getEdges(), arrayContainingInAnyOrder(second0Edge, first1Edge));
    }

    @Test
    public void testAddUndirected() {
        graph.addUndirected(0, 1);
        graph.addUndirected(0, 3);

        Edge second0Edge = new Edge(0, 3, null);
        Edge first0Edge = new Edge(0, 1, second0Edge);
        Edge first1Edge = new Edge(1, 0, null);
        Edge first3Edge = new Edge(3, 0, null);

        assertThat(graph.getEdges(), arrayContainingInAnyOrder(first0Edge, first1Edge, first3Edge));
    }

    @Test
    public void testTraverseBreadthFirst() {
        graph.addUndirected(1, 2);
        graph.addUndirected(1, 5);
        graph.addUndirected(1, 6);
        graph.addUndirected(2, 3);
        graph.addUndirected(3, 4);
        graph.addUndirected(4, 5);

        List<Integer> traversalOrder = graph.traverseBreadthFirst();
    }
}
