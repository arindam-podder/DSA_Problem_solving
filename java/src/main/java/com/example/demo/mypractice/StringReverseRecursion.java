package com.example.demo.mypractice;

public class StringReverseRecursion {

	public static void main(String[] args) {
		
		//System.out.println( rec("arin") );
		
		System.out.println( isPalindrome("madamf", 0, 5) );
	}
	
	//arin 
	//nira
	public static String rec(String s) { 
		if(s.length()==0) {
			return "";
		}
		else {
			return s.charAt(s.length()-1) + rec(s.substring(0, s.length()-1));
		}
		
	}
	
	
	public static boolean isPalindrome(String s, int start, int end) {
		if(start>end) {
			return true;
		}
		if(s.charAt(start) != s.charAt(end)) {
			return false;
		}
		return isPalindrome(s, start+1, end-1);
		
	}
	
	

}	
	

























