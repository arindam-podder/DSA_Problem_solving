/*
 * given 2d matrix , where 1 is land and o is water, find land perimeter.
 */

package com.example.demo.mypractice;

public class MatrixLandPerimeter {

	public static void main(String[] args) {
		

	}
	
	
	public int solve(int[][] A) {
        int perimeter = 0; 
        int rows = A.length;
        int columns = A[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(A[i][j] == 1){
                    if(i==0 || A[i-1][j] == 0){
                        perimeter++;
                    }
                    if(i==rows-1 || A[i+1][j] == 0){
                        perimeter++;
                    }
                    if(j==0 || A[i][j-1] == 0){
                        perimeter++;
                    }
                    if(j == columns-1 || A[i][j+1] == 0){
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }

}
