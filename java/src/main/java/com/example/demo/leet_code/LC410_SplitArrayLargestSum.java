/**
 * 410. Split Array Largest Sum

Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.
 
Example 1:
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

Example 2:
Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:
1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
 */



package com.example.demo.leet_code;

public class LC410_SplitArrayLargestSum {

	public static void main(String[] args) {
		int[] nums = {7,2,5,10,8}; int k = 2; 
		
		System.out.println( splitArray1(nums, k) );
		
	}
	
	//binary serach range Max(arr) to sum(arr)
    public static int splitArray1(int[] arr, int k) {
    	int n=arr.length;
    	int max=arr[0];
    	int sum=0;
    	for(int i=0; i<n; i++) {
    		sum=sum+arr[i]; 
    		if(arr[i]>max) max = arr[i]; 
    	}
    	
    	int l=max; int r=sum;
    	int result=max;
    	while(l<=r) {
    		int mid=(l+r)/2; 
    		if(kSplitPossible(mid, arr, k)) {
    			result=mid; 
    			r=mid-1; 
    		}else {
    			l=mid+1; 
    		}
    	}
    	return result;
    }
    
    public static boolean kSplitPossible(int limit, int[] arr, int k) {
    	int sum=0; 
    	for(int i=0; i<arr.length; i++) {
    		sum=sum+arr[i]; 
    		if(sum>limit) {
    			k-=1; 
    			sum=arr[i];
    		}
    		if(k<=0) return false;    		
    	}
    	return true;
    }
    
}
