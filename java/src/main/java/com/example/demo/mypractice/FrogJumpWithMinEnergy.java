/**
 * frog present in the 0th index , he hass to reach to nth stair with minimum energy. 
 * he can jump ith position to j=(i+1 or i+2). energy required abs(arr[i] - arr[j]).
 * find the min energy required toi reach to nth stair.  
 */


package com.example.demo.mypractice;

import java.util.Arrays;

public class FrogJumpWithMinEnergy {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 5, 33};
		
		System.out.println( energyRecur(arr.length-1, arr) );
		
		int[] dp = new int[arr.length]; 
		Arrays.fill(dp, -1);
 		System.out.println( energyRecurDP(arr.length-1, arr, dp) );
 		
 		
 		System.out.println(tabulationDp(arr));
 	}
	
	public static int energyRecur(int i, int[] arr) {
		//base case 
		if(i<=0) return 0;
		
		//int min = Integer.MAX_VALUE; 
		//one step 
		int oneStep = Math.abs(arr[i] - arr[i-1]) + energyRecur(i-1, arr);
		//two step
		int twoStep = Integer.MAX_VALUE;
		if(i>2) {
			twoStep = Math.abs(arr[i]-arr[i-2]) + energyRecur(i-2, arr);
		}
		
		return Math.min(oneStep, twoStep);
	}
	
	public static int energyRecurDP(int i, int arr[], int[] dp) {
		//base case 
		if(i<=0){
			return 0;
		}
		if(dp[i] != -1) return dp[i]; 
		
		//one step 
		int oneStep = Math.abs(arr[i] - arr[i-1]) + energyRecurDP(i-1, arr, dp);
		//two step
		int twoStep = Integer.MAX_VALUE;
		if(i>2) {
			twoStep = Math.abs(arr[i]-arr[i-2]) + energyRecurDP(i-2, arr, dp);
		}
		dp[i] = Math.min(oneStep, twoStep); 
		return dp[i]; 		
	}
	
	public static int tabulationDp(int[] arr) {
		int[] dp = new int[arr.length]; 
		
		dp[0] = 0; 
		for(int i=1; i<arr.length; i++) {
			//one step
			int oneStep = Math.abs(arr[i] - arr[i-1]) + dp[i-1]; 
			//two step
			int twoStep = Integer.MAX_VALUE;
			if(i>2) {
				twoStep = Math.abs(arr[i]-arr[i-2]) + dp[i-2];
			}
			dp[i] = Math.min(oneStep, twoStep);
		}
		
		return dp[arr.length-1]; 
	}

}












