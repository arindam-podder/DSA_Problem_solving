/**
 * 75. Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same 
color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

 
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 */



package com.example.demo.leet_code;

import java.util.Arrays;

public class LC75_SortColors {

	public static void main(String[] args) {
//		int[] arr = {2,0,2,1,1,0};
		int[] arr = {1,0,1,1,1,0};
		
		
		sortColors(arr);
		
		System.out.println( Arrays.toString(arr));
		
	}

	public static void sortColors(int[] arr) {
        //two pointer + swap tech
		int p1=0; 
		int p2=arr.length-1;
		while(p1<p2) {
			if(arr[p1]==0) p1++; 
			else if(arr[p1]==1){
				//llok for zero and swap 
				for(int i=p1+1; i<=p2; i++) {
					if(arr[i] == 0) {
						swap(arr, p1, i);
						break;
					}
				}
				p1++;
			}
			else {
				swap(arr, p1, p2);
				p2--;
			}
		}
	
    }
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp;
	}
	
}










