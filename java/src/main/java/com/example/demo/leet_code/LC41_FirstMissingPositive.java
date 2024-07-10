/**
 * 41. First Missing Positive  (Hard)

Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
 */



package com.example.demo.leet_code;

public class LC41_FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1, -1, -1, -1}; 
		
		System.out.println(misingPositive(arr));

	}
	
	public static int misingPositive(int[] arr) {
		
		//position each value at its proper index 
		for(int i=0; i<arr.length; i++) {
			int cur = arr[i]; 
			while(cur>0 && cur<=arr.length && cur!=i+1 ) {
				int temp = arr[i]; 
				arr[i] = arr[cur-1];
				arr[cur-1] = temp;
				
				//update the cur after swapping 
				cur = arr[i];
			}
		}		
		
		
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] !=  i+1) {
				return i+1; 
			}
		}
		
		return arr.length+1; 
	}//misingPositive method end

}//class end












