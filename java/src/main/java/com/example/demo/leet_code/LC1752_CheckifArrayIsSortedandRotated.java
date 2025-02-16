/**
 * 1752. Check if Array Is Sorted and Rotated

Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number 
of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.
Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], 
where % is the modulo operation.


Example 1:
Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].

Example 2:
Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.

Example 3:
Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC1752_CheckifArrayIsSortedandRotated {

	public static void main(String[] args) {
		int[] arr = {2, 6, 9};
		System.out.println( checkIsSortedAndRotate(arr) );
		System.out.println( chekArray(arr) );
	}
	
	
	//BF = sort arr , get all rotate arr then chcek with given input  tc(n3)
		public static boolean checkIsSortedAndRotate(int[] nums) {
	        int[] temp = new int[nums.length]; 
			for(int i=0; i<nums.length; i++) temp[i] = nums[i];
			Arrays.sort(temp);
			//rotate 	
			for(int i=0; i<nums.length; i++){
				int[] rotate = rotate(temp, i);
				if(compare(rotate, nums)) return true;
			}
			return false; 
	    }
		public static boolean compare(int[] arr1, int[] arr2){
			for(int i=0; i<arr1.length; i++){
				if(arr1[i] != arr2[i]){
					return false;
				}
			} 
			return true;
		}
		public static void reverse(int[] arr, int start, int end){
			while(start<end){
				int tmp = arr[start]; 
				arr[start] = arr[end]; 
				arr[end] = tmp; 

				start ++; 
				end--; 
			}
		}
		public static int[] rotate(int[] arr, int i){
			int[] tmp = new int[arr.length]; 
			for(int idx=0; idx<arr.length; idx++) tmp[idx] = arr[idx];
			if(i==0) return tmp; 
			reverse(tmp, 0, tmp.length-1); 
			reverse(tmp, 0, i-1); 
			reverse(tmp, i, arr.length-1); 
			return tmp;
		}
	
	
	//optimized :  find drop , act uppon this 
	public static boolean chekArray(int[] arr) {
		int dropCount = 0; 
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < arr[i-1]) {
				dropCount += 1; 
			}
			
			if(dropCount > 1) return false; 
			
			if(dropCount ==1 && arr[i]>arr[i]) return false;
			
		}
		
		return true;
	}
	

}
