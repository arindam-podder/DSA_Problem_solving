/*
  Q4. Dijsktra (Day 93 - Advanced DSA : Graphs 3: MST & Dijkstra -- Mon, 30 Oct 2023)
Problem Description
Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
You have to find an integer array D of size A such that:
D[i]: Shortest distance from the C node to node i.
If node i is not reachable from C then -1.

Note:
There are no self-loops in the graph.
There are no multiple edges between two pairs of vertices.
The graph may or may not be connected.
Nodes are numbered from 0 to A-1.
Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

Problem Constraints
1 <= A <= 1e5
0 <= B[i][0],B[i][1] < A
0 <= B[i][2] <= 1e3
0 <= C < A

Input Format
The first argument is an integer A, representing the number of nodes in the graph.
The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.

Output Format
Return the integer array D.

Example Input
Input 1:
A = 6
B = [   [0, 4, 9]
        [3, 4, 6] 
        [1, 2, 1] 
        [2, 5, 1] 
        [2, 4, 5] 
        [0, 3, 7] 
        [0, 1, 1] 
        [4, 5, 7] 
        [0, 5, 1] ] 
C = 4
Input 2:
A = 5
B = [   [0, 3, 4]
        [2, 3, 3] 
        [0, 1, 9] 
        [3, 4, 10] 
        [1, 3, 8]  ] 
C = 4

Example Output
Output 1:
D = [7, 6, 5, 6, 0, 6]
Output 2:
D = [14, 18, 13, 10, 0]

Example Explanation
Explanation 1:
 All Paths can be considered from the node C to get shortest path
Explanation 2:
 All Paths can be considered from the node C to get shortest path
 */


package com.example.demo.sclr_code.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijsktra_SingleSourceShortestDistance {
	public static void main(String[] args) {
		
	}
	
	public static int[] singleSourceToshortestPath(int totalNodes, int[][] edges, int source){
		//create graph list with pair 
		ArrayList< ArrayList<PairOfNodeEdge>> graphList = new ArrayList<>();
		for(int i=0; i<totalNodes; i++){
			graphList.add(new ArrayList<PairOfNodeEdge>());
		}
		for(int i=0; i<edges.length; i++){
			int u=edges[i][0];
			int v=edges[i][1];
			int weight = edges[i][2];
			graphList.get(u).add(new PairOfNodeEdge(v, weight));
			graphList.get(v).add(new PairOfNodeEdge(u, weight));
		}
		
		//create a distance array 
		int[] distance = new int[totalNodes]; 
		for(int i=0; i<distance.length; i++){
			distance[i] = -1; 
		}
		
		PriorityQueue<PairOfNodeEdge> minHeap = new PriorityQueue<PairOfNodeEdge>(new PairOfNodeEdge());
		//add the source node in min haep with 0 distance 
		minHeap.add(new PairOfNodeEdge(source, 0));
		while(!minHeap.isEmpty()){
			PairOfNodeEdge parent = minHeap.poll();
			if(distance[parent.node] == -1){
				distance[parent.node] = parent.weight; 
			}
			else{
				if(distance[parent.node] > parent.weight){
					distance[parent.node] = parent.weight; 
				}
			}
			
			ArrayList<PairOfNodeEdge> neighbour = graphList.get(parent.node); 
			for(int i=0; i<neighbour.size(); i++){
				PairOfNodeEdge child = neighbour.get(i);
				if(distance[child.node] == -1){
					minHeap.add( new PairOfNodeEdge(child.node, child.weight+distance[parent.node]) );
				}	
			}
		}
		return distance;	
	}
}


class PairOfNodeEdge implements Comparator<PairOfNodeEdge>{
	int node; 
	int weight; 
	PairOfNodeEdge() { }
	PairOfNodeEdge(int n , int w){
		this.node = n; 
		this.weight = w;
	}
	
	@Override
	public int compare(PairOfNodeEdge arg0, PairOfNodeEdge arg1) {
		return arg0.weight - arg1.weight;
	}
}




