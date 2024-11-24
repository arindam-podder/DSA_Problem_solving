/**
 * 200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */

//use graph traversal technique to check connected ones , like provinces questions (LC547_NumberOfProvinces)

package com.example.demo.leet_code;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Git;

public class LC200_NumberOfIslands {
	
	static class Node{
		int i;
		int j;
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	

	public static void main(String[] args) {
		char[][] grid = {
		                 {'1','1','1'},
		                 {'0','1','0'},
		                 {'1','1','1'}
						};
		
		System.out.println( totalNumIslands(grid) );
	}
	
	public static int totalNumIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int totalIsland = 0; 
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[0].length; j++) {
        		if(grid[i][j] == '1' && visited[i][j] != 1) {
        			totalIsland += 1; 
        			BFS(new Node(i, j), grid, visited);
        		}
        	}
        }
        
        return totalIsland;
    }
	

	//(horizontally or vertically.) top down left right 
	public static void BFS(Node node, char[][] grid, int[][] visited) {
		visited[node.i][node.j] = 1;
		Queue<Node> que = new LinkedList<Node>(); 
		que.add(node); 
		while(!que.isEmpty()) {
			node = que.poll();
			//vertically -  top check
			if(node.i != 0
					&& grid[node.i-1][node.j]=='1'
					&& visited[node.i-1][node.j] != 1) {
				visited[node.i-1][node.j] = 1; 
				que.add( new Node(node.i-1, node.j) );
			}
			//vertically - down check 
			if(node.i != grid.length-1 
					&& grid[node.i+1][node.j]=='1'
					&& visited[node.i+1][node.j] != 1) {
				visited[node.i+1][node.j] = 1;
				que.add(new Node(node.i+1, node.j));
			}
			
			
			//Hrizontally - left check 
			if(node.j != 0 
					&& grid[node.i][node.j-1]=='1'
					&& visited[node.i][node.j-1] != 1) {
				visited[node.i][node.j-1] = 1;
				que.add(new Node(node.i, node.j-1));
			}
			
			//Hrizontally - right check 
			if(node.j != grid[0].length-1 
					&& grid[node.i][node.j+1]=='1' 
					&& visited[node.i][node.j+1] != 1) {
				visited[node.i][node.j+1] = 1; 
				que.add( new Node(node.i, node.j+1));
			}
			
		}
		
	}

	
	
	
}

















