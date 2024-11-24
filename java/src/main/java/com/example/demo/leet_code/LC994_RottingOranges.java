/**
 * 994. Rotting Oranges
 * 
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 
Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 */



package com.example.demo.leet_code;

import java.util.LinkedList;
import java.util.Queue;

import com.example.demo.leet_code.LC200_NumberOfIslands.Node;

public class LC994_RottingOranges {

	public static void main(String[] args) {

	}
	
	
	//use simple BFS grpah technique with level order technique 
	public static int orangesRottingUsingBFS(int[][] grid) {
        Queue<Node> que = new LinkedList<>(); 
        //get all the rotten first
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[0].length; j++) {
        		if(grid[i][j] == 2) que.add(new Node(i, j));
        	}
        }
        
        int result = 0; 
        while(!que.isEmpty()) {
        	Boolean freshGotRotten = false; 
        	int curQueSize = que.size(); 
        	for(int i=0; i<curQueSize; i++) {
        		Node node = que.poll();
        		
        		//vertically -  top check
    			if(node.i != 0 && grid[node.i-1][node.j] == 1 ) {
    				grid[node.i-1][node.j] = 2;  //make rotten	 
    				freshGotRotten = true;
    				que.add( new Node(node.i-1, node.j) );
    			}
    			//vertically - down check 
    			if(node.i != grid.length-1 && grid[node.i+1][node.j] == 1) {
    				grid[node.i+1][node.j] = 2;
    				freshGotRotten = true;
    				que.add(new Node(node.i+1, node.j));
    			}
    			
    			
    			//Hrizontally - left check 
    			if(node.j != 0 && grid[node.i][node.j-1]==1) {
    				grid[node.i][node.j-1] = 2;
    				freshGotRotten = true;
    				que.add(new Node(node.i, node.j-1));
    			}
    			
    			//Hrizontally - right check 
    			if(node.j != grid[0].length-1 && grid[node.i][node.j+1]== 1 ) {
    				grid[node.i][node.j+1] = 2; 
    				freshGotRotten = true;
    				que.add( new Node(node.i, node.j+1));
    			}
        	}
        	if(freshGotRotten) result += 1;
        	
        }//while end
        
        //check any 1 left 
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[0].length; j++) {
        		if(grid[i][j] == 1) return -1;
        	}
        }
        
        return result;
        
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



















