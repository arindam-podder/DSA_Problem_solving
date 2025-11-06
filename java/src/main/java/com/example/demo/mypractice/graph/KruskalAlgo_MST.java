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
The graph is connected and doesn't contain self-loops & multiple edges.s
 */


// algo -> sort the edges based on weight + apply DSU 

package com.example.demo.mypractice.graph;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalAlgo_MST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 3, E = 3, Edges[][] = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}}; 

		System.out.println( spanningTree(V, Edges) );
	}
	
	public static int spanningTree(int V, int[][] edges) {
        // code here
        return kruskalDSU(V, edges);
    }

	public static int kruskalDSU(int v, int[][] edges) {
		Arrays.sort(edges, Comparator.comparingInt(arr -> arr[2]));
		DSU dsu = new DSU(v);
		int result = 0; 
		//edges traverse and dsu operation 
		for(int[] arr : edges) {
			int x=arr[0], y=arr[1], w=arr[2];
			if(dsu.findParent(x) != dsu.findParent(y)) {
				dsu.union(x, y);
				result += w;
			}
		}
		return result;
	}
	
}
















