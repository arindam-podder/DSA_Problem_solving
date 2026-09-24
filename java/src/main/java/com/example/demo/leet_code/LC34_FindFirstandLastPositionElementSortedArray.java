/**
 * 34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */




package com.example.demo.leet_code;

import java.util.Arrays;

public class LC34_FindFirstandLastPositionElementSortedArray {

	public static void main(String[] args) {
		int[] nums = {5,7,8,8,8,10}; int target = 10; 
		
		System.out.println( Arrays.toString(searchRange1(nums, target)) );
		
	}
	
	//binary search , once find any one 
    public static int[] searchRange1(int[] arr, int target) {
        int n=arr.length;
    	int l=0; int r=n-1; 
        while(l<=r) {
        	int mid= (l+r) / 2; 
        	if(arr[mid]== target) {
        		int ans[] = new int[2]; 
        		l=leftCheck(arr, 0, mid, target);
        		r=rightCheck(arr, mid, n-1, target);
        		ans[0]=l==-1? mid:l;
        		ans[1]=r==-1? mid:r;
        		return ans;
        	}
        	
        	//next window
        	if(arr[mid]>target) r=mid-1;
        	else l=mid+1;
        }
        return new int[] {-1, -1};
    }
    
    public static int leftCheck(int[] arr, int l, int r, int t) {
    	int lastFound = -1; 
    	while(l<=r) {
    		int mid=(l+r)/2; 
    		if(arr[mid]==t) {
    			lastFound = mid; 
    			r=mid-1; 
    		}
    		else {
    			l=mid+1;
    		}
    	}
    	
    	return lastFound; 
    }
    
    public static int rightCheck(int[] arr, int l, int r, int t) {
    	int lastFound = -1; 
    	while(l<=r) {
    		int mid=(l+r)/2; 
    		if(arr[mid]==t) {
    			lastFound = mid; 
    			l=mid+1; 
    		}
    		else {
    			r=mid-1;
    		}
    	}
    	return lastFound; 
    }
    

}














