/*
 * Q3. Ways to Decode

Problem Description
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it 
modulo 109 + 7.

Problem Constraints
1 <= length(A) <= 105

Input Format
The first and the only argument is a string A.

Output Format
Return an integer, representing the number of ways to decode the string modulo 109 + 7.

Example Input
Input 1:
 A = "12"
Input 2:
 A = "8"

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2.
Explanation 2:
 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.
 */

package com.example.demo.sclr_code.dynamic_programing;

import java.util.Arrays;

public class WaysToDecode {

	public static void main(String[] args) {
		String code = "102011220"; 
		System.out.println(num_ways(code));
	}
	
	public static int num_ways(String code) {
		int[] dp = new int[code.length()]; 
		Arrays.fill(dp, -1);
//		int result = helper(code, 0);
		int result = helper(code, 0, dp); 
		System.out.println(Arrays.toString(dp));
		return result; 
	}
	
	public static int helper(String s, int index) {
		if(index >= s.length()) return 1;
		if(s.charAt(index) == '0') return 0; 
		
		int result = helper(s, index+1); 
		if(index==s.length()-2 && Integer.valueOf(s.substring(index))<=26) result += helper(s, index+2);
		else {
			if( !(index+2 >= s.length()) && Integer.valueOf(s.substring(index, index+2))<=26) result += helper(s, index+2);  
		} 
		return result; 		
	}

	public static int helper(String s, int index, int[] dp) {
		if(index >= s.length()) return 1;
		if(s.charAt(index) == '0') return 0; 
		
		if(dp[index] != -1) return dp[index]; 
		
		int result = helper(s, index+1, dp); 
		if(index==s.length()-2 && Integer.valueOf(s.substring(index))<=26) result += helper(s, index+2, dp);
		else {
			if( !(index+2 >= s.length()) && Integer.valueOf(s.substring(index, index+2))<=26) result += helper(s, index+2, dp);  
		} 
		dp[index] = result; 
		return dp[index];
	}
	
}














