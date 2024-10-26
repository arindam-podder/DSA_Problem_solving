/**
 * 279. Perfect Squares

Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer; in other words, it is the product of 
some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:
1 <= n <= 104
 */




package com.example.demo.leet_code;

import java.util.Arrays;

public class LC279_PerfectSquares {

	public static void main(String[] args) {
		

	}
	
	
	public int numSquares(int n) {
        //return solutionWithRecur(n);
        //return solutionWithMemorization(n);
        //return recur(n);
        //return recurMemorization(n);
        return tabulationBottomUp(n);
    }

    //TLE
    // public static int solutionWithRecur(int n) {
	// 	int result = n; 
	// 	for(int i=1; i<=n/i; i++) {
	// 		result = Math.min(result, recur(i, n, 0));
	// 	}
	// 	return result;
	// }
	
	// public static int recur(int i, int n, int c) {
	// 	//base 
	// 	if(i==1) return c+n; 
	// 	if(n==0) return c; 
		
	// 	while(i*i <= n) {
	// 		c = c+1; 
	// 		n= n - i*i;
	// 	}
		
	// 	int temp = c+n;
	// 	for(int j=1; j<i; j++) {
	// 		temp = Math.min(temp, recur(j, n, c));
	// 	}
	// 	return temp;
	// }


    //TLE
    // public static int solutionWithMemorization(int n) {
	// 	int[][] dp = new int[n+1][n+1];
	// 	for(int[] arr: dp) {
	// 		Arrays.fill(arr, -1);
	// 	}
		
	// 	int result = n; 
	// 	for(int i=1; i<=n/i; i++) {
	// 		result = Math.min(result, recurDp(i, n, 0, dp));
	// 	}
	// 	return result;
	// }
	
	// public static int recurDp(int i, int n, int c, int[][] dp) {
	// 	//base 
	// 	if(i==1) return c+n; 
	// 	if(n==0) return c; 
		
	// 	if(dp[i][n] != -1) return dp[i][n];
		
	// 	while(i*i <= n) {
	// 		c = c+1; 
	// 		n= n - i*i;
	// 	}
		
	// 	int temp = c+n;
	// 	for(int j=1; j<i; j++) {
	// 		temp = Math.min(temp, recurDp(j, n, c, dp));
	// 	}
	// 	dp[i][n] = temp;
	// 	return dp[i][n];
	// }

    //TLE
    // public static int recur(int n) {
	// 	//base 
	// 	if(n<=0) return 0; 
		
	// 	int temp = n;
	// 	for(int i=1; i<=n/i; i++) {
	// 		temp = Math.min(temp,  1+recur(n-i*i) );
	// 	}
	// 	return temp;
	// }

    public static int recurMemorization(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		return recurDp(n, dp);
	}
	
	public static int recurDp(int n, int[] dp) {
		//base 
		if(n<=0) return 0; 
		
		if(dp[n] != -1)  return dp[n];
		
		int temp = n;
		for(int i=1; i<=n/i; i++) {
			temp = Math.min(temp,  1+recurDp(n-i*i, dp) );
		}
		dp[n] = temp; 
		return dp[n];
		
	}


    public static int tabulationBottomUp(int n) {
		int[] dp = new int[n+1]; 
		dp[0] = 0; 
		
		for(int i=1; i<=n; i++) {
			int temp = Integer.MAX_VALUE; 
			for(int j=1; j<=i/j; j++) {
				temp = Math.min(temp, 1+dp[i-(j*j)]);
			}
			dp[i] = temp;
		}
		return dp[n];
	}

}
