/**
 * 1631. Path With Minimum Effort

You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, 
where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), 
and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, 
or right, and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 
Example 1:
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Example 2:
Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better 
than route [1,3,5,3,5].

Example 3:
Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: here one route does not require any effort.
 

Constraints:
rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
 */


package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC1631_PathWithMinimumEffort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] heights = {{1,2,2}, {3,8,2}, {5,3,5}};
		
		System.out.println( minimumEffortPath1(heights) );

	}

	//not using mean heap, not required like dijktra rule 
    public static int minimumEffortPath1(int[][] heights) {
        int n = heights.length, m = heights[0].length;
    	int[][] efforts = new int[n][m];
    	for(int[] arr: efforts) Arrays.fill(arr, Integer.MAX_VALUE);
    	Queue<int[]> que = new LinkedList<>();
    	que.add(new int[] {0, 0}); 
    	efforts[0][0] = 0; 
    	while(!que.isEmpty()) {
    		int[] cell = que.poll();
    		int row = cell[0], col = cell[1];
    		//neighbor up 
    		if(row>0) {
    			int neighborRow = row-1, neighborCol = col;
    			int requiredEffort = Math.abs( heights[row][col] - heights[neighborRow][neighborCol] ); 
    			int pathEffort = Math.max( efforts[row][col] , requiredEffort );
    			if(pathEffort < efforts[neighborRow][neighborCol]) {
    				efforts[neighborRow][neighborCol] = pathEffort;
    				que.add(new int[] {neighborRow, neighborCol});
    			}
    		}
    		//neighbour down 
    		if(row<n-1) {
    			int neighborRow = row+1, neighborCol = col;
    			int requiredEffort = Math.abs( heights[row][col] - heights[neighborRow][neighborCol] ); 
    			int pathEffort = Math.max( efforts[row][col] , requiredEffort );
    			if(pathEffort < efforts[neighborRow][neighborCol]) {
    				efforts[neighborRow][neighborCol] = pathEffort;
    				que.add(new int[] {neighborRow, neighborCol});
    			}

    		}
    		//neighbor right 
    		if(col<m-1) {
    			int neighborRow = row, neighborCol = col+1;
    			int requiredEffort = Math.abs( heights[row][col] - heights[neighborRow][neighborCol] ); 
    			int pathEffort = Math.max( efforts[row][col] , requiredEffort );
    			if(pathEffort < efforts[neighborRow][neighborCol]) {
    				efforts[neighborRow][neighborCol] = pathEffort;
    				que.add(new int[] {neighborRow, neighborCol});
    			}
    		}
    		//neighbor left 
    		if(col>0) {
    			int neighborRow = row, neighborCol = col-1;
    			int requiredEffort = Math.abs( heights[row][col] - heights[neighborRow][neighborCol] ); 
    			int pathEffort = Math.max( efforts[row][col] , requiredEffort );
    			if(pathEffort < efforts[neighborRow][neighborCol]) {
    				efforts[neighborRow][neighborCol] = pathEffort;
    				que.add(new int[] {neighborRow, neighborCol});
    			}
    		}
    		
    	}//while end
    		
    	return efforts[n-1][m-1];
    }
	
	
}
