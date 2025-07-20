/**
 * 188. Best Time to Buy and Sell Stock IV

You are given an integer array prices where prices[i] is the price of a given stock on the ith day, 
and an integer k.
Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at
most k times and sell at most k times.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before 
you buy again).

Example 1:
Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 
(price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 
Constraints:
1 <= k <= 100
1 <= prices.length <= 1000
0 <= prices[i] <= 1000
 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC188_BestTimetoBuyandSellStockIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 2;
		int[] prices = {3,2,6,5,0,3};
		
		System.out.println( maxProfit1(k, prices) );
	}
	
    public static int maxProfit1(int k, int[] prices) {
        return recur(0, 1, prices, k);
    	
//    	int[][][] dp = new int[prices.length][2][k + 1];
//        for (int[][] arr : dp)
//            for (int[] row : arr)
//                Arrays.fill(row, -1);
//    	return memorize(0, 1, prices, k, dp);
    	
    }
    
    //Time Limit Exceeded     207 / 210 testcases passed
    public static int recur(int i, int canBuy, int[] prices, int k) {
        // Base cases
        if (i == prices.length || k == 0) return 0;

        int profit = 0;
        if (canBuy == 1) {
            // Can buy: two options, buy or skip
            profit = Math.max(
                -prices[i] + recur(i + 1, 0, prices, k), // Buy
                recur(i + 1, 1, prices, k)                // Skip
            );
        } else {
            // Can sell: two options, sell or skip
            profit = Math.max(
                prices[i] + recur(i + 1, 1, prices, k - 1), // Sell
                recur(i + 1, 0, prices, k)                  // Skip
            );
        }

        return profit;
    }
    
    public static int memorize(int i, int canBuy, int[] prices, int k, int[][][] dp) {
        // Base cases
        if (i == prices.length || k == 0) return 0;

        if (dp[i][canBuy][k] != -1) return dp[i][canBuy][k];

        int profit = 0;
        if (canBuy == 1) {
            // Can buy: two options, buy or skip
            profit = Math.max(
                -prices[i] + memorize(i + 1, 0, prices, k, dp), // Buy
                memorize(i + 1, 1, prices, k, dp)                // Skip
            );
        } else {
            // Can sell: two options, sell or skip
            profit = Math.max(
                prices[i] + memorize(i + 1, 1, prices, k - 1, dp), // Sell
                memorize(i + 1, 0, prices, k, dp)                  // Skip
            );
        }

        return dp[i][canBuy][k] = profit;
    }
    
    
    
    
}











 






