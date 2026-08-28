/**
 * 18. 4Sum

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_4Sum {
	public static void main(String[] args) {
		int[] nums = {1,0,-1,0,-2,2}; 
		int target = 0;
		
		System.out.println( fourSum1(nums, target) );
		
	}
	
	
    public static List<List<Integer>> fourSum1(int[] arr, int target) {
    	Arrays.sort(arr);
    	List<List<Integer>> result = new ArrayList<>(); 
    	int n = arr.length;
    	for(int i=0; i<n; ) {
    		for(int j=i+1; j<n; ) {
    			int l=j+1; int r=n-1;; 
    			while(l<r) {
    				int cur = arr[i] + arr[j] + arr[l] + arr[r]; 
    				if(cur>target) r--;
    				else if(cur<target) l++; 
    				else {
    					List<Integer> list = List.of(arr[i], arr[j], arr[l], arr[r]);
    					result.add(list);
    					l++;
    					//to avoid duplicate result, make sure same l not present next 
    					while(l<n && arr[l-1]==arr[l] ) {
    						l++;
    					}
    				}
    			}
    			j++;
    			//to avoid duplicate result, make sure same j not present next 
    			while(j<n && arr[j-1]==arr[j] ) {
					j++;
				}
    		}
    		i++;
    		//to avoid duplicate result, make sure same j not present next 
			while(i<n && arr[i-1]==arr[i] ) {
				i++;
			}
    	}
    	
    	return result;
    }

}
