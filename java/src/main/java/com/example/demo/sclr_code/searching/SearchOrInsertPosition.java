/*
 *Q1. Sorted Insert Position

Problem Description
You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

If the target value is present, return its index.
If the target value is not found, return the index of least element greater than equal to B.
Your solution should have a time complexity of O(log(N)).

Problem Constraints
1 <= N <= 106
1 <= A[i] <= 105
1 <= B <= 105

Input Format
The first argument is an integer array A of size N.
The second argument is an integer B.

Output Format
Return an integer denoting the index of target value.

Example Input
Input 1:
A = [1, 3, 5, 6]
B = 5 
Input 2:
A = [1, 4, 9]
B = 3

Example Output
Output 1:
2 
Output 2:
1

Example Explanation
Explanation 1:

The target value is present at index 2. 
Explanation 2:

The target value should be inserted at index 1. 
 */

package com.example.demo.sclr_code.searching;

public class SearchOrInsertPosition {

	public static void main(String[] args) {
		int[] arr = {2,4,5,10};
		int search = 6; 
		
		System.out.println(solutionBinarySearch(arr, search));
		
	}
	
	//using binary search 
	public static int solutionBinarySearch(int[] arr, int b) {
		 if(b<arr[0]){
			 return 0;
	     }
	     if(b>arr[arr.length-1]){
	    	 return arr.length;
	     }
	        
		int L = 0; 
		int R = arr.length-1;
		int mid = 0;
		while(L<=R) {
			mid = (L+R)/2;
			if(arr[mid] == b) return mid;
			else if(arr[mid] > b) { 
				if(mid>0 && arr[mid-1]< b ) {
					return mid;
				}
				R = mid-1;
			}
			else {
				if(mid<arr.length-1 && arr[mid+1]>= b) {
					return mid+1;
				}
				L = mid+1;
			}
		}
		return mid+1;
	}

}




















