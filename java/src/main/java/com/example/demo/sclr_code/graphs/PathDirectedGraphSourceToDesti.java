/*
 *  Path in Directed Graph

Problem Description
Given an directed graph having A nodes labelled from 1 to A containing M edges given by
matrix B of size M x 2such that there is a edge directed from node
B[i][0] to node B[i][1].
Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
2 <= A <= 105
1 <= M <= min(200000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed
from node B[i][0] to node B[i][1].

Output Format
Return 1 if path exists between node 1 to node A else return 0.

Example Input
Input 1:
 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:
 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 The given doens't contain any path from node 1 to node 5 so we will return 0.
Explanation 2:
 Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
 */


package com.example.demo.sclr_code.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class PathDirectedGraphSourceToDesti {

	public static void main(String[] args) {
		int totalNodes = 5;
		int[][] edges = {  	{1, 2}, 
				        	{4, 1}, 
				        	{2, 4}, 
				        	{3, 4}, 
				        	{5, 2}, 
				        	{1, 3} };
		
		ArrayList<ArrayList<Integer>> graphsList = new ArrayList<>(totalNodes+1);
		for(int i=0; i<=totalNodes; i++) {
			graphsList.add(new ArrayList<Integer>());
		}
		for(int i=0; i<edges.length; i++) {
			graphsList.get(edges[i][0]).add(edges[i][1]);
		}
		
		
		System.out.println( isPathExists(graphsList, 1, totalNodes) );
		
	}

	
	public static boolean isPathExists(ArrayList<ArrayList<Integer>> graphList, int source, int destination) {
		boolean[] visted = new boolean[destination+1];
		LinkedList<Integer> queue = new LinkedList<>(); 
		queue.offerLast(source); 
		visted[source] = true; 
		while(!queue.isEmpty()) {
			int node = queue.pollFirst();
			ArrayList<Integer> allEdges = graphList.get(node); 
			for(int i=0; i<allEdges.size(); i++) {
				int cur = allEdges.get(i);
				if(visted[cur] == false) {
					visted[cur] = true; 
					queue.offerLast(cur);
				}
			}
		}
		return visted[destination]; 
	}
	
}





















