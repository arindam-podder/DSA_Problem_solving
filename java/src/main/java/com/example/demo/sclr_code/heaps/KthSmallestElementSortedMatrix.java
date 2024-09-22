/**
 * Q3. Kth Smallest Element in a Sorted Matrix (https://www.scaler.com/academy/mentee-dashboard/class/99826/homework/problems/4950)

Problem Description
Given a sorted matrix of integers A of size N x M and an integer B.

Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.

NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.

Problem Constraints
1 <= N, M <= 500
1 <= A[i] <= 109
1 <= B <= N * M


Input Format
The first argument given is the integer matrix A.
The second argument given is an integer B.

Output Format
Return the B-th smallest element in the matrix.

Example Input
Input 1:
 A = [ [9, 11, 15],
       [10, 15, 17] ] 
 B = 6
Input 2:
 A = [  [5, 9, 11],
        [9, 11, 13],
        [10, 12, 15],
        [13, 14, 16],
        [16, 20, 21] ]
 B = 12


Example Output
Output 1:
 17
Output 2:
 16


Example Explanation
Explanation 1:
 6th smallest element in the sorted matrix is 17.
Explanation 2:
 12th smallest element in the sorted matrix is 16.
 */


package com.example.demo.sclr_code.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(List.of(5, 9, 11));
		matrix.add(List.of(9, 11, 13));
		matrix.add(List.of(10, 12, 15));
		matrix.add(List.of(13, 14, 16));
		matrix.add(List.of(16, 20, 21));
		

		System.out.println( kthSmallest(matrix, 12) );
		
		
	}
	
	//use maxHeap of size b which will contains all min possible elements 
	public static int kthSmallest(List<List<Integer>> matrix, int k) {
		//create a max heap with k elements in it which all are min possible value 
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (o1, o2) -> o2-o1 );
		int r = matrix.size();
		int c = matrix.get(0).size();
		int i=0;
		int j=0;
		for(; i<r; i++) {
			for(; j<c; j++) {
				if(maxHeap.size()<k) {
					maxHeap.add(matrix.get(i).get(j));
				}else {
					break;
				}
			}
			if(maxHeap.size()==k) {
				break;
			}
			j=0;
		}
		
		for(; i<r; i++) {
			for(; j<c; j++) {
				if(matrix.get(i).get(j)<=maxHeap.peek()) {
					maxHeap.poll();
					maxHeap.add(matrix.get(i).get(j));
				}
			}
			j=0;
		}
		
		return maxHeap.peek();		
	}
}



















