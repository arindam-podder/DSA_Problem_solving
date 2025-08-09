/**
 * given a directed graph, check cycle exits or not 
 * 
 * play with current path 
 */

package com.example.demo.mypractice.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedCycleDetection {

	public static void main(String[] args) {
		int n=5; 
		int[][] edges = {{0,1}, {1,2}, {4,3}, {2,4}, {3,1} };
		
		System.out.println( checkCycleExitsOrNot(n, edges)  );
	}
	
	public static boolean checkCycleExitsOrNot(int n, int[][] edges) {
		List<List<Integer>> graph = GraphUtil.getAdjacentListForDirected(n, edges);
		//int[] visited = new int[n]; 
		//int[] currentPath = new int[n];
		//return DFS(0, graph, visited, currentPath);
		
		return BFS(n, graph);
	}
	
	// cycle detection using DFS, play with currentPath
	public static boolean DFS(int vertex, List<List<Integer>> graph, int[] visited, int[] currentPath) {
		visited[vertex] = 1;
		currentPath[vertex] = 1; 
		for(int neighbor: graph.get(vertex)) {
			if(visited[neighbor] == 0) {
				if(DFS(neighbor, graph, visited, currentPath)) return true;
			}
			else if(currentPath[neighbor] == 1) return true;
 		}
		currentPath[vertex] = 0;
		return false;
	}
	
	// khan's algo - topological sorting , play with inDegree and at the end if all node visited then no cycle , 
	// if not then cycle 
	public static boolean BFS(int n, List<List<Integer>> graph) {
		int[] inDegree = new int[n]; 
		for(List<Integer> neighborsList: graph) {
			for(int i: neighborsList) {
				inDegree[i] += 1;
			}
		}
		
		Queue<Integer> que = new LinkedList<>();
		int visitVertexCount = 0;
		for(int i=0; i<inDegree.length; i++) {
			if(inDegree[i] == 0) {
				que.add(i); 
				visitVertexCount += 1;
			}
		}
		
		while(!que.isEmpty()) {
			int vertex = que.poll();
			for(int neighbor: graph.get(vertex)) {
				inDegree[neighbor] -= 1; 
				if(inDegree[neighbor] == 0) {
					que.add(neighbor); 
					visitVertexCount += 1;
				}
			}
		}
		
		//if all vertex visited then no cycle , else cycle
		return !(visitVertexCount==n);
	
	}
}













