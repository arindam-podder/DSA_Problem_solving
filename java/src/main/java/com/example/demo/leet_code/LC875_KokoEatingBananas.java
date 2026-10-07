/**
 * 875. Koko Eating Bananas

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.


Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:
1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 */



package com.example.demo.leet_code;

public class LC875_KokoEatingBananas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] piles = {3,6,7,11}; int h = 8;
		int[] piles = {30,11,23,4,20}; int h = 6;
		
		System.out.println( minEatingSpeed1(piles, h) );
		
	}
	
	
    public static int minEatingSpeed1(int[] arr, int h) {
    	int n=arr.length; 
    	int max=Integer.MIN_VALUE; 
    	int min=1;
    	for(int i=0; i<n; i++) {
    		if(arr[i]>max) max= arr[i];  
    	}
    	
    	int res=max;
    	while(min<=max) {
    		int mid=(min+max)/2; 
    		
    		if(canEatAll(mid, arr, h)) {
    			max=mid-1;
    			res=mid;
    		}else {
    			min=mid+1;
    		}
    	}
    	
    	return res;
    }
    
    public static boolean canEatAll(int k, int[] arr, int h) {
    	for(int i=0; i<arr.length; i++) {
    		h -= arr[i]/k; 
    		if(arr[i]%k != 0) h-=1;
    		
    		if(h<0) return false;
    	}
    	
    	return true; 
    }
	
}


