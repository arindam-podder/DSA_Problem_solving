/**
 * 905. Sort Array By Parity

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers
Return any array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:
Input: nums = [0]
Output: [0]
 
Constraints:
1 <= nums.length <= 5000
0 <= nums[i] <= 5000

 */


package com.example.demo.leet_code;

public class LC905_SortArrayByParity {
	public static void main(String[] args) {
		
	}
	
	
	//in place modification - not good as method want a new array not void 
    public static int[] sortArrayByParity(int[] nums) {
        for(int i=0; i<nums.length; i++) {
        	if(nums[i]%2 == 1) {
        		//from behgind pick even and swap 
        		for(int j=nums.length-1; j>i; j--) {
        			if(nums[j]%2 == 0) {
        				int tmp = nums[i]; 
        				nums[i] = nums[j]; 
        				nums[j] = tmp;
        			}
        		}
        	}
        }
        return nums;
    }//method end
    
    
    //optimized - two pointer and new array has been taken  //100% beats
    public static int[] solve(int[] arr) {
    	int[] res = new int[arr.length]; 
    	int even = 0; 
    	int odd = arr.length-1;
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i]%2 == 0) {
    			res[even++] = arr[i]; 
    		}else {
    			res[odd--] = arr[i]; 
    		}
    	}
    	return res;
    }
    
}














