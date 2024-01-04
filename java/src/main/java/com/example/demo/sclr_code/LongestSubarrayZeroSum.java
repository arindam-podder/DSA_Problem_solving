/*
 * Q3. Longest Subarray Zero Sum

Problem Description
Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.

Note :
while we A[i] multiple times, it may cross the range of integer, so wisely select data type for any operations.

Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109

Input Format
Single argument which is an integer array A.

Output Format
Return an integer.

Example Input
Input 1:
 A = [1, -2, 1, 2]
Input 2:
 A = [3, 2, -1]

Example Output
Output 1:
3
Output 2:
0

Example Explanation
Explanation 1:
 [1, -2, 1] is the largest subarray which sums up to 0.
Explanation 2:
 No subarray sums up to 0.

 */


package com.example.demo.sclr_code;

import java.util.HashMap;

public class LongestSubarrayZeroSum {

	public static void main(String[] args) {
		int[] arr = {2, 3, -2, 4, -7, 5, 6};
		
		System.out.println( longestSubArraySumZero(arr) );

	}
	
	public static int longestSubArraySumZero(int[] arr) {
		long[] pfSum = new long[arr.length]; 
		pfSum[0] = arr[0];
		for(int i=1; i<arr.length; i++) {
			pfSum[i] = pfSum[i-1]+arr[i];
		}
		
		HashMap<Long, Integer> hm = new HashMap<>();
		hm.put(0L, -1);
		int ans = 0;
		for(int i=0; i<pfSum.length; i++) {
			if(hm.containsKey(pfSum[i])){
				ans = Math.max(ans, i-hm.get(pfSum[i]));
			}else {
				hm.put(pfSum[i], i);
			}
		}
		return ans;
	}

}










