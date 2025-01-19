/**
 * 115. Distinct Subsequences

Given two strings s and t, return the number of distinct subsequences of s which equals t.
The test cases are generated so that the answer fits on a 32-bit signed integer.

Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit

Example 2:
Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag
 

Constraints:
1 <= s.length, t.length <= 1000
s and t consist of English letters.

 */



package com.example.demo.leet_code;

import java.util.Arrays;

public class LC115_DistinctSubsequences {

	public static void main(String[] args) {
		String s = "rabbbit", t = "rabbit";
		//Count c = new Count();
		//allSubSequence(0, s, "", t, c);
		//System.out.println( c.count );
		
		
		//System.out.println( totalCountRecur(s.length()-1, s, t.length()-1, t) );
		
		
		//int[][] dp = new int[s.length()][t.length()];
		//for(int[] arr: dp) {
			//Arrays.fill(arr, -1);
		//}
		//System.out.println( totalCountMemorization(s.length()-1, s, t.length()-1, t, dp) );
		
		
		//System.out.println( tabulation(s, t) );
		
		
		System.out.println( tabulationWithSpaceOptimization(s, t) );
		
	}
	
	// recursion : get all subsequence and match with t and get the count   //TLE
	public static void allSubSequence(int i, String s, String cur, String t, Count obj) {
		if(cur != "" && !t.contains(cur)) {
			return;
		}
		if(cur.equalsIgnoreCase(t)){
			obj.count += 1;
	        return;
	    }
		if(i==s.length()) {
			if(cur.equalsIgnoreCase(t)) {
				System.out.println(cur);
				obj.count += 1;
			}
			return; 
		}
		//unPick
		allSubSequence(i+1, s, cur, t, obj);
		//pick
		cur = cur+s.charAt(i); 
		allSubSequence(i+1, s, cur, t, obj);
		
		//backtrcak 
		cur = cur=="" || cur.length()==1? "": cur.substring(0, cur.length()-1);
	}
	static class Count {
		int count; 
	}
	
	
	// recursion (top-down approach) : string matching technique , char to char match   //TLE 
	public static int totalCountRecur(int i, String s, int j, String t) {
		//base case 
		if(j<0) return 1;		//1st j condition has to be there. not i , otherwise wrong result will get 
		else if(i<0) return 0; 
		 
		//body logic 
		if(s.charAt(i) == t.charAt(j)) {
			//totalCount(i-1, s, j-1, t) = char match and chose 
			//totalCount(i-1, s, j, t);  = char match but don't pick look for another 
			return totalCountRecur(i-1, s, j-1, t) + totalCountRecur(i-1, s, j, t);
		}else {
			return totalCountRecur(i-1, s, j, t);
		}
	}
	
	//recur memorization    //pass
	public static int totalCountMemorization(int i, String s, int j, String t, int dp[][]) {
		//base case 
		if(j<0) return 1;	
		else if(i<0) return 0;
		
		if(dp[i][j] != -1) return dp[i][j];
		
		if(s.charAt(i) == t.charAt(j)) {
			dp[i][j] = totalCountMemorization(i-1, s, j-1, t, dp) + totalCountMemorization(i-1, s, j, t, dp);
		}else {
			dp[i][j] = totalCountMemorization(i-1, s, j, t, dp);
		}
		return dp[i][j];
	}
	
	// tabulation ... above base case i,j <0 so in dp 0 index will handle that , so 1 based index will be body logic 
	public static int tabulation(String s, String t) {
		int n = s.length(); 
		int m = t.length();
		int[][] dp = new int[n+1][m+1]; 
		for(int i=0; i<dp.length; i++) dp[i][0] = 1; 		//j<0 logic in memorization all 1
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
		return dp[n][m];
	}
	
	
	//one-D array is possible because data depends on (i-1), j or j-1
	public static int tabulationWithSpaceOptimization(String s, String t) {
		int n = s.length(); 
		int m = t.length(); 
		int[] prev = new int[m+1]; 
		prev[0] = 1;   //j<0 logic
		for(int i=1; i<=n; i++) {
			int[] dp = new int[m+1]; 
			dp[0] = 1; 
			for(int j=1; j<=m; j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					dp[j] = prev[j-1] + prev[j];
				}else {
					dp[j] = prev[j];
				}
			}
			prev = dp; 
		}
		return prev[m];
	}
}






















