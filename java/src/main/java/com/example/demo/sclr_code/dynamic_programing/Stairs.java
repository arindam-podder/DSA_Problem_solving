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

import java.util.Arrays;

public class Stairs {
	
	public static void main(String[] args) {
		long[] dpArr = {-1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1};
		
		System.out.println("step 2 out put");
		System.out.println( recursion(11) );
		System.out.println( waysToClimbStair(11, dpArr));
		System.out.println( tabulationBottomUp(11) );
 		
		
		System.out.println("step 3 out put");
		int n3 = 5;
		System.out.println( Stairs3step.recur(n3) );
		long[] dp = new long[n3+1];
		Arrays.fill(dp, -1);
		System.out.println( Stairs3step.dp(n3, dp) );
		System.out.println( Stairs3step.tabulationBottomUp(n3) );
		
	}
	
	public static long recursion(int n) {
//		if(n<3) return n;
		if(n== 0) return 1; 
		else if(n<0) return 0;
		
		return recursion(n-1) + recursion(n-2); 
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

/*
 * now man is on 0, he can take either 1/2/3 step 
 * example : stairs = 3   ans = 4 
 *           stairs = 4   ans = 7
 *           
 */
class Stairs3step{
	
	public static long recur(int n) {
		if(n== 0) return 1; 
		else if(n<0) return 0;
		
		return recur(n-1) + recur(n-2) + recur(n-3);
	}
	
	public static long dp(int n, long[] dp) {
		if(n== 0) return 1; 
		else if(n<0) return 0; 
		
		if(dp[n] != -1) return dp[n]; 
		
		dp[n] = dp(n-1, dp) + dp(n-2, dp) + dp(n-3, dp); 
		
		return dp[n];
	}
	
	
	public static int tabulationBottomUp(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1; 
		dp[1] = 1; 
		dp[2] = 2; 
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		return dp[n];
	}
	
}
































