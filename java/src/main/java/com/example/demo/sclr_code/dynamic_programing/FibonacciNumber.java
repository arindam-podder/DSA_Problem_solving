/*
 * Q2. Fibonacci Number

Problem Description
Given a positive integer A, write a program to find the Ath Fibonacci number.

In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1.
i.e. f(0) = 0 and f(1) = 1.Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.

NOTE: 0th term is 0. 1th term is 1 and so on.

Problem Constraints
0 <= A <= 44

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the Ath Fibonacci number.

Example Input
Input 1:
 A = 4
Input 2:
 A = 6


Example Output
Output 1:
 3
Output 2:
 8

Example Explanation
Explanation 1:
 Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 0th term is 0 So, 4th term of Fibonacci series is 3. 
Explanation 2:
 6th term of Fibonacci series is 8.



 */


package com.example.demo.sclr_code.dynamic_programing;

public class FibonacciNumber {

	public static void main(String[] args) {
		int[] dpArr = {-1, -1, -1, -1, -1};

		System.out.println(aThFibo(4, dpArr));
		
		System.out.println( tabulationBottomUp(5) );
	}
	
	public static int aThFibo(int a, int[] dpArr) {
		if(a<2) {
			return a;
		}
		
		if(dpArr[a] != -1) {
			return dpArr[a];
		}
		
		dpArr[a] = aThFibo(a-1, dpArr) + aThFibo(a-2, dpArr);
		
		return dpArr[a];
	}
	
	
	public static int tabulationBottomUp(int a) {
		int[] dp = new int[a+1];
		dp[0] = 0;
		dp[1] = 1; 
		for(int i=2; i<=a; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[a];
	}
	

}





















