/**
 * given a graph, traverse level by level. 
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
 * 	ans :- [1, 2, 3, 5, 4, 6, 7, 8, 9 ]
 * 
 */

package com.example.demo.preparation1;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Graph_1_Traversal_BFS_LevelOrderTraversal {
	
	
	private static int NODES  = 9;
	private static int EDGES = 8; 
	private static int[][] EDGES_ARR = { {1, 2}, {1, 3}, {1, 5}, {2, 4}, {4, 7}, {5, 6}, {6, 8}, {6, 9} };
	
	
	public static void main(String[] args) {
		
		System.out.println( GraphTraversal.BFS(NODES, EDGES_ARR, 6) );
		
		System.out.println(GraphTraversal.BFS_levelByLevel(NODES, EDGES_ARR, 6));

	}

	
	
	private class GraphTraversal{
		
		public static List<Integer> BFS(int nodeCount, int[][] edges, int bfsStartVertex){
			List<Integer> result = new ArrayList<>();
			List<List<Integer>> adjacentList = getAdjacentList(nodeCount, edges);
			int[] visited = new int[nodeCount+1];
			LinkedList<Integer> que = new LinkedList<Integer>();
			
			que.offerLast(bfsStartVertex); 
			
			while(!que.isEmpty()) {
				int curVertex = que.poll();
				result.add(curVertex); 
				visited[curVertex] = 1;
				 
				// traverse curVertex all the adjacent vertex 
				List<Integer> neighbourVertexList = adjacentList.get(curVertex);
				for(int i=0; i<neighbourVertexList.size(); i++ ) {
					if(visited[neighbourVertexList.get(i)] == 0 ) {
						que.add(neighbourVertexList.get(i));
					}
				}
				
			}
			
			return result; 
		}
		
		public static List<List<Integer>> BFS_levelByLevel(int nodeCount, int[][] edges, int bfsStartVertex){
			List<List<Integer>> result = new ArrayList<>();
			List<List<Integer>> adjacentList = getAdjacentList(nodeCount, edges);
			int[] visted = new int[nodeCount+1]; 
			LinkedList<Integer> que = new LinkedList<>();
			
			que.offerLast(bfsStartVertex); 
			
			while(!que.isEmpty()) {
				int curLevelSize = que.size(); 
				List<Integer> curLevelVetexList = new ArrayList<>(); 
				
				//loop througn current que element 
				for(int i=0; i<curLevelSize; i++) {
					int curVertex = que.poll(); 
					curLevelVetexList.add(curVertex); 
					visted[curVertex] = 1; 
					
					//get the curVertex adjacent vertex
					List<Integer> neighbourList = adjacentList.get(curVertex);
					for(int j=0; j<neighbourList.size(); j++) {
						if(visted[neighbourList.get(j)] == 0) {
							que.add(neighbourList.get(j));
						}
					}
				}
				
				result.add(curLevelVetexList);
				
			}
			
			return result; 
		}
		
		
		public static List<List<Integer>> getAdjacentList(int nodeCount, int[][] edges) {
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
		
		
		
	}//GraphTraversal inner class end
	
	
//	private class 

	
}//Graph_1_Traversal_BFS_LevelOrderTraversal end
















