/*
 * Q4. Ath Magical Number

Problem Description
You are given three positive integers, A, B, and C.
 Any positive integer is magical if divisible by either B or C.
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Note: Ensure to prevent integer overflow while calculating.

Problem Constraints
1 <= A <= 109
2 <= B, C <= 40000

Input Format
The first argument given is an integer A.
The second argument given is an integer B.
The third argument given is an integer C.

Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Example Input
Input 1:
 A = 1
 B = 2
 C = 3
Input 2:
 A = 4
 B = 2
 C = 3

Example Output
Output 1:
 2
Output 2:
 6

Example Explanation
Explanation 1:
 1st magical number is 2.
Explanation 2:
 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.

 */


package com.example.demo.sclr_code.searching;

public class AthMagicalNumber {

	public static void main(String[] args) {
		
		System.out.println(athMagical(19, 11, 13));

	}
	
	 public static int athMagical(int A, int B, int C) {
	        long l = Math.min(B, C);
	        long h = A * l;
	        long lcm = getLCM(B, C);
	        long mod = 1000000007;
	        long ans = 0;
	        while (l <= h) {
	            long m = (l + h) / 2;
	            if ((m / B) + (m / C) - (m / lcm) == A) {
	                ans = m;
	                h = m - 1;
	            }
	            else if ((m / B) + (m / C) - (m / lcm) > A) {
	                h = m - 1;
	            }
	            else {
	                l = m + 1;
	            }
	        }
	        ans %= mod;
	        return (int)ans;
	    }
	    public static int getLCM(int a, int b) {
	        int x = a;
	        int y = b;
	        while (y != 0) {
	            int temp = y;
	            y = x % y;
	            x = temp;
	        }
	        int gcd = x;
	        int lcm = (a * b) / gcd;
	        return lcm;
	    }

}
















