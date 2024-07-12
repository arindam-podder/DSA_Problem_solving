/**
 * 44. Wildcard Matching (Hard)

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
 */


package com.example.demo.leet_code;

public class LC44_WildcardMatching {
	public static void main(String[] args) {
		String s = "aaaababbbaaabaabbbbabaababaabbabbaabababbaaaaaaabba";
		String p = "baaaaba*****b***ab******"; 
		
		System.out.println( isMatching("aa", "***************") );
		
	}
	
	public static boolean isMatching(String s, String p) {
		return match(s, p, s.length()-1, p.length()-1); 
    }
	
	public static boolean match(String s, String p, int si, int pi) {
		System.out.println("match call");
		//base case 
		if(si<0 && pi<0) {
			return true; 
		}
		if(pi<0) {
			return false; 
		}
		if(si<0) {
			while(pi>=0) {
				if(p.charAt(pi) != '*') {
					return false;
				}
				pi = pi-1;
			}
			return true;
		}
		
		if( s.charAt(si)==p.charAt(pi) || p.charAt(pi)=='?') {
			return match(s, p, si-1, pi-1); 
		}
		if(p.charAt(pi)=='*') {
			return match(s, p, si, pi-1) || match(s, p, si-1, pi) ;
		}
		
		return false;
	}
	
	public static boolean patternMatchSolution(String s, String p) {
		int[][] dp = new int[s.length()][p.length()];
		for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
		return recursionDP(s, p, s.length()-1, p.length()-1, dp)==1 ? true:false;
	
	}
	
	public static int recursionDP(String s, String p, int i, int j, int[][] dp){
		//base case 
		if(i<0 && j<0) return 1; 
		if(i>=0 && j<0) return 0; 
		if(i<0 && j>=0) {
			for(int k=0; k<=j; k++) {
				if(p.charAt(k) != '*') return 0;
			}
			return 1;
		}
		
		if(dp[i][j] != -1) return dp[i][j]; 
		
		if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
			dp[i][j] = recursionDP(s, p, i-1, j-1, dp);
		}
		else if(p.charAt(j)=='*') {
			dp[i][j] = (recursionDP(s, p, i, j-1, dp)==1 ||  recursionDP(s, p, i-1, j, dp)==1)? 1:0;
		}else {
			dp[i][j] = 0;
		}
		return dp[i][j]; 
		
	}
	
	
}
















