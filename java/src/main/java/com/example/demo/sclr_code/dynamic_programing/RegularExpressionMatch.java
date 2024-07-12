/*
 * Q3. Regular Expression Match (Day 88 - Advanced DSA : DP 5: DP on Strings -- Mon, 16 Oct 2023)
Problem Description
Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Problem Constraints
1 <= length(A), length(B) <= 104

Input Format
The first argument of input contains a string A.
The second argument of input contains a string B.

Output Format
Return 1 if the patterns match else return 0.

Example Input
Input 1:
 A = "aaa"
 B = "a*"
Input 2:
 A = "acz"
 B = "a?a"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 So, the pattern matches we return 1.
Explanation 2:
 '?' matches any single character. First two character in string A will be match. 
 But the last character i.e 'z' != 'a'. Return 0.
 */


package com.example.demo.sclr_code.dynamic_programing;

import java.util.Arrays;

public class RegularExpressionMatch {
	public static void main(String[] args) {
//		System.out.println(recursion("aaa", "*", 2, 0));
		System.out.println( patternMatchSolution("aaa", "*"));
	}
	
	
	public static boolean recursion(String s, String p, int i, int j){
		//base case 
		if(i<0 && j<0) return true; 
		if(i>=0 && j<0) return false; 
		if(i<0 && j>=0) {
			for(int k=0; k<=j; k++) {
				if(p.charAt(k) != '*') return false;
			}
			return true;
		}
		
		
		if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
			return recursion(s, p, i-1, j-1);
		}
		else if(p.charAt(j)=='*') {
			return recursion(s, p, i, j-1) || recursion(s, p, i-1, j);
		}else {
			return false;
		}
		
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





