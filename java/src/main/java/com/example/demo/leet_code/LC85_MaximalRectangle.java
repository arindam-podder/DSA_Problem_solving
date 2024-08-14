/**
 * 85. Maximal Rectangle (Hard)

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and 
return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:
Input: matrix = [["0"]]
Output: 0

Example 3:
Input: matrix = [["1"]]
Output: 1
 

Constraints:
rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
 */


package com.example.demo.leet_code;

import java.util.Stack;

public class LC85_MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static int maximamRectangle(char[][] A) {
		if (A == null || A.length == 0) {
	        return 0;
	    }
	    int m, n;
	    int i, j;
	    m = A.length;
	    n = A[0].length;
	    int count[][];
	    count = new int[m][n];
	    for (i = 0; i < m; i++) {
	        for (j = 0; j < n; j++) {
	            if (i == 0) {
	                count[i][j] = A[i][j] - '0';      //covert char to int   
	            } else {
	                count[i][j] = A[i][j] == '0' ? 0 : count[i - 1][j] + 1;
	            }
	        }
	    }
	    int res = 0;
	    for (i = 0; i < m; i++) {
	        res = Math.max(res, maxRect(count[i]));
	    }
	    return res;
    }
	
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
	

}
