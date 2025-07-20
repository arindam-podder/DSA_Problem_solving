/**
 * 221. Maximal Square

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.


Example 1:
Input: matrix = [[ 1 , 0 , 1 , 0 , 0 ],[ 1 , 0 , 1 , 1 , 1 ],[ 1 , 1 , 1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:
Input: matrix = [["0","1"],["1","0"]]
Output: 1

Example 3:
Input: matrix = [["0"]]
Output: 0
 

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.

 */



package com.example.demo.leet_code;

public class LC221_MaximalSquare {
	public static void main(String[] args) {
		int[][] arr = {{1, 0 , 1 , 0 , 0 }, { 1 , 0 , 1 , 1 , 1 }, { 1 , 1 , 1 , 1 , 1 }, { 1 , 0 , 0 , 1 , 0 }};
				
		System.out.println( maximalSquare1(arr) );
	
	}
	
    public static int maximalSquare1(int[][] arr) {
        int maxSqr = 0;
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int i=0; i<arr.length; i++) {
        	for(int j=0; j<arr[0].length; j++) {
        		if(i==0 || j==0) dp[i][j] = arr[i][j];
        		else if(arr[i][j] == 0) dp[i][j] = 0;
        		else {
        			dp[i][j] =  1 + Math.min(  Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1] );
        		}
        		
        		maxSqr = Math.max(maxSqr, dp[i][j]);
        	}
        }
        
        return maxSqr*maxSqr;
    }
	
	
}



















