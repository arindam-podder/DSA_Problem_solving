/*
 * Q3. First Depth First Search  (Day 90 - Advanced DSA : Graphs 1: Introduction with BFS & DFS -- Wed, 25 Oct 2023)
Problem Description
You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
Given 2 towns find whether you can reach the first town from the second without repeating any edge.
B C : query to find whether B is reachable from C.
Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.

Problem Constraints
1 <= N <= 100000

Input Format
First argument is vector A
Second argument is integer B
Third argument is integer C

Output Format
Return 1 if reachable, 0 otherwise.

Example Input
Input 1:
 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:
 A = [1, 1, 2]
 B = 2
 C = 1

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:
 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
 */


package com.example.demo.sclr_code.graphs;

import java.util.ArrayList;

public class FirstDepthFirstSearch {
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 4}; 
		
		System.out.println(sourceToDestinationPossible(arr, 4, 1));
		
	}
	
	public static int sourceToDestinationPossible(int[] A, final int B, final int C) {
		//create a graph list 
		ArrayList<ArrayList<Integer>> graphList = new ArrayList<>(); 
		for(int i=0; i<A.length+1; i++) {
			graphList.add(new ArrayList<Integer>()); 
		}
		for(int i=1; i<A.length; i++) {
			graphList.get(A[i]).add(i+1); 
		}
		
		boolean[] visited = new boolean[A.length+1]; 
		dfs(C, graphList, visited);
		
		return visited[B] ? 1:0;
		 
	}
	
	
	public static void dfs(int source, ArrayList<ArrayList<Integer>> graphList, boolean[] visited) {
		if(visited[source] == true) {
			return;
		}
		visited[source] = true; 
		for(int i=0; i<graphList.get(source).size(); i++) {
			int child = graphList.get(source).get(i);
			if(visited[child] == false) {
				dfs(child, graphList, visited);
			}
		}
	}
}


















