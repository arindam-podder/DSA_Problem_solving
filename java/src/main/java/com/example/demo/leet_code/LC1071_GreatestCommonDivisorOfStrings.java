/**
 * 1071. Greatest Common Divisor of Strings

For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t 
(i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""
 
Constraints:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
 */


package com.example.demo.leet_code;

public class LC1071_GreatestCommonDivisorOfStrings {

	public static void main(String[] args) {
		//String str1 = "ABCABC", str2 = "ABC";
		String str1 = "ABABABAB", str2 = "ABAB";
		System.out.println( prefixCheckToCompleteString("ABAB", str1)  );
		
		System.out.println(  gcdOfStrings1(str1, str2) );
		
	}
	 
	
    public static String gcdOfStrings1(String s1, String s2) {
        String res = "";
        int p1 = 0; 
        int p2 = 0;
        while(p1<s1.length() && p2<s2.length()) {
        	if(s1.charAt(p1) != s2.charAt(p2)) return res; 
        	
        	String prefix = s1.substring(0,p1+1);
        	
        	if(prefixCheckToCompleteString(prefix, s1) && prefixCheckToCompleteString(prefix, s2)) {
        		res = prefix;
        	}
        	p1++;
        	p2++;
        }
        return res;
    }
    
    //it is to check for given prefix , s = prefix + prefix + ..... 
    public static boolean prefixCheckToCompleteString(String prefix, String s) {
    	int idx = 0;
    	while(idx+prefix.length()<=s.length()) {
    		if(! s.substring(idx, idx+prefix.length()).equalsIgnoreCase(prefix)) {
    			return false;
    		}
    		idx += prefix.length(); 
    	}
    	
    	if(idx<s.length()) return false;
    	
    	return true;
    }

}










