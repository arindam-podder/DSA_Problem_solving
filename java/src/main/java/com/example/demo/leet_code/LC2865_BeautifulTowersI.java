/**
 * 2865. Beautiful Towers I

You are given an array heights of n integers representing the number of bricks in n consecutive towers. 
Your task is to remove some bricks to form a mountain-shaped tower arrangement. In this arrangement, the 
tower heights are non-decreasing, reaching a maximum peak value with one or multiple consecutive towers and 
then non-increasing.

Return the maximum possible sum of heights of a mountain-shaped tower arrangement.

Example 1:
Input: heights = [5,3,4,1,1]
Output: 13
Explanation:
We remove some bricks to make heights = [5,3,3,1,1], the peak is at index 0.

Example 2:
Input: heights = [6,5,3,9,2,7]
Output: 22
Explanation:
We remove some bricks to make heights = [3,3,3,9,2,2], the peak is at index 3.

Example 3:
Input: heights = [3,2,5,5,2,3]
Output: 18
Explanation:
We remove some bricks to make heights = [2,2,5,5,2,2], the peak is at index 2 or 3.

 
Constraints:
1 <= n == heights.length <= 103
1 <= heights[i] <= 109
 */


package com.example.demo.leet_code;

public class LC2865_BeautifulTowersI {

	public static void main(String[] args) {

	}

	public long maximumSumOfHeights(int[] heights) {
        return getMaxSumHeight(heights);
    }
	
	
	//approach traverse all index make it top , the go left and go right make mountain 
	public static long getMaxSumHeight(int[] arr) {
		long result = 0; 
		for(int i=0; i<arr.length; i++) {
			long forATop = getSumForATop(i, arr);
			result = Math.max(result, forATop);
		}
		return result;
	}
	
	public static long getSumForATop(int i, int[] arr) {
		long curSum = arr[i]; //start by making arr[i] as top then go left and right 
		//left check 
		int p=i-1;
		int maxVal = arr[i]; 
		while(p>=0) {
			if(arr[p] >= maxVal) curSum += maxVal; 
			else {
				curSum += arr[p]; 
				maxVal = arr[p];
			}
			p--;
		}
		//right check 
		p=i+1;
		maxVal = arr[i];
		while(p<arr.length) {
			if(arr[p] >= maxVal) curSum += maxVal; 
			else {
				curSum += arr[p]; 
				maxVal = arr[p];
			}
			p++;
		}
		return curSum;
	}
	
}
