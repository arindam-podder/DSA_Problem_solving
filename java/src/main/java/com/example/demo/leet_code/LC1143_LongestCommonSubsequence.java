/**
 * 1143. Longest Common Subsequence

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common 
subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 
Constraints:
1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 */



package com.example.demo.leet_code;

import java.util.Arrays;

public class LC1143_LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "adc";
		
		System.out.println( lCS(s1, s2) );
		
		System.out.println( tabulation(s1, s2) );
	}
	
	
	public static int lCS(String text1, String text2) {
        //return usingRecursion(text1.length()-1, text1, text2.length()-1, text2);
		
		int[][] dp = new int[text1.length()][text2.length()];
		for(int[] arr: dp) Arrays.fill(arr, -1);
		return memorization(text1.length()-1, text1, text2.length()-1, text2, dp);
		
		
    }
	
	public static int usingRecursion(int i, String text1, int j, String text2) {
		if(i<0 || j<0) return 0; 
		
		int ans = 0; 
		//possible 1 
		if(text1.charAt(i) == text2.charAt(j)) ans = usingRecursion(i-1, text1, j-1, text2) + 1;
		else ans = Math.max( usingRecursion(i, text1, j-1, text2), usingRecursion(i-1, text1, j, text2) );
			
		return ans; 
	}
	
	
	public static int memorization(int i, String text1, int j, String text2, int[][] dp) {
		if(i<0 || j<0) return 0; 
		if(dp[i][j] != -1) return dp[i][j]; 
		
		int ans = 0; 
		if(text1.charAt(i) == text2.charAt(j)) ans = memorization(i-1, text1, j-1, text2, dp) + 1; 
		else ans = Math.max( memorization(i, text1, j-1, text2, dp), memorization(i-1, text1, j, text2, dp) );
		dp[i][j] = ans;
		return dp[i][j];
	}
	
	
	//need to analyse and research 
	public static int tabulation(String s1, String s2) {
		 int[][] dp = new int[s1.length()][s2.length()];
		 for(int i=0; i<s1.length(); i++) {
			 for(int j=0; j<s2.length(); j++) {
				 if(i==0 && j==0) {
					 if(s1.charAt(i)==s2.charAt(j)) dp[i][j] = 1; 
				 }
				 else if(i==0) {
					 if(s1.charAt(i)==s2.charAt(j)) dp[i][j] = 1;
					 else dp[i][j] = dp[i][j-1];
				 }
				 else if(j==0) {
					 if(s1.charAt(i)==s2.charAt(j)) dp[i][j] = 1;
					 else dp[i][j] = dp[i-1][j];
				 }else {
					 if(s1.charAt(i)==s2.charAt(j)) dp[i][j] = 1+dp[i-1][j-1]; 
					 else dp[i][j] = Math.max( dp[i][j-1] , dp[i-1][j]);
				 }	 
			 }
		 }
		 return dp[s1.length()-1][s2.length()-1];
	}
	

}



















