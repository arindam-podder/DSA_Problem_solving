/**
 * 55. Jump Game (Medium)

You are given an integer array nums. You are initially positioned at the array's first index, 
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 
Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, 
which makes it impossible to reach the last index.
 

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105
 */


package com.example.demo.leet_code;

public class LC55_JumpGame {

	public static void main(String[] args) {
//		int[] arr = {3, 2, 1, 0, 4};
		int[] arr = {2,3,1,1,4};
		
		System.out.println(canJump(arr, 0));
	}
	
	
    //getting TLE
    public static boolean canJump(int[] arr, int i) {
		//base 
		if(i==arr.length-1) return true; 
		if(arr[i] == 0) return false; 
		
		int maxJump = arr[i]; 
        boolean dfault = false;
		for(int jump=1; jump<=maxJump; jump++) {
			if(i+jump < arr.length) {
				dfault = dfault || canJump(arr, i+jump);
			}
		}
		return dfault;
    }
    
    
    //approach:maintain a maxIdex can be reach from each index, kind of carryForward the max , and Zero value has to tackle 
   public static boolean canJump(int[] arr) {
	   int maxReach=0;
	   for(int i=0; i<arr.length; i++) {
		   //if current i is getter that maxReach then false, becoz we got zero previoulsy from there we cant go futher 
		   if(i>maxReach) return false;
		   maxReach = Math.max(maxReach, i+arr[i]); 
		   if(maxReach >= arr.length-1) return true;
	   }
	   return true;
   }
    

}




