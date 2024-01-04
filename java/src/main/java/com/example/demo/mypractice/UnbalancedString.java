/*
 * find longest unbalanced string 
 */

package com.example.demo.mypractice;

import java.util.Stack;

public class UnbalancedString {

	public static void main(String[] args) {
		System.out.println(longestUnbal("{}{}{}"));
	}
	
	public static int longestUnbal(String s) {
		if(s.charAt(0) == '}') {
			return s.length();
		}
		
		int unbalIndex = 0;
		Stack<Character> st = new Stack<>();
		st.add(s.charAt(0));
		for(int i=1; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch=='{') {
				st.add(ch); 
				unbalIndex = i;
			}
			else {
				if(st.isEmpty()) {
					return s.length();
				}
				else if(st.size() > 1) {
					st.pop(); 
					unbalIndex = i;
				}else {
					st.pop();
				}
			}
		}
		return unbalIndex+1;
	}
	
	

}
