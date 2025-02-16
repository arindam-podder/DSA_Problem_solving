/**
 * 2342. Max Sum of a Pair With Equal Sum of Digits

You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, 
such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that 
satisfy the conditions.

Example 1:
Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.

Example 2:
Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 
Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

 */


package com.example.demo.leet_code;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC2342_MaxSumPairWithEqualSumOfDigits {

	public static void main(String[] args) {
		 int[] arr = {18,43,36,13,7};
		 
		 System.out.println( maximumSum(arr) );
		 System.out.println( maximumSum2(arr) );
	}

	
	//passed
	public static int maximumSum(int[] nums) {
		//PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for(int n: nums) {
			int digitSum = getDigitSum(n);
			if(map.containsKey(digitSum)) {
				map.get(digitSum).add(n); 
			}else{
				map.put(digitSum, new PriorityQueue<>(Comparator.reverseOrder()));
				map.get(digitSum).add(n);
			}
		}
		int maxSum = -1; 
		for(PriorityQueue<Integer> q : map.values()) {
			if(q.size()>=2) {
				int a = q.poll(); 
				int b = q.poll();
				int sum = a+b; 
				maxSum = Math.max(maxSum, sum);
			}
		}
		
		return maxSum;
    } 
	
	//optimized , without using heap, in map keep max val and calculate sum then&there only
	public static int maximumSum2(int[] nums) {
		int maxSum = -1; 
		Map<Integer, Integer> map = new HashMap<>();
		for(int n : nums) {
			int digitSum = getDigitSum(n); 
			if(map.containsKey(digitSum)) {
				 maxSum = Math.max(maxSum, map.get(digitSum) + n);
				 if(n > map.get(digitSum)) {
					 map.put(digitSum, n);
				 }
			}else{
				map.put(digitSum, n);
			}
		}
		return maxSum;
	}
	
	public static int getDigitSum(int n) {
		int sum = 0;
		while(n>0) {
			sum += n%10;
			n = n/10;
		}
		return sum;
	}
	
}
