/**
 * 140. Word Break II

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence 
where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]

Example 2:
Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 
Constraints:
1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Input is generated in a way that the length of the answer doesn't exceed 105.
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC140_WordBreakII {

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = List.of("cat","cats","and","sand","dog");
		
		System.out.println(  wordBreak1(s, wordDict) );
	}
	
    public static List<String> wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
    	List<String> result = new ArrayList<>();
        recur(s, set, new ArrayList<String>(), result);
        return result;
    }
	
    
    public static void recur(String s, Set<String> words, List<String> current, List<String> res) {
    	//base 
    	if(s.length() == 0) {
    		if(current.size() > 0) {
    			String join = String.join(" ", current);
    			res.add(join);
    		}
    		return;
    	}
    	
    	//body
    	for(int i=1; i<=s.length(); i++) {
			String prefix = s.substring(0, i);
			if (words.contains(prefix)) {
				current.add(prefix);
				String suffix = s.substring(i);
				recur(suffix, words, current, res);
				current.remove(current.size() - 1);
			}
    	}
    	
    }
    

}
