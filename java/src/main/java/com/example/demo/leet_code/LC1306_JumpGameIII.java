/**
 * 1306. Jump Game III
Medium
Topics
premium lock icon
Companies
Hint
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
 

Constraints:

1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length
 * 
 */


package com.example.demo.leet_code;

public class LC1306_JumpGameIII {

	public static void main(String[] args) {
		int[] arr = {3,0,2,1,2};
		int start = 2;
		System.out.print( canReach1(arr, start));
	}
	
    public static boolean canReach1(int[] arr, int start) {
        int[] vis = new int[arr.length];
        return recur(start, arr, vis);
    }
    
    public static boolean recur(int i, int[] arr, int[] visited) {
    	if(arr[i] == 0 ) return true;
    	visited[i] = 1; 
    	
    	//go back
    	int leftIdx = i-arr[i];
    	boolean left = false;
    	if( leftIdx >=0 && visited[leftIdx] != 1 ) {
    		left = recur(leftIdx, arr, visited);
    	}
    	
    	//go right 
    	int rightIdx = i+arr[i];
    	boolean right = false;
    	if( rightIdx <arr.length && visited[rightIdx] != 1 ) {
    		right = recur(rightIdx, arr, visited);
    	}
    	
    	return left || right;
    	
    }
    
    

}








