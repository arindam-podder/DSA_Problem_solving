package com.example.demo.mypractice.graph;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GraphUtil {


	public static List<List<Integer>> getAdjacentListForUndirected(int nodes,int[][] edges){
		List<List<Integer>> adjaList = new ArrayList<>();
		//initialize lists 
		for(int i=0; i<nodes; i++) adjaList.add(new ArrayList<>());
		for(int[] e: edges) {
			int u=e[0], v=e[1];
			adjaList.get(u).add(v);
			adjaList.get(v).add(u);
		}
		return adjaList;
	}
	
	public static List<List<Integer>> getAdjacentListForDirected(int nodes,int[][] edges){
		List<List<Integer>> adjaList = new ArrayList<>();
		//initialize lists 
		for(int i=0; i<nodes; i++) adjaList.add(new ArrayList<>());
		for(int[] e: edges) {
			int u=e[0], v=e[1];
			adjaList.get(u).add(v);
		}
		return adjaList;
	}
	
	
	public static class VertexPair {
		public int vertex; 
		public int parent; 
		
		public VertexPair(int v, int p) {
			this.vertex = v; 
			this.parent = p;
		}
	}
	
}
