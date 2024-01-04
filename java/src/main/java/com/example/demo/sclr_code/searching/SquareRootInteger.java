/*
 * Q1. Square Root of Integer

Problem Description
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

The value of A can cross the range of Integer.

NOTE: 
   Do not use the sqrt function from the standard library. 
   Users are expected to solve this in O(log(A)) time.

Problem Constraints
0 <= A <= 1010

Input Format
The first and only argument given is the integer A.

Output Format
Return floor(sqrt(A))

Example Input
Input 1:
 11
Input 2:
 9

Example Output
Output 1:
 3
Output 2:
 3

Example Explanation
Explanation 1:
When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
Explanatino 2:
When A = 9 which is a perfect square of 3, so we return 3.
 */

package com.example.demo.sclr_code.searching;

public class SquareRootInteger {

	public static void main(String[] args) {
		System.out.println(sqrt(999999));
		//System.out.println(458753*458753);

	}
	
	public static int sqrt(int A) {
        long L=1; long R=A; 
        long sqrt =0; 
        while(L<=R){
            long mid = (L+R)/2;
            if(mid*mid == A) return (int)mid; 
            if(mid*mid < A) {
                sqrt = mid; 
                L = mid+1;
            }else{
                R = mid-1;
            }
        }
        return (int)sqrt;
    }

}















