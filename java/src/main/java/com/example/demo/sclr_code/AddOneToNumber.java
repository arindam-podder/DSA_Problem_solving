/*
 * Q1. Add One To Number

Problem Description
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :

Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

Problem Constraints
1 <= size of the array <= 1000000

Input Format
First argument is an array of digits.

Output Format
Return the array of digits after adding one.

Example Input
Input 1:
[1, 2, 3]

Example Output
Output 1:
[1, 2, 4]

Example Explanation
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */

package com.example.demo.sclr_code;

import java.util.ArrayList;
import java.util.List;

public class AddOneToNumber {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		list.add(9);
		list.add(9);
		
		System.out.println( plusOne(list) );
	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int add = 1;
        int startWith = 0;
        for(int i=A.size()-1; i>=0; i--){
            if(A.get(i)+add  == 10 ){
            	A.remove(i);
                A.add(i, 0);
                if(i==0){
                   startWith = 1;  
                }
            }else{
            	int val = A.get(i) + add;
            	A.remove(i);
                A.add(i, val);
                break;
            }
        }
        ArrayList<Integer> result = new ArrayList();
        boolean mostSignificatFound = false;
        if(startWith == 1 ){
            result.add(1);
            for(int i=0; i<A.size(); i++){
                result.add(A.get(i));
            }
        }else{
            for(Integer n : A){
                if(n!=0){
                    mostSignificatFound = true;
                }
                if(mostSignificatFound){
                    result.add(n);
                }
            }
        }
        return result;
    }
}
