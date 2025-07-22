/**
 * 678. Valid Parenthesis String

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "(*)"
Output: true

Example 3:
Input: s = "(*))"
Output: true

Constraints:
1 <= s.length <= 100
s[i] is '(', ')' or '*'.
 */

package com.example.demo.leet_code;

import java.util.Stack;

public class LC678_ValidParenthesisString {

	public static void main(String[] args) {
		String s = "***(*";
		
		System.out.println( checkValidString1(s) );
	}
	
    public static boolean checkValidString1(String s) {
        //return checkUsingStack(s);
    	return checkUsingTwoVariable(s);
    }	
    
    //will do 
    public static boolean recur(int i, String s) {
    	return true;
    }
    
    
    public static boolean checkUsingStack(String s) {
    	Stack<Integer> openStack = new Stack<>();
    	Stack<Integer> starStack = new Stack<>();
    	
    	for(int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if(c=='(') {
    			openStack.push(i);
    		}else if(c == '*') {
    			starStack.push(i);
    		}else {
    			if(!openStack.isEmpty()) {
    				openStack.pop();
    			}else if(!starStack.isEmpty()) {
    				starStack.pop();
    			}else {
    				return false;
    			}
    		}
    	}
    	
    	while(!openStack.isEmpty() && !starStack.isEmpty()) {
    		if(openStack.peek() < starStack.peek()) {
    			openStack.pop();
    			starStack.pop();
    		}else {
    			return false;
    		}
    	}
    	
    	return openStack.isEmpty();
    }
    
    
    public static boolean checkUsingTwoVariable(String s) {
    	int low = 0; 
    	int high = 0; 
    	for(char c: s.toCharArray()) {
    		if(c=='(') {
    			low += 1;
    			high += 1;
    		}else if(c == '*') {
    			low = Math.max(low-1, 0);
    			high += 1; 
    		}else {
    			low = Math.max(low-1, 0);
    			high -= 1;
    		}
    		
    		if(high<0) {
    			return false;
    		}
    	}
    	return low==0;
    }
    
}















