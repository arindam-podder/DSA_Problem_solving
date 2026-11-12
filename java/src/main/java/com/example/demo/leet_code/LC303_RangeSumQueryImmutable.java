/**
 * 303. Range Sum Query - Immutable

Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive 
(i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:
Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]
Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 

Constraints:
1 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= left <= right < nums.length
At most 104 calls will be made to sumRange.
 */




package com.example.demo.leet_code;

public class LC303_RangeSumQueryImmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static class NumArray {
		
		int[] arr; 
		int[] prefixSum; 

	    public NumArray(int[] nums) {
	    	arr = new int[nums.length];
            prefixSum = new int[nums.length];
	        for(int i=0; i<nums.length; i++) {
	        	arr[i] = nums[i]; 
	        	if(i==0) prefixSum[i] = arr[i];
	        	else prefixSum[i] = prefixSum[i-1] + arr[i];
	        }
	    }
	    
	    public int sumRange(int left, int right) {
	        return left==0? prefixSum[right]: prefixSum[right]-prefixSum[left-1];
	    }
	}

}
