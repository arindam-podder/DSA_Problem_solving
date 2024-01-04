/*
 * Q3. Inversion count in an array
Problem Description
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

Problem Constraints
1 <= length of the array <= 105
1 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return the number of inversions of A modulo (109 + 7).

Example Input
Input 1:
A = [1, 3, 2]
Input 2:
A = [3, 4, 1, 2]

Example Output
Output 1:
1
Output 2:
4

Example Explanation
Explanation 1:
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]

Explanation 2:
The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]

 */

package com.example.demo.sclr_code.sorting;

public class InversionCountInAnArray {

	public static void main(String[] args) {
		
		System.out.println(mergeSortForInversion(new int[]{3,1,2}, 0, 2));
		
	}
	 
	public static int mergeSortForInversion(int A[], int start, int end){
		//int count = 0;
		int mod = 1000000007;
		if(start==end){
			return 0;
		}
		int mid = (start+end)/2;
		int left = mergeSortForInversion(A,start,mid);
		int right = mergeSortForInversion(A,mid+1,end);
		int mergeD = merge(A,start,mid,end);
		return (left+right+mergeD)%mod;
	}
	
	public static int merge( int A[], int start, int mid , int end) {
		int count = 0;
		int mod = 1000000007;
		int C[] = new int[end-start+1]; //creating new array
		int p1 = start;
		int p2 = mid+1;
		int p3 = 0;
		while(p1<=mid && p2<=end) {
			if(A[p1]<=A[p2]) {
				C[p3]=A[p1];
				p1++;
				p3++;
			}
			else if(A[p1]>A[p2]){
				C[p3]=A[p2];
				p2++;
				p3++;
				count = count + (mid-p1+1);
				count%=mod;
			}
			
		}
		while(p1<=mid) {
			C[p3]=A[p1];
			p1++;
			p3++; 
		}
		while(p2<=end){
			C[p3]=A[p2];
			p2++;
			p3++; 
		}
		int k=0;
		for(int i=start; i<=end; i++){
			A[i] = C[k];
			k++;
		}
		return count;
	}
	

}








