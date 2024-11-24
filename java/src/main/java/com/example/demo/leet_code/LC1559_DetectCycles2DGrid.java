/**
 * 1559. Detect Cycles in 2D Grid

Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the 
same value in grid. A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, 
you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), 
if it has the same value of the current cell. Also, you cannot move to the cell that you visited in your last move. 
For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
Return true if any cycle of the same value exists in grid, otherwise, return false.

Example 1:
Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
Output: true
Explanation: There are two valid cycles shown in different colors in the image below:

Example 2:
Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
Output: true
Explanation: There is only one valid cycle highlighted in the image below:

Example 3:
Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
Output: false
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid consists only of lowercase English letters.
 */




package com.example.demo.leet_code;

import java.util.LinkedList;
import java.util.Queue;

public class LC1559_DetectCycles2DGrid {

	public static void main(String[] args) {
		char[][] grid = {
							{'a','b','b','b'},
							{'x','b','c','a'},
							{'a','a','c','a'}
						};
		
		System.out.println( detectCycle(grid) );
		
	}
	
	
	public static boolean detectCycle(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[0].length; j++) {
        		if(visited[i][j] != 1 ) {
        			 //boolean bfs = BFS(new Node(i, j, new Node(-1, -1, null)), grid, visited);
        			boolean dfs = BFS(new Node(i, j, new Node(-1, -1, null)), grid, visited); 
        			if(dfs == true) {
        				 return true;
        			 }
        		}
        	}
        }
        return false;
		
    }
	
	
	//approch , at node V, where u is not a parent and already visited then  it is cycle 
	public static boolean BFS(Node node, char[][] grid, int[][] visited) {
		visited[node.i][node.j] = 1;
		Queue<Node> que = new LinkedList<>(); 
		que.add(node);
		while(!que.isEmpty()) {
			node = que.poll();
			
			//top check 
			if( node.i != 0 
					&& (node.parent.i!=node.i-1 || node.parent.j!=node.j) 
					&& grid[node.i][node.j] == grid[node.i-1][node.j]) {
				if( visited[node.i-1][node.j] != 1) {
					visited[node.i-1][node.j] = 1; 
					que.add(new Node(node.i-1, node.j, node));
				}
				else{
					return true; 
				}
			}
					
			//bottom chcek 
			if( node.i != grid.length-1 
					&& (node.parent.i!=node.i+1 || node.parent.j!=node.j) 
					&& grid[node.i][node.j] == grid[node.i+1][node.j]) {
				if( visited[node.i+1][node.j] != 1) {
					visited[node.i+1][node.j] = 1; 
					que.add(new Node(node.i+1, node.j, node));
				}
				else{
					return true; 
				}
			}
			
			
			//left check 
			if( node.j != 0 
					&& (node.parent.i!=node.i || node.parent.j!=node.j-1) 
					&& grid[node.i][node.j] == grid[node.i][node.j-1]) {
				if( visited[node.i][node.j-1] != 1) {
					visited[node.i][node.j-1] = 1; 
					que.add(new Node(node.i, node.j-1, node));
				}
				else{
					return true; 
				}
			}
			
			
			//right check 
			if( node.j != grid[0].length-1
					&& (node.parent.i!=node.i || node.parent.j!=node.j+1) 
					&& grid[node.i][node.j] == grid[node.i][node.j+1]) {
				if( visited[node.i][node.j+1] != 1) {
					visited[node.i][node.j+1] = 1; 
					que.add(new Node(node.i, node.j+1, node));
				}
				else{
					return true; 
				}
			}
			
			
			
		}//while end
		
		return false;
	}
	
	
	public static boolean DFS(Node node, char[][] grid, int[][] visited) {
		//top check 
		if( node.i != 0 
				&& (node.parent.i!=node.i-1 || node.parent.j!=node.j) 
				&& grid[node.i][node.j] == grid[node.i-1][node.j]) {
			if( visited[node.i-1][node.j] != 1) {
				visited[node.i-1][node.j] = 1; 
				DFS(new Node(node.i-1, node.j, node), grid, visited);
			}
			else{
				return true; 
			}
		}
				
		//bottom chcek 
		if( node.i != grid.length-1 
				&& (node.parent.i!=node.i+1 || node.parent.j!=node.j) 
				&& grid[node.i][node.j] == grid[node.i+1][node.j]) {
			if( visited[node.i+1][node.j] != 1) {
				visited[node.i+1][node.j] = 1; 
				DFS(new Node(node.i+1, node.j, node), grid, visited);
			}
			else{
				return true; 
			}
		}
		
		
		//left check 
		if( node.j != 0 
				&& (node.parent.i!=node.i || node.parent.j!=node.j-1) 
				&& grid[node.i][node.j] == grid[node.i][node.j-1]) {
			if( visited[node.i][node.j-1] != 1) {
				visited[node.i][node.j-1] = 1; 
				DFS(new Node(node.i, node.j-1, node), grid, visited);
			}
			else{
				return true; 
			}
		}
		
		
		//right check 
		if( node.j != grid[0].length-1
				&& (node.parent.i!=node.i || node.parent.j!=node.j+1) 
				&& grid[node.i][node.j] == grid[node.i][node.j+1]) {
			if( visited[node.i][node.j+1] != 1) {
				visited[node.i][node.j+1] = 1; 
				DFS(new Node(node.i, node.j+1, node), grid, visited);
			}
			else{
				return true; 
			}
		}
		
		return false;
	}
	
	
	static class Node{
		int i; 
		int j;
		Node parent;
		public Node(int i, int j, Node parent) {
			this.i = i; 
			this.j = j;
			this.parent = parent;
		}
	}
	
}


























