package com.example.demo.mypractice.graph;

import java.util.Arrays;

public class BelamanFordAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nodeCount = 4;
		//int[][] edges = {{1,2,2}, {1,3,4}, {3,4,3}, {4,2,6} }; 
		int[][] edges = {{1,2,2}, {1,3,4}, {3,4,3}, {4,2,6}, {2,3,-3} };
		int src = 1;
		
		belamanFordAlgo(nodeCount, edges, src);
	}
	
	public static void belamanFordAlgo(int n, int[][] edges, int src) {
		int[] dist = new int[n+1]; 
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0; 
		//traverse all edges for n-1
		for(int i=0; i<n; i++){
			//edges traverse
			for(int[] edge: edges) {
				 int u=edge[0], v=edge[1], w=edge[2]; 
				 int nbrDis = dist[u] + w; 
				
				 if(dist[u] == Integer.MAX_VALUE) continue;
				 
				 if(nbrDis < dist[v]) {
					 dist[v] = nbrDis;
				 }
				 
			}
		}
		
		//negetive cycle 
		for(int[] edge: edges) {
			 int u=edge[0], v=edge[1], w=edge[2]; 
			 int nbrDis = dist[u] + w; 
			 if(nbrDis < dist[v]) {
				 //dist[v] = nbrDis;
				 System.out.println( "negetive cycle : "+ Arrays.toString(new int[] {-1})  );
				 return;
			 }
		}
		
		
		System.err.println(Arrays.toString( dist ));
	}
	

}




