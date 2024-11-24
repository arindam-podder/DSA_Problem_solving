/*
 * leetcode 394
 * 
 * Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 * 
 * 
 */

package com.example.demo.leet_code;

import java.util.Stack;

public class LC294_DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(decodeString("10[a2[c]]"));
		
	}

	public static String decodeString(String s) {
		Stack<Integer> numberStack = new Stack<>(); 
		Stack<String> stringStack = new Stack<>(); 
		
		for(int i=0; i<s.length(); i++) {
			char currentChar = s.charAt(i);
			if(Character.isDigit(currentChar)) {
				//numberStack.push(currentChar-'0'); 
				//check for continous digit 
				String digit = ""; 
				int j=i;
				while(Character.isDigit(s.charAt(j))) {
					digit += s.charAt(j); 
					j++; 
				}
				numberStack.push(Integer.valueOf(digit));
				i = j-1;
			}else {
				if(currentChar==']') {
					String temp = ""; 
					while(!stringStack.peek().equals("[") ) {
						temp = stringStack.pop() + temp; 
					}
					stringStack.pop();		//for removing '['
					int num = numberStack.pop();
					String main = "";
					for(int k=1; k<=num; k++) {
						main += temp; 
					}
					stringStack.push(main);
				}else {
					stringStack.push(currentChar+"");
				}
			}
		}
		
		String ans = ""; 
		while(!stringStack.isEmpty()) {
			ans = stringStack.pop() + ans; 
		}
		return ans;
	}

}












