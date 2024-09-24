/**
 * 121. Best Time to Buy and Sell Stock
Easy
Topics
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */


package com.example.demo.leet_code;

public class LC121_BestTimeBuySellStock {

	public static void main(String[] args) {
		int[] arr = {7,5,8};
		System.out.println( buySell(arr) );
		System.out.println( buySell2(arr) );
		
	}
	
	public static int buySell(int[] arr) {
		int profit=0; 
		int indexBuy=0; 
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] <= arr[indexBuy] ) {
				indexBuy = i; 
			}else {
				profit = Math.max(profit, arr[i]-arr[indexBuy]);
			}
		}
		
		return profit;
	}
	
	
	//2nd approach 
	public static int buySell2(int[] arr) {
		int buyVal = arr[0]; 
		int profit = 0; 
		for(int i=1; i<arr.length; i++) {
			int cost = arr[i] - buyVal; 
			profit = Math.max(profit, cost); 
			buyVal = Math.min(buyVal, arr[i]);
		}
		
		return profit;
	}

}















