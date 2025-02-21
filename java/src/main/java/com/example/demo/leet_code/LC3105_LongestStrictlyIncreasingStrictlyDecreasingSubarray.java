/**
 * 3105. Longest Strictly Increasing or Strictly Decreasing Subarray

You are given an array of integers nums. Return the length of the longest subarray of nums which is either 
strictly increasing or strictly decreasing.

Example 1:
Input: nums = [1,4,3,3,2]
Output: 2
Explanation:
The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
Hence, we return 2.

Example 2:
Input: nums = [3,3,3,3]
Output: 1
Explanation:
The strictly increasing subarrays of nums are [3], [3], [3], and [3].
The strictly decreasing subarrays of nums are [3], [3], [3], and [3].
Hence, we return 1.

Example 3:
Input: nums = [3,2,1]
Output: 3
Explanation:
The strictly increasing subarrays of nums are [3], [2], and [1].
The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].
Hence, we return 3.

Constraints:
1 <= nums.length <= 50
1 <= nums[i] <= 50

 */



package com.example.demo.leet_code;

public class LC3105_LongestStrictlyIncreasingStrictlyDecreasingSubarray {

	public static void main(String[] args) {
		int[] arr = {1,4,3,3,2,1};
		
		System.out.println( longestMonotonicSubarrayFind(arr) );
	}
	
	
    public static int longestMonotonicSubarrayFind(int[] nums) {
        int result = 1; 
        int inc = 1; 
        int dec = 1; 
        for(int i=1; i<nums.length; i++) {
        	if(nums[i] == nums[i-1]) inc = dec = 1;
        	else if (nums[i] > nums[i-1]) {
        		inc += 1; 
        		dec = 1; 
        		result = Math.max(result, inc); 
        	}else {
        		dec += 1; 
        		inc = 1;
        		result = Math.max(result, dec);
        	}
        }
        return result;
    }

}

















