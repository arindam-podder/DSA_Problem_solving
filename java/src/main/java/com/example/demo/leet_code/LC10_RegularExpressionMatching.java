/*
 * 10. Regular Expression Matching (HARD)

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

 

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
 

Constraints:
1 <= s.length <= 20
1 <= p.length <= 20
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */


package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.Map;

public class LC10_RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a*"));
	
	}
	
	public static boolean isMatch(String s, String p) {
		
		return dfs(0, 0, s, p, new HashMap<>());
	}
	
	// top-down approach
	public static boolean dfs(int i, int j, String s, String p) {
		//base condition 
		if(i >= s.length() && j >= p.length()) return true; 
		
		if(j >= p.length()) return false; 
		
		boolean match =  (i<s.length()) && ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.'));
		
		if(j+1<p.length() && p.charAt(j+1) == '*') {
			// dfs(i, j+2, s, p) => don't use * 
			//dfs(i+1, j, s, p) => use *
			return dfs(i, j+2, s, p) || ( match && dfs(i+1, j, s, p)) ;
		}
		
		if(match){
			return dfs(i+1, j+1, s, p);
		}
	
		return false;
		
	}
	
	public static boolean dfs(int i, int j, String s, String p, Map<String, Boolean> map) {
		String key = i+""+j;
		
		//base case 
		if(i>=s.length() || j>=p.length() ) return true;
		
		if(j>=p.length()) return false;
		
		if(map.containsKey(key)) {
			return map.get(key);
		}
		
		boolean match =  (i<s.length()) && ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.'));
		
		if(j+1<p.length() && p.charAt(j+1) == '*') {
			// dfs(i, j+2, s, p) => don't use * 
			//dfs(i+1, j, s, p) => use *
			boolean b = dfs(i, j+2, s, p) || ( match && dfs(i+1, j, s, p)) ;
			map.put(key, b);
			return map.get(key);
		}
		
		if(match){
			boolean b = dfs(i+1, j+1, s, p);
			map.put(key, b);
			return map.get(key);
		}
	
		map.put(key, false);
		return map.get(key);
		
	}
	
}//class LC10_RegularExpressionMatching end






















