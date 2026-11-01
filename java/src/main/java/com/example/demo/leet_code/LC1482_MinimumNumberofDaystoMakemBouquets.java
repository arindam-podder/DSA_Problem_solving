/**
 * 1482. Minimum Number of Days to Make m Bouquets

You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.


Example 1:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
Example 2:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
Example 3:

Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways.
 

Constraints:
bloomDay.length == n
1 <= n <= 105
1 <= bloomDay[i] <= 109
1 <= m <= 106
1 <= k <= n
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LC1482_MinimumNumberofDaystoMakemBouquets {
	public static void main(String[] args) {
//		int[] bloomDay = {1,10,3,10,2}; int m = 3; int k = 1;   //ans-3
		int[] bloomDay = {1,10,3,10,2}; int m = 3; int k = 2;   //ans-3
		
		System.out.println( minDays1(bloomDay, m, k) );
		
	}
	
	
    public static int minDays1(int[] bloomDay, int m, int k) {
    	int n=bloomDay.length;
    	List<Integer> list = new ArrayList<>(); 
    	Set<Integer> set = new HashSet<>(); 
    	for(int i=0; i<n; i++) {
    		if(!set.contains(bloomDay[i])) {
    			list.add(bloomDay[i]); 
    			set.contains(bloomDay[i]); 
    		}
    	}
    	
    	list.sort((a,b) -> a-b);
    	int l=0; int r=list.size()-1; 		//l,r idx of list, actual value lies in list[l,r]
    	int res=-1; 
    	while(l<=r) {
    		int mid=(l+r)/2;
    		int day = list.get(mid); 
    		if(isPossible(day, bloomDay, m, k)) {
    			res=day; 
    			r=mid-1; 
    		}else {
    			l=mid+1;
    		}
    	}
    	
    	return res; 
    }
    
    
    public static boolean isPossible(int day, int[] bloomDay, int m, int k) {
    	int n = bloomDay.length;
    	int[] arr = new int[n]; 
    	//for the given day , get the all possible bloom, other will be -1 
    	for(int i=0; i<n; i++) {
    		if(bloomDay[i] <= day) arr[i] = 1; 
    		else arr[i] = -1;
    	}
    	
    	//get m bouquets posiible with k flowers in each  
    	for(int i=0; i<n; i++) {
    		if(arr[i] != -1) { 		//can be used in making k flowers bouquet
    			int j=i; 
    			if(j+k-1 >= n) break; 
    			if(adjacentFlowersPresent(arr, j, j+k-1)) {
    				m = m-1;
    			}
    		}
    		
    	}
    	
    	if(m<=0) return true; 
    	
    	return false;
    }
    
    public static boolean adjacentFlowersPresent(int[] arr, int s, int e) {
    	for(int i=s; i<=e; i++) {
    		if(arr[i] == -1) return false;
    	}
    	
    	Arrays.fill(arr, s, e+1, -1);
    	return true; 
    }
    
}
