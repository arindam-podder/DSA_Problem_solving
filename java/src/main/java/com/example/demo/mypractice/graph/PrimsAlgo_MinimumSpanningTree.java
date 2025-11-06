/**
 * Minimum Spanning Tree (https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1)

Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of 
the weights of the edges in the Minimum Spanning Tree (MST) of the graph. The graph is provided as a list of edges, 
where each edge is represented as [u, v, w], indicating an edge between vertex u and vertex v with edge weight w.

Input: V = 3, E = 3, Edges = [[0, 1, 5], [1, 2, 3], [0, 2, 1]] 
Output: 4
Explanation:
The Spanning Tree resulting in a weight
of 4 is shown above.

Input: V = 2, E = 1, Edges = [[0 1 5]]
Output: 5 
Explanation: Only one Spanning Tree is possible which has a weight of 5.

Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
The graph is connected and doesn't contain self-loops & multiple edges.

 */

// algo -> PQ<int[]>{w, node, parent} , visited[] arr use properly

package com.example.demo.mypractice.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgo_MinimumSpanningTree {

	public static void main(String[] args) {
		int V = 3, E = 3, Edges[][] = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}}; 

		System.out.println( spanningTree(V, Edges) );
	}
	
    public static int spanningTree(int V, int[][] edges) {
        // code here
        return primsAlgo(V, edges);
    }
    
    // PQ<int[]>{w, node, parent} , visited[] 
    public static int primsAlgo(int v, int[][] edges) {
    	List<List<int[]>> graph = getGraph(v, edges);
    	int[] visited = new int[v]; 
    	List<int[]> mst = new ArrayList<>();		//for MST display we can use this
    	Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
    	//start with any node 
    	pq.add(new int[] {0, 0, -1});	//w=0, startNode=0, parent=-1
    	int sum = 0; 
    	while(!pq.isEmpty()) {
    		int[] arr = pq.poll();
    		int w = arr[0], node = arr[1], parent = arr[2];
    		if(visited[node] == 0) {
    			sum += w;
    			visited[node] = 1;
    			if(parent != -1) {
    				mst.add(new int[] {parent, node});
    			}
    		}
    		//neighbor 
    		for(int[] nbrArr: graph.get(node)) {
    			int nbr=nbrArr[0], w1=nbrArr[1];
    			if(visited[nbr] == 0) {
    				pq.add(new int[] {w1, nbr, node});
    			}
    		}
    	}
    	
    	return sum;
    }
    
    public static List<List<int[]>> getGraph(int v, int[][] edges){
    	List<List<int[]>> graph = new ArrayList<>();
    	for(int i=0; i<v; i++) graph.add(new ArrayList<>());
    	for(int[] arr: edges) {
    		int x=arr[0], y=arr[1], w=arr[2];
    		graph.get(x).add(new int[] {y, w});
    		graph.get(y).add(new int[] {x, w});
    	}
    	return graph;
    }

}
