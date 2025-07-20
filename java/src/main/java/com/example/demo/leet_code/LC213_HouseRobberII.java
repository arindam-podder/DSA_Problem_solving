/**
 * 213. House Robber II

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile,
adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses
were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
rob tonight without alerting the police.

Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:
Input: nums = [1,2,3]
Output: 3
 
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */


package com.example.demo.leet_code;

import java.util.Arrays;

public class LC213_HouseRobberII {

	public static void main(String[] args) {
		int[] arr = {1,2,4,1};
		
		System.out.println( rob1(arr) ); 
	}
	
	
    public static int rob1(int[] arr) {
    	//int[] pickler = new int[arr.length];
        //return recur(arr.length-1, arr, pickler);
    	
        //return Math.max( recur2(arr.length-1, arr, 1), recur2(arr.length-2, arr, 0));
        
//        int[] dp1 = new int[arr.length]; 
//        int[] dp2 = new int[arr.length]; 
//        Arrays.fill(dp1, -1);
//        Arrays.fill(dp2, -1);
//        return Math.max( memorize(arr.length-1, arr, 1, dp1) , memorize(arr.length-2, arr, 0, dp2));
    	
    	
    	return tabulation(arr, 1);
    	
    }
    
   
    //TLE 
    public static int recur(int i, int[] arr, int[] pickArr) {
    	//base case 
    	if(i<0) return 0;
    	if(i==0 && pickArr[arr.length-1]==1) return 0;
    	
    	//pick 
    	pickArr[i]=1;
    	int pick = arr[i] + recur(i-2, arr, pickArr);
    	
    	//unpick
    	pickArr[i]=0;
    	int unpick = 0 + recur(i-1, arr, pickArr);
    		
    	return Math.max(pick, unpick);
    }

    
    //simple recur, here end specify the circular problem to avoid 
    public static int recur2(int i, int[] arr, int end) {
    	//base 
    	if(i< end) return 0; 
    	
    	int pick = arr[i] + recur2(i-2, arr, end);
    	int unPick = 0 + recur2(i-1, arr, end);
    	return Math.max(pick, unPick);
    }
    
    
    public static int memorize(int i, int[] arr, int end, int[] dp) {
    	if(i<end) return 0; 
    	
    	 if(dp[i] != -1) return dp[i]; 
    	 
    	 int pick = arr[i] + memorize(i-2, arr, end, dp); 
    	 int unPick = 0 + memorize(i-1, arr, end, dp);
    	 dp[i] = Math.max(pick, unPick); 
    	 return dp[i]; 
    }
    
    
    public static int tabulation(int[] arr, int start) {
    	int end = start == 0 ? arr.length-2:arr.length-1;
    	int max = arr[start];
    	int[] dp = new int[arr.length];
    	dp[0] = arr[0]; 
    	dp[1] = arr[1];
    	for(int i=start+1; i<=end; i++) {
    		if(i == 1) max = Math.max(max, arr[i]);
    		else {
    			dp[i] = Math.max( arr[i]+dp[i-2] , dp[i-1]);
    			max = Math.max(max, dp[i]);
    		}
    	}
    	return max;
    }
    
    
    
    
    
    
}



































