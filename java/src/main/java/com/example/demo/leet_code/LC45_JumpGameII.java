/**
 * 45. Jump Game II (Medium)

You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i],
 you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 
Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, 
then 3 steps to the last index.
Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
 
Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
 */


package com.example.demo.leet_code;

public class LC45_JumpGameII {

	public static void main(String[] args) {
		int[] arr = {4,3,0,1,4};
		
		System.out.println(minJump(arr));
	}
	
	
	public static int minJump(int[] arr) {
		/**
		 * 	use carrey forward minJump count and l-r range to maintain max person can jump from its position 
		 */
		
		int minJump = 0; 
		//initially  l and r will be on 0 index 
		int l=0 , r = 0; 
		while(r<arr.length-1) {
			//current l-r range max jump can be perform 
			int max = Integer.MIN_VALUE; 
			for(int i=l; i<=r; i++) {
				max = Math.max(max, i + arr[i]);
			}
			l = r+1;
			r = max;
			minJump += 1;
		}
		return minJump; 
	}
	

}







