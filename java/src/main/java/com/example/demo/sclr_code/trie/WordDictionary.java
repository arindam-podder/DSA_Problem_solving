/*
 * this is word dictionary creation , Trie Data structure 
 */


package com.example.demo.sclr_code.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

	public static void main(String[] args) {
	}

	
	public static TrieNode createDict(String[] arr) {
		WordDictionary dict = new WordDictionary();
		TrieNode root = dict.new TrieNode('-'); 
		for(int i=0; i<arr.length; i++) {
			String s = arr[i]; 
			TrieNode temp = root;
			for(int j=0; j<s.length(); j++) {
				char ch = s.charAt(j); 
				if( !temp.child.containsKey(ch) ) {
					temp.child.put(ch, dict.new TrieNode(ch));
				}
				temp = temp.child.get(ch);
			}
			temp.eow = true;
		}
		return root; 		//returning the root TrieNood 
	}
	
	public static boolean isWordPresent(TrieNode root, String s) {
		TrieNode temp = root;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(!temp.child.containsKey(ch)) {
				return false;
			}
			temp = temp.child.get(ch);
		}
		return temp.eow;
	}
	
	
	class TrieNode{
		char data; 
		Map<Character, TrieNode> child;
		boolean eow;
		TrieNode(char ch){
			data = ch; 
			child = new HashMap<>();
			eow = false;
		}
	}//class TrieNode end

}
