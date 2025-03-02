/**
 * 1749. Maximum Absolute Sum of Any Subarray

You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is 
abs(numsl + numsl+1 + ... + numsr-1 + numsr).
Return the maximum absolute sum of any (possibly empty) subarray of nums.
Note that abs(x) is defined as follows:
If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x.
 

Example 1:
Input: nums = [1,-3,2,3,-4]
Output: 5
Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.

Example 2:
Input: nums = [2,-5,1,-4,3,-2]
Output: 8
Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.
 
Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */



package com.example.demo.leet_code;

public class LC1749_MaximumAbsoluteSumofAnySubarray {

	public static void main(String[] args) {
		//int[] arr = {2,-5,1,-4,3,-2};
		int[] arr = {-10,-5,-3,-3,-9,0,10,10,5,5,1,1,2,4,1,10,-3,7,-3,-10};
		
		System.out.println( kadenMin(arr) );
		System.out.println( kadenMax(arr) );
		System.out.println( maxAbsoluteSumFind(arr) );
	}
	//bf  - find all sub array and get max abs sum 
	
	//optimized , kaden's algo , while trbverseing try to get max from the subarray 
    public static int maxAbsoluteSumFind(int[] nums) {
        return Math.max( Math.abs(kadenMin(nums)) , kadenMax(nums));
    }
    
    public static int kadenMin(int[] arr) {
    	int result = arr[0]<0? arr[0]: 0; 
    	int cur = arr[0]<0? arr[0]: 0;
    	for(int i=1; i<arr.length; i++) {
    		if(cur + arr[i] > 0) {
    			cur = 0;
    		}else {
    			cur += arr[i]; 
    		}
    		result = Math.min(result, cur);
    	}
    	return result;
    }
    public static int kadenMax(int[] arr) {
    	int result = arr[0]>0? arr[0]: 0; 
    	int cur = arr[0]>0? arr[0]: 0;
    	for(int i=1; i<arr.length; i++) {
    		if(cur+arr[i] < 0) {
    			cur = 0;
    		}else {
    			cur += arr[i]; 
    		}
    		result = Math.max(result, cur);
    	}
    	return result;
    }
	

}




















