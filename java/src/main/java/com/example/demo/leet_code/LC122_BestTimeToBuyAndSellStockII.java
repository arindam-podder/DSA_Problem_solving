/**
 * 122. Best Time to Buy and Sell Stock II

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. 
However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 
Constraints:
1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC122_BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {
		int[] arr = {7,1,5,3,6,4};
		
		System.out.println( maxProfit(arr) );
		
		System.out.println( tabulation(arr) );
		
		System.out.println( easyApproach(arr) );
	}
	
	
	 public static int maxProfit(int[] prices) {
		 //return recur(0, true, prices);
		 
		 int[][] dp = new int[prices.length][2];
		 for(int[] arr: dp) {
			 Arrays.fill(arr, -1);
		 }
		 return recurDP(0, 1, prices, dp);
		 
	 }
	 
	 //1
	 public static int recur(int index, boolean canBuy, int[] arr) {
		 //base case 
		 if(index == arr.length) {
			 return 0;
		 }
		 
		 
		 int profit=0;
		 if(canBuy) {
			 int take =  -arr[index] + recur(index+1, false, arr); 
			 int notTake = 0 + recur(index+1, canBuy, arr);
			 profit = Math.max(profit, Math.max(take, notTake));
		 }else {
			 int take = arr[index] + recur(index+1, true, arr);
			 int notTake = 0 + recur(index+1, false, arr);
			 profit = Math.max(profit, Math.max(take, notTake));
		 }
		 
		 return profit;
	 }
	 
	 //2
	 public static int recurDP(int index, int canBuy, int[] arr, int[][] dp) {
		 //base case 
		 if(index == arr.length) {
			 return 0;
		 }
		 
		 if(dp[index][canBuy] != -1) return dp[index][canBuy];
		 
		 int profit=0;
		 if(canBuy==1) {
			 int take =  -arr[index] + recurDP(index+1, 0, arr, dp); 
			 int notTake = 0 + recurDP(index+1, 1, arr, dp);
			 profit = Math.max(profit, Math.max(take, notTake));
		 }else {
			 int take = arr[index] + recurDP(index+1, 1, arr, dp);
			 int notTake = 0 + recurDP(index+1, 0, arr, dp);
			 profit = Math.max(profit, Math.max(take, notTake));
		 }
		 dp[index][canBuy] = profit;
		 return dp[index][canBuy];
	 }
	 
	 //3
	 public static int tabulation(int[] arr) {
		 int[][] dp = new int[arr.length+1][2];
		 //base 
		 dp[arr.length][0] = dp[arr.length][1] = 0;
		 
		 for(int i=arr.length-1; i>=0; i--) {
			 //0/1 indicate canBuy
			 for(int buy=0; buy<2; buy++) {
				 
				 if(buy == 1) {
					 int take = -arr[i] + dp[i+1][0];
					 int notTake = 0 + dp[i+1][1];
					 dp[i][1] = Math.max(0, Math.max(take, notTake));
				 }else {
					 int take = arr[i] + dp[i+1][1];
					 int notTake = 0 + dp[i+1][0];
					 dp[i][0] = Math.max(0, Math.max(take, notTake));
				 }
			 }
		 }
		 return dp[0][1];
	 }
	 
	 
	 //4 - sell, buy same day approach 
	 public static int easyApproach(int[] arr) {
		 int result = 0;
		 int buyValue = arr[0];
		 for(int i=1; i<arr.length; i++) {
			 if(buyValue>=arr[i]) {
				 buyValue = arr[i];
			 }else {
				 //sell
				 result = result + arr[i]-buyValue; 
				 //same day buy again
				 buyValue = arr[i];
			 }
		 }
		 return result;
	 }
	

}




