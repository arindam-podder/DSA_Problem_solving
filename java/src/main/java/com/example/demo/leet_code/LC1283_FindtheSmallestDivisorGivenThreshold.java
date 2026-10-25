/**
 * 1283. Find the Smallest Divisor Given a Threshold

Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it,
 and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.

 
Example 1:
Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

Example 2:
Input: nums = [44,22,33,11,1], threshold = 5
Output: 44
 
Constraints:
1 <= nums.length <= 5 * 104
1 <= nums[i] <= 106
nums.length <= threshold <= 106
 */



package com.example.demo.leet_code;

public class LC1283_FindtheSmallestDivisorGivenThreshold {
	public static void main(String[] args) {
		int[] nums = {44,22,33,11,1}; int threshold = 5; 
		
		System.out.println( smallestDivisor1(nums, threshold) );
		
	}
	
	// fix max of arr , the l=1, r=max, do binary search to get smallest divisor in this range
    public static int smallestDivisor1(int[] nums, int threshold) {
    	int n=nums.length; 
    	int max=Integer.MIN_VALUE;
    	for(int i=0; i<n; i++) {
    		max = Math.max(max, nums[i]);
    	}
    	
    	int l=1; int r=max; 
    	int res=max; 
    	while(l<=r) {
    		int mid=(l+r)/2; 
    		if(isPossible(mid, nums, threshold)) {
    			res=mid; 
    			r=mid-1; 
    		}else {
    			l=mid+1;
    		}
    	}
    	
    	return res;
    	
    }
    
    
    public static boolean isPossible(int divisor, int[] arr, int t) {
    	int n=arr.length; 
    	int sum = 0; 
    	for(int i=0; i<n; i++) {
    		sum += arr[i]/divisor + arr[i]%divisor!=0? 1:0;
    		
    	}
    	if(sum<=t) return true; 
    	return false; 
    }
}












