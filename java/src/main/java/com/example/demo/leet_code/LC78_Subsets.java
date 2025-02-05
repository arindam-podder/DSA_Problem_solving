/**
 * 78. Subsets

Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 
Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC78_Subsets {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3}; 
		System.out.println( subsets(arr) );

	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>(); 
		recur(0, nums, new ArrayList<>(), res);
		return res;
    }
	
	//pick/unpick rule 
	public static void recur(int i, int[] arr, List<Integer> cur, List<List<Integer>> result) {
		if(i==arr.length) {
			result.add(new ArrayList<>(cur)); 
			return;
		}
/*		//pick 1st
		cur.add(arr[i]);
		recur(i+1, arr, cur, result);
		//unpick 2nd  
		cur.remove(cur.size()-1);
		recur(i+1, arr, cur, result);
*/
		//unpick 1st 
		recur(i+1, arr, cur, result);
		//pick 2nd
		cur.add(arr[i]); 
		recur(i+1, arr, cur, result);
		cur.remove(cur.size()-1);
		
	}
	
	
	
	//loop rule
	public static void recurLoop(int i, int[] arr, List<Integer> cur, List<List<Integer>> result) {
		result.add(new ArrayList<>(cur));
		for(int index=i; index<arr.length; index++) {
			cur.add(arr[index]); 
			recurLoop(index+1, arr, cur, result);
			cur.remove(cur.size()-1);
		}
	}
	

}





















