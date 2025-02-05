/**
 * 2258. Escape the Spreading Fire

You are given a 0-indexed 2D integer array grid of size m x n which represents a field. 
Each cell has one of three values:
0 represents grass,
1 represents fire,
2 represents a wall that you and fire cannot pass through.
You are situated in the top-left cell, (0, 0), and you want to travel to the safehouse at the bottom-right cell,
(m - 1, n - 1). Every minute, you may move to an adjacent grass cell. After your move, every fire cell will 
spread to all adjacent cells that are not walls.

Return the maximum number of minutes that you can stay in your initial position before moving while still safely 
reaching the safehouse. If this is impossible, return -1. If you can always reach the safehouse regardless of the 
minutes stayed, return 109.

Note that even if the fire spreads to the safehouse immediately after you have reached it, it will be counted as 
safely reaching the safehouse.

A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter 
(i.e., their sides are touching).

 

Example 1:
Input: grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]
Output: 3
Explanation: The figure above shows the scenario where you stay in the initial position for 3 minutes.
You will still be able to safely reach the safehouse.
Staying for more than 3 minutes will not allow you to safely reach the safehouse.

Example 2:
Input: grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
Output: -1
Explanation: The figure above shows the scenario where you immediately move towards the safehouse.
Fire will spread to any cell you move towards and it is impossible to safely reach the safehouse.
Thus, -1 is returned.

Example 3:
Input: grid = [[0,0,0],[2,2,0],[1,2,0]]
Output: 1000000000
Explanation: The figure above shows the initial grid.
Notice that the fire is contained by walls and you will always be able to safely reach the safehouse.
Thus, 109 is returned.
 

Constraints:
m == grid.length
n == grid[i].length
2 <= m, n <= 300
4 <= m * n <= 2 * 104
grid[i][j] is either 0, 1, or 2.
grid[0][0] == grid[m - 1][n - 1] == 0

 */



package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC2258_EscapeSpreadingFire {

	public static void main(String[] args) {
//		int[][] grid = {
//						{0, 2, 0, 0, 0, 0, 0},
//						{0, 0, 0, 2, 2, 1, 0},
//						{0, 2, 0, 0, 1, 2, 0},
//						{0, 0, 2, 2, 2, 0, 2},
//						{0, 0, 0, 0, 0, 0, 0}
//					};
		
		int[][] grid = {
					{0,2,0,0,1},
					{0,2,0,2,2},
					{0,2,0,0,0},
					{0,0,2,2,0},
					{0,0,0,0,0}
				};
		
		System.out.println( getMaximumMinutes(grid) );
		
	}
	
	public static int getMaximumMinutes(int[][] grid) {
        int[][] fire = bfsSpreadingFire(grid);
        for(int[] arr : fire) System.out.println( Arrays.toString(arr));
        int result = -1; 
        int left = 0; 
        int right = 1000000000;
        while(left <= right) {
        	int mid = (left + right)/2; 
        	if(bfsManMove(mid, fire, grid)) {
        		result = mid; 
        		left = mid + 1;
        	}else {
        		right = mid-1;
        	}
        }
        
    
        
        return result;
    }
	
	
	public static int[][] bfsSpreadingFire(int[][] grid){
		int[][] result = new int[grid.length][grid[0].length];
		for(int[] arr: result) Arrays.fill(arr, -1);
		
		//first add all the fire cells to a queue
		Queue<Cell> que = new LinkedList();
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					que.add(new Cell(i, j));
				}
			}
		}
		
		
		//now perofmn BFS , spread the fire
		int distance = 0; 
		while(!que.isEmpty()) {
			int curQueSize = que.size(); 
			for(int i=0; i<curQueSize; i++) {
				Cell popCell = que.poll();
				result[popCell.row][popCell.col] = distance;
				//now add the neighbour 
				//vertically - up 
				if(popCell.row!= 0 
					&& grid[popCell.row-1][popCell.col] == 0 
					&& result[popCell.row-1][popCell.col] == -1) {
					que.add(new Cell(popCell.row-1, popCell.col));
				}
				//vertically - down
				if(popCell.row!= grid.length-1 
						&& grid[popCell.row+1][popCell.col] == 0 
						&& result[popCell.row+1][popCell.col] == -1) {
						que.add(new Cell(popCell.row+1, popCell.col));
				}
				// horizontally - left 
				if(popCell.col != 0 
						&& grid[popCell.row][popCell.col-1] == 0 
						&& result[popCell.row][popCell.col-1] == -1) {
						que.add(new Cell(popCell.row, popCell.col-1));
				}
				// horizontally - right
				if(popCell.col != grid[0].length-1 
						&& grid[popCell.row][popCell.col+1] == 0 
						&& result[popCell.row][popCell.col+1] == -1) {
						que.add(new Cell(popCell.row, popCell.col+1));
				}
			}
			distance += 1; 
		}
		return result;
	}
	
	//this is to check a man can reach to m*n position from 0*0 
		public static boolean bfsManMove(int distance, int[][] fire, int[][] grid) {
			Queue<Cell> que = new LinkedList();
			int[][] visited = new int[grid.length][grid[0].length];
			visited[0][0] = 1;
			que.add(new Cell(0, 0));
			while(!que.isEmpty()) {
				int curQueSize = que.size();
				for(int i=0; i<curQueSize; i++) {
					Cell cell = que.poll();
					//check reached to [n-1,m-1] 
					if(cell.row == grid.length-1 && cell.col == grid[0].length-1) {
						if(fire[cell.row][cell.col] != -1 
		                        && distance > fire[cell.row][cell.col]) return false;
						return true;
					}
						
					//before BFS(adjacent movement) check current distance is fine with the fire or not 
					if(fire[cell.row][cell.col] == -1 || distance < fire[cell.row][cell.col]) {
						//down 
						if(cell.row<grid.length-1 && grid[cell.row+1][cell.col]!=2 
								&& visited[cell.row+1][cell.col]==0) {
							visited[cell.row+1][cell.col]=1;
							que.add(new Cell(cell.row+1, cell.col));
						}
						//up
						if(cell.row>0 && grid[cell.row-1][cell.col]!=2 
								&& visited[cell.row-1][cell.col]==0) {
							visited[cell.row-1][cell.col]=1;
							que.add(new Cell(cell.row-1, cell.col));
						}
						//left 
						if(cell.col>0 && grid[cell.row][cell.col-1]!=2 
								&& visited[cell.row][cell.col-1]==0) {
							visited[cell.row][cell.col-1]=1;
							que.add(new Cell(cell.row, cell.col-1));
						}
						//right 
						if(cell.col<grid[0].length-1 && grid[cell.row][cell.col+1]!=2 
								&& visited[cell.row][cell.col+1]==0) {
							visited[cell.row][cell.col+1]=1;
							que.add(new Cell(cell.row, cell.col+1));
						}
						
					}
				}
				
				distance += 1; 
			}
			return false;
		}
	
	
	//inner class 
	static class Cell{
		int row;
		int col;
		Cell(int r, int c) {
			this.row = r; 
			this.col = c;
		}
	}//Cell class end
}//main class end










