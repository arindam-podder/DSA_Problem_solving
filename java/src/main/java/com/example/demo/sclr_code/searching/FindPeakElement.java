/*
 * Q2. Find a peak element
Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:
It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return the peak element.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
Input 2:
A = [5, 17, 100, 11]

Example Output
Output 1:
 5
Output 2:
 100

Example Explanation
Explanation 1:
 5 is the peak.
Explanation 2:
 100 is the peak.
 */

package com.example.demo.sclr_code.searching;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {11,3,8};
		
		System.out.println(peakElement(arr));

	}
	
	
	public static int peakElement(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }
		if(arr.length>1 && arr[0] > arr[1]) {
			return arr[0];
		}
		if(arr[arr.length-1] > arr[arr.length-2]) {
			return arr[arr.length-1];
		}
		int L = 1; 
		int R = arr.length-2; 
		int mid=0;
		while(L<=R) {
			mid = (L+R) / 2; 
			if(arr[mid] > arr[mid-1] && arr[mid]>arr[mid+1]) {
				return arr[mid];
			}
			if(arr[mid]> arr[mid-1]) {
				L = mid+1; 
			}
			else {
				R = mid-1;
			}
			
		}
		return  arr[mid];
    }

}



















