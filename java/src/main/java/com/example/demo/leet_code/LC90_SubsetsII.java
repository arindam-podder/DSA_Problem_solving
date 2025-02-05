/**
 * 90. Subsets II

Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 
 
Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_SubsetsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 2};
		System.out.println( getSubsetsWithDup(arr) );

	}
	
	public static List<List<Integer>> getSubsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		//recurBacktrack(0, nums, new ArrayList<>(), result);
		recurLoop(0, nums, new ArrayList<>(),  result);
		return result ;
    }
	
	public static void recurLoop(int i, int[] arr, List<Integer> cur, List<List<Integer>> res) {
		res.add(new ArrayList<>(cur)); 
		for(int index=i; index<arr.length; index++) {
			if(index>i && arr[index] == arr[index-1]) continue;
			cur.add(arr[index]); 
			recurLoop(index+1, arr, cur, res);
			//backtrack 
			cur.remove(cur.size()-1);
		}
		
	}
	
	
}//class end

















