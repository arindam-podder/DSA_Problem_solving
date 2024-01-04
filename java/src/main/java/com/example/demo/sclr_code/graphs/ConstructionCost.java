/*
 * Q1. Construction Cost

Problem Description
Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all 
the edges in the graph. Find the minimum cost of constructing the graph by selecting some given edges such that
we can reach every other node from the 1st node.

NOTE: Return the answer modulo 109+7 as the answer can be large.

Problem Constraints
1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 109

Input Format
First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]

Output Format
Return an integer denoting the minimum construction cost.

Example Input
Input 1:
A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]
Input 2:
A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]


Example Output
Output 1:
9
Output 2:
37

Example Explanation
Explanation 1:
We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph. 
we can reach the 1st node from 2nd and 3rd node using only these two edges.
So, the total cost of costruction is 9.
Explanation 2:
We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.
 */

package com.example.demo.sclr_code.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ConstructionCost {

	public static void main(String[] args) {
		int A = 3;
		int[][] B = {   {1, 2, 14},
				        {2, 3, 7},
				        {3, 1, 2}   };
		
		System.out.println(minCostByKruskalAlgo(A, B));
	}

	
	public static int minCostByKruskalAlgo(int A, int[][] B) {
		ArrayList<PairOfNodeWeight> listOfPair = new ArrayList<>(); 
		for(int i=0; i<B.length; i++) {
			int s=B[i][0];
			int d=B[i][1];
			int c=B[i][2]; 
			listOfPair.add(new PairOfNodeWeight(s, d, c));
			listOfPair.add(new PairOfNodeWeight(d, s, c));
		}
		Collections.sort(listOfPair, new PairOfNodeWeight());
		int[] parent = new int[A+1];
		long ans = 0; 
		for(int i=0; i<parent.length; i++) {
			parent[i] = i; 
		}
		for(PairOfNodeWeight pair: listOfPair) {
			int s=pair.u;
			int d=pair.v; 
			int w=pair.w;
			if(union(s, d, parent) == true) {
				ans += w;
			}
		}
		return (int)ans; 
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



class PairOfNodeWeight implements Comparator<PairOfNodeWeight>{
	int u;
	int v;
	int w;
	public PairOfNodeWeight() { }
	PairOfNodeWeight(int u, int v, int w){
		this.u = u; 
		this.v = v; 
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "PNW ("+this.u+"->"+this.v+", "+w+")" ;
	}
	
	
	@Override
	public int compare(PairOfNodeWeight o1, PairOfNodeWeight o2) {
		// TODO Auto-generated method stub
		return o1.w - o2.w;
	}
	
}






