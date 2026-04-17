/**
 * 3761. Minimum Absolute Distance Between Mirror Pairs

You are given an integer array nums.

A mirror pair is a pair of indices (i, j) such that:
0 <= i < j < nums.length, and
reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x. Leading zeros are omitted after reversing, 
for example reverse(120) = 21.
Return the minimum absolute distance between the indices of any mirror pair. The absolute distance between indices i and j is abs(i - j).

If no mirror pair exists, return -1.

Example 1:
Input: nums = [12,21,45,33,54]
Output: 1

Explanation:
The mirror pairs are:
(0, 1) since reverse(nums[0]) = reverse(12) = 21 = nums[1], giving an absolute distance abs(0 - 1) = 1.
(2, 4) since reverse(nums[2]) = reverse(45) = 54 = nums[4], giving an absolute distance abs(2 - 4) = 2.
The minimum absolute distance among all pairs is 1.

Example 2:
Input: nums = [120,21]
Output: 1
Explanation:
There is only one mirror pair (0, 1) since reverse(nums[0]) = reverse(120) = 21 = nums[1].
The minimum absolute distance is 1.

Example 3:
Input: nums = [21,120]
Output: -1
Explanation:
There are no mirror pairs in the array.


Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 109
 */
package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC3761_MinimumAbsoluteDistanceBetweenMirrorPairs {

	public static void main(String[] args) {
		int[] nums = {21,120};
		int[] nums1 = {12,45,33,54};
		
		System.out.println( minMirrorPairDistance1(nums1) );
	}
	
	public static int minMirrorPairDistance1(int[] nums) {
		Map<Integer,List<Integer>> position = getPosition(nums);
		int result = Integer.MAX_VALUE; 
		for(int i=0; i<nums.length; i++) {
			int n = nums[i]; 
			int rev = reverse(n); 
			if(position.containsKey(rev)) {
				for(int idx: position.get(rev)) {
					if(idx>i) {
						int dis = Math.abs(i-idx); 
						if(dis==1) return 1;
						result = Math.min(result, dis);
						break;
					}
				}
			}
			
		}
		
		return result==Integer.MAX_VALUE? -1: result;
		
	}
	
	public static int reverse(int n) {
		int rev = 0; 
		while(n != 0 ) {
			int digit = n%10;
			rev = rev *10 + digit;
			n = n/10;
		}
		return rev;
	}
	
	//cach integer and thei position
	public static Map<Integer, List<Integer>> getPosition(int[] nums){
		Map<Integer, List<Integer>> cache = new HashMap<>(); 
		for(int i=0; i<nums.length; i++) {
			int n = nums[i];
			if(cache.containsKey(n)) {
				cache.get(n).add(i);
			}else {
				cache.put(n, new ArrayList<>());
				cache.get(n).add(i);
			}
		}
		return cache;
	}
	
}

















