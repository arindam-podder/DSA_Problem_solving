/**
 * 118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:
1 <= numRows <= 30
 */



package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC118_PascalTriangle {

	public static void main(String[] args) {
		System.out.println( generateList(6));

	}
	
	
	public  static List<List<Integer>> generateList(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
        for(int row=0; row<numRows; row++) {
        	List<Integer> rowList = new ArrayList<>();
        	for(int col=0; col<=row; col++) {
        		//0 and last col will be 1
        		if(col==0 || col==row) {
        			rowList.add(1);
        		}else {
        			rowList.add( result.get(row-1).get(col) + result.get(row-1).get(col-1) );
        		}
        	}
        	result.add(rowList);
        }
        
        return result;
    }

}



















