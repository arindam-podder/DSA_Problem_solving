/*
 * 198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected 
and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money 
you can rob tonight without alerting the police.

 
Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */


//note : questions says u can not pick adjacent element , now get the max 
package com.example.demo.leet_code;

import java.util.Arrays;

public class LC198_HouseRobber {

	public static void main(String[] args) {
		//int[] arr = {1,2,3,1}; 
		int[] arr = {2,7,9,3,1};
		//System.out.println( recur(arr.length-1, arr) );
		//System.out.println( memorization(arr) );
		System.out.println( tabulation(arr) );
	}
	
	
	//TLE 
	public static int recur(int index,int[] arr) {
		//base 
		if(index<0) return 0; 
		
		
		int pick = arr[index] + recur(index-2, arr);
		int dontPick = 0 + recur(index-1, arr);
		
		return Math.max(pick, dontPick);
	}
	
	
	public static int memorization(int[] arr) {
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		return recurDp(arr.length-1, arr, dp);
	}
	public static int recurDp(int index, int[] arr, int[] dp) {
		//base case 
		if(index < 0) return 0;
		if(dp[index] != -1) return dp[index];
		
		int pick = arr[index] + recurDp(index-2, arr, dp);
		int notPick = 0 + recurDp(index-1, arr, dp);
		
		dp[index] = Math.max(pick, notPick); 
		return dp[index];
	}
	
	
	//1D arr
	public static int tabulation(int[] arr) {
		//edge case 
		if(arr.length == 1 ) return arr[0];
		
		int[] dp = new int[arr.length];
		dp[0] = arr[0]; 
		dp[1] = Math.max(dp[0], arr[1]); 
		
		for(int i=2; i<arr.length; i++) {
			dp[i] = Math.max( arr[i]+ dp[i-2], 0+dp[i-1]);
		}
		return dp[arr.length-1];
	}
	

}




















