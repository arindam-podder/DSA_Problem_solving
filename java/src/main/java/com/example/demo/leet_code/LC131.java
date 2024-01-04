/*
 * 131. Palindrome Partitioning

Given a string s, partition s such that every 
substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]
 
Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.
 */

package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC131 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC131 obj = new LC131(); 
		System.out.println(obj.palindromePartition("aaa"));
	}
	
	public List<List<String>> palindromePartition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>(); 
        recursion(s, 0, path, result); 
        return result; 
    }

	private void recursion(String s, int index, List<String> path, List<List<String>> result) {
		if(index == s.length()) {
			result.add(new ArrayList<>(path)); 
			return;
		}
		
		for(int i=index; i<s.length(); i++) {
			if(isPalindrome(s, index, i)) {
				path.add(s.substring(index, i+1)); 
				recursion(s, i+1, path, result);
				path.remove(path.size()-1); 		//backtrack
			}
		}
		
	}

	private boolean isPalindrome(String s, int start, int end) {
		while(start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

}











