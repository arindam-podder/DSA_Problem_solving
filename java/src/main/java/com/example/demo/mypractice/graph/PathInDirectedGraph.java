/**
 * Path in Directed Graph  
 * (https://www.scaler.com/academy/mentee-dashboard/class/141964/assignment/problems/9359/?navref=cl_pb_nv_tb)

Problem Description
Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2
such that there is a edge directed from node
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
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a 
edge directed from node B[i][0] to node B[i][1].



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


package com.example.demo.mypractice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathInDirectedGraph {

	public static void main(String[] args) {

	}
	
	
	//approach : perform BFS and check the visited array , if visite[lastNode] == true that means 1-> lastNode path exist 
	public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
		//create adjacent list 
		List<List<Integer>> adjacent = new ArrayList<>();
		//initialize
		for(int i=0; i<=A; i++) {
			adjacent.add(new ArrayList<>());
		}
		//fill adjacent from B   
		for(ArrayList<Integer> list : B) {
			int u= list.get(0); 
			int v= list.get(1);
			//it a directed graph 
			adjacent.get(u).add(v);
		}
		
		int[] visited = new int[A+1];
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(1);
		visited[1] = 1;
		while(!que.isEmpty()) {
			int node = que.poll();
			List<Integer> list = adjacent.get(node);
			for(int n : list) {
				if(visited[n] != 1) {
					visited[n] = 1; 
					que.add(n);
				}
			}
		}
		return visited[A];
    }
	
	
	
	public static int solveByDepthFirstSearch(int totalNodes, ArrayList<ArrayList<Integer>> listOfEdges) {
		//construct adjacentList using listOfEdges 
		List<List<Integer>> adjacent = new ArrayList<>(); 
		for(int i=0; i<=totalNodes; i++) {
			adjacent.add(new ArrayList<>());
		}
		for(int i=0; i<listOfEdges.size(); i++) {
			int u=listOfEdges.get(i).get(0);
			int v=listOfEdges.get(i).get(1);
			adjacent.get(u).add(v);
		}
		
		int[] visited = new int[totalNodes+1];
		visited[1] = 1;
		DFS(1, adjacent, visited);
		
		return visited[totalNodes];
	}
	
	
	public static void DFS(int node, List<List<Integer>> adjacent, int[] visited) {
		List<Integer> listOfNeighbour = adjacent.get(node);
		for(int neighbour : listOfNeighbour) {
			if(visited[neighbour] != 1) {
				visited[neighbour] = 1; 
				DFS(neighbour, adjacent, visited);
			}
		}
	}
	
	

}

















