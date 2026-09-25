/**
 * 35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, 
return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */


package com.example.demo.leet_code;

public class LC35_SearchInsertPosition {

	public static void main(String[] args) {
		int arr[]= {2, 5, 8, 55}; int t=6;
	
	
		System.out.println( searchInsert1(arr, t) );
	}

	//binary search technique
    public static int searchInsert1(int[] arr, int t) {
        int n=arr.length; 
        if(arr[n-1]< t) return n;
        if(arr[0]> t) return 0; 
        
        int l=0; int r=n-1; 
        int notFoundPosi = -1; 
        while(l<=r) {
        	int mid = (l+r)/2; 
        	if(arr[mid] == t) return mid; 
        	
        	if(arr[mid]< t) {
        		l=mid+1;
        		notFoundPosi = l; 
        	}else {
        		r=mid-1; 
        		if(arr[r]<t) notFoundPosi = r+1;
        		else notFoundPosi=r;
        	}
        }
        
        return notFoundPosi;
    }
	
}
