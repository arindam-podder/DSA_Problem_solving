/**
 * 2542. Maximum Subsequence Score

You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. 
You must choose a subsequence of indices from nums1 of length k.

For chosen indices i0, i1, ..., ik - 1, your score is defined as:
The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
Return the maximum possible score.
A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or 
no elements.

Example 1:
Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
Output: 12
Explanation: 
The four possible subsequence scores are:
- We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
- We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6. 
- We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12. 
- We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
Therefore, we return the max score, which is 12.

Example 2:
Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
Output: 30
Explanation: 
Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30 is the maximum possible score.
 

Constraints:
n == nums1.length == nums2.length
1 <= n <= 105
0 <= nums1[i], nums2[j] <= 105
1 <= k <= n
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC2542_MaximumSubsequenceScore {

	public static void main(String[] args) {
		int[] nums1 = {1,3,3,2}, nums2 = {2,1,3,4}; 
//		nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6],
		int k = 3;
		
		System.out.println( maxScore(nums1, nums2, k) );
		
	}
	
	public static long maxScore(int[] nums1, int[] nums2, int k) {
        
		//List<Long> scores = new ArrayList<>();
		//sequecne(0, nums1, new ArrayList<>(), k, nums2, scores);
		//return scores.get(0);
		
		return findScore(nums1, nums2, k); 
		
    }
	
	
	//recur TLE
	public static void sequecne(int i, int[] arr1, List<Integer> cur, int k, int[] arr2, List<Long> scores ) {
		if(i==arr1.length) {
			if(cur.size() == k) {
				long score = getscore(cur, arr1, arr2);
				if(scores.size()==0) scores.add(score);
				else {
					if(scores.get(0) < score) scores.set(0, score);
				}
			}
			return;
		}
		sequecne(i+1, arr1, cur, k, arr2, scores);
		cur.add(i); 
		sequecne(i+1, arr1, cur, k, arr2, scores);
		cur.remove(cur.size()-1);
	}
	public static long getscore(List<Integer> indices, int[] arr1, int[] arr2) {
		int sum = arr1[indices.get(0)];
		int min = arr2[indices.get(0)];
		for(int i=1; i<indices.size(); i++) {
			sum += arr1[indices.get(i)];
			min = Math.min(min, arr2[indices.get(i)]);
		}
		return sum*min;
	}
	
	
	// same TLE
	public static long findScore(int[] arr1, int[] arr2, int k) {
		List<Pair> pair = new ArrayList<>();
		for(int i=0; i<arr1.length; i++) {
			pair.add(new Pair(arr1[i], arr2[i]));
		}
		Collections.sort(pair, (p1, p2) -> p2.num2 - p1.num2);
		//System.out.println( pair );
		
		Queue<Integer> que = new PriorityQueue<>();
		int curSum = 0; 
		long res = 0;	
		for(Pair p: pair) {
			curSum += p.num1; 
			que.add(p.num1);
			
			if(que.size() > k) {
				int poll = que.poll();
				curSum -= poll;
			}
			if(que.size() == k) {
				res = Math.max(res, curSum * p.num2);
			}
		}
		
		return res;
	}
	
	
	
	
	
	static class Pair{
		int num1;
		int num2;
		public Pair(int a, int b) {
			num1 = a; 
			num2 = b;
		}
		@Override
		public String toString() {
			return "Pair(num1=" + num1 + ", num2=" + num2 + ")";
		}
	}

	
}
































