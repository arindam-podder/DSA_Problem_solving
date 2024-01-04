/*
 * (HW)	(12july day-44 adv dsa math-4 combinatorics)
 * Q2. Consecutive Numbers Sum

Problem Description
Given a positive integer A.

Return the number of ways it can be written as a sum of consecutive positive integers.

Problem Constraints
1 <= A <= 109

Input Format
The first and the only argument of input contains an integer, A.

Output Format
Return an integer, representing the answer as described in the problem statement.

Example Input
Input 1:
 A = 5
Input 2:
 A = 15

Example Output
Output 1:
 2
Output 2:
 4

Example Explanation
Explanation 1:
 The 2 ways are:
 => [5]
 => [2, 3]
Explanation 2:
 The 4 ways are:
 => [15]
 => [7, 8]
 => [4, 5, 6] 
 => [1, 2, 3, 4, 5]
 */

package com.example.demo.sclr_code;

public class ConsecutiveNumbersSum {

	public static void main(String[] args) {
		
		System.out.println(solve(15));
		
	}
	
	public static int solve(int A) {
	        int ans = 0;
	        long n = 1;
	        while(n * (n + 1) <= 2 * A) {
	            // check if the difference between A and sum of n consecutive numbers is a multiple of n    
	            long sum = n * (n + 1) / 2;
	            if((A - sum) % n == 0) ans++;
	            n++;
	        }
	        return ans;
	 }

}

















