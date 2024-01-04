/*
 * Q2. Longest Palindromic Subsequence (Day 89 - Advanced DSA : DP 6: Famous Problems -- Thu, 19 Oct 2023)

Problem Description
Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and 
is a palindrome).
You need to return the length of longest palindromic subsequence.

Problem Constraints
1 <= length of(A) <= 103

Input Format
First and only integer is a string A.

Output Format
Return an integer denoting the length of longest palindromic subsequence.

Example Input
Input 1:
 A = "bebeeed"
Input 2:
 A = "aedsead"

Example Output
Output 1:
 4
Output 2:
 5

Example Explanation
Explanation 1:
 The longest palindromic subsequence is "eeee", which has a length of 4.
Explanation 2:
 The longest palindromic subsequence is "aedea", which has a length of 5.
 */


package com.example.demo.sclr_code.dynamic_programing;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String s = "aba"; 
		//System.out.println(generateAllSubSequence(s));
		System.out.println(longPalindromicSubsequence(s));
	}

	//used palindromic 2d arr to solve this prob 
	public static int longPalindromicSubsequence(String s){
		int[][] palindromicArray = new int[s.length()][s.length()]; 
		for(int dia=0; dia<s.length(); dia++) {
			int i=0, j=dia;
			for( ; j<s.length(); ) {
				if(dia == 0) palindromicArray[i][j]=1;
				else if(dia == 1) palindromicArray[i][j]= s.charAt(i) == s.charAt(j)? 2:1;
				else {
					if(s.charAt(i) == s.charAt(j)) palindromicArray[i][j] = palindromicArray[i+1][j-1] + 2; 
					else palindromicArray[i][j] = Math.max(palindromicArray[i][j-1], palindromicArray[i+1][j]);
				}
				i++;
				j++;
			}
		}
		return palindromicArray[0][s.length()-1]; 
	}
	
	
	//used power set rule to find all sub sequence 
	public static List<List<Character>> generateAllSubSequence(String s){
		List<List<Character>> allSubSequence = new ArrayList<>(); 
		int len = s.length(); 
		for(int i=0; i<(1<< len); i++) {
			List<Character> subSequence = new ArrayList<>();
			for(int j=0; j<len; j++) {
				if( (i & (1<<j)) != 0) {
					subSequence.add(s.charAt(j));
				}
			}
			allSubSequence.add(subSequence);
		}
		return allSubSequence; 
	}
	
	public static boolean isPalindrom(List<Character> list) {
		if(list.size() == 0 ) return false; 
		if(list.size() == 1) return true; 
		int s=0; 
		int e=list.size()-1;
		while(s<e) {
			if(list.get(s++) != list.get(e--)) {
				return false; 
			}
		}
		return true;
	}
	
}













