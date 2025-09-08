/**
 * 787. Cheapest Flights Within K Stops

There are n cities connected by some number of flights. You are given an array flights where 
flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. 
If there is no such route, return -1.


Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

Example 2:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

Example 3:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 

Constraints:
1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC787_CheapestFlightsWithinKStops {

	public static void main(String[] args) {
//		int n = 4, flights[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}}, src = 0, dst = 3, k = 1;
		
		int n = 17, src =13, dst = 4, k = 13;
		int[][] flights = {{0,12,28},{5,6,39},{8,6,59},{13,15,7},{13,12,38},{10,12,35},{15,3,23},{7,11,26},{9,4,65},{10,2,38},{4,7,7},{14,15,31},{2,12,44},{8,10,34},{13,6,29},{5,14,89},{11,16,13},{7,3,46},{10,15,19},{12,4,58},{13,16,11},{16,4,76},{2,0,12},{15,0,22},{16,12,13},{7,1,29},{7,14,100},{16,1,14},{9,6,74},{11,1,73},{2,11,60},{10,11,85},{2,5,49},{3,4,17},{4,9,77},{16,3,47},{15,6,78},{14,1,90},{10,5,95},{1,11,30},{11,0,37},{10,4,86},{0,8,57},{6,14,68},{16,8,3},{13,0,65},{2,13,6},{5,13,5},{8,11,31},{6,10,20},{6,2,33},{9,1,3},{14,9,58},{12,3,19},{11,2,74},{12,14,48},{16,11,100},{3,12,38},{12,13,77},{10,9,99},{15,13,98},{15,12,71},{1,4,28},{7,0,83},{3,5,100},{8,9,14},{15,11,57},{3,6,65},{1,3,45},{14,7,74},{2,10,39},{4,8,73},{13,5,77},{10,0,43},{12,9,92},{8,2,26},{1,7,7},{9,12,10},{13,11,64},{8,13,80},{6,12,74},{9,7,35},{0,15,48},{3,7,87},{16,9,42},{5,16,64},{4,5,65},{15,14,70},{12,0,13},{16,14,52},{3,10,80},{14,11,85},{15,2,77},{4,11,19},{2,7,49},{10,7,78},{14,6,84},{13,7,50},{11,6,75},{5,10,46},{13,8,43},{9,10,49},{7,12,64},{0,10,76},{5,9,77},{8,3,28},{11,9,28},{12,16,87},{12,6,24},{9,15,94},{5,7,77},{4,10,18},{7,2,11},{9,5,41}};
		
		
		System.out.println( findCheapestPrice2(n, flights, src, dst, k) );
	}
	
	//for k stop level order and cheap dijkstra logic , it is combined logic 
    public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
    	List<List<int[]>> graph = getGraph(n, flights);
    	int destinationPrice = Integer.MAX_VALUE;
    	//que contaions int[3] -> node, price, stopCnt
    	Queue<int[]> que = new LinkedList<>();
    	que.add(new int[] {src, 0, 0});
    	while(!que.isEmpty()) {
    		int curSize = que.size(); 
    		for(int i=0; i<curSize; i++) {
    			int[] arr = que.poll();
    			int node = arr[0], price = arr[1], stop = arr[2];
    			for(int[] nbr: graph.get(node)) {
    				int nbrPrice = price + nbr[1], nbrStopCnt = stop + 1;
    				if(nbr[0] == dst && nbrStopCnt <= k+1) {
    					destinationPrice = Math.min(destinationPrice, nbrPrice);
    				}else if(nbrStopCnt <= k) {
    					que.add(new int[] {nbr[0], nbrPrice, nbrStopCnt});
    				}
    			}
    		}	
    	}//while end
 
    	if(destinationPrice != Integer.MAX_VALUE) {
    		return destinationPrice;
    	}
    	return -1;
    }
    
    //use dijktra PriorityQue and node per stop array arr[node][stopt]
    public static int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
    	List<List<int[]>> graph = getGraph(n, flights);
    	Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
    	pq.add(new int[] {src, 0, 0});	//arr -> node, price, stop
    	
    	int[][] nodeStop = new int[n][k+2];
    	for(int[] arr: nodeStop) Arrays.fill(arr, Integer.MAX_VALUE);
    	nodeStop[src][0] = 0; 
    	
    	while(!pq.isEmpty()) {
    		int[] arr = pq.poll();
    		int node = arr[0];
    		int price = arr[1]; 
    		int stop = arr[2];
    		
    		if(node == dst) return price; 	//dijktra pq always be minimum
    		if(stop == k+1) continue; 	//no more edge allowed 
    		
    		for(int[] nbr: graph.get(node)) {
    			int v = nbr[0]; 
    			int nc = price + nbr[1]; 
    			int ns = stop + 1;
    			if(nc < nodeStop[v][ns]) {
    				nodeStop[v][ns] = nc;
    				pq.add(new int[] {v, nc, ns});
    			}
    		}
    		
    	}
    	return -1;
    	
    }
    
    
    public static List<List<int[]>> getGraph(int n, int[][] flights) {
    	List<List<int[]>> graph = new ArrayList<>();
    	for(int i=0; i<n; i++) graph.add(new ArrayList<>()); 
    	for(int[] arr: flights) {
    		int u = arr[0], v= arr[1], price = arr[2]; 
    		graph.get(u).add(new int[] {v, price});
    	}
    	return graph;
    }

}
