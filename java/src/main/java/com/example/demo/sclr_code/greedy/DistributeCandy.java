/*
 * Q1. Distribute Candy
Problem Description
N children are standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum number of candies you must give?


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109

Input Format
The first and only argument is an integer array A representing the rating of children.

Output Format
Return an integer representing the minimum candies to be given.

Example Input
Input 1:
 A = [1, 2]
Input 2:
 A = [1, 5, 2, 1]


Example Output
Output 1:
 3
Output 2:
 7

Example Explanation
Explanation 1:
 The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor. 
 So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
Explanation 2:
 Candies given = [1, 3, 2, 1]
 */


package com.example.demo.sclr_code.greedy;

public class DistributeCandy {

	public static void main(String[] args) {
		int[] arr = {1, 5, 2, 1};
		
		System.out.println(minimumCandy(arr));
	}
	
	public static int minimumCandy(int[] A) {
		int ans = 0; 
		//create left to right candy distribute arr 
		int[] lArr = new int[A.length];
		lArr[0] = 1;
		for(int i=1; i<A.length; i++) {
			if(A[i] > A[i-1]) {
				lArr[i] = lArr[i-1]+1;
			}else {
				lArr[i] = 1;
			}
		}
		//create right to left candy distribute arr 
		int[] rArr = new int[A.length]; 
		rArr[A.length-1] = 1;
		for(int i=A.length-2; i>=0; i--) {
			if(A[i] > A[i+1]) {
				rArr[i] = rArr[i+1]+1;
			}else {
				rArr[i] = 1;
			}
		}
		
		//get from lArr& rArr for each index and add it to sum will give minimum candy that needs to be share 
		for(int i=0; i<lArr.length || i<rArr.length; i++) {
			ans = ans + Math.max(lArr[i], rArr[i]);
		}
		return ans;
	}

}
















