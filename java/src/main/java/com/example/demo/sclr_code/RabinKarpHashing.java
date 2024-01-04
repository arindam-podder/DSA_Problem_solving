/*
 * Q1. Rabin Karp			(day 59-1 Aug 2023)
Problem Description
Given two string A and B of length N and M respectively consisting of lowercase letters. Find the number of occurrences of B in A.

Problem Constraints
1 <= M <= N <= 105

Input Format
Two argument A and B are strings

Output Format
Return an integer denoting the number of occurrences of B in A

Example Input
Input 1:
A = "acbac"
B = "ac"
Input 2:
A = "aaaa"
B = "aa"

Example Output
Output 1:
2
Output 2:
3

Example Explanation
For Input 1:
The string "ac" occurs twice in "acbac".
For Input 2:
The string "aa" occurs thrice in "aaaa".
 */


package com.example.demo.sclr_code;

public class RabinKarpHashing {

	public static void main(String[] args) {
		String A = "aaaa"; 
		String B = "aa"; 
		
		System.out.println(occurrence(A, B));
	}
	
	//without rabin karp 
	public static int occurrence(String A,String B) {
		int n=A.length();
		int m=B.length();
		int L=0; int R=m-1;
		int count = 0;
		for(; R<n; R++, L++) {
			if(A.substring(L,R+1).equals(B)) {
				count++;
			}
		}
		return count;
	}

	
	//rolling hashing by rabin karp rule use 
	public static int rabinHashing() {
		return -1;
	}
}













