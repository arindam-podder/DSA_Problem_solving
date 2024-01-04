package com.example.demo.mypractice;

import java.util.Arrays;

public class ArrayRotation {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};

		System.out.println(Arrays.toString(rotate(arr, 1)));
	}
	
	
	public static int[] rotate(int[] arr, int b) {
		int rotate = b%arr.length;
		if(rotate==0) {
			return arr; 
		}
		
		//reverse array 
		int p1 = 0 ; 
		int p2 = arr.length-1; 
		while(p1<p2) {
			int temp = arr[p1]; 
			arr[p1] = arr[p2]; 
			arr[p2] = temp; 
			
			p1++; 
			p2--;
 		}

		//left side rotate rotate 
		p1 = 0; 
		p2 = arr.length-rotate-1;
		while(p1<p2) {
			int temp = arr[p1]; 
			arr[p1] = arr[p2]; 
			arr[p2] = temp; 
			
			p1++; 
			p2--;
 		}
		
		//right side rotate
		p1 = arr.length-rotate; 
		p2 = arr.length-1;
		while(p1<p2) {
			int temp = arr[p1]; 
			arr[p1] = arr[p2]; 
			arr[p2] = temp; 
			
			p1++; 
			p2--;
 		}
		
		return arr;
	}

}
