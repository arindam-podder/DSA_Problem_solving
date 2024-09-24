/**
 * 123. Best Time to Buy and Sell Stock III

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
Example 1:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the 
same time. You must sell before buying again.

Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 
Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 105
 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC123_BestTimeBuySellStockIII {

	public static void main(String[] args) {
		int[] arr = {3,3,5,0,0,3,1,4};
		
		//System.out.println( maxProfitPossible(arr) );
		
		System.out.println( tabulation(arr) );

	}
	
	public static int maxProfitPossible(int[] arr) {
        //return recur(arr, 0, 1, 2);
		
		int[][][] dp = new int[arr.length][2][3];
		for(int[][] a : dp) {
			for(int[] x: a) {
				Arrays.fill(x, -1);
			}
		}
		return recurDP(arr, 0, 1, 2, dp);
    }

	//buy = 0/1 , cap (at max two transaction) = 2/1/0
//	public static int recur(int[] arr, int idx, int buy, int cap) {
//		//base case 
//		if(arr.length == idx || cap==0) return 0;
//		
//		int profit = 0; 
//		//can buy 
//		if(buy == 1) {
//			int take = -arr[idx] + recur(arr, idx+1, 0, cap);
//			int notTake = 0 + recur(arr, idx+1, 1, cap);
//			profit = Math.max(profit,  Math.max(take, notTake));
//		}else { //sell part
//			int take = arr[idx] + recur(arr, idx+1, 1, cap-1);
//			int notTake = 0 + recur(arr, idx+1, 0, cap);
//			profit = Math.max(profit,  Math.max(take, notTake));
//		}
//		return profit;
//	}
	
	
	//accept in Leetcode
	public static int recurDP(int[] arr, int idx, int buy, int cap, int[][][] dp) {
		//base case 
		if(arr.length == idx || cap==0) return 0;
		
		if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
		
		int profit = 0; 
		//can buy 
		if(buy == 1) {
			int take = -arr[idx] + recurDP(arr, idx+1, 0, cap, dp);
			int notTake = 0 + recurDP(arr, idx+1, 1, cap, dp);
			profit = Math.max(profit,  Math.max(take, notTake));
		}else { //sell part
			int take = arr[idx] + recurDP(arr, idx+1, 1, cap-1, dp);
			int notTake = 0 + recurDP(arr, idx+1, 0, cap, dp);
			profit = Math.max(profit,  Math.max(take, notTake));
		}
		dp[idx][buy][cap] = profit;
		return dp[idx][buy][cap]; 
	}
	
	
	public static int tabulation(int[] arr) { 
		int[][][] dp = new int[arr.length+1][2][3]; 
		
		//base 1 :  arr.length all ZERO according to recurDP 
//		for(int buy=0; buy<2; buy++) {
//			for(int cap=0; cap<3; cap++) {
//				dp[arr.length][buy][cap] = 0;
//			}
//		}
//		
//		//base 2 : cap==0 then all Zero
//		for(int idx=0; idx<=arr.length; idx++) {
//			for(int buy=0; buy<2; buy++) {
//				dp[idx][buy][0] = 0;
//			}
//		}
		
		
		//follow the recurDP main body logic 
		for(int idx=arr.length-1; idx>=0; idx--) {
			for(int buy=0; buy<2; buy++) {
				for(int cap=1; cap<3; cap++) {
					int profit = 0; 
					if(buy == 1) {
						int take = -arr[idx] + dp[idx+1][0][cap];
						int notTake = 0 + dp[idx+1][1][cap];
						profit = Math.max(profit,  Math.max(take, notTake));
					}else { //sell part
						int take = arr[idx] + dp[idx+1][1][cap-1];
						int notTake = 0 + dp[idx+1][0][cap];
						profit = Math.max(profit,  Math.max(take, notTake));
					}
					dp[idx][buy][cap] = profit;
				}
			}
		}
		return dp[0][1][2];
	}
	
}



















