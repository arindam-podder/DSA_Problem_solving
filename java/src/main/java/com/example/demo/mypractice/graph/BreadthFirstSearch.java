/**
 * BFS means explore neighbor 
 */

package com.example.demo.mypractice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	public static void main(String[] args) {
		int totalNode = 5; 	//0-4
		int[][] edges = {{0,1}, {1,2}, {2,3}, {2,4}, {0,4}};
		
		graphTraversal(totalNode, edges, 0);
	}
	
	public static void graphTraversal(int nodeCount, int[][] adges, int sourceNode) {
		List<List<Integer>> adjacentList = GraphUtil.getAdjacentListForUndirected(nodeCount, adges);
		
		BFS2(nodeCount, adjacentList, sourceNode);
	}
	
 	
//	// bfs - where poll first and mark visited    //wrong it will not work 
//	public static void BFS1(int nodes, List<List<Integer>> adjaList, int source) {
//		int[] visited = new int[nodes];
//		Queue<Integer> que = new LinkedList<>();
//		que.add(source);
//		
//		while(!que.isEmpty()) {
//			int vertex = que.poll();
//			visited[vertex] = 1;		//after poll marking visted 
//			System.out.println( vertex );
//			for(Integer neighbor: adjaList.get(vertex)) {
//				if(visited[neighbor] == 0) {
//					que.add(neighbor);
//				}
//			}
//		}
//	}//BFS1 end
	
	// bfs - where add to que and mark visited 		//correct
	public static void BFS2(int nodes, List<List<Integer>> adjaList, int source) {
		int[] visited = new int[nodes];
		Queue<Integer> que = new LinkedList<>();
		que.add(source);
		visited[source] = 1; 	//mark visited after added to que
		
		while(!que.isEmpty()) {
			int vertex = que.poll();
			System.out.println( vertex );
			for(Integer neighbor: adjaList.get(vertex)) {
				if(visited[neighbor] == 0) {
					que.add(neighbor);
					visited[neighbor] = 1;		//mark visited after or before added to que  (required)
				}
			}
		}
	}//BFS2 end	
	
}






















