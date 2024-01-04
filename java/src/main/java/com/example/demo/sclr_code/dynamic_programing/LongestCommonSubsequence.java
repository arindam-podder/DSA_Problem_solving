/*
 * Q2. Longest Common Subsequence (Day 88 - Advanced DSA : DP 5: DP on Strings -- Mon, 16 Oct 2023)
Problem Description
Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), 
which is common in both the strings.
You need to return the length of such longest common subsequence.

Problem Constraints
1 <= Length of A, B <= 1005

Input Format
First argument is a string A.
Second argument is a string B.

Output Format
Return an integer denoting the length of the longest common subsequence.

Example Input
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

Example Explanation
Explanation 1:
 The longest common subsequence is "bbcgf", which has a length of 5.
Explanation 2:
 The longest common subsequence is "aaa", which has a length of 3.

 */


package com.example.demo.sclr_code.dynamic_programing;

import java.util.Arrays;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		
	}
	
	public int solve(String A, String B) {
        int[][] dp = new int[A.length()][B.length()];
		for(int i=0; i<dp.length; i++){
			Arrays.fill(dp[i], -1);
		}
        //return longestCommonSubsequenceUsingRecursionandDP(A, B, A.length()-1, B.length()-1, dp); 

        return lcsUsingIterativeAndDP(A, B);
    }

    public static int longestCommonSubsequenceUsingRecursionandDP(String s1, String s2, int i, int j, int[][] dp){
		if(i<0 || j<0) return 0; 
		
		if(dp[i][j] != -1 ) return dp[i][j]; 

		int ans = 0 ; 
		if(s1.charAt(i) == s2.charAt(j)){
			ans = longestCommonSubsequenceUsingRecursionandDP(s1, s2, i-1, j-1, dp) + 1;
		}else if (s1.charAt(i) != s2.charAt(j)){
			ans = Math.max(longestCommonSubsequenceUsingRecursionandDP(s1, s2, i, j-1, dp), longestCommonSubsequenceUsingRecursionandDP(s1, s2, i-1, j, dp));
		}
		dp[i][j] = ans; 
		return ans; 
	}


    public static int lcsUsingIterativeAndDP(String s1, String s2){
		int[][] dp = new int[s1.length()][s2.length()]; 
		for(int i=0; i<s1.length(); i++){
			for(int j=0; j<s2.length(); j++){
				if(i==0 && j==0) {
					if(s1.charAt(i)==s2.charAt(j))	dp[i][j] = 1;
					else	dp[i][j] = 0;
				}
				else if(i==0){
					if(s1.charAt(i)==s2.charAt(j))	dp[i][j] = 1; 
					else	dp[i][j] = dp[i][j-1];
				}
				else if(j==0){
					if(s1.charAt(i)==s2.charAt(j))	dp[i][j] = 1; 
					else dp[i][j] = dp[i-1][j];
				}else{
					if(s1.charAt(i)==s2.charAt(j))	dp[i][j] = dp[i-1][j-1] + 1;
					else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		return dp[s1.length()-1][s2.length()-1]; 
	}
}
















