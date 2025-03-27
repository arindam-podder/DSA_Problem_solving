/**
 * 2523. Closest Prime Numbers in Range

Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, 
return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

Example 1:
Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.

Example 2:
Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
 

Constraints:
1 <= left <= right <= 106
 */



package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2523_ClosestPrimeNumbersRange {

	public static void main(String[] args) {
		int left = 10, right = 19;
		
		System.out.println( Arrays.toString(closestPrimes2(left, right)));
	}
	
	
	public static int[] closestPrimes1(int left, int right) {
		boolean[] primeArr = getPrimeArr(right);
		int[] ans = new int[2];
		int[] tmp = new int[2];
		tmp[0] = -1; 
		tmp[1] = -1; 
		for(int i=left; i<=right; i++) {
			if(primeArr[i] == false) {
				if(tmp[0] == -1) {
					tmp[0] = i; 
					ans[0] = i;
				}else if(tmp[1] == -1) {
					tmp[1] = i;
					ans[1] = i;
 				}else{
 					tmp[0] = tmp[1];
 					tmp[1] = i;
					if(ans[1]-ans[0] > tmp[1]-tmp[0]) {
						ans[0] = tmp[0]; 
						ans[1] = tmp[1];
					}
					
				}
			}
		}
		if(tmp[0] == -1 || tmp[1] == -1) return new int[] {-1, -1};
		return ans;
	}
	
	public static int[] closestPrimes2(int left, int right) {
		List<Integer> primeArr = getPrimeArr(left, right);
		if(primeArr.size() < 2) return new int[] {-1, -1};
		int[] ans = new int[2];
		int[] tmp = new int[2];
		tmp[0] = ans[0] = primeArr.get(0); 
		tmp[1] = ans[1] = primeArr.get(1); 
		for(int i=2; i<primeArr.size(); i++) {
			tmp[0] = tmp[1];
			tmp[1] = primeArr.get(i);
			if (ans[1] - ans[0] > tmp[1] - tmp[0]) {
				ans[0] = tmp[0];
				ans[1] = tmp[1];
			}
		}
		
		return ans;
	}
	
	
	
	
	
	//here false means prime , true means not prime
	public static boolean[] getPrimeArr(int n) {
		boolean[] primes = new boolean[n+1];
		primes[1] = true;
		for(int i=2; i<=n; i++) {
			if(primes[i] == false) {
				int j = i*2; 
				while(j<=n) {
					primes[j] = true;
					j = j + i;
				}
			}
		}
		return primes;
	}
	
	
	//here only adding primes for the given range
	public static List<Integer> getPrimeArr(int l, int n) {
		List<Integer> lst = new ArrayList<>();
		boolean[] primes = new boolean[n+1];
		primes[1] = true;
		for(int i=2; i<=n; i++) {
			if(primes[i] == false) {
				if(i>=l)lst.add(i);
				int j = i*2; 
				while(j<=n) {
					primes[j] = true;
					j = j + i;
				}
			}
		}
		return lst;
	}


}
