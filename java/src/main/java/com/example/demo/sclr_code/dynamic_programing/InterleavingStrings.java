/*
 * Q1. Interleaving Strings

Problem Description
Given A, B, C find whether C is formed by the interleaving of A and B.

Problem Constraints
1 <= length(A), length(B) <= 100
1 <= length(C) <= 200

Input Format
The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.

Output Format
Return 1 if string C is formed by interleaving of A and B else 0.

Example Input
Input 1:
 A = "aabcc"
 B = "dbbca"
 C = "aadbbcbcac"
Input 2:
 A = "aabcc"
 B = "dbbca"
 C = "aadbbbaccc"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
Explanation 2:
 It is not possible to get C by interleaving A and B.
 */


package com.example.demo.sclr_code.dynamic_programing;

import java.util.Arrays;

public class InterleavingStrings {
	public static void main(String[] args) {
		String s1 = "abc"; 
		String s2 = "xyz"; 
		String s3 = "abcxyz"; 
		
		System.out.println(isInterleave(s1, s2, s3));
	}
	
	
	//2D dp array + bottom-up approach (https://www.youtube.com/watch?v=3Rw3p9LrgvE)
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length()) return false; 
		boolean[][] dp = new boolean[s1.length()+1][s2.length()+1]; 
		for(int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], false);
		}
		dp[s1.length()][s2.length()] = true; 
		for(int i=s1.length(); i>=0; i--) {
			for(int j=s2.length(); j>=0; j--) {
				if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j) && dp[i+1][j]) dp[i][j] = true;
				if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j) && dp[i][j+1]) dp[i][j] = true;
			}
		}
		return dp[0][0];
	}
	
}

//scaler solution 
class SolutionInterleavingStrings {

    int nA, nB, nC;
    private int mem[][];
    private String A, B, C;

    public int isInterleave(String A, String B, String C) {

        if (A == null || B == null || C == null)
            return 0;

        nA = A.length();
        nB = B.length();
        nC = C.length();

        if (nA + nB != nC)
            return 0;

        mem = new int[nA + 1][nB + 1];

        for (int i = 0; i <= nA; i++)
            Arrays.fill(mem[i], -1);

        this.A = A;
        this.B = B;
        this.C = C;

        return rec(0, 0);

    }

    public int rec(int nA, int nB) {

        if (nA + nB == nC)
            return 1;

        if (mem[nA][nB] != -1)
            return mem[nA][nB];

        char a = nA < this.nA ? A.charAt(nA) : '~';
        char b = nB < this.nB ? B.charAt(nB) : '~';
        char c = C.charAt(nA + nB);

        int status = 0;

        if (a == c) {
            status = rec(nA + 1, nB);
        }

        if (b == c) {
            status |= rec(nA, nB + 1);
        }

        return mem[nA][nB] = status;

    }

}


























