/**
 * 169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority 
element always exists in the array.

 

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 
Follow-up: Could you solve the problem in linear time and in O(1) space?

 */



package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.Map;

public class LC169_MajorityElement {

	public static void main(String[] args) {
		int[] arr = {2,2,1,1,1,2,2};
		
		System.out.println( majority(arr) );
		System.out.println( majority(arr) );
	}

	
	//map to keep count 
	public static int majority(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>(); 
		for(int n : arr) {
			map.put(n, map.getOrDefault(n, 0)+1); 
			if(map.get(n) > arr.length/2) {
				return n;
			}
		}
		return Integer.MIN_VALUE;
	} 
	
	
	//optimized , use candidate algo 
	public static int majority2(int[] arr) {
		int majo = arr[0];
		int count = 1;
		for(int i=1; i<arr.length; i++) {
			 if(arr[i] == majo) {
				 count += 1;
			 }else {
				 count -= 1;
			 }
			 
			 if(count == 0) {
				 majo = arr[i]; 
				 count = 1;
			 }
			
		}
		return majo;
	} 
	
	
	
	
}

















