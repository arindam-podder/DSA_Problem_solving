/**
 * 62. Unique Paths

There is a robot on an m x n grid. The robot is initially located at the top-left corner 
(i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to 
reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:
1 <= m, n <= 100

 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC62_UniquePaths {

	public static void main(String[] args) {
		int m=3, n=2;
		System.out.println( uniquePaths1(m-1, n-1) );
		
		int[][] dp = new int[m][n];
		for(int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		System.out.println( uniquePaths2(m-1, n-1, dp) );
		
		
		System.out.println( tabulation(m, n) );
	}
	
	//recursion top-down			//TLE
    public static int uniquePaths1(int m, int n) {
        //base case 
    	if(m==0 || n==0) {
    		return 1;
    	}
    	
    	return uniquePaths1(m-1, n) + uniquePaths1(m, n-1);
    	
    }
    
    //memorize 			//100% beat 
    public static int uniquePaths2(int m, int n, int[][] dp) {
    	if(m==0 || n==0) return 1; 
    	if(dp[m][n] != -1) return dp[m][n];
    	
    	dp[m][n] = uniquePaths2(m-1, n, dp) + uniquePaths2(m, n-1, dp);
    	
    	return dp[m][n];
    }
	
    
    //bottom-up 
    public static int tabulation(int m, int n) {
    	int[][] dp = new int[m][n];
		//zero col all 1
    	for(int i=0; i<m; i++) dp[i][0] = 1; 
    	//1st row all val 1
    	Arrays.fill(dp[0], 1);
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
    }
	

}
