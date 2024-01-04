/*
 * Q2. Infix to Postfix

Problem Description
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
Find and return the postfix expression of A.

NOTE:
^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.

Problem Constraints
1 <= length of the string <= 500000

Input Format
The only argument given is string A.

Output Format
Return a string denoting the postfix conversion of A.

Example Input
Input 1:
 A = "x^y/(a*z)+b"
Input 2:
 A = "a+b*(c^d-e)^(f+g*h)-i"

Example Output
Output 1:
 "xy^az* /b+"
Output 2:
 "abcd^e-fgh*+^*+i-"

Example Explanation
Explanation 1:
Ouput dentotes the postfix expression of the given input.

 */


package com.example.demo.sclr_code;

import java.util.ArrayList;
import java.util.Stack;

public class StackInfixToPostfix {

	public static void main(String[] args) {
		StackInfixToPostfix obj = new StackInfixToPostfix();
		System.out.println( obj.infixToPostfix("a+b-c") );
	}
	
	
    // Function to convert infix expression
    //to postfix expression
    public String infixToPostfix(String s) {
        Stack < Character > st = new Stack < Character > ();
        st.push('N');
        ArrayList < Character > ns = new ArrayList < Character > ();
        for (int i = 0; i < s.length(); i++) {
            char C = s.charAt(i);
            // If the scanned character is an operand, add it to output string.
            if ((C >= 'a' && C <= 'z') || (C >= 'A' && C <= 'Z'))
                ns.add(C);
            // If the scanned character is an '(', push it to the stack.
            else if (C == '(')
                st.push('(');
            // If the scanned character is an ')', pop and to output string from the stack
            // until an '(' is encountered.
            else if (C == ')') {
                while (st.peek() != 'N' && st.peek() != '(') {
                    char c = st.peek();
                    st.pop();
                    ns.add(c);
                }
                if (st.peek() == '(') {
                    char c = st.peek();
                    st.pop();
                }
            }
            //If an operator is scanned
            else {
                while (st.peek() != 'N' && prec(C) <= prec(st.peek())) {
                    char c = st.peek();
                    st.pop();
                    ns.add(c);
                }
                st.push(C);
            }
        }
        //Pop all the remaining elements from the stack
        while (st.peek() != 'N') {
            char c = st.peek();
            st.pop();
            ns.add(c);
        }
        StringBuilder result = new StringBuilder(ns.size());
        for (Character c: ns) {
            result.append(c);
        }
        return result.toString();
    }
    
    public int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

}





















