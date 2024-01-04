/*
 *Q3. Sorted Permutation Rank	(HW)	(12july day-44 adv dsa math-4 combinatorics)
Problem Description
Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003

Problem Constraints
1 <= |A| <= 1000

Input Format
First argument is a string A.

Output Format
Return an integer denoting the rank of the given string.

Example Input
Input 1:
A = "acb"
Input 2:
A = "a"

Example Output
Output 1:
2
Output 2:
1

Example Explanation
Explanation 1:
Given A = "acb".
The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.
Explanation 2:

Given A = "a".
Rank is clearly 1. 
 */

package com.example.demo.sclr_code;

public class SortedPermutationRank {
	
	public static final int mod = 1000003;

	public static void main(String[] args) {
		System.out.println(rankOfPermutation("acb"));
	}
	
	
	public static int rankOfPermutation(String s) {
		int len = s.length();
		int result = 0; 
		for(int i=0; i<len; i++) {
			int lessCharCount = 0; 
			for(int j=i+1; j<len; j++) {
				if(s.charAt(j)<s.charAt(i)) {
					lessCharCount = lessCharCount + 1;
				}
			}
			result = (result%mod + (lessCharCount * fact(len-i-1))%mod) %mod;
		}
		return result+1;
	}
	
	public static int fact(int n) {
		if(n==0 || n==1) return 1;
		return (n * fact(n-1))%mod;  
	}
}












