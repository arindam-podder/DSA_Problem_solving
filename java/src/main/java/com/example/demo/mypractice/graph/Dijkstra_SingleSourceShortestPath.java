package com.example.demo.mypractice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.example.demo.mypractice.graph.Dijkstra_SingleSourceShortestPath.NodeWeight;

public class Dijkstra_SingleSourceShortestPath {
	public static void main(String[] args) {
		int nodes = 5; 
		int[][] edges = {{0,1,5}, {0,3,2}, {1,2,1}, {1,4,1}, {2,3,3}, {3,4,2} };
		int source = 0; 
			
		System.out.println( Arrays.toString(dijkstraSSP(nodes, edges, source)) );
	}
	
	
	/*
	 * use NodeWight class to build graph  
	 * PriorityQue<NodeWight>
	 * distance array 
	 */
	public static int[] dijkstraSSP(int nodes, int[][] edges, int source) {
		List<List<NodeWeight>> graph = getGraph(nodes, edges);
		int[] distance = new int[nodes]; 
		Arrays.fill(distance, -1);
		PriorityQueue<NodeWeight> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
		pq.add(new NodeWeight(source, 0));
		while(!pq.isEmpty()) {
			NodeWeight nodeWeight = pq.poll();
			//distace update part
			if(distance[nodeWeight.node] == -1 || distance[nodeWeight.node]>nodeWeight.weight ) {
				distance[nodeWeight.node] = nodeWeight.weight;
			}
			
			//neighbor traverse part 
			for(NodeWeight nbr: graph.get(nodeWeight.node)) {
				int child = nbr.node, nextDis = nbr.weight + nodeWeight.weight;
				if(distance[child] == -1 ) {
					pq.add(new NodeWeight(child, nextDis));
				}
			}
		}
		return distance;
	}
	
	
	public static List<List<NodeWeight>> getGraph(int nodes, int[][] edges) {
		List<List<NodeWeight>> graph = new ArrayList<>(); 
		//initialize inner list 
		for(int i=0; i<nodes; i++) graph.add(new ArrayList<NodeWeight>());
		
		for(int[] edge: edges) {
			int u=edge[0], v=edge[1], w=edge[2];
			graph.get(u).add(new NodeWeight(v, w)); 
			graph.get(v).add(new NodeWeight(u, w)); 
		}
		return graph;
	}
		
	static class NodeWeight{
		int node; 
		int weight; 
		public NodeWeight(int v, int w) {
			this.node = v; 
			this.weight = w;
		}
	}
	
}
