/*
 * Q1. Stairs

Problem Description
You are climbing a staircase and it takes A steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Return the number of distinct ways modulo 1000000007

Problem Constraints
1 <= A <= 10^5

Input Format
The first and the only argument contains an integer A, the number of steps.

Output Format
Return an integer, representing the number of ways to reach the top.

Example Input
Input 1:
 A = 2
Input 2:
 A = 3

Example Output
Output 1:
 2
Output 2:
 3

Example Explanation
Explanation 1:
 Distinct ways to reach top: [1, 1], [2].
Explanation 2:
 Distinct ways to reach top: [1 1 1], [1 2], [2 1].


 */


package com.example.demo.sclr_code.dynamic_programing;

public class Stairs {
	
	public static void main(String[] args) {
		long[] dpArr = {-1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1};
		
		System.out.println(waysToClimbStair(11, dpArr));
		
		System.out.println( tabulationBottomUp(5) );
 		
	}

	
	public static long waysToClimbStair(int numberOfStair, long[] dp) {
		if(numberOfStair<3) {
			return numberOfStair;
		}
		
		if(dp[numberOfStair] != -1) {
			return dp[numberOfStair];
		}
		
		dp[numberOfStair] = waysToClimbStair(numberOfStair-1, dp) + waysToClimbStair(numberOfStair-2, dp);
		
		return dp[numberOfStair];
		
	}
	
	public static int tabulationBottomUp(int numberOfStair) {
		int[] dp = new int[numberOfStair+1];
		dp[0] = 0; 
		dp[1] = 1; 
		dp[2] = 2; 
		for(int i=3; i<=numberOfStair; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[numberOfStair];
	}
	
	
}
































