package com.jadekler.app;

public class ShortestPath {
	public static void main(String args[]) {
		int[][] vertices = {{1,2,5},{0,2,3},{0,1,3,5},{1,2,4},{3,5},{0,4}};
		int[][] edges = {{7,9,14},{7,10,15},{9,10,11,2},{15,11,6},{6,9},{14,9}};

		ShortestPath sp = new ShortestPath(vertices, edges);
		sp.djikstrasAlgorithm();
	}

	public ShortestPath(int[][] vertices, int[][] edges) {
		
	}

	public void djikstrasAlgorithm() {}
}