/*
 * Q1. Delete one

Problem Description
Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.

Problem Constraints
2 <= N <= 105
1 <= A[i] <= 109

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the maximum value of GCD.

Example Input
Input 1:
 A = [12, 15, 18]
Input 2:
 A = [5, 15, 30]


Example Output
Output 1:
 6
Output 2:
 15


Example Explanation

Explanation 1:
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
 */


package com.example.demo.sclr_code;

public class DeleteOneGCD {

	public static void main(String[] args) {
		
		System.out.println(solve(new int[]{21,7,3,42,63}));

	}
	
	public static int solve(int[] A) {
        int[] leftGCD = new int[A.length];
        leftGCD[0] = A[0];
        int[] rightGCD = new int[A.length];
        rightGCD[rightGCD.length-1] = A[A.length-1];
        for(int i=1; i<A.length; i++){
            leftGCD[i] = gcdOfTwoNum(leftGCD[i-1], A[i]);
            rightGCD[rightGCD.length-(i+1)] = gcdOfTwoNum(rightGCD[rightGCD.length-i],A[rightGCD.length-(i+1)]);
        }
        int ans = 0; 
        for(int i=0; i<A.length; i++){
            int left=0, right=0;
            if(i!=0){
                left = leftGCD[i-1];
            }
            if(i!=A.length-1){
                right = rightGCD[i+1];
            }
            ans = Math.max(ans, gcdOfTwoNum(left,right));
        }
        return ans;
    }


    public static int gcdOfTwoNum(int A, int B){
        if(B==0){
            return A;
        }
        return gcdOfTwoNum(B, A%B);
    }

}


















