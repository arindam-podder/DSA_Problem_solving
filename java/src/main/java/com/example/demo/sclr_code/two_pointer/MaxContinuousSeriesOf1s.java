/*
 * Q2. Max Continuous Series of 1s

Problem Description
Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.
For this problem, return the indices of maximum continuous series of 1s in order.
If there are multiple possible solutions, return the sequence which has the minimum start index.

Problem Constraints
0 <= B <= 105
1 <= size(A) <= 105
0 <= A[i] <= 1

Input Format
First argument is an binary array A.
Second argument is an integer B.

Output Format
Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.

Example Input
Input 1:
 A = [1, 1, 0, 1, 1, 0, 0, 1, 1, 1]
 B = 1
Input 2:
 A = [1, 0, 0, 0, 1, 0, 1]
 B = 2

Example Output
Output 1:
 [0, 1, 2, 3, 4]
Output 2:
 [3, 4, 5, 6]

Example Explanation
Explanation 1:
 Flipping 0 present at index 2 gives us the longest continous series of 1's i.e subarray [0:4].
Explanation 2:
 Flipping 0 present at index 3 and index 5 gives us the longest continous series of 1's i.e subarray [3:6].
 */


package com.example.demo.sclr_code.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousSeriesOf1s {

	public static void main(String[] args) {
		int[] arr = {0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1}; 
		int B = 0;

		int[] ans = maxone(arr, B);
		
		System.out.println(Arrays.toString(ans));
	}
	
	 public static int[] maxone(int[] A, int B) {		//giving issue
		 int L = 0; 
		 int R = 0; 
		 int left=0; 
		 int right=0;
		 int max=B; 
		 int count= A[0]==0 ? 1:0 ;
		 while(L<=R && R<A.length) {
			 if(count<=B) {
				 if(max <= R-L+1) {
					 max = R-L+1; 
					 left = L; 
					 right = R;
				 }
				 R++; 
				 if(R<=A.length-1 && A[R]==0) {
					 count++;
				 }
			 }
			 else {
				 if(A[L]==1) {
					 L++;
				 }else {
					 count--; 
					 L++;
				 }
			 }
			 
			 if(L>R) {
				 R=L;
				 count = A[R]==0 ? 1:0;
			 }
		 }
		 int[] result = new int[right-left+1];
		 for(int i=left; i<=right; i++) {
			 result[i-left] = i;
		 }
		 return result;
	 }
	 
	 
	 
	 public static ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {			// all cases pass 
		    ArrayList<Integer> zeroPos = new ArrayList<>();
		    ArrayList<Integer> res = new ArrayList<>();
		    if (A == null)
		        return res;
		    int n = A.size();
		    // store the index of all the 0's
		    for (int i = 0; i < n ; i++) {
		        int num = A.get(i);
		        if (num == 0)
		            zeroPos.add(i);
		    }
		    if (B >= zeroPos.size()) {
		        for (int i = 0; i < n; i++)
		            res.add(i);
		        return res;
		    }
		    int i = 0;
		    int j = B;
		    int maxSize = 0;
		    int start, end;
		    start = 0;
		   // find the longest segment by removing B 0's
		    while (j <= zeroPos.size()) {
		        if (j == zeroPos.size())
	    	        end = n - 1;
	    	    else
	    	        end = zeroPos.get(j) - 1;
		        
		        int size = end - start + 1;
		        
		        if (size > maxSize) {
		            maxSize = size;
		            res.clear();
		            res.add(start);
		            res.add(end);
		        }
		        
		        if (j == zeroPos.size())
		            break;
		        
		        start = zeroPos.get(i) + 1;
		        i++;
		        j++;
		    }
		    start = res.get(0);
		    end = res.get(1);
		    res.clear();
		    for (i = start; i <= end; i++)
		        res.add(i);
		    return res;
		}

}











