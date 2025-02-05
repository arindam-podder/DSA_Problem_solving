/**
 * 46. Permutations

Given an array nums of distinct integers, return all the possible 
permutations
. You can return the answer in any order.



Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 
Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */



package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC46_Permutations {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3}; 
		System.out.println( getPermutation(arr) );
		
	}
	
	
	public static List<List<Integer>> getPermutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteRecur(nums, new ArrayList<>(), res);
        return res;
    }
	
	public static void permuteRecur(int[] arr, List<Integer> cur, List<List<Integer>> result) {
		//base case 
		if(cur.size() == arr.length) {
			result.add(new ArrayList<>(cur)); 
			return;
		}else {
			for(int n: arr) {
				if(!cur.contains(n)) {
					cur.add(n);
					permuteRecur(arr, cur, result);
					cur.remove(cur.size()-1);
				}
			}
		}
	}
	

}//LC46_Permutations end



















