/**
 * 1020. Number of Enclaves

You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the 
boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Example 2:
Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
 */



package com.example.demo.leet_code;

import java.util.LinkedList;
import java.util.Queue;

import com.example.demo.leet_code.LC130_SurroundedRegions.Node;

public class LC1020_NumberOfEnclaves {

	public static void main(String[] args) {

	}
	
	
	public static int enclaves(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[0].length; j++) {
        		//top/bottom border
        		if(i==0 || i==grid.length-1) {
        			if(grid[i][j] == 1 && visited[i][j] != 1) {
        				BFS(new Node(i, j), grid, visited);
        			}
        		}
        		//left/right border
        		else if(j==0 || j==grid[0].length-1){
        			if(grid[i][j] == 1 && visited[i][j] != 1) {
        				BFS(new Node(i, j), grid, visited);
        			}
        		}
        	}
        }
        
        int result = 0;
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[0].length; j++) {
        		if(visited[i][j] == 0 && grid[i][j] ==1) {
        			result +=1; 
        		}
        	}
        }
        return result;
    }
	
	
	public static void BFS(Node node, int[][] grid, int[][] visited) {
		visited[node.i][node.j] = 1;
		Queue<Node> que = new LinkedList<Node>(); 
		que.add(node); 
		while(!que.isEmpty()) {
			node = que.poll();
			//vertically -  top check
			if(node.i != 0
					&& grid[node.i-1][node.j]==1
					&& visited[node.i-1][node.j] != 1) {
				visited[node.i-1][node.j] = 1; 
				que.add( new Node(node.i-1, node.j) );
			}
			//vertically - down check 
			if(node.i != grid.length-1 
					&& grid[node.i+1][node.j]==1
					&& visited[node.i+1][node.j] != 1) {
				visited[node.i+1][node.j] = 1;
				que.add(new Node(node.i+1, node.j));
			}
			
			
			//Hrizontally - left check 
			if(node.j != 0 
					&& grid[node.i][node.j-1]==1
					&& visited[node.i][node.j-1] != 1) {
				visited[node.i][node.j-1] = 1;
				que.add(new Node(node.i, node.j-1));
			}
			
			//Hrizontally - right check 
			if(node.j != grid[0].length-1 
					&& grid[node.i][node.j+1]==1
					&& visited[node.i][node.j+1] != 1) {
				visited[node.i][node.j+1] = 1; 
				que.add( new Node(node.i, node.j+1));
			}
		}
	}
	
	
	static class Node{
		int i; 
		int j; 
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
}
