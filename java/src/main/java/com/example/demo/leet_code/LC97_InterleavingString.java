/**
 * 97. Interleaving String

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings 
respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.


Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.

Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true

Constraints:
0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.
 */



package com.example.demo.leet_code;

import java.util.Arrays;

public class LC97_InterleavingString {

	public static void main(String[] args) {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		
		System.out.println(  recur(s1.length()-1, s1, s2.length()-1, s2, s3.length()-1, s3) );
		
		
		int[][][] dp = new int[s1.length()][s2.length()][s3.length()];
		for(int[][] arr1 : dp) {
			for(int[] arr2 : arr1) {
				Arrays.fill(arr2, -1);
			}
		}
		boolean ans = memorize(s1.length()-1, s1, s2.length()-1, s2, s3.length()-1, s3, dp) == 0 ? false : true;
		System.out.println( ans );
	}
	
	//TLE 
	public static boolean recur(int i, String s1, int j, String s2, int k, String s3) {
		//base 
		if(i<0) {
			if(j != k) return false; 
			else{
				for(int idx=0; idx<=j; idx++) {
					if(s2.charAt(idx) != s3.charAt(idx)) return false;
				}
				return true;
			}
		}
		
		if(j<0) {
			if(i != k) return false; 
			else{
				for(int idx=0; idx<=i; idx++) {
					if(s1.charAt(idx) != s3.charAt(idx)) return false;
				}
				return true;
			}
		}
		
		if(k<0 && (i!=0 || j!=0)) return false;
		
		//body
		if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
			return recur(i-1, s1, j, s2, k-1, s3) || recur(i, s1, j-1, s2, k-1, s3); 
		}else if(s1.charAt(i) == s3.charAt(k) ) {
			return recur(i-1, s1, j, s2, k-1, s3); 
		}else if(s2.charAt(j) == s3.charAt(k) ) {
			return recur(i, s1, j-1, s2, k-1, s3);
		}
			
		return false;
	}
	
	
	//memeorise , in dp 0 means false , 1 means true
	public static int memorize(int i, String s1, int j, String s2, int k, String s3, int[][][] dp) {
		//base 
		if (i < 0) {
			if (j != k)
				return 0;
			else {
				for (int idx = 0; idx <= j; idx++) {
					if (s2.charAt(idx) != s3.charAt(idx))
						return 0;
				}
				return 1;
			}
		}
		if (j < 0) {
			if (i != k)
				return 0;
			else {
				for (int idx = 0; idx <= i; idx++) {
					if (s1.charAt(idx) != s3.charAt(idx))
						return 0;
				}
				return 1;
			}
		}	
		if(k<0 && (i!=0 || j!=0)) return 0;
		
		if(dp[i][j][k] != -1) return dp[i][j][k];
		
		
		//body
		if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
			dp[i][j][k] = 
					Math.max(memorize(i - 1, s1, j, s2, k - 1, s3, dp), memorize(i, s1, j - 1, s2, k - 1, s3, dp));
		} else if (s1.charAt(i) == s3.charAt(k)) {
			dp[i][j][k] = memorize(i - 1, s1, j, s2, k - 1, s3, dp);
		} else if (s2.charAt(j) == s3.charAt(k)) {
			dp[i][j][k] = memorize(i, s1, j - 1, s2, k - 1, s3, dp);
		}else {
			dp[i][j][k] = 0;
		}
		return dp[i][j][k];
	}
}














