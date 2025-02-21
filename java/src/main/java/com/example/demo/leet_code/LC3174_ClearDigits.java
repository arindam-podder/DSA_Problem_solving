/**
 * 3174. Clear Digits

You are given a string s.
Your task is to remove all digits by doing this operation repeatedly:
Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

Note that the operation cannot be performed on a digit that does not have any non-digit character to its left.

Example 1:
Input: s = "abc"
Output: "abc"
Explanation:
There is no digit in the string.

Example 2:
Input: s = "cb34"
Output: ""
Explanation:
First, we apply the operation on s[2], and s becomes "c4".
Then we apply the operation on s[1], and s becomes "".

Constraints:
1 <= s.length <= 100
s consists only of lowercase English letters and digits.
The input is generated such that it is possible to delete all digits. 
 */



package com.example.demo.leet_code;

import java.util.Stack;

public class LC3174_ClearDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cb3yy4";
		
		System.out.println( clearDigitsStack(s) );
		
	}

	
    public static String clearDigitsStack(String s) {
        Stack<Character> st = new Stack<>(); 
        for(char c: s.toCharArray() ) {
        	if(c>='0' && c<='9') {
        		if(!st.isEmpty()) {
        			st.pop();
        		}
        	}
        	else {
        		st.push(c);
        	}
        }
        
        String result = "";
        while(!st.isEmpty()) {
        	result =  st.pop()+ result;
        }
        return result;
    }
	
}





















