/**
 * 424. Longest Repeating Character Replacement
 * 
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. 
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:
1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */



package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.Map;

public class LC424_LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH";
		int k = 7;    //ans:11
		
		System.out.println( characterReplacement1(s, k) );

	}
	
    public static int characterReplacement1(String s, int k) {
        //return solution1(s, k);
    	return solution2(s, k);
    }
    
    
    //BF: get all subarray and within that find max char count and try replace k other chars  Time Limit Exceeded 22 / 51 testcases passed
    public static int solution1(String s, int k) {
    	int res = k; 	//default k will be result 
    	for(int i=0; i<s.length()-k; i++) {
    		for(int j=i+k; j<s.length(); j++) {
    			int window = j-i+1;
    			int maxOccurChar = maxOccurChar(s, i, j);
    			if( (maxOccurChar+k) >= window ) res = Math.max(res, window);
    		}
    	}
    	return res;
    }
    
    //optimize : window + tow pointer 
    public static int solution2(String s, int k) {
    	int res=k;
    	int l=0;
    	int r=k;
    	int count = 0; 
    	//window - initial map of char-count 
    	Map<Character, Integer> map = new HashMap<>(); 
    	for(int i=0; i<k; i++) {
    		map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1); 
    		count = Math.max(count, map.get(s.charAt(i)));
    	}
    	
    	while(r<s.length()) {
    		map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1); 
    		count = Math.max(count, map.get(s.charAt(r)));
    		
    		// characters that need to be replaced
    		int replace = r-l+1 - count; 
    		
    		if(replace > k) {
    			map.put(s.charAt(l), map.get(s.charAt(l))-1);
    			l++;
    		}
    		
    		res = Math.max(res, r-l+1);
    		r = r+1; //right pointer move
    	}
    	
    	return res;
    	
    }
    
    
    
    /*
     * helper method
     */
    public static int maxOccurChar(String s, int l, int r) {
    	int count=1;
    	Map<Character, Integer> map = new HashMap<>(); 
    	for(int i=l; i<=r; i++) {
    		char charAt = s.charAt(i);
    		map.put(charAt, map.getOrDefault(charAt, 0) + 1); 
    		count = Math.max(count, map.get(charAt));
    	}
    	
    	return count;
    }

}

























