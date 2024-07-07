/**
 * 15. 3Sum
Medium
Topics
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3Sum {
	public static void main(String[] args) {
		
		int[] arr = {-1, 0, 1, 2, -1, -4};
		
		System.out.println(threeSum(arr));
		
	}
	
	
	public static List<List<Integer>> threeSum(int[] nums){
		//sort the array first 
		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			//fixed a , for b,c use two pointer 
			if( i>0 && nums[i] == nums[i-1]) continue; 
			
			int a = nums[i]; 
			int l = i+1; 
			int r = nums.length-1; 
			while(l<r) {
				int sum3 = a + nums[l] + nums[r]; 
				
				if(sum3 > 0) {
					r -= 1;
				}else if(sum3<0) {
					l += 1;
				}else {
					result.add(List.of(a, nums[l], nums[r]) );
					l += 1; 
					while(l<r && nums[l] == nums[l-1] ) {
						l += 1;
					}
				}
				
			}	
		}
		
		return result; 
	}
	
}






















