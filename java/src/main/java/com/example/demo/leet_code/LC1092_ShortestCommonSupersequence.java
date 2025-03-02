/**
 * 1092. Shortest Common Supersequence 

Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. 
If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) 
results in the string s.

Example 1:
Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.

Example 2:
Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 
Constraints:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC1092_ShortestCommonSupersequence {

	public static void main(String[] args) {
		String str1 = "adbac", str2 = "cab";
		
		System.out.println( shortestCommonSupersequence1(str1, str2) ); 
		
	}
	
    public static String shortestCommonSupersequence1(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
    	getLongestCommonSubSequenceDP(str1, str2, dp);
    	for(int[] arr : dp) System.out.println( Arrays.toString(arr) );
    	
    	int i=str1.length();
    	int j=str2.length();
    	String result = "";
    	while(i>0 && j>0) {
    		if(str1.charAt(i-1) == str2.charAt(j-1) ) {
    			result = str1.charAt(i-1)+result;
    			i--;
    			j--;
    		}
    		else if(dp[i][j-1] > dp[i-1][j]) {
    			result = str2.charAt(j-1) + result;
    			j--;
    		}
    		else {
    			result = str1.charAt(i-1) + result;
    			i--;
    		}
    	}
    	
    	//now if i or j is not completed , means some character is left 
    	while(i>0) {
    		result = str1.charAt(i-1) + result; 
    		i--;
    	}
    	while(j>0) {
    		result = str2.charAt(j-1) + result;
    		j--;
    	}
    	return result;
    }
    
    
    //using 1 based dp 
    public static void getLongestCommonSubSequenceDP(String s1, String s2, int[][] dp) {
    	for(int i=1; i<dp.length; i++) {
    		for(int j=1; j<dp[0].length; j++) {
    			if(s1.charAt(i-1) == s2.charAt(j-1)){
    				dp[i][j] = 1 + dp[i-1][j-1];
    			}else {
    				dp[i][j] = Math.max( dp[i][j-1] , dp[i-1][j]);
    			}
    		}
    	}
    }
    
    
	
}






/*
 
static String shortestSupersequence(String s1, String s2){

  int n = s1.length();
  int m = s2.length();

  int[][] dp =new int[n+1][m+1];
  for (int i = 0; i <= n; i++) {
    dp[i][0] = 0;
  }
  for (int i = 0; i <= m; i++) {
    dp[0][i] = 0;
  }

  for (int ind1 = 1; ind1 <= n; ind1++) {
    for (int ind2 = 1; ind2 <= m; ind2++) {
      if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
        dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
      else
        dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
    }
  }

  int len = dp[n][m];
  int i = n;
  int j = m;

  int index = len - 1;
  String ans = "";

  while (i > 0 && j > 0) {
    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
      ans += s1.charAt(i-1);
      index--;
      i--;
      j--;
    } else if (dp[i - 1][j] > dp[i][j - 1]) {
        ans += s1.charAt(i-1);
        i--;
    } else {
        ans += s2.charAt(j-1);
        j--;
    }
  }
  
  //Adding Remaing Characters - Only one of the below two while loops will run 
  
  while(i>0){
      ans += s1.charAt(i-1);
      i--;
  }
  while(j>0){
      ans += s2.charAt(j-1);
      j--;
  }
  String ans2=new StringBuilder(ans).reverse().toString();
  return ans2;
} 
 

*/














