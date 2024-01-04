package com.example.demo.sclr_code.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {3,4,0,1,2};
		quickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	
	}
	
	
	public static void quickSort(int[] arr, int start, int end) {
		if(start >= end) {
			return ;
		}
		int pivot = partitionPivot(arr, start, end);
		quickSort(arr, start, pivot-1);
		quickSort(arr, pivot+1, end);
	}
	
	public static int partitionPivot(int[] arr, int start, int end) {
		int pivot = arr[end];
		int index = 0; 
		for(int j=index; j<=end; j++) {				//traversing arr element start to end
			if(arr[j] < pivot) {
				swap(arr, index, j);
				index++;
			}
		}
		swap(arr, index, end);
		return index;
	}
	
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}






