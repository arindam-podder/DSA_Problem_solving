/**
 * 53. Maximum Subarray 

Given an integer array nums, find the 
subarray with the largest sum, and return its sum.

 
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */



package com.example.demo.leet_code;

public class LC53_MaximumSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, -4, 5 , -1};
		System.out.println(maxSubArraySum(arr));
		
	}
	
	
	public static int maxSubArraySum(int[] arr) {
        int temp = arr[0]; 
        int ans = arr[0];
        //just find the max value that we can get by add arr element - think wisely 
        for(int i=1; i<arr.length; i++) {
        	temp = Math.max(arr[i], temp+arr[i]); 
        	ans = Math.max(ans, temp);
        }
        return ans;
    }

}













