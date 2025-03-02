/**
 * 916. Word Subsets

You are given two string arrays words1 and words2.
A string b is a subset of string a if every letter in b occurs in a including multiplicity.
For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.
Return an array of all the universal strings in words1. You may return the answer in any order.

Example 1:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["lc","eo"]
Output: ["leetcode"]

Example 3:
Input: words1 = ["acaac","cccbb","aacbb","caacc","bcbbb"], words2 = ["c","cc","b"]
Output: ["cccbb"]

Constraints:
1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LC916_WordSubsets {
	public static void main(String[] args) {
		String[] words1 = {"amazon", "apple", "facebook", "googlec", "leetcode"};
		String[] words2 = {"lc", "eo"};
		
		System.out.println( wordSubsetsSolve(words1, words2) );
		System.out.println( wordSubsetsSolve2(words1, words2) );
	}
	
	
	//TLE
    public static List<String> wordSubsetsSolve(String[] words1, String[] words2) {
        List<String> resList = new ArrayList<>();
        for(String w1 : words1) {
        	int[] charCount = getCharCount(w1);
        	boolean universal = true;
        	for(String w2 : words2) {
        		if(!isGood(w2, charCount)) {
        			universal = false;
        			break;
        		}
        	}
        	if(universal) resList.add(w1);
        }
        
        return resList;
    }
    
    private static boolean isGood(String w2, int[] charCount) {
    	int[] freq = new int[26]; 
    	for(char c: w2.toCharArray()) {
    		freq[c - 'a']++;
    		if(freq[c - 'a'] > charCount[c - 'a']) return false;
    	}
		return true;
	}

	public static int[] getCharCount(String s) {
    	int[] freq = new int[26]; 
    	for(char c: s.toCharArray()) freq[c - 'a']++;
    	return freq;
    }
	
	
	
	//store overall freq of word2
	public static List<String> wordSubsetsSolve2(String[] words1, String[] words2) {
        List<String> resList = new ArrayList<>();
        int[] overALL = overAllFreq(words2);
        for(String s : words1) {
        	int[] cur = new int[26];
			for(int i=0; i<s.length(); i++) cur[s.charAt(i) - 'a' ]++;
		
			boolean addable = true;
			for(int i=0; i<cur.length; i++) {
				if(cur[i] < overALL[i]) {
					addable = false; 
					break;
				}
			}
			if(addable) resList.add(s);
        }
        
        return resList;
    }
	
	public static int[] overAllFreq(String[] arr) {
		int[] overAll = new int[26];
		for(String s: arr) {
			int[] cur = new int[26];
			for(int i=0; i<s.length(); i++) cur[s.charAt(i) - 'a' ]++;
		
			for(int i=0; i<overAll.length; i++) {
				if(cur[i]> overAll[i]) {
					overAll[i] = cur[i];
				}
			}
		}
		return overAll;
	}
	
}





















