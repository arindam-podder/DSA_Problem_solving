/**
 * 743. Network Delay Time

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as 
directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time 
it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. 
If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:
1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC743_NetworkDelayTime {

	public static void main(String[] args) {
		//int times[][] = {{1,2,1}}, n = 2, k = 2; 
		//int times[][] = {{2,1,1}, {2,3,1}, {3,4,1}}, n = 4, k = 2;
		//int times[][] = {{1,2,1}, {2,1,3}}, n = 2, k = 2;
		int times[][] = {{1,2,1}, {2,3,2}, {1,3,4}}, n=3, k=1;
		
		System.out.println( networkDelayTime1(times, n, k) );
	}
	
    public static int networkDelayTime1(int[][] times, int n, int k) {
        return dijktraAlgo(times, n, k);
        //return bellamanFordAlgo(times, n, k);
    }
    
    
    public static int dijktraAlgo(int[][] times, int n, int k) { //wrong
    	List<List<int[]>> graph = getGraph(n, times);
    	int[] time = new int[n+1];
    	Arrays.fill(time, Integer.MAX_VALUE);
    	PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));	//arr -> node, time
    	pq.add(new int[] {k, 0});
    	time[k] = 0;
    	int result = 0;
    	int traversNode = 0;
    	while(!pq.isEmpty()) {
    		int[] arr = pq.poll();
    		int node = arr[0], delayTime = arr[1];
    		traversNode += 1;
    		for(int[] nbr: graph.get(node)) {
    			int nbrNode = nbr[0], nbrTime = nbr[1]; 
    			int nextTime = delayTime + nbrTime; 
    			if(nextTime < time[nbrNode]) {
    				pq.add(new int[] {nbrNode, nextTime});
    				time[nbrNode] = nextTime; 
    				result = Math.max(result, nextTime);
    			}
    		}
    	}
    	
    	if(traversNode == n ) return result; 
    	return -1;
    	
    }
    
    public static int bellamanFordAlgo(int[][] times, int n, int k) {
    	return 0;
    }
    
    // node 1-n 
    public static List<List<int[]>> getGraph(int n, int[][] times){
    	List<List<int[]>> graph = new ArrayList<>();
    	for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
    	for(int[] t: times) {
    		int u=t[0], v=t[1], w=t[2];
    		graph.get(u).add(new int[] {v, w});
    	}
    	return graph;
    }

}
