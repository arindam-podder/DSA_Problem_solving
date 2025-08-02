/**
 * 2360. Longest Cycle in a Graph

You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from 
node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.
Return the length of the longest cycle in the graph. If no cycle exists, return -1.
A cycle is a path that starts and ends at the same node.
 
Example 1:
Input: edges = [3,3,4,2,3]
Output: 3
Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
The length of this cycle is 3, so 3 is returned.

Example 2:
Input: edges = [2,-1,3,1]
Output: -1
Explanation: There are no cycles in this graph.
 

Constraints:
n == edges.length
2 <= n <= 105
-1 <= edges[i] < n
edges[i] != i
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC2360_LongestCycleInGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] edges = {3,3,4,2,3};	//0->3, 1->3, 2->4, 3->2, 4->3
		
		System.out.println( longestCycle1(edges) );
	}
	
	
    public static int longestCycle1(int[] edges) {
    	int[] visited = new int[edges.length];
        //List<Integer> path = new ArrayList<>();
        Map<Integer, Integer> path = new HashMap<>();
        int longestCycle = -1;
        for(int vertex=0; vertex<edges.length; vertex++){
            if(visited[vertex] == 0){
                longestCycle = Math.max(longestCycle,  DFS(vertex, edges, visited, path));
            }
        }
        return longestCycle;
    	
    	
    }

    //TLE 
    public static int DFS(int vertex, int[] graph, int[] visited, List<Integer> path) {
    	visited[vertex] = 1;
        path.add(vertex);

        int cycle = -1;
        int neighbor = graph[vertex];
        if(path.contains(neighbor)){
            cycle = path.size() - path.indexOf(neighbor);
        }else if(neighbor != -1 && visited[neighbor] == 0){
            cycle = DFS(neighbor, graph, visited, path);
        }
        path.remove(path.size()-1);
        return cycle;
    }
    
    // using map as path, instead of list , success 
    public static int DFS(int vertex, int[] graph, int[] visited, Map<Integer, Integer> path) {
    	visited[vertex] = 1; 
    	path.put(vertex, path.size()+1);
    	
    	int circleLen = -1; 
    	
    	//if neighbor already in path
    	int neighbor = graph[vertex];
    	if(path.containsKey(neighbor) ) {
    		circleLen = path.get(vertex) - path.get(neighbor) + 1;
    	}else if(neighbor != -1 && visited[neighbor] == 0) {
    		circleLen = DFS(neighbor, graph, visited, path);
    	}
    	path.remove(vertex);
    	return circleLen;
    }
    
}
