package com.jadekler.sarah;

import com.jadekler.sarah.graph.*;
import org.junit.*;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GraphTest {
    Graph graph;

    @Before
    public void setup() {
        graph = new Graph(3);
    }

    @Test
    public void testAddDirected() {
        graph.add(0, 1, true);
        graph.add(0, 2, true);

        assertThat(graph.getVertices().length, equalTo(3));

        assertThat(graph.getVertices()[0].getAdjacentVertices(), equalTo(asLinkedList(1, 2)));
        assertThat(graph.getVertices()[1], nullValue());
        assertThat(graph.getVertices()[2], nullValue());
    }

    @Test
    public void testAddUndirected() {
        graph.add(0, 1, false);
        graph.add(0, 2, false);

        assertThat(graph.getVertices().length, equalTo(3));

        assertThat(graph.getVertices()[0].getAdjacentVertices(), equalTo(asLinkedList(1, 2)));
        assertThat(graph.getVertices()[1].getAdjacentVertices(), equalTo(asLinkedList(0)));
        assertThat(graph.getVertices()[2].getAdjacentVertices(), equalTo(asLinkedList(0)));
    }

    @Test
    public void testTraverseBreadthFirst() {
        graph = new Graph(6);

        graph.add(0, 1, false);
        graph.add(0, 4, false);
        graph.add(0, 5, false);
        graph.add(1, 2, false);
        graph.add(2, 3, false);
        graph.add(3, 4, false);

        assertThat(graph.getVertices().length, equalTo(6));

        assertThat(graph.getVertices()[0].getAdjacentVertices(), equalTo(asLinkedList(1, 4, 5)));
        assertThat(graph.getVertices()[1].getAdjacentVertices(), equalTo(asLinkedList(0, 2)));
        assertThat(graph.getVertices()[2].getAdjacentVertices(), equalTo(asLinkedList(1, 3)));
        assertThat(graph.getVertices()[3].getAdjacentVertices(), equalTo(asLinkedList(2, 4)));
        assertThat(graph.getVertices()[4].getAdjacentVertices(), equalTo(asLinkedList(0, 3)));
        assertThat(graph.getVertices()[5].getAdjacentVertices(), equalTo(asLinkedList(0)));

        int[] order = graph.traverseBreadthFirst(0);
        assertThat(order, equalTo(new int[]{0, 1, 4, 5, 2, 3}));
    }

    @Test
    public void testTraverseDepthFirst() {
        graph = new Graph(7);

        // A B C D E F G
        // 0 1 2 3 4 5 6

        graph.add(0, 1, false);
        graph.add(0, 2, false);
        graph.add(0, 4, false);
        graph.add(1, 3, false);
        graph.add(1, 5, false);
        graph.add(2, 6, false);
        graph.add(4, 5, false);

        int[] order = graph.traverseDepthFirst(0);
        assertThat(order, equalTo(new int[]{0, 1, 3, 5, 4, 2, 6}));
    }

    public <T> LinkedList<T> asLinkedList(T... froms) {
        LinkedList<T> item = new LinkedList();

        for (int i = 0; i < froms.length; i++) {
            item.add(froms[i]);
        }

        return item;
    }
}
