/**
 * 152. Maximum Product Subarray

Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.


Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
Constraints:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer
 */



package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.TreeSet;

public class LC152_MaximumProductSubarray {

	public static void main(String[] args) {
		int[] nums = {2,3,-2,4};
		
		System.out.println( maxProduct1(nums) );
		
	}
	
    public static int maxProduct1(int[] nums) {
        //return bf(nums);
    	//return memrize(nums);
    	return optimized(nums);
    }
    
    //brute force - get all sub array and their sum then return max 		TLE
    public static int bf(int[] arr) {
    	//TreeSet<Integer> set = new TreeSet<>();
    	int res = Integer.MIN_VALUE;
    	for(int i=0; i<arr.length; i++) {
    		for(int j=i; j<arr.length; j++) {
    			int l=i; int r=j;
    			res = Math.max(res, getSum(l, r, arr));
    		}
    	}
    	return res;
    }
    //TLE
    public static int memrize(int[] arr) {
    	//TreeSet<Integer> set = new TreeSet<>();
    	int res = Integer.MIN_VALUE;
    	int[][] dp = new int[arr.length][arr.length];
    	for(int[] a : dp) Arrays.fill(a, Integer.MIN_VALUE);
    	for(int i=0; i<arr.length; i++) {
    		for(int j=i; j<arr.length; j++) {
    			int l=i; int r=j;
    			int curSum = getSum(l, r, arr, dp);
    			res = Math.max(res, getSum(l, r, arr, dp));
    		}
    	}
    	return res;
    }
    public static int getSum(int l, int r, int[] arr) {
    	int sum  = 1; 
    	while(l<=r) {
    		sum = sum * arr[l++];
    	}
    	return sum; 
    }
    public static int getSum(int l, int r, int[] arr, int[][] dp) {
    	if(l<r && dp[l][r-1] != Integer.MIN_VALUE) return dp[l][r-1] * arr[r];
    	
    	int sum  = 1;  	
    	while(l<=r) {
    		sum = sum * arr[l++];
    	}
    	return sum; 
    }
    
    
    //observation : 
    // 1. all positive   2. even negetive  3. odd negetive   4. zeros 
    public static int optimized(int[] arr) {
    	int pre = 1; int suf = 1; 
    	int res = Integer.MIN_VALUE; 
    	for(int i=0; i<arr.length; i++) {
    		if(pre == 0) pre = 1; 
    		if(suf == 0) suf =1; 
    			
    		pre = pre * arr[i]; 
    		suf = suf * arr[arr.length-i-1];
    		
    		res = Math.max(res,  Math.max(pre, suf));
    	}
    	
    	return res;
    }

}















