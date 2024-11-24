/**
 * 547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, 
and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are 
directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.


Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 
Constraints:
1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */




package com.example.demo.leet_code;

import java.util.*;

public class LC547_NumberOfProvinces {

	public static void main(String[] args) {
		
	}
	
	
	public static int findTotalProvinces(int[][] isConnected) {
		//create adjacentList from isConnected data || we are performing operation on ZERO-based node value 
		List<List<Integer>> adjacent = new ArrayList<>();
		for(int i=0; i<isConnected.length; i++) {
			adjacent.add(new ArrayList<>());
		}
		for(int i=0; i<isConnected.length; i++) {
			for(int j=0; j<isConnected[0].length; j++) {
				if(isConnected[i][j] == 1) {
					adjacent.get(i).add(j); 
				}
			}
		}
		int[] visited = new int[isConnected.length];
		
		//traverse the nodes 0-n and check how many times DFS is called 
		int count = 0; 
		for(int node=0; node<isConnected.length; node++) {
			if(visited[node] != 1) {
				count++; 
				//DFS(node, adjacent, visited);
				BFS(node, adjacent, visited);
			}
		}
        
		return count;
    }
	
	
	public static void DFS(int node, List<List<Integer>> adjacent, int[] visited) {
		visited[node] = 1; 
		List<Integer> listOfNeighbour = adjacent.get(node);
		for(int neighbour : listOfNeighbour) {
			if(visited[neighbour] != 1) DFS(neighbour, adjacent, visited);
		}
	}
	
	
	public static void BFS(int node, List<List<Integer>> adjacent, int[] visited) {
		visited[node] = 1; 
		Queue<Integer> que = new LinkedList<>();
		que.add(node); 
		while(!que.isEmpty()) {
			int n = que.poll();
			List<Integer> listOfNeighbour = adjacent.get(n);
			for(int neighbour : listOfNeighbour) {
				if(visited[neighbour] != 1) {
					visited[neighbour] = 1; 
					que.add(neighbour);
				}
			}
		}
	}

}















