/*
 * Q1. Max Sum Contiguous Subarray

Problem Description
Find the maximum sum of contiguous non-empty subarray within an array A of length N.

Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000



Input Format
The first and the only argument contains an integer array, A.

Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.


Example Input
Input 1:
 A = [1, 2, 3, 4, -10] 
Input 2:
 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 

Example Output
Output 1:
 10 
Output 2:
 6 


Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6. 
 */

package com.example.demo.sclr_code;

public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(new int[] {-6,-7,-3,8,9} ));
		System.out.println(maxSubArray2(new int[] {-6,-7,-3,8,9} ));
		
	}
	
	
	public static int maxSubArray(final int[] A) {
        //optimized
        int temp = A[0];
        int result = A[0];
        for(int i=1; i<A.length; i++){
           temp = Math.max(A[i], temp+A[i]);
           result = Math.max(result, temp);
        }
        return result;
    }
	
	
	public static int maxSubArray2(int[] A) {
		int current = A[0];
		int maxSum = A[0];
		for(int i=1; i<A.length; i++) {
			current = current + A[i]; 
			if(current<A[i]) {
				current = A[i]; 
			}
			
			maxSum = maxSum >= current ? maxSum : current;
		}
		return maxSum;
	}
}
