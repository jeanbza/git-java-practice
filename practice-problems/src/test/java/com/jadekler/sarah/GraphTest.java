package com.jadekler.sarah;

import com.jadekler.sarah.graph.*;
import org.junit.*;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsEqual.equalTo;

public class GraphTest {
    Graph graph;

    @Before
    public void setup() {
        this.graph = new Graph();
    }

    @Test
    public void testAdd() {
        graph.add(0, 1, 5);

        assertThat(graph.getEdges().get(0), equalTo(new Edge(0, 1, null)));
        assertThat(graph.getEdges().size(), equalTo(1));
    }
}
