/*
 * Q1.Sheldon and Pair of Cities (Day 94 - Advanced DSA : Graphs 4: Floyd Warshall Algorithm & Graph Coloring-Wed, 1 Nov 2023)
Problem Description
Sheldon lives in a country with A cities (numbered from 1 to A) and B bidirectional roads.
Roads are denoted by integer array D, E and F of size M, where D[i] and E[i] denotes the cities and F[i] denotes the 
distance between the cities.
Now he has many lectures to give in the city and is running short of time, so he asked you C queries, 
for each query i, find the shortest distance between city G[i] and H[i].
If the two cities are not connected then the distance between them is assumed to be -1.

Problem Constraints
1 <= A <= 200
1 <= B <= 200000
1 <= C <= 100000
1 <= F[i] <= 1000000
1 <= D[i], E[i], G[i], H[i] <= A

Input Format
First argument is an integer A.
Seocnd argument is an integer B.
Third argument is an integer C.
Fourth argument is an integer array D.
Fifth argument is an integer array E.
Sixth argument is an integer array F.
Seventh argument is an integer array G.
Eight argument is an integer array H.

Output Format
Return an integer array of size C, for each query denoting the shortest distance between the given two vertices.
If the two vertices are not connected then output -1.

Example Input
Input 1:
 A = 4
 B = 6
 C = 2
 D = [1, 2, 3, 2, 4, 3]
 E = [2, 3, 4, 4, 1, 1]
 F = [4, 1, 1, 1, 1, 1]
 G = [1, 1]
 H = [2, 3]
Input 2:
 A = 3
 B = 3
 C = 2
 D = [1, 2, 1]
 E = [2, 3, 3]
 F = [3, 1, 1]
 G = [2, 1]
 H = [3, 2]


Example Output
Output 1:
 [2, 1]
Output 2:
 [1, 2]

Example Explanation
Explanation 1:
 Distance between (1,2) will 2 if we take path 1->4->2.
 Distance between (1,3) will 1 if we take path 1->3.
Explanation 2:
 Distance between (2,3) will 1 if we take path 1->3.
 Distance between (1,2) will 2 if we take path 1->3->2.

 */


package com.example.demo.sclr_code.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SheldonAndPairOfCities {
	public static void main(String[] args) {
		int A = 4;
		int B = 6;
		int C = 2; 
		int[] D = {1, 2, 3, 2, 4, 3};
		int[] E = {2, 3, 4, 4, 1, 1};
		int[] F = {4, 1, 1, 1, 1, 1};
	    int[] G = {1, 1};
	    int[] H = {2, 3};
		
	    System.out.println( Arrays.toString( solve(A, B, C, D, E, F, G, H) ) );
	}
	
	 public static int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
		//create graph list with pair 
		ArrayList< ArrayList<PairOfNodeEdge>> graphList = new ArrayList<>();
		for(int i=0; i<=A; i++){
			graphList.add(new ArrayList<PairOfNodeEdge>());
		}
		for(int i=0; i<B; i++) {
			int s = D[i]; 
			int d = E[i]; 
			int edge = F[i]; 
			graphList.get(s).add(new PairOfNodeEdge(d, edge)); 
			graphList.get(d).add(new PairOfNodeEdge(s, edge)); 			
		}
		
		int[] ans = new int[C]; 
		for(int i=0; i<C; i++) {
			int s=G[i]; 
			int d = H[i]; 
			ans[i] = shortestSourceToDestination(A, s, d, graphList); 
		}
		return ans;
		
	 }
	 
	 
	 //Dijkstra algo - based on the question 
	 public static int shortestSourceToDestination(int nodeCount,int s, int d, ArrayList<ArrayList<PairOfNodeEdge>> graphList){
		 int[] distance = new int[nodeCount+1]; 
		 Arrays.fill(distance, -1);
		 
		 PriorityQueue<PairOfNodeEdge> minHeap = new PriorityQueue<>(new PairOfNodeEdge());
		 //add the source node in min haep with 0 distance
		 minHeap.add(new PairOfNodeEdge(s, 0)); 
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
		 return distance[d];
	 }
}


















