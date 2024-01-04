/*Given an array of integers A and multiple values in B, which represents the number of times array A needs to be
left rotated. Find the rotated array for each value and return the result in the from of a matrix where ith row 
represents the rotated array for the ith value in B.



Problem Constraints
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000


Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.


Output Format
Return the resultant matrix.


Example Input
Input 1:
    A = [1, 2, 3, 4, 5]
    B = [2, 3]

Input 2: 
    A = [5, 17, 100, 11]
    B = [1]


Example Output
Output 1:
     [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]


Output 2:
    [ [17, 100, 11, 5] ]


Example Explanation
for input 1 -> B[0] = 2 which requires 2 times left rotations

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

*/


package com.example.demo.sclr_code;

public class RotateArray {

	public static void main(String[] args) {
		
		solve(new int[]{1,2,3,4,5}, new int[]{1});
		
	}

	
	 public static int[][] solve(int[] A, int[] B) {
	        int[] reverse = new int[A.length];
	        int p1 = 0;
	        int p2 = A.length-1;
	        for( ; p1<=p2; ){
	            reverse[p1] = A[p2];
	            reverse[p2] = A[p1];
	            p1++;
	            p2--;
	        }

	        int[][] result = new int[B.length][A.length];
	        int rotate = 0 ;
	        for(int i=0; i<B.length; i++){
	            rotate = B[i] % A.length;		//main rotate val

	            p1 = 0;     p2 = A.length-rotate-1;
	            for( ;  p1<=p2; ){
	                result[i][p1] = reverse[p2];
	                result[i][p2] = reverse[p1];
	                p1++;
	                p2--;
	            }

	            p1= A.length-rotate;    p2= A.length-1;
	            for( ; p1<=p2; ){
	                result[i][p1] = reverse[p2];
	                result[i][p2] = reverse[p1];
	                p1++;
	                p2--;
	            }
	        }
	        return result;
	    }
	
}
