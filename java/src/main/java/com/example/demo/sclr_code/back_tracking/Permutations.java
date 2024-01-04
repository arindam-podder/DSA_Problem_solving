/*
 * Q2. Permutations

Problem Description
Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.

Problem Constraints
1 <= N <= 9

Input Format
Only argument is an integer array A of size N.

Output Format
Return a 2-D array denoting all possible permutation of the array.

Example Input
A = [1, 2, 3]

Example Output
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3] 
  [2, 3, 1] 
  [3, 1, 2] 
  [3, 2, 1] ]

Example Explanation
All the possible permutation of array [1, 2, 3].
 */


package com.example.demo.sclr_code.back_tracking;

import java.util.ArrayList;

public class Permutations {
	
	ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public static void main(String[] args) {
		
	}
	
	 public void permuteEvalute(ArrayList<Integer> A, ArrayList<Integer> ans, ArrayList<Integer> visited, int idx) {		//not correct
	    if(idx == A.size()) {
	    	this.list.add(ans);
	    	return; 
	    }
	    
	    for(int i=0; i<A.size(); i++) {
	    	if(visited.get(i) == 0 || visited.get(i)==null) {
	    		visited.set(i, 1);
	    		ans.set(i, A.get(i));
	    		permuteEvalute(A, ans, visited, idx+1);
	    		visited.set(i, 0);
	    	}
	    }
	    
	 }

}






















