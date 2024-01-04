package com.example.demo.sclr_code.sorting;

import java.util.Arrays;

public class MergeSort {

	public static int total = 0;
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,65};
		mergeSort1(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println(total);

	}
	
	public static void mergeSort1(int[] arr, int start, int end) {
		if(start>=end) {
			return ;
		}
		int mid = (start+end)/2;
		mergeSort1(arr, start, mid);
		mergeSort1(arr, mid+1, end);
		merge1(arr, start, mid, end);
	}
	
	public static void merge1(int[] arr, int start, int mid, int end) {
		int[] merged = new int[end-start+1];
		int p1 = start;
		int p2 = mid+1; 
		int index = 0;
		for( ; p1<=mid && p2<=end; ) {
			if(arr[p1]<arr[p2]){
				merged[index] = arr[p1];
				p1++;
			}else {
				merged[index] = arr[p2];
				p2++;
				total += (mid-p1+1);
			}
			index++;
		}
		for( ; p1<=mid; ) {
			merged[index] = arr[p1];
			p1++;
			index++;
		}
		for( ; p2<=end; ) {
			merged[index] = arr[p2];
			p2++;
			index++;
		}
		//now merged is sorted , just put this into arr
		for(int i=start; i<=end; i++) {
			arr[i] = merged[i-start];
		}
	}

}
