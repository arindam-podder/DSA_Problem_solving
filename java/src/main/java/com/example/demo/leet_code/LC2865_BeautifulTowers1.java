/**
 * 2865. Beautiful Towers I

You are given an array heights of n integers representing the number of bricks in n consecutive towers. 
Your task is to remove some bricks to form a mountain-shaped tower arrangement. In this arrangement, 
the tower heights are non-decreasing, reaching a maximum peak value with one or multiple consecutive towers and 
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

import java.util.Arrays;
import java.util.Stack;

public class LC2865_BeautifulTowers1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,4,5,2,5,5,2,1,1,3};   //23
		System.out.println( maximumSumOfHeights1(arr) );
	}
	
    public static long maximumSumOfHeights1(int[] heights) {
        long result = 0; 
        for(int i=0; i<heights.length; i++) {
        	result = Math.max(result, maxForAGivenIdx(i, heights));
        }
       //return result;
       
       
       //approach2
       long arrSum = Arrays.stream(heights).sum();
       return arrSum - minimumRemovalCost(heights);
       
        	
    }
    
    //approach 1 - each index: current idx is the peak, then left and right make mountains , take the sum (TC - n^2)
    public static long maxForAGivenIdx(int idxOfMax, int[] arr) {
    	int[] heights = Arrays.copyOf(arr, arr.length);
    	int left = idxOfMax -1; 
        int right = idxOfMax +1;
        long result = heights[idxOfMax]; 
        while(left>=0 && right<heights.length) {
        	if(heights[left] < heights[left+1])
        		result +=   heights[left];
        	else {	
        		result += heights[left+1];
        		heights[left] = heights[left+1];
        	}	
        	left -= 1;
        	if(heights[right] < heights[right-1])
        		result +=   heights[right];
        	else {		
        		result += heights[right-1];
        		heights[right] = heights[right-1];
        	}
       		right += 1;
        }
        while(left>=0 ) {
        	if(heights[left] < heights[left+1])
        		result +=   heights[left];
        	else {	
        		result += heights[left+1];
        		heights[left] = heights[left+1];
        	}	
        	left -= 1;
        }
        while(right<heights.length) {
	        if(heights[right] < heights[right-1])
	    		result +=   heights[right];
	    	else {		
	    		result += heights[right-1];
	    		heights[right] = heights[right-1];
	    	}
	   		right += 1;
        }	
        return result;
    }
    
    
    //approach 2- find left to right increasing bricks removal cost, 
    // right to left increasing brick removal cost
    // then ( arrSum - (min(left[i])+min(right[i]) )   (TC - 3N ~ N)
    public static long minimumRemovalCost(int[] arr) {
    	int arrLen = arr.length;
    	Stack<Integer> st = new Stack<>();
    	int[] leftCost = new int[arrLen]; //storing min cost for L->R
    	leftCost[0] = 0; 
    	st.add(arr[0]); 
    	for(int i=1; i<arrLen; i++) {		//left to right increasing
    		if(arr[i] >= st.peek()) {
    			leftCost[i] = leftCost[i-1]; 
    			st.add(arr[i]);
    		}else {
    			int cur = 0; 
    			while(!st.isEmpty() && st.peek() >= arr[i]) {
    				cur = cur + ( st.peek() - arr[i] );
    				st.pop();
    			}
    			leftCost[i] = leftCost[i-1] + cur; 
    			st.add(arr[i]);
    		}
    	}
    	
    	int[] rightCost = new int[arrLen]; 	////storing min cost for R->L
    	rightCost[arrLen-1] = 0; 
    	st.clear();
    	st.add(arr[arrLen-1]);
    	for(int i=arrLen-2; i>=0; i--) {	//right to left increasing
    		if(arr[i] >= st.peek()) {
    			rightCost[i] = rightCost[i+1];
    			st.add(arr[i]);
    		}else {
    			int cur = 0;
    			while( !st.isEmpty() && st.peek() >= arr[i]) {
    				cur = cur + ( st.peek() - arr[i]);
    				st.pop();
    			}
    			rightCost[i] = rightCost[i+1] + cur;
    			st.add(arr[i]);
    		}
    	}
    	
    	int removalCost = Integer.MAX_VALUE; 
    	for(int i=0; i<arrLen; i++) {
    		removalCost = Math.min(removalCost, leftCost[i]+rightCost[i]);
    	}
    	return removalCost;
    }
}






