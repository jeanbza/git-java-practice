package com.jadekler.sarah;

import com.jadekler.sarah.graph.*;
import org.junit.*;

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
        this.graph = new Graph(3);

        graph.add(0, 1, true);
        graph.add(0, 2, true);
        graph.add(1, 2, true);

        Edge first0Edge = new Edge(0, 1, null);
        Edge second0Edge = new Edge(0, 2, first0Edge);
        Edge first1Edge = new Edge(1, 2, null);

        assertThat(graph.getEdges(), arrayContainingInAnyOrder(second0Edge, first1Edge, null));
    }

    @Test
    public void testAddUndirected() {
        this.graph = new Graph(3);

        graph.add(0, 1, false);
        graph.add(0, 2, false);

        Edge first0Edge = new Edge(0, 1, null);
        Edge second0Edge = new Edge(0, 2, first0Edge);
        Edge first1Edge = new Edge(1, 0, null);
        Edge first3Edge = new Edge(2, 0, null);

        assertThat(graph.getEdges(), arrayContainingInAnyOrder(second0Edge, first1Edge, first3Edge));
    }

    @Test
    public void testTraverseBreadthFirst() {
        Graph graph = new Graph(6);

        graph.add(0, 1, true);
        graph.add(0, 4, true);
        graph.add(0, 5, true);
        graph.add(1, 2, true);
        graph.add(2, 3, true);
        graph.add(3, 4, true);

        int[] traversalOrder = graph.traverseBreadthFirst(1);

        assertThat(traversalOrder, equalTo(new int[]{1, 2, 5, 6, 3, 4}));
    }
}
