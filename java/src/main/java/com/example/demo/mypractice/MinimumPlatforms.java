/**
 * Minimum Platforms
Difficulty: MediumAccuracy: 26.84%Submissions: 607K+Points: 4
Given arrival arr[] and departure dep[] times of trains on the same day, find the minimum number of platforms needed 
so that no train waits. A platform cannot serve two trains at the same time; if a train arrives before another 
departs, an extra platform is needed.

Note: Time intervals are in the 24-hour format (HHMM) , where the first two characters represent hour 
(between 00 to 23 ) and the last two characters represent minutes (this will be <= 59 and >= 0). Leading zeros for 
hours less than 10 are optional (e.g., 0900 is the same as 900).

Examples:
Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
Output: 3
Explanation: There are three trains during the time 9:40 to 12:00. So we need a minimum of 3 platforms.

Input: arr[] = [900, 1235, 1100], dep[] = [1000, 1240, 1200]
Output: 1
Explanation: All train times are mutually exclusive. So we need only one platform.

Input: arr[] = [1000, 935, 1100], dep[] = [1200, 1240, 1130]
Output: 3
Explanation: All 3 trains have to be there from 11:00 to 11:30

Constraints:
1 ≤ number of trains ≤ 50000
0000 ≤ arr[i] ≤ dep[i] ≤ 2359
 */

package com.example.demo.mypractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumPlatforms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {900, 940, 950, 1100, 1500, 1800}, dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		//int arr[] = {900, 1235, 1100}, dep[] = {1000, 1240, 1200};
		//int arr[] = {1000, 935, 1100}, dep[] = {1200, 1240, 1130};
		int arr[] = {1114, 825, 357, 1415, 54}, dep[] = {1740, 1110, 2238, 1535, 2323};
		
		System.out.println( minPlatform1(arr, dep) );
    	}
	
	public static int minPlatform1(int arr[], int dep[]) {
        List<int[]> trains = new ArrayList<>(); 
        for(int i=0; i<arr.length; i++) {
        	trains.add(new int[] {arr[i], dep[i]});
        }
        
        trains.sort(Comparator.comparingInt(a-> a[0]));
        
        int platform = 1; 
        for(int i=0; i<trains.size(); i++) {
        	int curPlat = 1; 
        	int departure = trains.get(i)[1];
        	//chcek any arrival of train before depature 
        	for(int j=i+1; j<trains.size(); j++) {
        		int arrival = trains.get(j)[0];
        		if(arrival<= departure) curPlat += 1;
        		else break;
        	}
        	
        	platform = Math.max(platform, curPlat);
        }
        return platform;
    }

}


