/**
 * 238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all 
the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 */



package com.example.demo.leet_code;

public class LC238_ProductArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//use multiplication prefix, suffix rule
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        //step 1 - multiplication prefix 
        ans[0] = 1; 
        for(int i=1; i<nums.length; i++) {
        	ans[i] = ans[i-1] * nums[i-1];
        }
        
        //step 2 - multiplication suffix
        int suffix = 1; 
        for(int i=nums.length-1; i>=0; i--) {
        	ans[i] = ans[i] * suffix; 
        	suffix = suffix * nums[i]; 
        }
        return ans; 
    }
	

    
}






