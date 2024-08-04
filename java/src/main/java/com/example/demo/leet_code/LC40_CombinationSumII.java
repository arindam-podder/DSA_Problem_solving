/**
 * 40. Combination Sum II  (Medium)

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in 
candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 
Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC40_CombinationSumII {
	public static void main(String[] args) {
		int[] arr = new int[] {10,1,2,7,6,1,5};
		int target = 8; 
		
		System.out.println(getCombinationSum2(arr, target));
		
	}
	
	 public static List<List<Integer>> getCombinationSum2(int[] candidates, int target){
		 List<Integer> data = new ArrayList<>(); 
		 List<List<Integer>> result = new ArrayList<>();
		 Arrays.sort(candidates);
		 recursion(0, candidates, target, data, result);
		 
		 return result;
	 }
	
	 
	 //make choice from 0-n-1 arrray value 
	 public static void recursion(int idx, int[] arr, int target, List<Integer> data, List<List<Integer>> result) {
		//base 
		if(target == 0 ) {
			 result.add(new ArrayList<>(data));
			 return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			if(i>idx && arr[i]==arr[i-1]) {
				continue;
			}
			if(arr[i] > target) break;
			
			data.add(arr[i]); 
			recursion(i+1, arr, target-arr[i], data, result);
			data.remove(data.size()-1);
		}
		 
	 }	
}



//TLE for simple set farmula 

/**
 * 
 * public static List<List<Integer>> getCombinationSum2(int[] candidates, int target) {
		List<Integer> data = new ArrayList<>(); 
		Set<List<Integer>> resultSet = new HashSet<>();
		Arrays.sort(candidates);
		recursion(0, candidates, target, data, resultSet);

		List<List<Integer>> result = new ArrayList<>();
		for(List<Integer> l: resultSet) {
			result.add(l);
		}
		
        return result;
    }
	
	//pick - unpick fomula , and using set to remove the duplicate 
	public static void recursion(int i, int[] arr, int target, List<Integer> data, Set<List<Integer>> resultSet) {
		if(target == 0){
			ArrayList<Integer> list = new ArrayList<>(data);
//			Collections.sort(list);
			resultSet.add(list);
			return;
		}
		if(i == arr.length) return; 
				
		
		//pick , multiple not allowed 
		if(target >= arr[i]) {
			data.add(arr[i]); 
			recursion(i+1, arr, target-arr[i], data, resultSet);
			data.remove(data.size()-1); //backtrack, remove last added data 
		}
		
		//don't pick 
		recursion(i+1, arr, target, data, resultSet);
		
	}
 * 
 * 
 */








