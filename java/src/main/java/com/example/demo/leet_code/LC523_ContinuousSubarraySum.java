/**
 * 523. Continuous Subarray Sum

Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.

Note that:
A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 

Example 1:
Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

Example 2:
Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.

Example 3:
Input: nums = [23,2,6,4,7], k = 13
Output: false
 

Constraints:
1 <= nums.length <= 105
0 <= nums[i] <= 109
0 <= sum(nums[i]) <= 231 - 1
1 <= k <= 231 - 1
 */


package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.Map;

public class LC523_ContinuousSubarraySum {

	public static void main(String[] args) {
		int[] nums = {23, 2, 3,6}; int k = 6;
		
		System.out.println( checkSubarraySum1(nums, k)  );
		System.out.println( checkSubarraySum2(nums, k)  );
	}
	
	//BF
	/*
	 * Time Limit Exceeded -> 95 / 105 testcases passed
	 */
    public static boolean checkSubarraySum1(int[] arr, int k) {
    	 int n = arr.length;
    	 for(int i=0; i<n; i++) {
    		 int curSum = arr[i]; 
    		 for(int j=i+1; j<n; j++) {	//j = i+1 . becoz sub arr length should alteast 2
    			 curSum += arr[j];
    			 if(curSum % k  == 0 ) return true;
    		 }
    	 }
    	 
    	 return false; 
    }
    
    
    public static boolean checkSubarraySum2(int[] arr, int k) {
    	int res = 0; 
    	int n = arr.length; 
    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0, -1);
    	int prefixSum = 0; 
    	for(int i=0; i<n; i++) {
    		prefixSum += arr[i]; 
    		int remainder = prefixSum%k; 
    		
    		if(map.containsKey(remainder)) {
                if ((i-map.get(remainder)) >= 2 ) return true;
            }else
    		    map.put(remainder, i);
    		
    	}
    	
    	return false;
    }

}



