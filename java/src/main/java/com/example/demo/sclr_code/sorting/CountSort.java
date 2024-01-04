package com.example.demo.sclr_code.sorting;

import java.util.Arrays;

public class CountSort {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 4, 5, 2, 3, -1,-1,-1};
		countSort(arr);
		
		System.out.println(Arrays.toString(arr));

	}
	
	
	public static void countSort(int[] arr) {
		int minimum = arr[0]; 
		for(int i=1; i<arr.length; i++) {
			if(arr[i]<minimum ) {
				minimum = arr[i];
			}
		}
		int maximum = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i]> maximum) {
				maximum = arr[i];
			}
		}
		
		int[] freequency = new int[maximum-minimum+1]; 
		for(int i=0; i<arr.length; i++) {					//arr[i]-min will give exact indexin freequeny for arr[i] value ,,, please observe and dry run
			freequency[arr[i]-minimum]++ ;
		}
		
		int[] sort = new int[arr.length];
		int sortIndex = 0; 
		for(int i=0; i<freequency.length; i++) {
			for(int j=0; j<freequency[i]; j++) {
				sort[sortIndex] = i + minimum; 
				sortIndex++;
			}
		}
		
		//copy now 
		for(int i=0; i<sort.length; i++) {
			arr[i] = sort[i];
		}
	}

}
