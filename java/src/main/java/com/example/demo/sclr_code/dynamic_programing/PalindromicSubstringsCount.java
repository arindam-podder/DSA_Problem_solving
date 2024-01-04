/*
 * Q4. Palindromic Substrings Count (Day 89 - Advanced DSA : DP 6: Famous Problems -- Thu, 19 Oct 2023)

Given a string A consisting of lowercase English alphabets. Your task is to find how many substrings of A are palindrome.
The substrings with different start indexes or end indexes are counted as different substrings even if they consist of same characters.
Return the count of palindromic substrings.

Note: A string is palindrome if it reads the same from backward and forward.

Input Format
The only argument given is string A.
Output Format
Return the count of palindromic substrings.
Constraints
1 <= length of the array <= 1000
For Example

Input 1:
    A = "abab"
Output 1:
    6
Explanation 1:
    6 palindromic substrings are:
    "a", "aba", "b", "bab", "a" and "b".

Input 2:
    A = "ababa"
Output 2:
    9
Explanation 9:
    9 palindromic substrings are:
    "a", "a", "a", "b", "b" , "aba" ,"bab", "aba" and "ababa".
 */

package com.example.demo.sclr_code.dynamic_programing;

public class PalindromicSubstringsCount {
	public static void main(String[] args) {
		System.out.println( palindromeCount("aa") );
	}
	
	
	
	public static int palindromeCount(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()]; 
		for(int dia=0; dia<s.length(); dia++) {
			int i=0; int j=dia;
			for(; j<s.length(); ) {
				if(dia==0) dp[i][j] = true;
				else if(dia==1) dp[i][j] = s.charAt(i)==s.charAt(j);
				else {
					if(s.charAt(i) == s.charAt(j)) {
						dp[i][j] = dp[i+1][j-1]; 
					}else {
						dp[i][j] = false;
					}
				}
				i++; 
				j++; 
			}
		}
		
		int ans = 0; 
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<s.length(); j++) {
				if(dp[i][j]) {
					ans += 1;
				}
			}
		}
		return ans;
	}
}
















