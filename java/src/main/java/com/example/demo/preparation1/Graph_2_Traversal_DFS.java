/**
 * given a graph, traverse depth wise. DFS 
 * 
 * Example : 
 * vertex = <1-9> 
 * edge = 8
 * [1, 2]
 * [1, 3]
 * [1, 5]
 * [2, 4]
 * [4, 7]
 * [5, 6]
 * [6, 8]
 * [6, 9]
 * 
 * 	ans :- [1, 2, 4, 7, 3, 5, 6, 8, 9 ]
 * 
 */



package com.example.demo.preparation1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph_2_Traversal_DFS {
	
	private static int NODES  = 9;
	private static int EDGES = 8; 
	private static int[][] EDGES_ARR = { {1, 2}, {1, 3}, {1, 5}, {2, 4}, {4, 7}, {5, 6}, {6, 8}, {6, 9} };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(depthFirstSearc(NODES, EDGES_ARR));
		
	}
	
	public static List<Integer> depthFirstSearc(int nodeCount, int[][] edges){
		List<Integer> result  = new ArrayList<>();
		List<List<Integer>> adjacentList = createAdjacentList(nodeCount, edges);
		int[] visited = new int[nodeCount+1];
		Arrays.fill(visited, -1);
		
		dfs(1, adjacentList, visited, result);
		
		return result; 
		
	}
	
	
	public static void dfs(int node, List<List<Integer>> adjacentList, int[] visitedArr, List<Integer> result){
		visitedArr[node] = 1;
		result.add(node); 
		
		for(int neighbour: adjacentList.get(node)) {
			if(visitedArr[neighbour] == -1) {
				dfs(neighbour, adjacentList, visitedArr, result);			
			}
		}
	}
	
	public static List<List<Integer>> createAdjacentList(int nodeCount, int[][] edges){
		List<List<Integer>> adjacentList = new ArrayList<>();
		for(int i=0; i<=nodeCount; i++) {
			adjacentList.add(new ArrayList<>()); 
		}
		
		for(int i=0; i<edges.length; i++) {
			int u = edges[i][0]; 
			int v = edges[i][1]; 
			
			adjacentList.get(u).add(v); 
			adjacentList.get(v).add(u);
		}
		return adjacentList; 
	}
	

}
