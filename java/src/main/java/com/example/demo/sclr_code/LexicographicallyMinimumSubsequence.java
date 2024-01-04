/*
 * Q1. Little Ponny and 2-Subsequence

Little Ponny has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2. Can you help him?
A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a. For example, "abc" is lexicographically smaller than "acc" because the first different 
letter is 'b' and 'c' which is smaller in "abc".

Problem Constraints
1 <= |A| <= 10^5
A only contains lowercase alphabets.

Input Format
The first and the only argument of input contains the string, A.

Output Format
Return a string representing the answer.

Example Input
Input 1:
 A = "abcdsfhjagj" 
Input 2:
 A = "ksdjgha" 

Example Output
Output 1:
 "aa" 
Output 2:
 "da" 

Example Explanation
Explanation 1:
 "aa" is the lexicographically minimum subsequence from A. 
Explanation 2:

 "da" is the lexicographically minimum subsequence from A.
 */

package com.example.demo.sclr_code;

public class LexicographicallyMinimumSubsequence {

	public static void main(String[] args) {
		
		System.out.println( solve("axyzbcdefghijk"));
	}

	public static String solve(String A) {
		char[] finalOP = new char[2];
        finalOP[0] = 255;				// 255 = ÿ
        finalOP[1] = 255;
        for (int i = 0; i < A.length() - 1; i++) {
        	if (finalOP[0] > A.charAt(i)) {
                finalOP[0] = A.charAt(i);
                //finalOP[1] = 255;
            }else {
                if (A.charAt(i) < finalOP[1]) {
                    finalOP[1] = A.charAt(i);
                }
            }
        }
        
        if (A.charAt(A.length() - 1) < finalOP[1]) {
            finalOP[1] = A.charAt(A.length() - 1);
        }

        return new String(finalOP);
    }
}
















