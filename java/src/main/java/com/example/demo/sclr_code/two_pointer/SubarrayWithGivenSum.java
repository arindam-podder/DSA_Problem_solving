package com.example.demo.sclr_code.two_pointer;

import java.util.Arrays;

public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 3 , 6, 8};
		
		int[] result = subarraySum(arr, 19);
		
		System.out.println(Arrays.toString(result));

	}
	
	
	public static int[] subarraySum(int[] arr, int B) {
		int L = 0; int R = 0; 
		long sum = arr[0]; 
		for(; R<arr.length; ) {
			if(sum == B) {
				int[] result = new int[R-L+1];
				for(int i=L, index=0; i<=R; i++, index++) {
					result[index] = arr[i];
				}
				return result;
			}
			if(sum < B) {
				if(R == arr.length-1) {
					return new int[] {-1};
				}
				R++;
				sum += arr[R];
			}else {
				sum -= arr[L]; 
				L++;
			}
		}
		return new int[] {-1};
	}

}
