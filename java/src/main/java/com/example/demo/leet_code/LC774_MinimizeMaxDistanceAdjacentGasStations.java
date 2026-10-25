/**
 * Minimize Max Distance of Adjacent Gas Stations (https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1)

We have a horizontal number line. On that number line, we have gas stations at positions stations[0], stations[1], ..., stations[n-1]. 
Now, we add k more gas stations so that d, the maximum distance between adjacent gas stations is minimized. Find the smallest possible value of d.
Find the answer exactly to 6 decimal places.
Note: stations sorted is in a strictly increasing order.

Examples:
Input: stations[] = [1, 2, 3, 4, 5], k = 2
Output: 1.00
Explanation: Since all gaps are already equal (1 unit each), adding extra stations in between does not reduce the maximum distance.

Input: stations[] = [3, 6, 12, 19, 33], k = 3
Output: 6.00 
Explanation: The largest gap is 14 (between 19 and 33). Adding 2 stations there splits it into approx 4.67. The next largest gap is 7 (between 12 and 19). Adding 1 station splits it into 3.5. Now the maximum gap left is 6.

Constraints:
2 ≤ stations.size() ≤ 105
0 ≤ stations[i] ≤ 106
0 ≤ k ≤ 105
 */


package com.example.demo.leet_code;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC774_MinimizeMaxDistanceAdjacentGasStations {

	public static void main(String[] args) {
//		int stations[] = {1, 2, 3, 4, 5}; int k = 2;		//Output: 1.00
		int stations[] = {3, 6, 12, 19, 33}; int k = 3;		

		System.out.println( minMaxDist1(stations, k) );
		
	}
	
	
    public static double minMaxDist1(int[] stations, int k) {
    	int n=stations.length;
    	PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
    	Set<Integer> set = new HashSet<>(); //to check duplicate should not add in pq
    	int max=Integer.MIN_VALUE;
    	for(int i=1; i<n; i++) {
    		int d= stations[i]-stations[i-1];
    		max = Math.max(max, d);
    		if(!set.contains(d)) {
    			pq.add(d); 
    			set.add(d);
    		}
    	}
    	
    	int l=1; int r=max; 
    	int res=max;
    	while(l<=r) {
    		int mid = (l+r)/2; 
    		if(isPossible(mid, pq, k)) {
    			res=mid; 
    			r=mid-1;
    		}else {
    			l=mid+1; 
    		}
    	}
    	
        return res; 
    }
    
    
    //here need to check min distance <=d possible or not
    public static boolean isPossible(int d, PriorityQueue<Integer> priority, int k) {
    	PriorityQueue<Integer> pq= new PriorityQueue<>(priority); 
    	while(!pq.isEmpty() && k>0) {
    		 int cur=pq.poll(); 
    		 if(cur<=d) {
    			 pq.add(cur);
    			 break; 
    		 }
    		 k=k-(cur/d); 
    		 if(cur%d == 0) k+= 1; 
    		 
    		 if(k<0) {
    			 pq.add(cur);
    			 break;
    		 }
    				 
    	}
    	
    	if(pq.isEmpty() || (!pq.isEmpty() && pq.poll()<=d)) {
    		return true;
    	}
    	
    	return false;
    	
    }
    

}
