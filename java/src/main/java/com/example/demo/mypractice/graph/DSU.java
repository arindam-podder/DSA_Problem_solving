package com.example.demo.mypractice.graph;

import lombok.Data;

@Data
public class DSU {

	private int[] rank;
	private int[] parent;
	
	public DSU(int v) {
		rank = new int[v]; 	// initially rank of all is 0 
		parent = new int[v]; 
		for(int i=0; i<v; i++) parent[i] = i; 
	}
	

	public int[] getRank() {
		return rank;
	}
	public void setRank(int[] rank) {
		this.rank = rank;
	}

	public int[] getParent() {
		return parent;
	}
	public void setParent(int[] parent) {
		this.parent = parent;
	}



	public int findParent(int node) {
		if(parent[node] == node) return node;
		parent[node] = findParent(parent[node]);		//path compression 
		return parent[node];
	}
	
	//union by rank rule applied
	public void union(int x, int y) {
		int parent_X = findParent(x);
		int parent_Y = findParent(y);
		if(parent_X != parent_Y) {
			if(rank[parent_X] < rank[parent_Y]) {
				parent[parent_X] = parent_Y;
			}else if(rank[parent_Y] < rank[parent_X]) {
				parent[parent_Y] = parent_X;
			}else {
				parent[parent_Y] = parent_X;
				rank[parent_X] += 1;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
