/**
 * 209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater 
than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */


package com.example.demo.leet_code;

public class LC209_MinimumSizeSubarraySum {
	
	public static void main(String[] args) {
		int target = 7, nums[] = {2,3,1,2,4,3};
		//int target = 1, nums[] = {1,4,4};
		
		System.out.println( minSubArrayLen1(target, nums) );
		
	}
	
	public static int minSubArrayLen1(int target, int[] nums) {
        //return minsubArr1(target, nums);
        return minsubArr2(target, nums);
	}
	
	
	//brute force : find all sub array and get min sub arr with sum target  TLE
	public static int minsubArr1(int t, int[] arr) {
		int res = Integer.MAX_VALUE; 
		for(int i=0; i<arr.length; i++) {
			int curSum = arr[i];
			if(curSum>=t) return 1;
			for(int j=i+1; j<arr.length; j++) {
				curSum += arr[j];
				if(curSum>=t) res = Math.min(res, j-i+1);
			}
		}
		
		return res==Integer.MAX_VALUE ? 0: res;
		
	}
	
	
	//optimize : window + two pointer  "1 ms | Beats 99.92%"
	public static int minsubArr2(int t, int[] arr) {
		int res = Integer.MAX_VALUE; 
		int l=0; 
		int r=0; 
		int cur=0;
		while(r<arr.length) {
			cur += arr[r]; 
			
			while(cur >= t) {
				res = Math.min(res, r-l+1); 
				//shrink window by moving l towards right 
				cur -= arr[l]; 
				l+=1;
			}
			
			r += 1; 
		}
		return res==Integer.MAX_VALUE? 0: res;
	}

}
















