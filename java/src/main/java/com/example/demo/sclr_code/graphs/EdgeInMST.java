/*
 * Edge in MST (Day 93 - Advanced DSA : Graphs 3: MST & Dijkstra -- Mon, 30 Oct 2023)

Problem Description
Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of 
size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].
For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else 
return 0.

Return an one-dimensional binary array of size M denoting answer for each edge.

NOTE:
The graph may be disconnected in that case consider mst for each component.
No self-loops and no multiple edges present.
Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].

Problem Constraints
1 <= A, M <= 3*105
1 <= B[i][0], B[i][1] <= A
1 <= B[i][1] <= 103

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given is an matrix B of size M x 3 which represents the M edges such that there is a edge between node 
B[i][0] and node B[i][1] with weight B[i][2].



Output Format
Return an one-dimensional binary array of size M denoting answer for each edge.

Example Input
Input 1:
 A = 3
 B = [ [1, 2, 2]
       [1, 3, 2]
       [2, 3, 3]
     ]
     
Example Output
Output 1:
 [1, 1, 0]

Example Explanation
Explanation 1:
 Edge (1, 2) with weight 2 is included in the MST           1
                                                          /   \
                                                         2     3
 Edge (1, 3) with weight 2 is included in the same MST mentioned above.
 Edge (2,3) with weight 3 cannot be included in any of the mst possible.
 So we will return [1, 1, 0]

 */


package com.example.demo.sclr_code.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class EdgeInMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 3;
		int[][] B =	{  {1, 2, 2},
				       {1, 3, 2},
				       {2, 3, 3}
					};

		System.out.println(Arrays.toString(edgeInMst(A, B)));
	}
	
	public static int[] edgeInMst(int A, int[][] B) {
		ArrayList<PairOfNodeWeightIndex> listOfPair = new ArrayList<>(); 
		for(int i=0; i<B.length; i++) {
			int s=B[i][0]; 
			int d=B[i][1]; 
			int w=B[i][2];
			listOfPair.add(new PairOfNodeWeightIndex(s, d, w, i));
		}
		Collections.sort(listOfPair, new PairOfNodeWeightIndex());
		int[] parent = new int[A+1]; 
		for(int i=0; i<parent.length; i++) {
			parent[i] = i; 
		}
		int[] ans = new int[B.length]; 
		for(PairOfNodeWeightIndex pair : listOfPair) {
			if( union(pair.u, pair.v, parent) == true ) {
				ans[pair.indexPosition] = 1; 
			}
		}
		return ans;
	}

	
	public static boolean union(int s, int d, int[] parent) {
		int rootS = findRoot(s, parent); 
		int rootD = findRoot(d, parent); 
		if(rootS == rootD) return false;
		else {
			if(rootS<rootD) {
				parent[rootD] = rootS; 
			}else {
				parent[rootS] = rootD;
			}
		}
		return true;
	}
	
	public static int findRoot(int x, int[] parent) {
		if(parent[x] == x) return x; 
		parent[x] = findRoot(parent[x], parent);
		return parent[x]; 
	}
}



class PairOfNodeWeightIndex implements Comparator<PairOfNodeWeightIndex>{
	int u;
	int v;
	int w;
	int indexPosition; 
	public PairOfNodeWeightIndex() { }
	PairOfNodeWeightIndex(int u, int v, int w, int i){
		this.u = u; 
		this.v = v; 
		this.w = w;
		this.indexPosition = i;
	}
	
	@Override
	public String toString() {
		return "PNW ("+this.u+"->"+this.v+", "+w+")" ;
	}
	
	
	@Override
	public int compare(PairOfNodeWeightIndex o1, PairOfNodeWeightIndex o2) {
		// TODO Auto-generated method stub
		return o1.w - o2.w;
	}
	
}













