/**
 * 1800. Maximum Ascending Subarray Sum

Given an array of positive integers nums, return the maximum possible sum of an 
strictly increasing subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

 
Example 1:
Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.

Example 2:
Input: nums = [10,20,30,40,50]
Output: 150
Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.

Example 3:
Input: nums = [12,17,15,13,10,11,12]
Output: 33
Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.
 

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
 */


package com.example.demo.leet_code;

public class LC1800_MaximumAscendingSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12,17,15,13,10,11,12};
		
		System.out.println( maxAscendingSubArrSum(arr) );
		
	}
	
    public static int maxAscendingSubArrSum(int[] arr) {
        int max = arr[0]; 
        int curSum = arr[0];
        for(int i=1; i<arr.length; i++) {
        	if(arr[i] > arr[i-1]) {
        		curSum += arr[i]; 
        	}else {
        		max = Math.max(max, curSum); 
        		curSum = arr[i]; 
        	}
        }
        max = Math.max(max, curSum);
        
        return max; 
    }

}

















