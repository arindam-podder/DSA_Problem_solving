/**
 * 72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:
Insert a character
Delete a character
Replace a character
 

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:
0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.

 */



package com.example.demo.leet_code;

import java.util.Arrays;

public class LC72_EditDistance {

	public static void main(String[] args) {
		String s1 = "horse"; 
		String s2 = "ros"; 
		
		//System.out.println( minOperationRecurtion(s1.length()-1, s1, s2.length()-1, s2) );
		
		//int[][] dp = new int[s1.length()][s2.length()];
		//for(int[] arr: dp) Arrays.fill(arr, -1);
		//System.out.println( minOperationMemorization(s1.length()-1, s1, s2.length()-1, s2, dp) );
		
	
		System.out.println( minOperationTabulation(s1, s2) );
	
	}
	
	public int minDistance(String word1, String word2) {
        return 0;
    }
	
	// TLE 

	public static int minOperationRecurtion(int i, String s1, int j, String s2) {
		//base case 
		if(i<0) return j+1;   //i<0 means s1 end , so to make s2 j+1 operation 
		if(j<0) return i+1;   //i+1 operation required to remove all char of s1
		
		//body logic 
		if(s1.charAt(i) == s2.charAt(j)) return 0 + minOperationRecurtion(i-1, s1, j-1, s2); 
		else {
			int insert = 1 + minOperationRecurtion(i, s1, j-1, s2);   //insert hypotheticall on i+1 , so (i+1 and j) match
			int replace = 1 + minOperationRecurtion(i-1, s1, j-1, s2); 
			int remove = 1 + minOperationRecurtion(i-1, s1, j, s2); 
			
			return Math.min(Math.min(insert, replace), remove);
		}
	}
	
	// passed - beats 95 % 
	public static int minOperationMemorization(int i, String s1, int j, String s2, int[][] dp) {
		//base case 
		if(i<0) return j+1;   //i<0 means s1 end , so to make s2 j+1 operation 
		if(j<0) return i+1;   //i+1 operation required to remove all char of s1
		if(dp[i][j] != -1) return dp[i][j];
		//body logic 
		if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 0 + minOperationMemorization(i-1, s1, j-1, s2, dp); 
		else {
			int insert = 1 + minOperationMemorization(i, s1, j-1, s2, dp);   //insert hypotheticall on i+1 , so (i+1 and j) match
			int replace = 1 + minOperationMemorization(i-1, s1, j-1, s2, dp); 
			int remove = 1 + minOperationMemorization(i-1, s1, j, s2, dp); 
			dp[i][j] = Math.min(Math.min(insert, replace), remove);
		}
		return dp[i][j];
	}
	
	
	//tabulation
	public static int minOperationTabulation(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int j=0; j<dp[0].length; j++) dp[0][j] = j; 
		for(int i=0; i<dp.length; i++) dp[i][0] = i; 
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				//body logic 
				if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 0 + dp[i-1][j-1]; 
				else {
					int insert = 1 + dp[i][j-1];   //insert hypotheticall on i+1 , so (i+1 and j) match
					int replace = 1 + dp[i-1][j-1]; 
					int remove = 1 + dp[i-1][j]; 
					dp[i][j] = Math.min(Math.min(insert, replace), remove);
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}	

}























