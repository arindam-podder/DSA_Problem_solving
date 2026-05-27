/**
 * 516. Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the 
remaining elements.
 
Example 1:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

Constraints:
1 <= s.length <= 1000
s consists only of lowercase English letters.
 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC516_LongestPalindromicSubsequence {
	
	public static void main(String[] args) {
		String s = "bbbab";
		//System.out.println( longestPalindromeSubseq1(s) );
	
		System.out.println( recursion2pointer(0, s.length()-1, s) );
		
		int[][] dp = new int[s.length()][s.length()]; 
		for(int[] a: dp) Arrays.fill(a, -1);
		System.out.println( memorize2pointer(0, s.length()-1, s, dp) );
		
	}
	
	
    public static int longestPalindromeSubseq1(String s) {
//        int[] result = new int[1]; 
//        result[0] = 1;
//    	useRecur(0, s, new StringBuilder(), result);
//    	return result[0];
    	
    	return useBit(s);
    }
    
    //generation all possible subsequence 
    //Time Limit Exceeded 61 / 86 testcases passed
    public static void useRecur(int i, String s, StringBuilder sb, int[] result) {		//result lenngth is 1, just to store max 
    	if(i>=s.length()) {
    		if(checkPalindrome(sb)) {
    			result[0] = Math.max(result[0], sb.length());
    		}
    		return;
    	}
    	
    	//dont pick
    	useRecur(i+1, s, sb, result);

    	//pick 
    	sb.append(s.charAt(i)); 
    	useRecur(i+1, s, sb, result);
    	sb.deleteCharAt(sb.length()-1);
    	
    }
    
    //TLE
    public static int useBit(String s) {
    	int result = 1;
    	int n = s.length(); 
    	for(int i=0; i<Math.pow(2, n); i++) {
    		StringBuilder sb = new StringBuilder();
    		for(int idx=0; idx<s.length(); idx++) {
    			//check bit set or not 
    			if( (i & (1 << idx)) != 0) sb.append(s.charAt(idx));
    		}
    		
    		if(checkPalindrome(sb)) {
    			result = Math.max(result, sb.length());
    		}
    	}
    	return result;
    }
    
    
    public static boolean checkPalindrome(StringBuilder sb) {
    	if(sb.length() <= 1) return true;
    	
    	int i=0; 
    	int j=sb.length()-1; 
    	while(i<j) {
    		if(sb.charAt(i++) != sb.charAt(j--)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    
   //approach - 2 => use 2 pointer  [TLE]
    public static int recursion2pointer(int start, int end, String s) {
    	//base case 1
    	if(start>end) return 0; 
    	
    	//base case 2 - same position means same char 
    	if(start == end) return 1; 
    	
    	//body
    	int result = 1;
    	//match
    	if(s.charAt(start) == s.charAt(end)) {
    		result = 2 + recursion2pointer(start+1, end-1, s);
    	}
    	//no match 
    	else {
    		result = Math.max(recursion2pointer(start+1, end, s) ,
    				recursion2pointer(start, end-1, s));
    	}
    	
    	return result;
    }
    
    
    //pass
    public static int memorize2pointer(int start, int end, String s, int[][] dp) {
    	//base case 1
    	if(start>end) return 0; 
    	
    	//base case 2 - same position means same char 
    	if(start == end) return 1; 
    	
    	if(dp[start][end] != -1) return dp[start][end];
    	
    	//body
    	int result = 1;
    	//match
    	if(s.charAt(start) == s.charAt(end)) {
    		result = 2 + memorize2pointer(start+1, end-1, s, dp);
    	}
    	//no match 
    	else {
    		result = Math.max(memorize2pointer(start+1, end, s, dp) ,
    				memorize2pointer(start, end-1, s, dp));
    	}
    	
    	return dp[start][end] = result;
    }
    
    
}






















