/*
 * 20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
 

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'
 */

package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		
		//int[] arr = {'(', ')', '{', '}', '[', ']' };
		//System.out.println(Arrays.toString(arr));
		
		System.out.println(solutionUingStack("(((([]))))"));
		
	}
	
	
	public static boolean solutionUingStack(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[' ) {
				stack.add(s.charAt(i));
			}else {
				if(stack.isEmpty()) {
					return false;
				}else {
					if(s.charAt(i)==')') {
						if(stack.peek()=='(') {
							stack.pop();
						}else {
							return false;
						}
					}
					if(s.charAt(i)=='}') {
						if(stack.peek()=='{') {
							stack.pop();
						}else {
							return false;
						}
					}
					if(s.charAt(i)==']') {
						if(stack.peek()=='[') {
							stack.pop();
						}else {
							return false;
						}
					}
				}
			}
		}
		
		if(!stack.isEmpty()) {
			return false;
		}
		
		return true;
	}

}
















