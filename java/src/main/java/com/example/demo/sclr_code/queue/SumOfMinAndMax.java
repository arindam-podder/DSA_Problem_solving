/*
 * Q2. Sum of min and max

Problem Description
Given an array A of both positive and negative integers.
Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.

Problem Constraints
1 <= size of array A <= 105
-109 <= A[i] <= 109
1 <= B <= size of array

Input Format
The first argument denotes the integer array A.
The second argument denotes the value B

Output Format
Return an integer that denotes the required value.

Example Input
Input 1:
 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:
 A = [2, -1, 3]
 B = 2

Example Output
Output 1:
 18
Output 2:
 3

Example Explanation
Explanation 1:
 Subarrays of size 4 are : 
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4      
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4   
    Sum of all min & max = 6 + 4 + 4 + 4 = 18 
Explanation 2:
 Subarrays of size 2 are : 
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3 
 */


package com.example.demo.sclr_code.queue;

import java.util.LinkedList;

public class SumOfMinAndMax {

	public static void main(String[] args) {
		int[] arr = {2, 5, -1, 7, -3, -1, -2};
		
		System.out.println(minMaxSumOfEachWindow(arr, 4));

	}
	
	
	public static int minMaxSumOfEachWindow(int[] arr, int windowSize) {
		int mod = 1000000007;
		long ans = 0;
		//find max and min in first window 
		LinkedList<Integer> minQ = new LinkedList<>(); 
		LinkedList<Integer> maxQ = new LinkedList<>(); 
		for(int i=0; i<windowSize; i++) {
			//for min
			while(!minQ.isEmpty() && minQ.getLast()>arr[i]) {
				minQ.pollLast();
			}
			minQ.offerLast(arr[i]); 
			
			//for max 
			while(!maxQ.isEmpty() && maxQ.getLast() < arr[i] ) {
				maxQ.pollLast();
			}
			maxQ.offerLast(arr[i]);
		}
		
		ans =  minQ.getFirst() + maxQ.getFirst() ;
		
		int start = 1; 
		int end = windowSize;
		while(start <= arr.length-windowSize ) {
			//for min 
			if(minQ.getFirst() == arr[start-1] ) {
				minQ.pollFirst();
			}
			while(!minQ.isEmpty() && minQ.getLast()>arr[end]) {
				minQ.pollLast();
			}
			minQ.offerLast(arr[end]);
			
			//for max 
			if(maxQ.getFirst() == arr[start-1]) {
				maxQ.pollFirst();
			}
			while(!maxQ.isEmpty() && maxQ.getLast()<arr[end] ) {
				maxQ.pollLast();
			}
			maxQ.offerLast(arr[end]);
			
			ans = (ans%mod + (minQ.getFirst() + maxQ.getFirst())%mod )%mod; 
			
			start++; 
			end++;
		}
		
		return (int)ans;
	}

}


















