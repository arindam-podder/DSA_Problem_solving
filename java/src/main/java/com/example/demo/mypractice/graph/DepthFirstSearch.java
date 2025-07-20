package com.example.demo.mypractice.graph;

import java.util.List;

public class DepthFirstSearch {
	public static void main(String[] args) {
		int totalNode = 5; 	//0-4
		int[][] edges = {{0,1}, {1,2}, {2,3}, {2,4}, {0,4}};
		
		graphTraversal(totalNode, edges, totalNode);
	}
	
	public static void graphTraversal(int totalNode, int[][] edges, int source) {
		List<List<Integer>> adjacentList = GraphUtil.getAdjacentListForUndirected(totalNode, edges);
		int[] visited = new int[totalNode];
		DFS1(0, adjacentList, visited);
	}
	
	public static void DFS1(int node, List<List<Integer>> adjaList, int[] visited) {
		
		System.out.println( node );
		visited[node] = 1;
		
		for(int neighbor: adjaList.get(node)) {
			if(visited[neighbor] == 0) DFS1(neighbor, adjaList, visited);
		}
		
	}
	
}
