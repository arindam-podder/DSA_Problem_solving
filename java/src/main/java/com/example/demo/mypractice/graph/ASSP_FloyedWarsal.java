/**
 * ASSP - all source shortest path 
 * intermediate node -> src -> dest
 */

package com.example.demo.mypractice.graph;

import java.util.Arrays;

public class ASSP_FloyedWarsal {
	public static void main(String[] args) {
		int n = 4;
		int[][] edges = {{0,1,5}, {0,2,7}, {2,3,2}, {3,1,3} };
	
		int[][] warsal = floyedWarsal(n, edges);
		for(int[] a : warsal ) System.out.println( Arrays.toString(a) );
	}
	
	public static int[][] floyedWarsal(int n, int[][] edges){
		int[][] distance = new int[n][n];
		for(int[] arr: distance) Arrays.fill(arr, Integer.MAX_VALUE);
		//initialize the distance 
		for(int i=0; i<n; i++) distance[i][i] = 0;
		for(int[] edg: edges) {
			int u=edg[0], v=edg[1], w=edg[2];
			distance[u][v] = w;
		}
		
		//for loop intermediate
		for(int inter=0; inter<n; inter++) {
			//for loop src 
			for(int src=0; src<n; src++) {
				//for loop dest
				for(int dest=0; dest<n; dest++) {
					int viaInter = Integer.MAX_VALUE;
					if(distance[src][inter] != Integer.MAX_VALUE && distance[inter][dest] != Integer.MAX_VALUE) 
							viaInter = distance[src][inter] + distance[inter][dest] ;
					if( viaInter < distance[src][dest]) distance[src][dest] = viaInter;
				}
			}
		}
		return distance;
	} 
}
