/**
 * 48. Rotate Image

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

 */


package com.example.demo.leet_code;

public class LC48_RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		
		solution(arr);
	}
	
	
	//BF --- observation arr[i][j] ->  arr[j][n-1-i]
	public static void rotate90(int[][] arr) {
		int n= arr.length;
		int[][] ans = new int[n][arr[0].length];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				ans[j][n-1-i] = arr[i][j];
			}
		}
		
		
		
		//copy ans to arr 
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j] = ans[i][j];
			}
		}
		
	}
	
	//in place solution - 1) transpose arr[i][j] -> arr[j][i]  then reverse each row , will get 90deg matrix
	public static void solution(int[][] arr) {
		//1-transpose
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr[0].length; j++) {
				matrixSwap(arr, i, j);
			}
		}
		
		//2-reverse each row
		for(int i=0; i<arr.length; i++) {
			rev(arr[i]);
		}
		
	}
	
	public static void matrixSwap(int[][] arr, int i, int j) {
		int temp = arr[i][j]; 
		arr[i][j] = arr[j][i]; 
		arr[j][i] = temp;
	}
	
	public static void rev(int[] arr) {
		int p1=0; 
		int p2=arr.length-1;
		while(p1<p2) {
			int temp = arr[p1]; 
			arr[p1] = arr[p2]; 
			arr[p2] = temp;
			
			p1++; 
			p2--;
		}
	}
	

}












