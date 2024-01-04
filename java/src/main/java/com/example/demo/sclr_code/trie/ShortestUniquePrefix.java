/*
 * Q3. Shortest Unique Prefix

Problem Description
Given a list of N words, find the shortest unique prefix to represent each word in the list.

NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible

Problem Constraints
1 <= Sum of length of all words <= 106

Input Format
First and only argument is a string array of size N.

Output Format
Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.

Example Input
Input 1:
 A = ["zebra", "dog", "duck", "dove"]
Input 2:
 A = ["apple", "ball", "cat"]

Example Output
Output 1:
 ["z", "dog", "du", "dov"]
Output 2:
 ["a", "b", "c"]

Example Explanation
Explanation 1:
 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".  
Explanation 2:
 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
 */


package com.example.demo.sclr_code.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

	public static void main(String[] args) {
		String[] arr = {"arin", "poidder", "arko", "arkis"};
		
		TrieNode dict = createDictWithCount(arr); 
		
		System.out.println( Arrays.toString(getUniquePrefix(dict, arr)) );
		

	}
	
	public static String[] getUniquePrefix(TrieNode node, String[] arr) {
		String[] ans = new String[arr.length];
		//traverse all strings of arr
		for(int i=0; i<arr.length; i++) {
			String s = arr[i]; 
			String uniquePrefix = ""; 
			//go through all char of each string in Trie
			TrieNode temp = node; 
			for(int j=0; j<s.length(); j++) {
				char ch = s.charAt(j); 
				uniquePrefix = uniquePrefix+ch;
				temp = temp.child.get(ch); 
				if(temp.count == 1 ) {
					break;
				}
			}
			ans[i] = uniquePrefix;
		}
		
		return ans;
	}
	
	public static TrieNode createDictWithCount(String[] arr) {
		TrieNode root = new TrieNode('-'); 
		for(int i=0; i<arr.length; i++) {
			String s = arr[i]; 
			TrieNode temp = root;
			for(int j=0; j<s.length(); j++) {
				char ch = s.charAt(j); 
				if( !temp.child.containsKey(ch) ) {
					temp.child.put(ch, new TrieNode(ch));
				}else {
					temp.child.get(ch).count = temp.child.get(ch).count+1;
				}
				temp = temp.child.get(ch);
			}
			temp.eow = true;
		}
		return root; 		//returning the root TrieNood 
	}

}


class TrieNode{
	char data; 
	Map<Character, TrieNode> child; 
	boolean eow;
	int count;
	ArrayList<Integer> list;
	TrieNode(char ch){
		data = ch; 
		child = new HashMap<>();
		eow = false;
		count = 1;
		list = new ArrayList<>();
	}
}//class TrieNode end




