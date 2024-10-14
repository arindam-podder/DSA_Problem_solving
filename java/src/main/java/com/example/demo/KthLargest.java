package com.example.demo;

import java.util.PriorityQueue;

public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			// 88 66 99 44 
		int[] arr = {1, 43, 2, 33, 33, 12, 11, 10};
		int k = 4;
		
		System.out.println( kthLargets(arr, k) );
		
															
	}

	//use min heap oh k size with all max element 
	public static int kthLargets(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
		
		for(int i=0; i<k; i++)
		{
			minHeap.add(arr[i]);
		}
		
		for(int i=k; i<arr.length; i++) {
			if(minHeap.peek() < arr[i]) {
				minHeap.poll();
				minHeap.add(arr[i]);
			}
		}
		return minHeap.peek();
								
	}
	
	
}
