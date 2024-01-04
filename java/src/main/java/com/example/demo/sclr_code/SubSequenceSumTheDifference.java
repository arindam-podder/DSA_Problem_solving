/*
 * Q2. Sum the Difference

Problem Description
Given an integer array, A of size N.
You have to find all possible non-empty subsequences of the array of numbers and then,
for each subsequence, find the difference between the largest and smallest number in that subsequence.
Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

NOTE: Subsequence can be non-contiguous.

Problem Constraints
1 <= N <= 10000
1<= A[i] <=1000

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the output.

Example Input
Input 1:

A = [1, 2] 
Input 2:

A = [3, 5, 10]


Example Output
Output 1:
1 
Output 2:
21

Example Explanation
Explanation 1:

All possible non-empty subsets are:
[1]     largest-smallest = 1 - 1 = 0
[2]     largest-smallest = 2 - 2 = 0
[1, 2]  largest-smallest = 2 - 1 = 1
Sum of the differences = 0 + 0 + 1 = 1
So, the resultant number is 1 
Explanation 2:

All possible non-empty subsets are:
[3]         largest-smallest = 3 - 3 = 0
[5]         largest-smallest = 5 - 5 = 0
[10]        largest-smallest = 10 - 10 = 0
[3, 5]      largest-smallest = 5 - 3 = 2
[3, 10]     largest-smallest = 10 - 3 = 7
[5, 10]     largest-smallest = 10 - 5 = 5
[3, 5, 10]  largest-smallest = 10 - 3 = 7
Sum of the differences = 0 + 0 + 0 + 2 + 7 + 5 + 7 = 21
So, the resultant number is 21
 */


package com.example.demo.sclr_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubSequenceSumTheDifference {

	public static void main(String[] args) {
		
		//System.out.println( solve(new int[]{4,9,7}) );
	
		ArrayList<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(9);
		list.add(7);
		System.out.println( solve2(list) );
		
	}
	
	public static int solve(int[] A) {
        int mod = 1000000007;
        int n = A.length;
        Arrays.sort(A);
        double ans = 0;
        for(int i=0;i<A.length;i++){
        double pow1 = Math.pow(2, i)%mod;
        double pow2 = Math.pow(2, n - i - 1)%mod;
        ans = (ans + (A[i] * (pow1 - pow2 + mod) % mod)) % mod;
        }

        return (int) ans;
    }
	
	 public static int solve2(ArrayList<Integer> A) {		// tc : O(n * 2^n)
	        Collections.sort(A);
	        int modulo = 1000000007;
	        long sum = 0;
	        for(long i=0; i<(long)Math.pow(2,A.size()); i++){
	            ArrayList<Integer> list = new ArrayList();
	            for(int j=0; j<A.size(); j++){
	                if( ((1<<j) & i) != 0){
	                    list.add(A.get(j));
	                }
	            }
	            if(list.size()>1){
	                sum = sum + (list.get(list.size()-1) - list.get(0));
	            }

	        }
	        return (int)sum % modulo;
	    }

}


























