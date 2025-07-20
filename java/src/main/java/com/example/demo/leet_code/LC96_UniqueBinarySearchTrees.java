/**
 * 96. Unique Binary Search Trees

Given an integer n, return the number of structurally unique BST's (binary search trees) which has 
exactly n nodes of unique values from 1 to n.

Example 1:
Input: n = 3
Output: 5

Example 2:
Input: n = 1
Output: 1

Constraints:
1 <= n <= 19
 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC96_UniqueBinarySearchTrees {

	public static void main(String[] args) {
		int n = 5; 
		
		System.out.println( recur(n) );
		
		int[] dp = new int[n+1]; 
		Arrays.fill(dp, -1);
		System.out.println( memorize(n, dp) );
		
		System.out.println( tabulation(n) );
	}

	//recursion , for total nodes have to calculate for each root,  node=3, then root 1, 2, 3
	public static int recur(int n) {
		//base case 
		if(n<=1) return 1; 
		
		int total = 0; 
		for(int root=1; root<=n; root++) {
			total += recur(root-1) * recur(n-root); 
		}
		return total;
    }
	
	//memerization dp
	public static int memorize(int n, int[] dp) {
		if(n<=1) return 1;
		
		if(dp[n] != -1) return dp[n]; 
		
		int total = 0; 
		for(int root=1; root<=n; root++) {
			 total += memorize(root-1, dp) * memorize(n-root, dp); 
		}
		dp[n] = total;
		return dp[n];
	}
	
	//tabulation bottom-up
	public static int tabulation(int n) {
		if(n<=1) return 1; 
		
		int[] dp = new int[n+1]; 
		dp[0] = 1; 
		dp[1] = 1; 
		for(int node=2; node<=n; node++) {
			int total = 0; 
			for(int root=1; root<=node; root++) {
				total += dp[root-1] * dp[node-root];
			}
			dp[node] = total;
		}
		return dp[n];
	}
	
	
	
}







