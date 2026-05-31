/**
 * 3783. Mirror Distance of an Integer

You are given an integer n.

Define its mirror distance as: abs(n - reverse(n))​​​​​​​ where reverse(n) is the integer formed by reversing the digits of n.

Return an integer denoting the mirror distance of n​​​​​​​.

abs(x) denotes the absolute value of x.


Example 1:
Input: n = 25
Output: 27
Explanation:
reverse(25) = 52.
Thus, the answer is abs(25 - 52) = 27.

Example 2:
Input: n = 10
Output: 9
Explanation:
reverse(10) = 01 which is 1.
Thus, the answer is abs(10 - 1) = 9.

Example 3:
Input: n = 7
Output: 0
Explanation:
reverse(7) = 7.
Thus, the answer is abs(7 - 7) = 0.
 

Constraints:
1 <= n <= 109
 */

package com.example.demo.leet_code;

public class LC3783_MirrorDistanceInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println( mirrorDistance(71));
	}
	
    public static int mirrorDistance(int n) {
        int reverse = rev(n); 
        return Math.abs(n-reverse);
        
    }
    
    public static int rev(int n) {
    	int r = 0; 
    	while(n!=0) {
    		int digit = n%10; 
    		r = r*10 + digit; 
    		n=n/10;
    	}
    	return r;
    }

}
