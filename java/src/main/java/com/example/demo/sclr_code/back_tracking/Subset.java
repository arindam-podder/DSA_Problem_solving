/*
 * Q1. Subset

Problem Description
Given a set of distinct integers A, return all possible subsets.

NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The initial list is not necessarily sorted.

Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX

Input Format
First and only argument of input contains a single integer array A.

Output Format
Return a vector of vectors denoting the answer.


Example Input
Input 1:
A = [1]
Input 2:
A = [1, 2, 3]


Example Output
Output 1:
[
    []
    [1]
]
Output 2:
[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]

 */

package com.example.demo.sclr_code.back_tracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {
	
	ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Subset obj = new Subset(); 
		obj.subsetsUsingRecursion(list, 0, new ArrayList<>());
		
		System.out.println(obj.list);
	}
	
	public void subsetsUsingRecursion(ArrayList<Integer> arr, int index, ArrayList<Integer> current) {		//not working 
		if(index >= arr.size()) {
			this.list.add(current);
			return;
		}
		subsetsUsingRecursion(arr, index+1, current);
		current.add(arr.get(index));
		subsetsUsingRecursion(arr, index+1, current);
		current.remove(arr.size()-1);
	}

}

class Solution {
    ArrayList<ArrayList<Integer>> finalAns = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        findSubsets(A, new ArrayList<Integer>(), 0);
        return finalAns;
    }

    public void findSubsets(ArrayList<Integer> A, ArrayList<Integer> temp, int index) {
        finalAns.add(new ArrayList<>(temp));

        for (int i = index; i < A.size(); i++) {
            temp.add(A.get(i));
            findSubsets(A, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}//solution end 









