/**
 * 73. Set Matrix Zeroes

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 
Constraints:
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 
Follow up:
A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

 */


package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LC73_SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {0,1,2,0}, {3,4,5,2}, {1,3,1,5} };
		
		rowColZeros(matrix);
		
		for(int[] arr: matrix) {
			System.out.println(Arrays.toString(arr));
		}
		
		
		
		

	}

	//keep one data-structure to remember fake source of Zeros  
	public static void rowColZeros(int[][] matrix) {
        HashSet<FakeZeroPlace> fakeZeros = new HashSet<>(); 
        int rows = matrix.length; 
        int cols = matrix[0].length; 
        for(int i=0; i<rows; i++) {
        	for(int j=0; j<cols; j++) {
        		int val = matrix[i][j]; 
        		//if val is non-zero or fake-zero then continue 
        		if(val != 0 || (val == 0 && fakeZeros.contains(new FakeZeroPlace(i, j))) ) {
        			continue;
        		}else {
        			fill(matrix, i, j, fakeZeros);
        		}
        	}
        }
    }
	
	public static void fill(int[][] matrix, int r, int c, Set<FakeZeroPlace> fakeZeros)  {
		//row zeros 
		for(int i=0; i<matrix[0].length; i++) {
			if(matrix[r][i] != 0 ) {
				matrix[r][i] = 0; 
				//mark it as fake zero 
				fakeZeros.add(new FakeZeroPlace(r, i));
			}	
		}
		
		//col zeros 
		for(int i=0; i<matrix.length; i++) {
			if(matrix[i][c] != 0 ) {
				matrix[i][c] = 0; 
				//mark it as fake zero 
				fakeZeros.add(new FakeZeroPlace(i, c));
			}	
		}
	}
	
	
	
	
	static class FakeZeroPlace{
		
		int row; 
		int col; 
		
		public FakeZeroPlace(int r, int c) {
			this.row = r;
			this.col = c;
		}
		
		@Override
		public boolean equals(Object obj) {
			FakeZeroPlace fakeZeroPlace = (FakeZeroPlace) obj;
			if(this.row == fakeZeroPlace.row && this.col == fakeZeroPlace.col) {
				return true;
			}else {
				return false;
			}
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(row, col);
		}
		
		@Override
		public String toString() {
			return "FakeZeroPlace ["+this.row+","+this.col+"]" ;
		}
		
		
	}
	
}
