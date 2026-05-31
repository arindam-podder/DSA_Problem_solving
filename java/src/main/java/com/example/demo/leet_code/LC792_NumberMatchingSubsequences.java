/**
 * 792. Number of Matching Subsequences

Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing
the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
 
Example 1:
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".

Example 2:
Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2

Constraints:
1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.
 */


package com.example.demo.leet_code;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC792_NumberMatchingSubsequences {
	public static void main(String[] args) {
		//String s = "abcde", words[] = {"a","bb","acd","ace"};
		//String s = "dsahjpjauf", words[] = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
		String s = "qlhxagxdqh", words[] = {"qlhxagxdq","qlhxagxdq","lhyiftwtut","yfzwraahab"};
		
		System.out.println( numMatchingSubseq1(s, words) );
	}
	
    public static int numMatchingSubseq1(String s, String[] words) {
    	//return bfUseBit(s, words);
    	//return bfUseBit2(s, words);
    	return optimal(s, words);
    }
    
    //generate all sequence and look present in arr or not      Time Limit Exceeded - 6 / 53 testcases passed
    public static int bfUseBit(String s, String[] words) {
    	int n = s.length();
    	int res = 0; 
    	
    	for(int i=0; i<Math.pow(2, n); i++) {
    		String seq = "";
    		for(int j=0; j<s.length(); j++){
    			//chcek jth bit set or not 
    			if((i & (1<<j)) !=0 ) seq = seq+s.charAt(j); 
    		}
    		System.out.println( seq );
    		//check seq present in  words or not 
    		for(int k=0; k<words.length; k++) {
    			String w = words[k];
    			if(w.equals(seq)) { 
    				res += 1;
    				words[k] = "-";
    			}
    		}
    		
    	}
    	return res;
    }
    
    
    //2. generate all sequence and keep words in map with cnt for faster lookup    Time Limit Exceeded - 7 / 53 testcases passed
    public static int bfUseBit2(String s, String[] words) {
    	Map<String, Integer> map = new HashMap(); 
    	for(String w: words) map.put(w, map.getOrDefault(w, 0)+1);
   
    	int n = s.length();
    	int res = 0; 
    	
    	for(int i=0; i<Math.pow(2, n); i++) {
    		String seq = "";
    		for(int j=0; j<s.length(); j++){
    			//chcek jth bit set or not 
    			if((i & (1<<j)) !=0 ) seq = seq+s.charAt(j); 
    		}
    		//check seq present in map or not and count is more than 0
    		if(map.containsKey(seq) && map.get(seq)>0) {
    			res += map.get(seq); 
    			map.put(seq, 0);
    		}
    		
    	}
    	return res;
    }
    
    
    
    //3.Keep index detail of each char of S, and then loop words check seq possible or not   
    public static int optimal(String s, String[] words) {
    	Map<Character, List<Integer>> indexMap = new HashMap<>();
    	for(int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if(indexMap.containsKey(c)) {
    			indexMap.get(c).add(i);
    		}else {
    			indexMap.put(c, new ArrayList<>());
    			indexMap.get(c).add(i);
    		}		
    	}

    	Map<String, Integer> preCompute = new HashMap<>();		//preCompute  pass 
    	int res = 0; 
    	for(String w: words) {
    		if(preCompute.containsKey(w)) res += preCompute.get(w);
    		else if(isSubSeq(w, indexMap)) {
    			res += 1;
    			preCompute.put(w, 1);
    		}else{
    			preCompute.put(w, 0);
    		}
    	}
    	
    	return res;
    }
	private static boolean isSubSeq(String w, Map<Character, List<Integer>> indexMap) {
		HashMap<Character, List<Integer>> indexMapCopy = new HashMap<>();
		//deep copy 
		for(Map.Entry<Character, List<Integer>> entry: indexMap.entrySet()) {
			indexMapCopy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
		}
		
		int lastIdx = -1; 
		for(int i=0; i<w.length(); i++) {
			char c = w.charAt(i);
			if(!indexMapCopy.containsKey(c)) return false;
			else {
				List<Integer> listIdx = indexMapCopy.get(c);
				if(lastIdx == -1) { //mean first char 
					lastIdx = listIdx.get(0);
					listIdx.remove(0);
				}else {
					boolean gotIdx = false;
					for(int idx=0; idx<listIdx.size(); idx++) {
						if(listIdx.get(idx)>lastIdx) {
							lastIdx = listIdx.get(idx);
							listIdx.remove(idx);
							gotIdx = true;
							break;
						}
					}
					if(!gotIdx) return false;
				}
			}
		}
		return true;
	}
    
    
    
}


















