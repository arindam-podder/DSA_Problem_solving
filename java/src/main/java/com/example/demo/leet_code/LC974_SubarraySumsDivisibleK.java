/**
 * 974. Subarray Sums Divisible by K

Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Example 2:
Input: nums = [5], k = 9
Output: 0
 

Constraints:
1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
2 <= k <= 104
 */



package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.Map;

public class LC974_SubarraySumsDivisibleK {

	public static void main(String[] args) {

	}

	//BF
	//Time Limit Exceeded -> 71 / 76 testcases passed
	public static int subarraysDivByK1(int[] arr, int k) {
		int n=arr.length;
		int res = 0; 
		for(int i=0; i<n; i++) {
			int curSum=0; 
			for(int j=i; j<n; j++) {
				curSum += arr[j]; 
				if(curSum%k == 0) res += 1;
			}
		}
		
		return res;
	}
	
	
	/*
	 * You want (prefix[i] - prefix[j]) % k == 0
	 * how many earlier prefix sums had the same remainder as the current one? That count is exactly the number of valid subarrays for that
	 * current ith position - Map<prefixSum remainder, count >
	 * 
	 * 
	 * Negative numbers: in Java, % can return a negative remainder for negative sums. Remainders -2 and k-2 should be 
	 * treated as the same bucket. Think about how to normalize the remainder into the range 0..k-1.
	 */
	public static int subarraysDivByK2(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		int prefixSum = 0; 
		map.put(0,  1);   //default remainder 0 will have 1 subArr count
		for(int i=0; i<arr.length; i++) {
			prefixSum += arr[i]; 
			int remainder = (prefixSum % k) <0? k+(prefixSum % k) : (prefixSum % k); 	//handle negetive remaider case 
			if(map.containsKey(remainder)) res += map.get(remainder);
			
			map.put(remainder, map.getOrDefault(remainder, 0) +1);
		}
		
		return res;
	}

}











