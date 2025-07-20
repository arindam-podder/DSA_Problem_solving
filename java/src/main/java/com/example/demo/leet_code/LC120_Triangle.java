/**
 * 120. Triangle

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i 
on the current row, you may move to either index i or index i + 1 on the next row.


Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:
Input: triangle = [[-10]]
Output: -10
 
Constraints:
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 */




package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.List;

public class LC120_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
		List<List<Integer>> triangle = List.of( List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));  

		System.out.println( minimumTotal1(triangle) );
		
	}
	
    public static int minimumTotal1(List<List<Integer>> triangle) {
        //return recur(0, 0, triangle);
    	
    	int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
    	for(int[] arr: dp) Arrays.fill(arr, Integer.MAX_VALUE);
    	
    	return memeorize(0, 0, triangle, dp);
    }
    
    
    //TLE 
    public static int recur(int row, int index, List<List<Integer>> triangle) {
    	//base 
    	if(row == triangle.size()-1) return triangle.get(row).get(index);
    	
    	//body 
    	int a = recur(row+1, index, triangle) + triangle.get(row).get(index);
    	int b =  recur(row+1, index+1, triangle) + triangle.get(row).get(index);
    	
    	return Math.min( a ,  b);
    }
    
    public static int memeorize(int row, int index, List<List<Integer>> triangle, int[][] dp) {
    	//base 
    	if(row == triangle.size()-1) return triangle.get(row).get(index);
    	
    	if(dp[row][index] != Integer.MAX_VALUE) return dp[row][index];
    	
    	//body 
    	int a = memeorize(row+1, index, triangle, dp) + triangle.get(row).get(index);
    	int b =  memeorize(row+1, index+1, triangle, dp) + triangle.get(row).get(index);
    	
    	dp[row][index] = Math.min( a ,  b);
    	return dp[row][index];
    }
    
    
    
    

}
