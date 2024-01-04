/*
 * Q2. Longest Increasing Subsequence (Day 89 - Advanced DSA : DP 6: Famous Problems -- Thu, 19 Oct 2023)

Problem Description
Find the longest increasing subsequence of a given array of integers, A.
In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order,
and in which the subsequence is as long as possible.
In this case, return the length of the longest increasing subsequence.

Problem Constraints
1 <= length(A) <= 2500
0 <= A[i] <= 2500

Input Format
The first and the only argument is an integer array A.

Output Format
Return an integer representing the length of the longest increasing subsequence.

Example Input
Input 1:
 A = [1, 2, 1, 5]
Input 2:
 A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]

Example Output
Output 1:
 3
Output 2:
 6

Example Explanation
Explanation 1:
 The longest increasing subsequence: [1, 2, 5]
Explanation 2:
 The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */


package com.example.demo.sclr_code.dynamic_programing;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//solve by recursion 
	public static int findLis(int[] arr) {
		int ans =0;
		for(int i=0; i<arr.length; i++) {
			ans = Math.max(ans, lisByRecursion(arr, i));
		}
		return ans; 
	}
	
	public static int lisByRecursion(int[] arr, int i) {
		int tempAns = 0; 
		for(int j=0; j<i; j++) {
			if(arr[j]< arr[i]) {
				tempAns = Math.max(tempAns, lisByRecursion(arr, j));
			}
		}
		return tempAns+1;
	}
	
	
	//slove by iterative and dp-1d array for memorization 
	public static int lisByDp(int[] arr){
		int[] dp = new int[arr.length];
		//initialized dp value with -1
		for(int i=0; i<dp.length; i++){
			dp[i] = -1; 
		}
		dp[0] = 1; 
		int ans = dp[0];
        for(int i=1; i<arr.length; i++){
			int tempAns = 0 ; 
			for(int j=0; j<i; j++){
				if(arr[j]<arr[i]){
					tempAns = Math.max(tempAns, dp[j]); 
				}
			}
			dp[i] = tempAns+1; 
			ans = Math.max(ans, dp[i]);
		}   		
		return ans; 
	}
	
}







