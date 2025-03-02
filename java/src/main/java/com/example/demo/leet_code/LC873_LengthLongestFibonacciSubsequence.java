/**
 * 873. Length of Longest Fibonacci Subsequence

A sequence x1, x2, ..., xn is Fibonacci-like if:

n >= 3
xi + xi+1 == xi+2 for all i + 2 <= n
Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest 
Fibonacci-like subsequence of arr. If one does not exist, return 0.

A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, 
without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].

 

Example 1:
Input: arr = [1,2,3,4,5,6,7,8]
Output: 5
Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].

Example 2:
Input: arr = [1,3,7,11,12,14,18]
Output: 3
Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].

Constraints:
3 <= arr.length <= 1000
1 <= arr[i] < arr[i + 1] <= 109
 */



package com.example.demo.leet_code;

import java.util.HashSet;
import java.util.Set;

public class LC873_LengthLongestFibonacciSubsequence {

	public static void main(String[] args) {
		int[] arr = {1,3,7,11,12,14,18};
		
		System.out.println( lenLongestFibSubseq1(arr) );
		
	}
	
	
	//BF : for each index find all posible fibo 
    public static int lenLongestFibSubseq1(int[] arr) {
        Set<Integer> set = new HashSet();
        for(int n: arr) set.add(n); 
        int res = 0; 
        for(int i=0; i<arr.length-2; i++) {
        	int seqLen = getSeqLen(i, arr, set);
        	res = Math.max(res, seqLen);
        }
        return res;
    }
    
    
    public static int getSeqLen(int idx, int[] arr, Set<Integer> set) {
    	int res = 0; 
    	for(int i=idx+1; i<arr.length-1; i++) {
    		int a = arr[idx], b = arr[i];
    		int curSeq = 0; 
    		while(set.contains(a+b)) {
    			int sum = a + b;
    			a = b; 
    			b = sum;
    			curSeq += 1;
    		}
    		res = Math.max(res, curSeq);
    	}
    	return res!=0? res+2 : 0;
    }

}





















