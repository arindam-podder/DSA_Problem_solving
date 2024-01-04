/*
 * Q1. Unique Paths in a Grid

Problem Description
Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). 
At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. 
Return the total number unique paths from (1, 1) to (n, m).

Note: 
1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
2. Given Source Point and Destination points are 1-based index.


Problem Constraints
1 <= n, m <= 100
A[i][j] = 0 or 1


Input Format
Firts and only argument A is a 2D array of size n * m.

Output Format
Return an integer denoting the number of unique paths from (1, 1) to (n, m).

Example Input
Input 1:
 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
Input 2:
 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]


Example Output
Output 1:
 2
Output 2:
 0

Example Explanation
Explanation 1:
 Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}  
 So, the total number of unique paths is 2. 
Explanation 2:
 It is not possible to reach (n, m) from (1, 1). So, ans is 0.
 */


package com.example.demo.sclr_code.dynamic_programing;

public class UniquePathsInGrid {

	public static void main(String[] args) {
		int[][] arr = {{0,1}, {0,0}};
		
		System.out.println(uniquePath(arr));
	
	}
	
	
	public static int uniquePath(int[][] A) {
		for(int i=0; i<A.length; i++) {
 			for(int j=0; j<A[0].length; j++) {
				if(A[i][j] ==1 ) A[i][j] =0;		//if cell is blocked 
				else if(i==0 && j==0) A[i][j] =1; 		//starting top-left
				else if(i==0) A[i][j] = A[i][j-1];
				else if(j==0) A[i][j] = A[i-1][j];
				else {
					A[i][j] = A[i][j-1] + A[i-1][j];
				}
			}
		}
		return A[A.length-1][A[0].length-1];
	}
	

}
