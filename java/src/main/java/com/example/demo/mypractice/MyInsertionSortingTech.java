package com.example.demo.mypractice;

public class MyInsertionSortingTech {

	public static void main(String[] args) {
		int[] insertionSortArray = insertionSortArray(new int[]{7, 8 ,5, 9, 4, 4, 4});
		for(int n : insertionSortArray) {
			System.out.print(n + " ");
		}
	}
	
	
	static int[] insertionSortArray(int[] arr) {
		int len = arr.length;
		int temp;
		for(int i=1; i<len; i++) {
			int initIndex = i;
			for(int j=i-1; j>=0; j--) {
				if(arr[initIndex] < arr[j]) {
					temp = arr[initIndex];
					arr[initIndex] = arr[j];
					arr[j] = temp;
				}else {
					break;
				}
				initIndex--;
			}
		}
		return arr;
	}
}
