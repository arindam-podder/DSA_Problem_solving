/*
 * Q3. Regular Expression Match (Day 88 - Advanced DSA : DP 5: DP on Strings -- Mon, 16 Oct 2023)
Problem Description
Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Problem Constraints
1 <= length(A), length(B) <= 104

Input Format
The first argument of input contains a string A.
The second argument of input contains a string B.

Output Format
Return 1 if the patterns match else return 0.

Example Input
Input 1:
 A = "aaa"
 B = "a*"
Input 2:
 A = "acz"
 B = "a?a"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 So, the pattern matches we return 1.
Explanation 2:
 '?' matches any single character. First two character in string A will be match. 
 But the last character i.e 'z' != 'a'. Return 0.
 */


package com.example.demo.sclr_code.dynamic_programing;

import java.util.Arrays;

public class RegularExpressionMatch {
	public static void main(String[] args) {
		
	}
	
	 public static boolean isStringAndPatternMatching(String s, String p, int i, int j){ //String p = pattern 
		 	if(i<0 && j<0) return true; 
		 	else if(j<0) return false; 
		 	else if(i<0) {
		 		for(int k=0; k<=j; k++){
		 			if(p.charAt(k) != '*'){
		 				return false;
		 			}
		 		}
		 		return true; 
		 	}
		 	else{
		 		if(s.charAt(i)==p.charAt(j)) return isStringAndPatternMatching(s, p, i-1, j-1);
		 		else if(p.charAt(j)=='?') return isStringAndPatternMatching(s, p, i-1, j-1); 
		 		else if(p.charAt(j)=='*') return isStringAndPatternMatching(s, p, i, j-1) || isStringAndPatternMatching(s, p, i-1, j);		//* means 0 or more 
		 		else return false; 		// when s[i] != p[j]				
		 	}
		 }

	     public static int isStringAndPatternMatchingWithDP(String s, String p, int i, int j, int[][] dp){	//String p = pattern ,   getting TLE in scaler
		 	if(i<0 && j<0) return 1; 
		 	else if(j<0) return 0; 
		 	else if(i<0) {
		 		for(int k=0; k<=j; k++){
		 			if(p.charAt(k) != '*'){
		 				return 0;
		 			}
		 		}
		 		return 1; 
		 	}
		
		 	if(dp[i][j] != -1 ) return dp[i][j]; 
				
		 	if(s.charAt(i)==p.charAt(j)) dp[i][j] = isStringAndPatternMatchingWithDP(s, p, i-1, j-1, dp);
		 	else if(p.charAt(j)=='?') dp[i][j] =  isStringAndPatternMatchingWithDP(s, p, i-1, j-1, dp); 
		 	else if(p.charAt(j)=='*') dp[i][j] = Math.max( isStringAndPatternMatchingWithDP(s, p, i, j-1, dp) ,  isStringAndPatternMatchingWithDP(s, p, i-1, j, dp) );		//* means 0 or more 
		 	else dp[i][j] = 0; 		// when s[i] != p[j]				
			
		 	return dp[i][j];
		 }







	    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	    public int isMatch(final String A, final String B) {
	        int n = A.length();
	        int m = B.length();
	        StringBuilder sb = new StringBuilder();
	        //removing extra char * if they are side by side in B to avoid java heap space issue for hard test case
	        for(int i=0;i<m-1;i++){
	            if(B.charAt(i)== '*' && B.charAt(i+1) == '*') continue;
	            sb.append(B.charAt(i));
	        }
	        sb.append(B.charAt(m-1));
	        String s = sb.toString();
	        m = s.length();
	        int[][] dp = new int[n][m];
	       
	        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

	        return matching(A,s,n-1,m-1,dp);
	    }
	    public int matching(String A,String B,int i,int j,int[][] dp){
	        if(i<0 && j<0) return 1;
	        //if still chars left in B
	        if(i<0){
	            while(j>=0){
	                if(B.charAt(j)=='*') j--;
	                else return 0;
	            }
	            return 1;
	        }
	        //if still chars left in A
	        if(j<0) return 0;

	        if(dp[i][j]==-1){
	            //if chars are equal check the previous one.
	            if(A.charAt(i) == B.charAt(j)){
	                dp[i][j] = matching(A,B,i-1,j-1,dp);
	            }
	            // Three possibilities if B char is *
	            else if(B.charAt(j)=='*'){
	                //while(j-1>=0 && (B.charAt(j)== '*' && B.charAt(j-1) =='*')) j--;
	                dp[i][j] = (matching(A,B,i-1,j-1,dp) | matching(A,B,i-1,j,dp)) | matching(A,B,i,j-1,dp);
	            }
	            //Only one possibility if B char is ?
	            else if(B.charAt(j)=='?'){
	                dp[i][j] = matching(A,B,i-1,j-1,dp);
	            }
	            //if char are not equal return 0
	            else{
	                dp[i][j] = 0;
	            }
	        }
	        return dp[i][j];
	    }
}





