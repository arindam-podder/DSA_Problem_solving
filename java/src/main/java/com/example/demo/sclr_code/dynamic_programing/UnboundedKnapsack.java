/*
 *  Unbounded Knapsack (Day 86 - Advanced DSA : DP 3: Knapsack -- Wed, 11 Oct 2023)

Problem Description
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], 
we need to calculate maximum amount that could fit in this quantity.
This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.

Problem Constraints
1 <= A <= 1000
1 <= |B| <= 1000
1 <= B[i] <= 1000
1 <= C[i] <= 1000

Input Format
First argument is the Weight of knapsack A
Second argument is the vector of values B
Third argument is the vector of weights C

Output Format
Return the maximum value that fills the knapsack completely

Example Input
Input 1:
A = 10
B = [5]
C = [10]
Input 2:
A = 10
B = [6, 7]
C = [5, 5]

Example Output
Output 1:
 5
Output 2:
14

Example Explanation
Explanation 1:
Only valid possibility is to take the given item.
Explanation 2:
Take the second item twice.
 */


package com.example.demo.sclr_code.dynamic_programing;

import java.util.Arrays;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		int knapsackCapacity = 10;
		int[] value = {6, 7};
		int[] weight = {5, 5};
		
		int[][] dp = new int[value.length+1][knapsackCapacity+1];
		for(int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(unboundKnapSack(value, weight, knapsackCapacity, dp));
	}

	public static int unboundKnapSack(int[] value, int[] weight, int knapSackCapacity, int[][] dp) {
		for(int i=0; i<= value.length; i++) {
			for(int j=0; j<= knapSackCapacity; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0; 
				}
				else {
					int val1 = dp[i-1][j]; 				//not picked 
					int val2 = 0 ;				//picked 
					if(weight[i-1] <= j) {
						val2 = dp[i][j-weight[i-1]]+ value[i-1]; 
					}
					dp[i][j] = Math.max(val1, val2); 
				}
			}
		}
		return dp[value.length][knapSackCapacity];
	}
	
	
}










