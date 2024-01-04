/*
 * Q4. Single Element in Sorted Array

Problem Description
Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

Elements which are appearing twice are adjacent to each other.

NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the single element that appears only once.

Example Input
Input 1:
A = [1, 1, 7]
Input 2:
A = [2, 3, 3]

Example Output
Output 1:
 7
Output 2:
 2

Example Explanation
Explanation 1:
 7 appears once
Explanation 2:
 2 appears once
 */

package com.example.demo.sclr_code.searching;

public class SingleElementSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int uniqueElement(int[] A){
        if(A.length == 1) return A[0];
        if(A[0]!=A[1]) return A[0];
        if(A[A.length-1]!=A[A.length-2]) return A[A.length-1];
        int L = 1; int R = A.length-2;
        while(L<=R){
            int mid = (L+R)/2; 
            if(A[mid] == A[mid-1]) mid = mid-1 ;            //mid correction , place mid poin at left of duplicate 
            if(A[mid] != A[mid+1]) return A[mid]; 
            if(mid%2==0) L = mid + 2;                   //even position 
            else R = mid-1;             //odd position
        }
        return -1;
    }

}
