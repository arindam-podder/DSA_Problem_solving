/*
 * Q1. Prime Sum

Problem Description
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
If there is more than one solution possible, return the lexicographically smaller solution.
If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
[a, b] < [c, d], If a < c OR a==c AND b < d. 

NOTE: A solution will always exist. Read Goldbach's conjecture.

Problem Constraints
4 <= A <= 2*107

Input Format
First and only argument of input is an even number A.

Output Format
Return a integer array of size 2 containing primes whose sum will be equal to given number.

Example Input
 4
Example Output
 [2, 2]

Example Explanation
 There is only 1 solution for A = 4.
 */

package com.example.demo.sclr_code;

import java.util.Arrays;

public class PrimeSumSeiveOfEratosthenes {

	public static void main(String[] args) {
		
		System.out.println( Arrays.toString(findTwoPrime(27)));
		
	}
	
	
	public static int[] findTwoPrime(int A) {
		boolean[] soe = seiveOfEratosthenes(A);
		int[] result = new int[2];
		for(int i=2; i<A+1; i++) {
			if(soe[i] && soe[A-i]) {
				result[0] = i;
				result[1] = A-i;
				return result;
			}
		}
		return null;
	}
	
	
	public static boolean[] seiveOfEratosthenes(int A) {
		boolean[] SOE = new boolean[A+1];
		//initially marking all as true (prime)
		for(int i=2; i<A+1; i++) {
			SOE[i] = true;
		}
		//now mark all as false that are multiple of primes (seive of eratosthenes algo)
		for(int i=2; i<=A/i; i++) {
			if(SOE[i]==true) {
				for(int j=i*i; j<A+1; j=j+i) {
					SOE[j] = false;
				}
			}
		}
		return SOE;
	}

}






















