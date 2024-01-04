/*
 * Q1. Combinations

Problem Description
Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Problem Constraints
1 <= A, B <= 10

Input Format
The first argument is an integer A.
The second argument is an integer B.

Output Format
Return a 2-D vector denoting all possible combinations.

Example Input
Input 1:
 A = 4
 B = 2
Input 2:
 A = 3
 B = 2

Example Output
Output 1:
 [
  [1, 2],
  [1, 3],
  [1, 4],
  [2, 3],
  [2, 4],
  [3, 4],
 ]
Output 2:
 [
  [1, 2],
  [1, 3],
  [2, 3]
 ] 

Example Explanation
Explanation 1:

All the possible combinations of size 2 in sorted order.
 */

package com.example.demo.sclr_code;

import java.util.ArrayList;

public class CombinationRecursion {
	
	public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

	public static void main(String[] args) {
		
		int A = 2; 
		int B = 1;
		ArrayList<Integer> cur = new ArrayList<>();
		
		solution(1, cur, A, B);
	
		System.out.println(result);
	}
	
	public static void solution(int digit, ArrayList<Integer> cur, int A, int B) {
		if(cur.size() == B) {
			result.add(new ArrayList<>(cur));
			return;
		}
		if(digit == A+1) {
			return;
		}
		//include current ele 
		if(!result.contains(digit)) {
			cur.add(digit);
		}
		solution(digit+1, cur, A, B);
		cur.remove(cur.size() - 1);
        // Don't include current element
        solution(digit + 1, cur, A, B);
		
		
	}

}














