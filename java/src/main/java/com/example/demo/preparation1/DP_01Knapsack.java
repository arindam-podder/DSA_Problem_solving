/*
 * wt = [3, 2, 5]
 * val = [30, 40, 60]
 * knapsack bag weight/capacity = 6
 * get max val within the knapsack capcity. 
 * 
 * ans : 70
 * (https://www.youtube.com/watch?v=GqOmJHQZivw)
 */



package com.example.demo.preparation1;

import java.util.Arrays;

public class DP_01Knapsack {

	public static void main(String[] args) {
		int[] wt = {3, 2, 5}; 
		int[] val = {30, 40, 60}; 
		int knapsackCapacity = 6; 
				
		//nt maxVal = DP_01Knapsack_onlyRecursion.knapsack(knapsackCapacity, wt, val); 
		//int maxVal = DP_01Knapsack_Memorization.knapsack(knapsackCapacity, wt, val); 
		int maxVal = DP_01Knapsack_tabulation.knapsack(knapsackCapacity, wt, val); 
		System.out.println(maxVal);
	}

}

class DP_01Knapsack_onlyRecursion{
	
	public static int knapsack(int bagCapacity, int[] wt, int[] val) {
		int itemCount = wt.length; 
		int result = recursion(itemCount-1, bagCapacity, wt, val); 
		return result; 
	}

	private static int recursion(int i, int capacity, int[] wt, int[] val) {
		
		if(i<0) return 0; 
		
		int notTake = 0 + recursion(i-1, capacity, wt, val); 
		int take = Integer.MIN_VALUE; 
		if(wt[i] <= capacity) {
			take = val[i] + recursion(i-1, capacity-wt[i], wt, val); 
		}
		return Math.max(notTake, take); 
	}
	
}


class DP_01Knapsack_Memorization{
	
	public static int knapsack(int bagCapacity, int[] wt, int[] val) {
		int itemCount = wt.length; 
		int[][] dp = new int[itemCount][bagCapacity+1]; 
		//fill dp with -1
		for(int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		
		int res = memorization(itemCount-1, bagCapacity, wt, val, dp);
		return res; 
	}

	private static int memorization(int i, int capacity, int[] wt, int[] val, int[][] dp) {
		if(i==0) {
			if(wt[0] <= capacity ) return val[0]; 
			else return 0;
		}
		if(dp[i][capacity] != -1) return dp[i][capacity];  
		
		int notTake = 0 + memorization(i-1, capacity, wt, val, dp); 
		int take = Integer.MIN_VALUE; 
		if(wt[i] <= capacity) {
			take = val[i] + memorization(i-1, capacity-wt[i], wt, val, dp);
		}
		dp[i][capacity] = Math.max(notTake, take); 
		return dp[i][capacity]; 
	}	
}


class DP_01Knapsack_tabulation{
	
	public static int knapsack(int bagCapacity, int[] wt, int[] val) {
		int itemCount = wt.length; 
		int[][] dp = new int[itemCount][bagCapacity+1]; 
		
		//for 0th index item
		for(int weight=wt[0]; weight<=bagCapacity; weight++) {
			dp[0][weight] = val[0];
		}
		
		for(int i=1; i<itemCount; i++) {
			for(int weight=0; weight<=bagCapacity; weight++) {
				int notTake = 0 + dp[i-1][weight]; 
				int take = Integer.MIN_VALUE; 
				if(wt[i] <= weight) {
					take = val[i] + dp[i-1][weight-wt[i]]; 
				}
				dp[i][weight] = Math.max(take, notTake);
			}
		}
		
		return dp[itemCount-1][bagCapacity];
	}
	
}















