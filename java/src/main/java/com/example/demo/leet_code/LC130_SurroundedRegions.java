/**
 * 130. Surrounded Regions

You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the 
region cells are on the edge of the board.
A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.

 

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation:
In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:
Input: board = [["X"]]
Output: [["X"]]

 
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */



package com.example.demo.leet_code;

import java.util.LinkedList;
import java.util.Queue;


public class LC130_SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//idea DFS/BFS - Zeros that can not be captured , marked them and apart from this all should be X
	public static void update(char[][] board) {
        int[][] visited = new int[board.length][board[0].length]; 
        //check for border ZERO and pass to BFS
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++ ) {
        		//top/bottom border
        		if(i==0 || i==board.length-1) {
        			if(board[i][j] == 'O' && visited[i][j] != 1) {
        				BFS(new Node(i, j), board, visited);
        			}
        		}
        		//left/right border
        		else if(j==0 || j==board[0].length-1){
        			if(board[i][j] == 'O' && visited[i][j] != 1) {
        				BFS(new Node(i, j), board, visited);
        			}
        		}
        		
        	}
        }
        
        
       //check unvisted one and mark them 'X'
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++ ) {
        		if(visited[i][j] == 0) {
        			board[i][j] = 'X';
        		}
        	}
        }
        
    }
	
	public static void BFS(Node node, char[][] grid, int[][] visited) {
		visited[node.i][node.j] = 1;
		Queue<Node> que = new LinkedList<Node>(); 
		que.add(node); 
		while(!que.isEmpty()) {
			node = que.poll();
			//vertically -  top check
			if(node.i != 0
					&& grid[node.i-1][node.j]=='O'
					&& visited[node.i-1][node.j] != 1) {
				visited[node.i-1][node.j] = 1; 
				que.add( new Node(node.i-1, node.j) );
			}
			//vertically - down check 
			if(node.i != grid.length-1 
					&& grid[node.i+1][node.j]=='O'
					&& visited[node.i+1][node.j] != 1) {
				visited[node.i+1][node.j] = 1;
				que.add(new Node(node.i+1, node.j));
			}
			
			
			//Hrizontally - left check 
			if(node.j != 0 
					&& grid[node.i][node.j-1]=='O'
					&& visited[node.i][node.j-1] != 1) {
				visited[node.i][node.j-1] = 1;
				que.add(new Node(node.i, node.j-1));
			}
			
			//Hrizontally - right check 
			if(node.j != grid[0].length-1 
					&& grid[node.i][node.j+1]=='O' 
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
