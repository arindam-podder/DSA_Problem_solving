/**
 * 64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC64_MinimumPathSum {

	public static void main(String[] args) {
		int[][] arr = {{1,3,1}, {1,5,1}, {4,2,1}};
		
		System.out.println( minPathSum1(arr) );

	}
	
	public static int minPathSum1(int[][] arr) {
        int m = arr.length; 
        int n = arr[0].length;
	   	//return recur(m-1, n-1, arr);
	   	
	   	//int[][] dp = new int[m][n];
	   	//for(int[] a: dp) Arrays.fill(a, -1);
	   	//return memorize(m-1, n-1, arr, dp);
        
        return tabulation(arr);
	   	
	}
	    
	    
	//recursion top-down 
	public static int recur(int i, int j, int[][] arr) {
    	//base 
    	if(i==0 && j==0) return arr[i][j]; 
    
    	int topVal = Integer.MAX_VALUE;
    	int leftVal = Integer.MAX_VALUE; 
	   	if(i>0) {
	   		topVal = arr[i][j] + recur(i-1, j, arr); 
	   	}
	   	if(j>0) {
	   		leftVal = arr[i][j] + recur(i, j-1, arr);
	   	}
	   	int ans = Math.min(topVal, leftVal);
	   	return ans;
	}
	    
	public static int memorize(int i, int j, int[][] arr, int[][] dp) {
		//base 
    	if(i==0 && j==0) return arr[i][j]; 
    	
    	if(dp[i][j] != -1) return dp[i][j]; 
    	
    	int topVal = Integer.MAX_VALUE;
    	int leftVal = Integer.MAX_VALUE; 
	   	if(i>0) {
	   		topVal = arr[i][j] + memorize(i-1, j, arr, dp); 
	   	}
	   	if(j>0) {
	   		leftVal = arr[i][j] + memorize(i, j-1, arr, dp);
	   	}
	   	dp[i][j] = Math.min(topVal, leftVal);
	   	return dp[i][j];
	}
	
	//tabulation 
	public static int tabulation(int[][] arr) {
		int m = arr.length; 
		int n = arr[0].length;
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i==0 && j==0) dp[i][j] = arr[i][j];
				else if(i==0) dp[i][j] = arr[i][j] + dp[i][j-1];
				else if(j==0) dp[i][j] = arr[i][j] + dp[i-1][j];
				else {
					dp[i][j] = Math.min(arr[i][j] + dp[i-1][j] , arr[i][j] + dp[i][j-1]);
				}
			}
		}
		return dp[m-1][n-1];
	}
	

}






