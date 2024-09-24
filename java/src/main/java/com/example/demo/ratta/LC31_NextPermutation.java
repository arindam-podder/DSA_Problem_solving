/**
 * 31. Next Permutation   (https://www.youtube.com/watch?v=JDOXKqF60RQ)

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1],
[3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container according to their lexicographical 
order, then the next permutation of that array is the permutation that follows it in the sorted container. If such 
arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending 
order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger 
rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]
 
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100
 */



package com.example.demo.ratta;

import java.util.Arrays;

public class LC31_NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 1, 2};
		
		findNextPermutation(arr);
		
		System.out.println(Arrays.toString(arr));

	}
	
	public static void findNextPermutation(int[] arr) {
        //get increasing point from the backward
		int incIndex = -1;
		for(int i=arr.length-2; i>=0; i--) {
			if(arr[i]<arr[i+1]) {
				incIndex = i;
				break;
			}
		}
		
		//edge case 
		if(incIndex == -1) {
			reverse(arr, 0, arr.length-1);
			return;
		}
		
			
		//get just greater than the arr[incIndex] value from backward and swap
		for(int i=arr.length-1; i>incIndex; i--) {
			if(arr[i] > arr[incIndex]) {
				swap(arr, incIndex, i);
				break;
			}
		}
		
		//now reverse - incIndex to arr.lenth-1 
		reverse(arr, incIndex+1, arr.length-1);
		
    }
	
	
	public static void reverse(int[] arr, int i, int j) {
		while(i<j) {
			int temp = arr[i]; 
			arr[i] = arr[j]; 
			arr[j] = temp;
			
			i++; 
			j--;
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp;
	}

}
