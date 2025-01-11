/**
 * 28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 
Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

 */



package com.example.demo.leet_code;

public class LC28_FindTheIndexOfTheFirstOccurrenceString {

	public static void main(String[] args) {
		String haystack = "sadbutsad", needle = "sagd";
		
		System.out.println( strStrInBuiltMethodUse(haystack, needle) );
		
		System.out.println( strStrLogic(haystack, needle) );
	}
	
	
	public static int strStrLogic(String haystack, String needle) {
        //chcek all substr length of (needle)
		int subLen = needle.length();
//		int result = -1; 
		for(int i=0; i<=haystack.length()-subLen; i++) {
			if(haystack.charAt(i) == needle.charAt(0)) {
				//check from the current index is the string present 
				boolean present = true; 
				for(int j=i, p=0; j<i+subLen; j++, p++) {
					if(haystack.charAt(j)!=needle.charAt(p)) {
						present = false; 
						break;
					}
				}
				if(present) return i;
			}
		}
		
		return -1; 
    }

	
	public static int strStrInBuiltMethodUse(String haystack, String needle) {
        return haystack.indexOf(needle);
       
    }
}


















