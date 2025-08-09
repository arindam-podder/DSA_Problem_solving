/*
 * given a undirected graph , check cycle exits or not 
 * 
 * solution : for a vertex, if its neighbor is already visited and is not a parent then cycle present.  
 */


package com.example.demo.mypractice.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.example.demo.mypractice.graph.GraphUtil.VertexPair;

public class UndirectedCycleDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5; 
		int[][] edges = {{0,1}, {1,2}, {1,3}, {3,4}, {4,1} };
		
		System.out.println( checkCycleExitsOrNot(n, edges)  );
	}
	
	public static boolean checkCycleExitsOrNot(int n, int[][] edges) {
		List<List<Integer>> graph = GraphUtil.getAdjacentListForUndirected(n, edges);
		//int[] visited = new int[n];
		//return DFS(0, -1, graph, visited);
		
		return BFS(n, graph);
	}
	
	// cycle detection using Depth First Search
	public static boolean DFS(int vertex, int parent, List<List<Integer>> graph, int[] visited) {
		visited[vertex] = 1; 
		for(int neighbor: graph.get(vertex)) {
			//cycle detec
			if(neighbor != parent && visited[neighbor]==1) {
				return true;
			}
			else if(visited[neighbor] == 0){
				boolean res = DFS(neighbor, vertex, graph, visited);
				if(res) return true;
			}
		}
		
		return false;
	}
	
	// cycle detection using Breadth first Search   // use Pair class or a parent array
	public static boolean BFS(int n, List<List<Integer>> graph) {
		int[] visited = new int[n];
		Queue<VertexPair> que = new LinkedList<>();
		que.add(new VertexPair(0, -1)); 
		visited[0] = 1;
		while(!que.isEmpty()) {
			VertexPair vertexPair = que.poll();
			int vertext = vertexPair.vertex; 
			int  parent = vertexPair.parent;
			for(int neighbor: graph.get(vertext)) {
				if(neighbor != parent && visited[neighbor] == 1) return true;
				else if(visited[neighbor] == 0) {
					que.add(new VertexPair(neighbor, vertext));
					visited[neighbor] = 1; 
				}
			}
		}
		return false;
	}
	

	

}
