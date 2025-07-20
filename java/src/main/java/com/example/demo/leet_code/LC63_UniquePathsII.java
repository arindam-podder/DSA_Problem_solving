/**
 * 63. Unique Paths II

You are given an m x n integer array grid. There is a robot initially located at the top-left corner 
(i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot 
include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The testcases are generated so that the answer will be less than or equal to 2 * 109.


Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 
Constraints:
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC63_UniquePathsII {

	public static void main(String[] args) {
		int[][] arr = {{0,0,0}, {0,1,0}, {0,0,0}};
		
		System.out.println( uniquePathsWithObstacles1(arr) );

	}
	
    public static int uniquePathsWithObstacles1(int[][] arr) {
    	int m = arr.length; 
    	int n = arr[0].length;
        //return recur(m-1, n-1, arr);
    	
    	int[][] dp = new int[m][n]; 
    	for(int[] a: dp) Arrays.fill(a, -1);
    	//return memorize(m-1, n-1, arr, dp);
    	
    	return tabulation(arr);
    	
    }
    
    //recursion approach   			//TLE
    public static int recur(int i, int j, int[][] arr) {
    	if(arr[i][j] == 1) return 0;
    	if(i==0) {
    		for(int k=j-1; k>=0; k--) {
    			if(arr[i][k] == 1 ) return 0;
    		}
    		return 1;
    	}
    	if(j==0) {
    		for(int k=i-1; k>=0; k--) {
    			if(arr[k][j] == 1 ) return 0;
    		}
    		return 1;
    	}
    	
    	return recur(i-1, j, arr) + recur(i, j-1, arr);
    }
    
    
    //memorize      
    public static int memorize(int i, int j, int[][] arr, int[][] dp) {
    	if(arr[i][j] == 1) return 0;
    	if(i==0) {
    		for(int k=j-1; k>=0; k--) {
    			if(arr[i][k] == 1 ) return 0;
    		}
    		return 1;
    	}
    	if(j==0) {
    		for(int k=i-1; k>=0; k--) {
    			if(arr[k][j] == 1 ) return 0;
    		}
    		return 1;
    	}
    	
    	if(dp[i][j] != -1) return dp[i][j];
    	
    	dp[i][j] = memorize(i-1, j, arr, dp) + memorize(i, j-1, arr, dp);
    	return dp[i][j];
    }
    
    
    public static int tabulation(int[][] arr) {
    	int m = arr.length; 
    	int n = arr[0].length;
    	int[][] dp = new int[m][n];
     	//when row 0 , all col 1 , keep obstacle in mind 
    	for(int i=0; i<n; i++) {
    		if(arr[0][i] == 1) break;
    		dp[0][i] = 1;
    	}
    	//when col 0, all rows 1, keep obstacle in mind
    	for(int i=0; i<m; i++) {
    		if(arr[i][0] == 1) break;
    		dp[i][0] = 1;
    	}
    	for(int i=1; i<m; i++) {
    		for(int j=1; j<n; j++) {
    			if(arr[i][j] != 1) {
    				dp[i][j] = dp[i-1][j] + dp[i][j-1];
    			}
    		}
    	}
    	return dp[m-1][n-1];
    }
}


















