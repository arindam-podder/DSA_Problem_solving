/*
 * 
 */


package com.example.demo.sclr_code.dynamic_programing;

public class PalindromePartitioningCut {
	public static void main(String[] args) {
		String s = "abcd";
		boolean[][] palindrimicArray = getPalindrimicArray(s);
		
		//System.out.println(minCutReqiredUsingRecursion(0, s.length(), palindrimicArray));
	
		int[][] dpCut = new int[s.length()][s.length()]; 
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<s.length(); j++) {
				dpCut[i][j] = -1; 
			}
		}

		System.out.println(minCutReqiredUsingRecursionAndDp(0, s.length(), palindrimicArray, dpCut));
		
	}
	
	
	public static boolean[][] getPalindrimicArray(String s){
		boolean[][] dp = new boolean[s.length()][s.length()]; 
		for(int dia=0; dia<s.length(); dia++) {
			int i=0; int j=dia;
			for(; j<s.length(); ) {
				if(dia==0) dp[i][j] = true;
				else if(dia==1) dp[i][j] = s.charAt(i)==s.charAt(j);
				else {
					if(s.charAt(i) == s.charAt(j)) {
						dp[i][j] = dp[i+1][j-1]; 
					}else {
						dp[i][j] = false;
					}
				}
				i++; 
				j++; 
			}
		}
		return dp;
	}
	
	
	//public static int minCutReqired(String str, int s, int e, int[][] dp) {
	public static int minCutReqiredUsingRecursion(int s, int e, boolean[][] palindromicDP) {
		if(palindromicDP[s][e-1] == true) return 0; 			//here zero cut required 
		int ans = Integer.MAX_VALUE;
		for(int cut=s; cut<e; cut++) {
			if(palindromicDP[s][cut] == true) {
				ans = Math.min(ans, minCutReqiredUsingRecursion(cut+1, e, palindromicDP));
			}
		} 
		return ans+1;
	}
	
	
	public static int minCutReqiredUsingRecursionAndDp(int s, int e, boolean[][] palindromicDP, int[][] dpCut) {
		if(palindromicDP[s][e-1] == true) return 0; 			//here zero cut required 
		if(dpCut[s][e-1] != -1) return dpCut[s][e-1];
		int ans = Integer.MAX_VALUE;
		for(int cut=s; cut<e; cut++) {
			if(palindromicDP[s][cut] == true) {
				ans = Math.min(ans, minCutReqiredUsingRecursion(cut+1, e, palindromicDP));
			}
		}
		dpCut[s][e-1] = ans+1;
		return ans+1;
	}
}






























