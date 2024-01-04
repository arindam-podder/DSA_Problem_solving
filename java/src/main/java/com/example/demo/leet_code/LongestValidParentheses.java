/*
 * 32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
substring

Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0
 
Constraints:
0 <= s.length <= 3 * 104
s[i] is '(', or ')'.

 */

package com.example.demo.leet_code;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solutionUsingStack(")()))"));
		
	}
	
	public static int solutionUsingStack(String s){
		Stack<Character> ct = new Stack<>();
		Stack<Integer> index = new Stack<>();
		index.add(-1);
		int max = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				ct.add(s.charAt(i));
				index.add(i);
			}else {		//closing bracket
				if(!ct.isEmpty()) {
					ct.pop();
					index.pop();
					max = Math.max(max, i-index.peek());
				}else {
					index.add(i);
				}
			}
		}
		return max;
	}

}


















