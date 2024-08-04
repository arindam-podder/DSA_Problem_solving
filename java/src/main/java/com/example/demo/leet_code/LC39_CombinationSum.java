/**
 * 39. Combination Sum (Medium)

Given an array of distinct integers candidates and a target integer target, return a list of all unique 
combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 
combinations for the given input.

 
Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
 
Constraints:
1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC39_CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,3};
		int target = 4; 
		
		System.out.println(getCombinationSum(arr, target));
	}

	
	public static List<List<Integer>> getCombinationSum(int[] candidates, int target) {
		//pick-unpick rule 
		List<List<Integer>> result = new ArrayList<>(); 
		List<Integer> data = new ArrayList<>(); 
		
		recursion(0, candidates, target, data, result);
		
		return result;
    }
	
	//pick - unpick recursion fromula, according to question multiple time pick possible ,keep that in mind  
	public static void recursion(int i, int[] arr, int target, List<Integer> dataList, List<List<Integer>> result) {
		//base case
		if(i == arr.length) {
			if(target == 0) {
				result.add(new ArrayList<>(dataList));
			}
			return;
		}
		
		//pick condition 
		if(target >= arr[i]) {
			dataList.add(arr[i]);
			recursion(i, arr, target-arr[i], dataList, result);
			dataList.remove(dataList.size()-1); //backtrack, remove last added data 
		}
		
		//don't pick condition, just increase the index 
		recursion(i+1, arr, target, dataList, result);
		
	}
	
}












