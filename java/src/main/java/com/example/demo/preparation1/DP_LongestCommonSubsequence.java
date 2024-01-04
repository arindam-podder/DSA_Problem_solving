/*
 * Example Input
Input 1:
 A = "abbcdgf"
 B = "bbadcgf"
Input 2:
 A = "aaaaaa"
 B = "ababab"

Example Output
Output 1:
 5
Output 2:
 3
 */


package com.example.demo.preparation1;

import java.util.Arrays;

public class DP_LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "xzw"; 
		String s2 = "xyazw"; 
		
		//int ans = DP_LongestCommonSubsequence_recursive.longestCommonSubsequence(s1, s2); 
		//int ans = DP_LongestCommonSubsequence_memorization.longestCommonSubsequence(s1, s2); 
		int ans = DP_LongestCommonSubsequence_tabulation.longestCommonSubsequence(s1, s2); 
		System.out.println(ans);

	}

}


class DP_LongestCommonSubsequence_recursive{
	
	public static int longestCommonSubsequence(String s1, String s2) {
		int result = recursion(s1.length()-1, s1, s2.length()-1, s2); 
		return result; 
	}
	
	public static int recursion(int i, String s1, int j, String s2) {
		if(i<0 || j<0) return 0; 
		
		int ans=0; 
		if(s1.charAt(i) == s2.charAt(j)) ans = 1 + recursion(i-1, s1, j-1, s2); 
		else ans = Math.max(recursion(i, s1, j-1, s2), recursion(i-1, s1, j, s2));
		
		return ans; 
	}
	
}

class DP_LongestCommonSubsequence_memorization{
	
	public static int longestCommonSubsequence(String s1, String s2) {
		int[][] dp = new int[s1.length()][s2.length()]; 
		for(int[] arr : dp) Arrays.fill(arr, -1);
		
		int result = memorization(s1.length()-1, s1, s2.length()-1, s2, dp); 
		return result; 
	}
	
	public static int memorization(int i, String s1, int j, String s2, int[][] dp) {
		if(i<0 || j<0) return 0; 
		
		if(dp[i][j] != -1) return dp[i][j]; 
		
		int ans=0; 
		if(s1.charAt(i) == s2.charAt(j)) ans = 1 + memorization(i-1, s1, j-1, s2, dp); 
		else ans = Math.max(memorization(i, s1, j-1, s2, dp), memorization(i-1, s1, j, s2, dp));
		
		dp[i][j] = ans; 
		return dp[i][j]; 
	}
	
}

class DP_LongestCommonSubsequence_tabulation{
	
	public static int longestCommonSubsequence(String s1, String s2) {
		int[][] dp = new int[s1.length()][s2.length()]; 
		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				if(i==0 && j==0) { 
					if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1; 
				}
				else if(i==0) {
					if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1; 
					else dp[i][j] = dp[i][j-1]; 
				}
				else if(j==0) {
					if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1; 
					else dp[i][j] = dp[i-1][j]; 
				}else {
					if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + dp[i-1][j-1]; 
					else  dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); 
				}
			}
		}
		return dp[s1.length()-1][s2.length()-1]; 
	}
	
}











