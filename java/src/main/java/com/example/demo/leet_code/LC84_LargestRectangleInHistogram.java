/**
 * 84. Largest Rectangle in Histogram  (Hard)

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
return the area of the largest rectangle in the histogram.

 

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4
 

Constraints:
1 <= heights.length <= 105
0 <= heights[i] <= 104
 */


package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.Stack;

public class LC84_LargestRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = new int[] {1, 2, 2, 3, 4, 2, 1};
//		int[] arr = new int[] {2, 0, 4};
		int[] arr = {3,5,5,2,5,5,6,6,4,4,1,1,2,5,5,6,6,4,1,3};
		
		System.out.println( maxRect(arr));
		
		//System.out.println( Arrays.toString( getLeftIdxArr(arr) ));
		//System.out.println( Arrays.toString( getRightIdxArr(arr) ));
		
		System.out.println( largestRectArea(arr) );
	}
	
	
	//this is same as below 
	public static int maxRect(int [] histogram) {
	    int n;
	    int res = 0;
	    int prevMin[];
	    int nextMin[];
	    int num;
	    Stack<Integer> stack;
	    
	    n = histogram.length;
	    prevMin = new int[n];
	    nextMin = new int[n];
	    
	    stack = new Stack<Integer>();
	    
	    prevMin[0] = -1;
	    stack.push(0);
	    for (int i = 1; i < n; i++) {
	        num = histogram[i];
	        while (!stack.isEmpty() && num <= histogram[stack.peek()]) {
	            stack.pop();
	        }
	        prevMin[i] = -1;
	        if (!stack.isEmpty()) {
	            prevMin[i] = stack.peek();
	        }
	        stack.push(i);
	    }

	    
	    nextMin[n - 1] = n;
	    stack.clear();
	    stack.push(n - 1);
	    for (int i = n - 2; i >= 0; i--) {
	        num = histogram[i];
	        while (!stack.isEmpty() && num <= histogram[stack.peek()]) {
	            stack.pop();
	        }
	        nextMin[i] = n;
	        if (!stack.isEmpty())
	            nextMin[i] = stack.peek();
	        stack.push(i);
	    }
	    
	    for (int i = 0; i < n; i++) {
	        int left = prevMin[i] + 1;
	        int right = nextMin[i] - 1;
	        res = Math.max(res, histogram[i] * (right - left + 1));
	    }
	    
	    return res;
	}
	
	
	
	
	
	
	
	

	public static int largestRectArea(int[] heights) {
        int result = Integer.MIN_VALUE; 
        int[] left = getLeftIdxArr(heights); 
        int[] right = getRightIdxArr(heights);
        for(int i=0; i<heights.length; i++) {
        	int h = heights[i]; 
        	int w = right[i] - left[i] +1;
        	
        	result = Math.max(result, h*w);
        }
        return result;
    }
	
	
	//use stack to maintain left lower, and leftIdx will point to farthest index that we can go 
	public static int[] getLeftIdxArr(int[] arr) {
		int[] left = new int[arr.length];
		Stack<Integer> stack = new Stack<>(); 
		
		left[0] = 0; 
		stack.add(0);
		for(int i=1; i<arr.length; i++) {
			if(arr[i] == arr[stack.peek()]) left[i] = left[i-1];
			else if(arr[i] < arr[stack.peek()]) {
				while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					int plus = 1;			//edge case to handle 
					int peekIdx = stack.peek();
					while(arr[peekIdx+plus] < arr[i]) {
						plus ++;
					}
					
					left[i] = peekIdx + plus;
					stack.add(i);
				}
				else {
					left[i] = 0;
					stack.add(i);
				}
			}
			else {
				left[i] = i; 
				stack.add(i);
			}
		}
		return left;
	}
	
	
	//use stack to maintain left lower, and leftIdx will point to farthest index that we can go 
	public static int[] getRightIdxArr(int[] arr) {
		int[] right = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		
		right[arr.length-1] = arr.length-1; 
		stack.add(arr.length-1);
		for(int i=arr.length-2; i>=0; i--) {
			if(arr[i] == arr[stack.peek()]) right[i] = right[i+1];
			else if(arr[i] < arr[stack.peek()]) {
				while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					int minus = 1;
					int peekIdx = stack.peek();
					while(arr[peekIdx-minus] < arr[i]) {
						minus ++;
					}
					right[i] = peekIdx-minus;
					stack.add(i);
				}
				else {
					right[i] = arr.length-1;
					stack.add(i);
				}
			}
			else {
				right[i] = i; 
				stack.add(i);
			}
		}
		return right;
	}
	
}











