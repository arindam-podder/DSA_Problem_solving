/**
 * directed acyclic graph(DAG) get topological sorting 
 * no dependent vertex will come 1st thatn the vertex has the dependency on it. 
 * zero in-degree to max in-degree  
 */


package com.example.demo.mypractice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KhansAlgoTopologicalSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5; 
		int[][] edges = {{0, 2}, {0, 3}, {1, 2}, {2, 3}, {2, 4}, {3, 4}};  // 0/1 2 3 4
		
		System.out.println( topologicalSorting(n, edges) );
	}

	
	public static List<Integer> topologicalSorting(int n, int[][] edges) {
		List<List<Integer>> graph = GraphUtil.getAdjacentListForDirected(n, edges);
		
		//return BFS(n, graph);
		
		//DFS approach
		List<Integer> topologicalList = new ArrayList<>(); 
		int[] inDegree = new int[n];
		for(List<Integer> neighborList: graph) {
			for(int nbr: neighborList) inDegree[nbr] += 1;
		}
		List<Integer> initialZeros = new ArrayList<>();
		for(int i=0; i<inDegree.length; i++) {
			if(inDegree[i] == 0) initialZeros.add(i);
		}
		//all initial zero indegree call DFS 
		for(int vertex: initialZeros) {
			DFS(vertex, graph, inDegree, topologicalList);
		}
		return topologicalList;
	}
	
	
	//topological sorting using BFS
	public static List<Integer> BFS(int n, List<List<Integer>> graph){
		int[] inDegree = new int[n];
		for(List<Integer> neighborList: graph) {
			for(int nbr: neighborList) inDegree[nbr] += 1;
		}
		
		Queue<Integer> que = new LinkedList<>(); 
		//all zero indegree add too que 
		for(int i=0; i<inDegree.length; i++) {
			if(inDegree[i] == 0) que.add(i);
		}
		List<Integer> topologicalList = new ArrayList<>();
		while(!que.isEmpty()) {
			int vertex = que.poll();
			topologicalList.add(vertex); 
			for(int neighbor : graph.get(vertex)) {
				inDegree[neighbor] -= 1;
				if(inDegree[neighbor] == 0) {
					que.add(neighbor);   
				}
			}
		}
		return topologicalList;
	}
	
	//topological sorting using DFS
	public static void DFS(int vertex, List<List<Integer>> graph, int[] inDegree, List<Integer> topologicalList) {
		topologicalList.add(vertex); 
		for(int neighbor : graph.get(vertex)) {
			inDegree[neighbor] -= 1; 
			if(inDegree[neighbor] == 0) {
				DFS(neighbor, graph, inDegree, topologicalList);
			}
		}
	}
	
	
}
