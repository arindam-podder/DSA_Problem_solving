/*
 * Q3. Minimum Number of Squares

Problem Description
Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.

Problem Constraints
1 <= A <= 105

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the minimum count.

Example Input
Input 1:
 A = 6
Input 2:
 A = 5

Example Output
Output 1:
 3
Output 2
 2


Example Explanation
Explanation 1:

 Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 Minimum count of numbers, sum of whose squares is 6 is 3. 
Explanation 2:

 We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
 */


package com.example.demo.sclr_code.dynamic_programing;

public class MinimumNumberSquares {

	public static void main(String[] args) {
		int[] arr = {-1, -1, -1, -1, -1, -1};
		
		System.out.println(minimumNumbeSquare(5, arr));
	}

	public static int minimumNumbeSquare(int A, int[] arr) {
		if(A == 0 ) {
			return 0;
		}
		if(arr[A] != -1) {
			return arr[A];
		}
		int tempAns = Integer.MAX_VALUE; 
		for(int i=1; i*i<= A; i++) {
			tempAns = Math.min(tempAns, A-(i*i));
		}
		arr[A] = tempAns+1;
		
		return arr[A];          
		
	}
}







