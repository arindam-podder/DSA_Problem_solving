/*
 *Q2. Longest Consecutive Sequence

Problem Description
Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from array A.

Problem Constraints
1 <= N <= 106
-106 <= A[i] <= 106


Input Format
First argument is an integer array A of size N.

Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.

Example Input
Input 1:
A = [100, 4, 200, 1, 3, 2]
Input 2:
A = [2, 1]

Example Output
Output 1:
 4
Output 2:
 2

Example Explanation
Explanation 1:
 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:
 The set of consecutive elements will be [1, 2]. 
 */


package com.example.demo.sclr_code;

import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr = {100, 4, 200, 1,2,3};
		System.out.println(longestSecquence(arr));
	}
	
	
	public static int longestSecquence(int[] arr) {
		int result = -1;
		//put arr ele into set 
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			hs.add(arr[i]);
		}
		for(Integer n: hs) {
			if(hs.contains(n-1)) {
				continue;
			}else {
				int val = n; 
				int temp_len = 0; 
				while(hs.contains(val)) {
					temp_len ++; 
					val++;
				}
				result = Math.max(result, temp_len);
			}
		}
		return result;
	}
	

}







