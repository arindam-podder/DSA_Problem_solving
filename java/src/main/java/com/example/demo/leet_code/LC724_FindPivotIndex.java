/**
 * 724. Find Pivot Index

Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of 
all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. 
This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

Example 1:
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

Example 2:
Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.

Example 3:
Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0

Constraints:
1 <= nums.length <= 104
-1000 <= nums[i] <= 1000
 */


package com.example.demo.leet_code;



public class LC724_FindPivotIndex {

	public static void main(String[] args) {
		int[] arr = {1,7,3,6,5,6};
		
		System.out.println(leftMostPivotIndex(arr));
	}
	
	
	//approach : prefix sum 
	public static int leftMostPivotIndex(int[] arr) {
		int[] prefixSumFromLeft = getPrefixSumFromLeft(arr);
		for(int i=0; i<arr.length; i++) {
			if(i==0) {
				//for 0 index, left val is Zero and check right val 
				if(prefixSumFromLeft[prefixSumFromLeft.length-1] - prefixSumFromLeft[i] == 0) {
					return i;
				}
			}else if(i==arr.length-1) {
				//for last index, right val is Zero and check left val 
				if(prefixSumFromLeft[i-1] == 0) {
					return i;
				}
			}else {
				if(prefixSumFromLeft[i-1] == prefixSumFromLeft[prefixSumFromLeft.length-1]-prefixSumFromLeft[i]) {
					return i;
				}
			}
		}
		
		//if no pivot return -1 
		return -1;
	}
	
	
	public static int[] getPrefixSumFromLeft(int[] arr) {
		int[] leftPrefix=new int[arr.length]; 
		leftPrefix[0] = arr[0];
		for(int i=1; i<arr.length; i++) {
			leftPrefix[i] = leftPrefix[i-1] + arr[i];
		}
		return leftPrefix;
	}

}
