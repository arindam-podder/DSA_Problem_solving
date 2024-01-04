/*
 * sorting by swapping adjacent
 */


package com.example.demo.sclr_code.sorting;

import java.util.Arrays;

public class BubleSort {

	public static void main(String[] args) {
		int arr[] = {10, 9, 6, 7, 8, 12, 4, 13, 77, 44, 88, 99};
		bublrSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	
	public static void bublrSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
		
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}	
		

}
