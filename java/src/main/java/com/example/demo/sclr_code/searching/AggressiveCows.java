/*
 * Q2. Aggressive cows

Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?


Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the largest minimum distance possible among the cows.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 3
Input 2:
A = [1, 2]
B = 2

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
Explanation 2:
 The minimum distance will be 1.
 */


package com.example.demo.sclr_code.searching;

import java.util.Arrays;

public class AggressiveCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int ans = -1;
        int L = 1; 
        int R = A[A.length-1]-A[0]; 
        while(L<=R){
            int mid = L + (R-L)/2; 
            if(check_cows(A, mid, B)){
                ans = mid; 
                L = mid+1; 
            }else{
                R = mid-1;
            }
        }
        return ans;
    }

    public static boolean check_cows(int[] A, int dist, int cows){
        int cow_count = 1; int position = A[0]; 
        for(int i=1; i<A.length; i++){
            if(A[i]-position >= dist){
                cow_count++; 
                position = A[i]; 
                if(cow_count == cows){
                    return true;
                }
            }
        }
        return false;
    }

}













