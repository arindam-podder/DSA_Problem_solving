/**
 * 802. Find Eventual Safe States

There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D 
integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i 
to each node in graph[i]. A node is a terminal node if there are no outgoing edges. A node is a safe node if every 
possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

Example 1:
Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.

Example 2:
Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 

Constraints:
n == graph.length
1 <= n <= 104
0 <= graph[i].length <= n
0 <= graph[i][j] <= n - 1
graph[i] is sorted in a strictly increasing order.
The graph may contain self-loops.
The number of edges in the graph will be in the range [1, 4 * 104].

 */



package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LC802_FindEventualSafeStates {

	public static void main(String[] args) {
		int[][] graph = { {1,2}, {2,3}, {5}, {0}, {5}, {}, {}} ;
		
		System.out.println( safeNodes1(graph) );
	}
	
	public static List<Integer> safeNodes1(int[][] graph) {
        int[] visited = new int[graph.length];
        TreeSet<Integer> safeNode = new TreeSet<>();
        for(int vertex=0; vertex<graph.length; vertex++) {
        	if(visited[vertex] == 0) DFS(vertex, graph, visited, safeNode);
        }
		return new ArrayList<>(safeNode);
    }
	
	//vertex with zero outDegree will be base case, and rest recursion will take care , play with safeVetex set also
	public static boolean DFS(int vertex, int[][] graph, int[] visited, TreeSet<Integer> safeVertex) {
		visited[vertex] = 1;
		if(graph[vertex].length == 0) {	//outDegree 0
			safeVertex.add(vertex);
			return true;
		}
		
		boolean isSafeNode = true;
		for(int neighbor: graph[vertex]) {
			if(visited[neighbor] == 0 && DFS(neighbor, graph, visited, safeVertex)==false) {
				isSafeNode = false;
			}
			else if(visited[neighbor] == 1 && !safeVertex.contains(neighbor)) {
				isSafeNode = false; 
			}
		}
		if(isSafeNode) safeVertex.add(vertex);
		return isSafeNode;
	}

}
