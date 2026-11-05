/**
 * 242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 
 */




package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.Map;

public class LC242_ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram"; String t = "nagarmm"; 
		
		System.out.println(  isAnagram1(s, t) );
		
	}
	
	
    public static boolean isAnagram1(String s, String t) {
    	if(s.length() != t.length()) return false;
    	
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
        	map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        
        for(int i=0; i<t.length(); i++) {
        	char charAt = t.charAt(i);
        	if(map.containsKey(charAt)) {
        		map.put(charAt, map.get(charAt)-1); 
        		if(map.get(charAt) <=0) map.remove(charAt);
        	}
        		
        }
        
        
        return map.isEmpty();
    }

}
