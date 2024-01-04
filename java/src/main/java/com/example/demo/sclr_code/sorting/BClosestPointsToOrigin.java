/*
 * Q2. B Closest Points to Origin

Problem Description
We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).

Problem Constraints
1 <= B <= length of the list A <= 105
-105 <= A[i][0] <= 105
-105 <= A[i][1] <= 105

Input Format
The argument given is list A and an integer B.

Output Format
Return the B closest points to the origin (0, 0) in any order.

Example Input
Input 1:
 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1
Input 2:
 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1

Example Output
Output 1:
 [ [-2, 2] ]
Output 2:
 [ [1, -1] ]

Example Explanation
Explanation 1:
 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:
 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
 */


package com.example.demo.sclr_code.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class BClosestPointsToOrigin implements Comparator<int[]>{

	public static void main(String[] args) {
		int[][] position = {{2,2}, {5,4}, {2,3}, {6,6}, {7,7}};
		
		System.out.println(Arrays.toString( solve(position, 3) ));
		
	}
	
	public static int[][] solve(int[][] A, int B) {
        Arrays.sort(A, new BClosestPointsToOrigin());
        int[][] result = new int[B][2];
        for(int i=0; i<B; i++){
            result[i][0] = A[i][0];
            result[i][1] = A[i][1];
        }
        return result;
    }
	
	@Override
	public int compare(int[] a, int[] b) {
		if(Math.sqrt((a[0]*a[0]) + (a[1]*a[1])) < Math.sqrt((b[0]*b[0]) + (b[1]*b[1]))  ){
            return -1;
        }
        if(Math.sqrt((a[0]*a[0]) + (a[1]*a[1])) > Math.sqrt((b[0]*b[0]) + (b[1]*b[1]))  ){
            return 1;
        }
        return 0;
	}

}
