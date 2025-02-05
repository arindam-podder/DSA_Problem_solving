/**
 * 560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
 
Constraints:
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */



package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.Map;

public class LC560_SubarraySumEqualsK {
	public static void main(String[] args) {
		
	}
	
	public int subarraySum(int[] nums, int k) {
         return totalSubrraysWithSumK(nums, k);
    }
	
	
	//use prefix sum(here kind of carry sum) with map<prefixsum, count>
	public static int totalSubrraysWithSumK(int[] arr, int k) {
		int result = 0; 
		int carrySum = 0; 
		Map<Integer, Integer> map = new HashMap<>(); 
		map.put(0, 1);  //1st entry sum 0, and count 1
		for(int i=0; i<arr.length; i++) {
			carrySum += arr[i]; 
			//we need sum k , so check (carrySum-k) key present in the map or not , that key's value add to the result 
			if(map.containsKey(carrySum-k)) {
				result += map.get(carrySum-k);
			}
			
			//add carry sum key to map 
			map.put(carrySum, map.getOrDefault(carrySum, 0)+1);
		}
		return result;
	}
	
}
 











