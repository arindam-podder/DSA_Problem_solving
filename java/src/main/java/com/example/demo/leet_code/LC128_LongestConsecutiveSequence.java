/**
 * 128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input: nums = [1,0,1,2]
Output: 3

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */



package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC128_LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {100,4,200,1,3,2};
		System.out.println( longestConsecutive1(nums) );
		System.out.println( longestConsecutive2(nums) );
		
	}
	
	//app1 - sort then find consecutive  //passed  TC:O(nlogn + n)
    public static int longestConsecutive1(int[] nums) {
    	int n = nums.length;
    	if(n<=1) return n;
  
        Arrays.sort(nums);
        int res = 1; 
        int cur = 1; 
        for(int i=1; i<n; i++) {
        	if(nums[i] == nums[i-1]+1) {
        		cur +=1;
        	}else if(nums[i] == nums[i-1]) {	// in case of repeat
        		continue;
        	}
        	else {
        		cur = 1;
        	}
        	res = Math.max(res, cur);
        }
        return res;
    }
    
    //app 2 - extra space set 
    public static int longestConsecutive2(int[] nums) {
    	int n = nums.length;
    	if(n<=1) return n;
    	
    	Set<Integer> set = new HashSet<>();
    	for(int a: nums) set.add(a);
    	int res = 0; 
    	for(int i=0; i<n; i++) {
    		int num = nums[i];
    		int cur = 1;
    		if( set.contains(num) ) {
    			//left consecutive 
    			int left = num-1;
    			while(set.contains(left)) {
    				set.remove(left);
    				cur +=1; 
    				left -= 1;
    			
    			}
    			//right consecutive
    			int right = num+1; 
    			while(set.contains(right)) {
    				set.remove(right); 
    				cur +=1; 
    				right += 1;
    			}
    		}
    		
    		res = Math.max(res, cur);
    	}
    	return res;
    }
    
    
}
















