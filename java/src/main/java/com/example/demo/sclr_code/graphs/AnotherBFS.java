/*
 * Q3. Another BFS (Day 93 - Advanced DSA : Graphs 3: MST & Dijkstra -- Mon, 30 Oct 2023)

Problem Description
Given a weighted undirected graph having A nodes, a source node C and destination node D.
Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
You are expected to do it in Time Complexity of O(A + M).

Note:
There are no self-loops in the graph.
No multiple edges between two pair of vertices.
The graph may or may not be connected.
Nodes are Numbered from 0 to A-1.
Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

Problem Constraints
1 <= A <= 105
0 <= B[i][0], B[i][1] < A
1 <= B[i][2] <= 2
0 <= C < A
0 <= D < A

Input Format
The first argument given is an integer A, representing the number of nodes.
The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].
The third argument given is an integer C, representing the source node.
The fourth argument is an integer D, representing the destination node.

Note: B[i][2] will be either 1 or 2.

Output Format
Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.

Example Input
Input 1:
A = 6
B = [   [2, 5, 1]
        [1, 3, 1] 
        [0, 5, 2] 
        [0, 2, 2] 
        [1, 4, 1] 
        [0, 1, 1] ] 
C = 3
D = 2
Input 2:
A = 2
B = [   [0, 1, 1]
    ] 
C = 0
D = 1

Example Output
Output 1:
 4
Output 2:
 1

Example Explanation
Explanation 1:
The path to be followed will be:
    3 -> 1 (Edge weight : 1)
    1 -> 0 (Edge weight : 1)
    0 -> 2 (Edge weight : 2)
Total length of path = 1 + 1 + 2 = 4.
Explanation 2:
 Path will be 0-> 1.
 */


package com.example.demo.sclr_code.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class AnotherBFS {
	public static void main(String[] args) {
		int A = 3; 
		int[][] B = { {1, 2, 4}, {1, 3, 7}, {2, 3, 1} }; 
		int C = 1; 
		int D = 3;
		
		System.out.println(minDistance(A, B, C, D));
	}
	
	public static int minDistance(int A, int[][] B, int C, int D) {
		//create graphList 
		ArrayList<ArrayList<PairOfNodeEdge>> graphList =  new ArrayList<>(); 
		for(int i=0; i<=A; i++) {
			graphList.add(new ArrayList<PairOfNodeEdge>()); 
		}
		for(int i=0; i<B.length; i++) {
			int s = B[i][0]; 
			int d = B[i][1]; 
			int w = B[i][2]; 
			graphList.get(s).add(new PairOfNodeEdge(d, w));
			graphList.get(d).add(new PairOfNodeEdge(s, w));			
		}
		int[] distance = new int[A+1];
		Arrays.fill(distance, -1);
		
		//we need minHeap here 
		PriorityQueue<PairOfNodeEdge> minHeap = new PriorityQueue<>(new PairOfNodeEdge()); 
		minHeap.add(new PairOfNodeEdge(C, 0)); 
		while(!minHeap.isEmpty()) {
			PairOfNodeEdge pair = minHeap.poll(); 
			if(distance[pair.node] == -1) {
				distance[pair.node] = pair.weight;
			}else {
				if(distance[pair.node] > pair.weight) {
					distance[pair.node] = pair.weight; 
				}
			}
			
			
			ArrayList<PairOfNodeEdge> neighbour = graphList.get(pair.node);  
			for(int i=0; i<neighbour.size(); i++) {
				PairOfNodeEdge child = neighbour.get(i);
				if(distance[child.node] == -1){
					minHeap.add( new PairOfNodeEdge(child.node, child.weight+distance[pair.node]) );
				}
			}
		}
		return distance[D];
	}
}
























