/*
 * Q1. Edit Distance
Problem Description
Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
ou have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Problem Constraints
1 <= length(A), length(B) <= 450

Input Format
The first argument of input contains a string, A.
The second argument of input contains a string, B.

Output Format
Return an integer, representing the minimum number of steps required.

Example Input
Input 1:
 A = "abad"
 B = "abac"
Input 2:
 A = "Anshuman"
 B = "Antihuman

Example Output
Output 1:
 1
Output 2:
 2


Example Explanation
Exlanation 1:
 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.
 
Explanation 2:
 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.

 */


package com.example.demo.sclr_code.dynamic_programing;

public class EditDistance {

	public static void main(String[] args) {
		String s1 = "abcee";
		String s2 = "abcd"; 
		int[][] dp = new int[s1.length()][s2.length()]; 
		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println( editString(s1, s2, s1.length()-1, s2.length()-1, dp) );
	}
	
	public static int editString(String s1, String s2, int i, int j, int[][] dp) {
		if(i<0 && j<0 ) return 0;
		else if(i<0) return j+1;
		else if(j<0) return i+1; 
		
		if(dp[i][j] != -1) return dp[i][j]; 
		int ans = 0 ; 
		if(s1.charAt(i) == s2.charAt(j)) {
			ans = editString(s1, s2, i-1, j-1, dp);
		}
		else {
			int a = editString(s1, s2, i, j-1, dp);		//insert
			int b = editString(s1, s2, i-1, j-1, dp);		//replace
			int c = editString(s1, s2, i-1, j, dp);		//delete
			ans = Math.min( Math.min(a, b), c) + 1;
		}
		dp[i][j] = ans; 
		return ans;
		
	}

}





