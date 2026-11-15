/**
 * 930. Binary Subarrays With Sum

Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.


Example 1:
Input:
int[] nums = new int[]{1, 0, 1, 0, 1};
int goal = 2;
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

Example 2:
Input:
int[] nums = new int[]{0, 0, 0, 0, 0};
int goal = 0;
Output: 15
 

Constraints:
1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
 */



package com.example.demo.leet_code;

import java.awt.geom.CubicCurve2D;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class LC930_BinarySubarraysWittSum {

	public static void main(String[] args) {
		int[] nums = new int[]{1,0,1,0,1};
		int goal = 2;
		
		//int[] nums = new int[]{0, 0, 0, 0, 0};
		//int goal = 0;
		
		
		System.out.println( numSubarraysWithSum1(nums, goal) );
	}
    
    
    /**
     * use Map<presfixSum, count> to get subArray count 
     * 
     */
    public static int numSubarraysWithSum1(int[] arr, int goal) {
        int res = 0; 
        int curSum = 0; 
        Map<Integer, Integer> map = new HashMap<>();   	//map<prefixsum, count>
        map.put(curSum, 1); 	//initially curSum has one count
        int l=0; 
        while(l<arr.length) {
        	curSum += arr[l]; 
        	
        	//for goal we need (cursum-goal)  key 
        	if(map.containsKey(curSum-goal)) res += map.get(curSum-goal); 
        	
        	map.put(curSum, map.getOrDefault(curSum, 0)+1);
        	
        	l++;
        }
        
        return res; 
    }

}















