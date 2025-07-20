package com.example.demo.mypractice.graph;

import java.util.ArrayList;
import java.util.List;

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
	
}
