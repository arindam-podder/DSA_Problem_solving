/*
 *Q2. Maximum Unsorted Subarray

Problem Description
Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.

Note :
Follow 0-based indexing, while returning the sub-array's starting and ending indexes.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000

Input Format
First and only argument is an array of non-negative integers of size N.

Output Format
Return an array of length two where,
the first element denotes the starting index(0-based) and
the second element denotes the ending index(0-based) of the sub-array.
If the array is already sorted, return an array containing only one element i.e. -1.

Example Input
Input 1:
A = [1, 3, 2, 4, 5]
Input 2:
A = [1, 2, 3, 4, 5]

Example Output
Output 1:
[1, 2]
Output 2:
[-1]

Example Explanation
Explanation 1:
If we sort the sub-array [A1, A2] then the whole array A gets sorted.

Explanation 2:
A is already sorted. 
 */


package com.example.demo.sclr_code.sorting;

import java.util.Arrays;

public class MaximumUnsortedSubarray {

	public static void main(String[] args) {
		int[] arr = {1, 5, 5, 5, 3, 6, 7, 4, 8, 9};

		System.out.println(Arrays.toString(solve(arr)));
	}
	
	//solution by checking adjacent 
    public  static int[] solve(int[] A){
    	int[] result = new int[2];
        int n = A.length;
    	int i=0, j=n-1;
    	while(i<n-1 && A[i] <= A[i+1]) {
    		i++;
    	}
    	if(i==n-1) {				//if already sorted 
    		return new int[] {-1};
    	}
    	while(j>0 && A[j]>=A[j-1]) {
    		j--;
    	}
    	
    	//i to j is now subarray, find min & max
    	int min = A[i]; 
    	int max = A[i]; 
    	for(int k=i; k<=j; k++) {
    		min = Math.min(min, A[k]);
    		max = Math.max(max, A[k]);
    	}
    	int left = 0; 
    	int right =n-1; 
    	while(A[left]<=min && left<=i) {
    		left++;
    	}
    	while(A[right]>=max && right>=j) {
    		right--;
    	}
    	result[0] = left; 
    	result[1] = right;
    	return result;
    }

}






















