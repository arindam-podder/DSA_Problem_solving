/*
 * Q1. Largest Number

Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109

Input Format
The first argument is an array of integers.

Output Format
Return a string representing the largest number.

Example Input
Input 1:
 A = [3, 30, 34, 5, 9]
Input 2:
 A = [2, 3, 9, 0]

Example Output
Output 1:
 "9534330"
Output 2:
 "9320"

Example Explanation
Explanation 1:
Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */


package com.example.demo.sclr_code.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber implements Comparator<String> {

	public static void main(String[] args) {
		int[] arr = {3, 30, 34, 5, 9};
		
		System.out.println(largestNumber(arr));

	}

	public static String largestNumber(final int[] A) {
        String[] temp = new String[A.length];
        for(int i=0; i<temp.length; i++) {
        	temp[i] = ""+A[i];
        }
        Arrays.sort(temp, new LargestNumber());
        
        String s = "";
        for(int i=0; i<temp.length; i++) {
        	s = s+temp[i];
        }
        return s;
    }   

    public int compare(String a, String b){
//        if(Integer.parseInt(""+a+b) < Integer.parseInt(""+b+a)){
//            return 1;
//        }
//        if(Integer.parseInt(""+a+b) > Integer.parseInt(""+b+a)){
//            return -1;
//        }
//        return 0;
    	String first = a + b;
        String second =b + a;
        return second.compareTo(first);

    }

	
}

/*
 * 
> TestCase - Trivial Case Correctness Failed
Wrong Answer
Your program's output doesn't match the expected output. You can try testing your code with custom input and try putting debug statements in your code.
Your submission failed for the following input

Arg 1: An Integer Array, For e.g [1,2,3]
[3,30,34,5,9]

Test As Custom Input
The expected return value:
9534330

Your function returned the following:
9534303

Final Verdict
> Wrong Answer
 */














