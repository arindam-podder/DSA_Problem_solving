/*
 * 132. Palindrome Partitioning II

Given a string s, partition s such that every substring of the partition is a palindrome
.
Return the minimum cuts needed for a palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:
Input: s = "a"
Output: 0
Example 3:
Input: s = "ab"
Output: 1
 
Constraints:
1 <= s.length <= 2000
s consists of lowercase English letters only.
 */


package com.example.demo.leet_code;

public class LC132 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc"; 
		
		LC132 obj = new LC132(); 
		boolean[][] palindromicArray = obj.getPalindromicArray(s);
		
		int[][] dpCut = new int[s.length()][s.length()]; 
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<s.length(); j++) {
				dpCut[i][j] = -1; 
			}
		}
		
		System.out.println(obj.minCut(0, s.length()-1, palindromicArray));
		
	}
	
	
	public boolean[][] getPalindromicArray(String s){
		boolean[][] palindromicArray = new boolean[s.length()][s.length()]; 
		//diagonally run the loop
		for(int dia=0; dia<s.length(); dia++) {
			int i=0; int j=dia; 
			for( ; j<s.length(); ) {
				if(dia == 0 ) palindromicArray[i][j] = true;
				else if(dia == 1) palindromicArray[i][j] = s.charAt(i)==s.charAt(j);
				else {
					if(s.charAt(i) == s.charAt(j)) {
						palindromicArray[i][j] = palindromicArray[i+1][j-1]; 
					}else {
						palindromicArray[i][j] = false; 
					}
				}
				i++; 
				j++; 
			}
		}
		return palindromicArray;
	}
	
	//solution using only recursion 
	public int minCut(int s, int e, boolean[][] palindromicArray) {
		if(palindromicArray[s][e] ) return 0;
		int ans = Integer.MAX_VALUE; 
		for(int i=s; i<=e; i++) {
			if(palindromicArray[s][i] == true) {
				ans = Math.min(ans, minCut(i+1, e, palindromicArray));
			}
		}
		return ans+1;
	}

	
	public int minCutReqiredUsingRecursionAndDp(int s, int e, boolean[][] palindromicDP, int[][] dpCut) {
		if(palindromicDP[s][e] == true) return 0; 			//here zero cut required 
		if(dpCut[s][e] != -1) return dpCut[s][e];
		int ans = Integer.MAX_VALUE;
		for(int cut=s; cut<=e; cut++) {
			if(palindromicDP[s][cut] == true) {
				ans = Math.min(ans, minCutReqiredUsingRecursionAndDp(cut+1, e, palindromicDP, dpCut));
			}
		}
		dpCut[s][e] = ans+1;
		return ans+1;
	}
	
}























