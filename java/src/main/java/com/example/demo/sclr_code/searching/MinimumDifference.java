/*
 *Q2. Minimum Difference		(day 51 - HW question)

Problem Description
You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly built array is minimized.

The cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.

So if the newly built array is X, the element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.

Determine the minimum cost of the newly built array.

Problem Constraints
2 <= A <= 1000
2 <= B <= 1000
1 <= C[i][j] <= 106

Input Format
The first argument is an integer A denoting number of rows in the 2-D array.
The second argument is an integer B denoting number of columns in the 2-D array.
The third argument is a 2-D array C of size A x B.

Output Format
Return an integer denoting the minimum cost of the newly build array.

Example Input
Input 1:
 A = 2
 B = 2
 C = [ [8, 4]
      [6, 8] ]
Input 2:
 A = 3
 B = 2
 C = [ [7, 3]
       [2, 1]
       [4, 9] ]

Example Output
Output 1:
 0
Output 2:
 1
 
Example Explanation
Explanation 1:
 Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
Explanation 2:
 Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2). 
 */


package com.example.demo.sclr_code.searching;

import java.util.Arrays;

public class MinimumDifference {

	public static void main(String[] args) {
		int[][] arr = {{5,2,7,3}, {55, 33, 44, 99}, {8,4,11,9} };
		
		System.out.println( minimusCost(arr, 2, 4) );
			
	}
	
	
	public static int minimusCost(int[][] C, int A, int B) {				//debug it and understand 
		int x;
	    int ans = Integer.MAX_VALUE; // Initialize answer as a large number
	    int lb;
	    for (int i = 0; i < A; i++) {
	    	Arrays.sort(C[i]); // Sort each row of matrix
	    }
	    for (int i = 0; i < A - 1; i++) {
	    	for (int j = 0; j < B; j++) {
	    		lb = lower_bound(C[i + 1], C[i][j]); // check for next element as in soltion
	            if (lb != B) {
	            	ans = Math.min(ans, Math.abs(C[i][j] - C[i + 1][lb])); // Update answer
	            }
	            if (lb != 0) {
	            	ans = Math.min(ans, Math.abs(C[i][j] - C[i + 1][lb - 1]));
	            }
	    	}
	    }
	    return ans;
	}

	
	//function used to find element index just greater than or equal to val
	public static int lower_bound(int a[], int val) {
		int low = 0, high = a.length - 1, ans = a.length;
	    while (low <= high) {
	    	int mid = (high - low) / 2 + low;
	        if (a[mid] < val) {
	           low = mid + 1;
	        } else {
	           ans = mid;
	           high = mid - 1;
	        }
	    }
	    return ans;
	}
}














