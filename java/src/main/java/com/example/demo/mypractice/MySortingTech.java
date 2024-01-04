package com.example.demo.mypractice;


public class MySortingTech {

	
	public static int[] arr = {77, 3, 88, 16 , 33, 7, 4, 88};

	public static void main(String[] arg) {
		
		//int[] sortedArr = new int[arr.length];
		int temp = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("sorted array ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
}
