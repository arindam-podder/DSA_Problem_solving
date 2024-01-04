/*
 * Q1. Maximum XOR

Problem Description
Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.

Problem Constraints
1 <= length of the array <= 100000
0 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return an integer denoting the maximum result of A[i] XOR A[j].

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [5, 17, 100, 11]

Example Output
Output 1:
 7
Output 2:
 117

Example Explanation
Explanation 1:
 Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
Explanation 2:
 Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
 */


package com.example.demo.sclr_code.trie;

public class MaximumXOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
		
		System.out.println(maxXorPairBF(arr));
		
	}
	
	//Brute force 
	public static int maxXorPairBF(int[] arr) {
		int ans = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				ans = Math.max(ans, arr[i]^arr[j]);
			}
		}
		return ans;
	}
	
	//use trie of bits 
	public static int usingTrieBit(int[] arr) {
		//TrieBit root = new TrieBit(10);
		return 0;
	}

}




























