/*
 * selection sort with minimum swap 
 */

package com.example.demo.sclr_code.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int arr[] = {10, 9, 6, 7, 8, 12, 4, 13, 77, 44, 88, 99, 23, 54, 33, 53};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	
	public static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int min = arr[i], minIndex = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]< min) {
					min = arr[j];
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	
	
}//class end
