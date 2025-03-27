/**
 * 1358. Number of Substrings Containing All Three Characters

Given a string s consisting only of characters a, b and c.
Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are 
"abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

Example 2:
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

Example 3:
Input: s = "abc"
Output: 1
 
Constraints:
3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.

 */


package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1358_NumberSubstringsContainingAllThreeCharacters {

	public static void main(String[] args) {
		//String s = "abcabc";
		String s = "aaacb";
		
		System.out.println( numberOfSubstrings1(s) );
		
		System.out.println( numberOfSubstrings2(s) );
		
	}

	//BF : for each index keep moving right till abc found, for that index count += s.len -r    //TLE
    public static int numberOfSubstrings1(String s) {
        int count = 0;
        for(int i=0; i<=s.length()-3; i++) {
        	count += givenIndexGetNumber(i, s);
        }
        return count;
    }
    
    //chcek for a particule index, what is count of substring "abc"
    public static int givenIndexGetNumber(int idx, String s) {
    	Set<Character> set = new HashSet<>(); 
    	while(idx<s.length()) {
    		set.add(s.charAt(idx)); 
    		if(set.size() == 3) {
    			return s.length()-idx;
    		}
    		idx++;
    	}
    	return 0;
    }
    
    //optimized : slide widow + map 
    public static int numberOfSubstrings2(String s) {
        int n = s.length(); 
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>(); 
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        int res = 0; 
        while(r<n) {
        	char c = s.charAt(r);
        	map.put(c, map.getOrDefault(c, 0)+1);
        	
        	while(map.get('a')>0 && map.get('b')>0 && map.get('c')>0) {
        		res += n-r;
        		char lc = s.charAt(l);
        		map.put(lc, map.get(lc)-1);
        		l++;
        	}
        	r++;
        }
        
        return res;
    }
    
    
}






