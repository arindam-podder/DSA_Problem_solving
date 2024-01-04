package com.example.demo.sclr_code;

import java.util.Arrays;

public class Keep012Properly {

	public static void main(String[] args) {
		int[] arr = {0,2,1,1, 1,2, 2, 1, 0}; 
		arrange(arr);
		System.out.println(Arrays.toString(arr));
		
	}

	public static void arrange(int[] arr) {
		boolean zeroDone = false;
		boolean oneDone = false;
		for(int i=0; i<arr.length; i++) {
			//for zero
			if(zeroDone == false) {
				if(arr[i] != 0) {
					int cur = i+1;
					while(cur<arr.length && arr[cur]!=0) {
						cur = cur +1;
					}
					if(cur>= arr.length) {
						zeroDone = true; 
					}else {
						int temp = arr[i];
						arr[i] = arr[cur];
						arr[cur] = temp;
					}
				}
			}
			//for 1
			else if(oneDone == false) {
				if(arr[i] != 1) {
					int cur = i+1;
					while(cur<arr.length && arr[cur]!=1) {
						cur = cur +1;
					}
					if(cur>= arr.length) {
						oneDone = true; 
					}else {
						int temp = arr[i];
						arr[i] = arr[cur];
						arr[cur] = temp;
					}
				}
			}
			
		}
	}
}
