/*
 * Q3. Flip Array (Day 86 - Advanced DSA : DP 3: Knapsack -- Wed, 11 Oct 2023)
Problem Description
Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the 
elements of array should be minimum non-negative(as close to zero as possible).
Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.

Problem Constraints
1 <= length of(A) <= 100
Sum of all the elements will not exceed 10,000.

Input Format
First and only argument is an integer array A.

Output Format
Return an integer denoting the minimum number of elements whose sign needs to be flipped.

Example Input
Input 1:
 A = [15, 10, 6]
Input 2:
 A = [14, 10, 4]

Example Output
Output 1:
 1
Output 2:
 1

Example Explanation
Explanation 1:
 Here, we will flip the sign of 15 and the resultant sum will be 1.
Explanation 2:
 Here, we will flip the sign of 14 and the resultant sum will be 0.
 Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.
 */

package com.example.demo.sclr_code.dynamic_programing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>(); 
		list.add(15);
		list.add(10);
		list.add(6);
		
		FlipArray obj =  new FlipArray(); 
		System.out.println( obj.solve(list) ); 
		

	}

//	public int flipArr(final List<Integer> A) {
//		int N = A.size(); 
//		int sum = 0 ; 
//		//iterate all element of A and find sum 
//		for(int i=0; i<N; i++) {
//			sum +=A.get(i);
//		}
//		sum = sum/2; 
//		
//		int[][] cache1 = new int[N][sum+1];
//		for(int[] arr: cache1) Arrays.fill(arr, -1);
//		int maxSum = findMax(A, N-1, cache1, sum); 
//		
//		int[][] cache2 = new int[N+1][maxSum+1];
//		for(int[] arr: cache1) Arrays.fill(arr, -1);
//		return findMinCount(A, N-1, cache2, maxSum);
//	}
//	
//	//this function will give us the maximun sum that can be achieved for given capacity
//	public int findMax(List<Integer> A, int index, int[][] dp, int capacity) {
//		if(capacity == 0) return 0; 
//		if(index < 0) return 0; 
//		if(dp[index][capacity] != -1) return dp[index][capacity]; 
//		
//		int val = A.get(index); 
//		int notTake = findMax(A, index-1, dp, capacity); 
//		int take = 0; 
//		if(capacity>= val) {
//			take  = 1 + findMax(A, index-1, dp, (capacity-val));
//		}
//		dp[index][capacity] = Math.max(notTake, take);
//		return dp[index][capacity];
//	}
//	
//	public int findMinCount(List<Integer> A, int index, int[][] dp, int capacity) {
//		if(capacity == 0) return 0; 
//		if(index < 0) return 101; 
//		if(dp[index][capacity] != -1) return dp[index][capacity]; 
//		
//		int val = A.get(index); 
//		int notTake = findMinCount(A, index-1, dp, capacity); 
////		int take = Integer.MAX_VALUE; 
////		if(capacity>= val) {
////			take  = 1 + findMinCount(A, index-1, dp, (capacity-val));
////		}
////		dp[index][capacity] = Math.min(notTake, take);
//		if(capacity >= val){
//			dp[index][capacity] = Math.min(notTake , 1 + findMinCount(A , index-1 , dp , capacity-val));
//		}else{
//			dp[index][capacity] = notTake;
//		}
//		return dp[index][capacity];
//	}
	
	public int solve(final List<Integer> A) {

        int N = A.size();
        int sum = 0;

        for(int i=0; i<N; i++){
            sum += A.get(i);
        }
        sum = sum/2;

        int[][] cache1 = new int[N+1][sum+1];

        for(int[] arr: cache1) Arrays.fill(arr,-1);

        int maxSum = FindMaxSum(A , N-1 , cache1 , sum);

        int[][] cache2 = new int[N+1][maxSum+1];

        for(int[] arr: cache2) Arrays.fill(arr , -1);

        return findMinCount(A , N-1 , cache2 , maxSum);
    }

    //this function will give us the maximun sum that can be achieved for given capacity.
    public int FindMaxSum(List<Integer> A, int index , int[][] dp , int capacity){

        if(capacity == 0){
            return 0;
        }

        if(index < 0){
            return 0;
        }

        if(dp[index][capacity] != -1){
            return dp[index][capacity];
        }

        int val = A.get(index);

        int notTake = FindMaxSum(A , index-1 , dp , capacity);

        if(capacity >= val){
            dp[index][capacity] = Math.max(notTake , val + FindMaxSum(A , index-1 , dp , (capacity-val)));
        }else{
            dp[index][capacity] = notTake;
        }

        return dp[index][capacity];
    }

    //this function will give us the minimum number of elements required to achieve the given cpacity(which we are getting from above function \)
    public int findMinCount(List<Integer> A , int index , int[][] dp , int capacity){

        if(capacity == 0){
            return 0;
        }

        if(index < 0){
            return 101;
        }

        if(dp[index][capacity] != -1){
            return dp[index][capacity];
        }

        int val = A.get(index);

        int notTake = findMinCount(A , index-1 , dp , capacity);

        if(capacity >= val){
            dp[index][capacity] = Math.min(notTake , 1 + findMinCount(A , index-1 , dp , capacity-val));
        }else{
            dp[index][capacity] = notTake;
        }

        return dp[index][capacity];
    }
}











