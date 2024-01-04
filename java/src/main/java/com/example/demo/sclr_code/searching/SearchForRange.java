/*
 * Q3. Search for a Range

Problem Description
Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that 
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Your algorithm's runtime complexity must be in the order of O(log n).

Problem Constraints
1 <= N <= 106
1 <= A[i], B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].

Example Input
Input 1:
 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:
 A = [5, 17, 100, 111]
 B = 3

Example Output
Output 1:
 [3, 4]
Output 2:
 [-1, -1]

Example Explanation
Explanation 1:
The first occurrence of 8 in A is at index 3.
 The last occurrence of 8 in A is at index 4.
 ans = [3, 4]
Explanation 2:
 There is no occurrence of 3 in the array.

 */


package com.example.demo.sclr_code.searching;

import java.util.Arrays;

public class SearchForRange {

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 
				5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 
				7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 
				8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 
				10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		
		//System.out.println(arr.length);
		System.out.println(Arrays.toString(leftMostRightMostPosition(arr, 10)));

	}
	
	 public static int[] leftMostRightMostPosition(int[] A, int B){
	        int arrayLength = A.length;
	        int[] result = {-1,-1};
	        //edge cases , if B is not in range of A[elememts]
	        if(B<A[0] || B>A[arrayLength-1]){
	            return result;
	        }
	        int L=0; int R=arrayLength-1;
	        while(L<=R){
	            int mid=(L+R)/2; 
	            if(A[mid] == B){
	            	result[0] = leftMost(A, mid, B); 
	            	result[1] = rightMost(A, mid, B);
	                return result;
	            }
	            if(A[mid]> B){
	                R = mid-1;
	            }else{
	                L = mid+1;
	            }
	        }
	        return result; 
	 }	        
	        
	 public static int leftMost(int[] arr, int mid, int B) {		//this to check better left most 
		 int leftMost = mid; 
		 int L=0; int R=mid-1;
		 while(L<=R) {
			 mid = (L+R)/2; 
			 if(arr[mid]==B) {
				 leftMost = mid; 
				 R = mid-1;
			 }
			 if(arr[mid] < B) {
				 L = mid+1;
			 }
		 }
		 return leftMost;
	 }
	        
	 public static int rightMost(int[] arr,int mid, int B) {		//this to check better right most 
		 int rightMost = mid; 
		 int L=mid+1; int R=arr.length-1;
		 while(L<=R) {
			 mid = (L+R)/2; 
			 if(arr[mid]==B) {
				 rightMost = mid; 
				 L = mid+1;
			 }
			 if(arr[mid] > B) {
				 R = mid-1;
			 }
		 }
		 return rightMost;
	 }
	 
}//class end



















