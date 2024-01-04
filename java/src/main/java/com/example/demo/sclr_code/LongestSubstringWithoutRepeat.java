/*
 * Q1. Longest Substring Without Repeat

Problem Description
Given a string A, find the length of the longest substring without repeating characters.

Note: Users are expected to solve in O(N) time complexity.

Problem Constraints
1 <= size(A) <= 106
String consists of lowerCase,upperCase characters and digits are also present in the string A.

Input Format
Single Argument representing string A.

Output Format
Return an integer denoting the maximum possible length of substring without repeating characters.

Example Input
Input 1:
 A = "abcabcbb"
Input 2:
 A = "AaaA"

Example Output
Output 1:
 3
Output 2:
 2


Example Explanation
Explanation 1:
 Substring "abc" is the longest substring without repeating characters in string A.
Explanation 2:
 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.

 */


package com.example.demo.sclr_code;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringWithoutRepeat("abcac"));
	}
	
	
	public static int lengthOfLongestSubstringWithoutRepeat(String s) {
		String temp="";
		int ans= 0;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(temp.indexOf(ch) != -1) {
				if(temp.length()-1 == temp.indexOf(ch)) {
					temp = ""+ch;
				}else {
					temp=temp.substring(temp.indexOf(ch)+1)+ch; 
				}
			}
			else {
				temp=temp+ch;
			}
			
			ans = ans >= temp.length() ? ans : temp.length();
		}
		
		return ans;
	}

}
















