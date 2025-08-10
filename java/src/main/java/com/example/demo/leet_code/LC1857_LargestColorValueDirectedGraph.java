/**
 * 1857. Largest Color Value in a Directed Graph

There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in 
this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed 
edge from node aj to node bj.
A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from 
xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most 
frequently occurring color along that path.
Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

Example 1:
Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
Output: 3
Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).

Example 2:
Input: colors = "a", edges = [[0,0]]
Output: -1
Explanation: There is a cycle from 0 to 0.
 

Constraints:
n == colors.length
m == edges.length
1 <= n <= 105
0 <= m <= 105
colors consists of lowercase English letters.
0 <= aj, bj < n
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC1857_LargestColorValueDirectedGraph {

	public static void main(String[] args) {
		String colors = "abaca";
		int[][] edges = {{0,1}, {0,2}, {2,3}, {3,4}};
		
		System.out.println( largestPathValue1(colors, edges) );
		
	}
	
	// topological sort logic with color counting maintaining for each node 
    public static int largestPathValue1(String colors, int[][] edges) {
        int totalNode = colors.length();
        //graph + indegree details ready
        List<List<Integer>> graph = new ArrayList<>(totalNode);
        for(int i=0; i<totalNode; i++) {
        	graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[totalNode]; 
        for(int[] edge: edges) {
        	int u = edge[0], v = edge[1]; 
        	graph.get(u).add(v); 
        	inDegree[v] += 1; 
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++) {
        	if(inDegree[i] == 0) que.add(i); 
        }
        
        int[][] colorCountMatrix = new int[totalNode][26];
        int totalNodeCovered = 0;  //this to check cycle 
        int result = 0;
        while(!que.isEmpty()) {
        	int node = que.poll();
        	totalNodeCovered += 1; 
        	colorCountMatrix[node][colors.charAt(node)-'a'] += 1; 
        	
        	//here itself process the max after each node precessing 
        	result = Math.max(result, colorCountMatrix[node][colors.charAt(node)-'a']);
        	
        	for(int neighbor: graph.get(node)) {
        		inDegree[neighbor] -= 1; 
        		if(inDegree[neighbor] == 0) {
        			que.add(neighbor); 
        		}
        		
        		//for current neighbor update a-z value that are comig from its parent(parent can be multiple) 
        		for(int i=0; i<26; i++) {
        			colorCountMatrix[neighbor][i] = Math.max(colorCountMatrix[neighbor][i], 
        														colorCountMatrix[node][i]);
        		}
        	}
        	
        }
       
        return totalNodeCovered==totalNode? result: -1;
    }
    
}










