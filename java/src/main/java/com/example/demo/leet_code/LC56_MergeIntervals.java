/**
 * 56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */




package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56_MergeIntervals implements Comparator<int[]>{
	public static void main(String[] args) {
		int[][] arr = { {3, 5}, {6, 8}, {1, 3} };
		mergeInterval(arr);
		
	}
	
	public static int[][] mergeInterval(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        sort(intervals);
        
        for(int i=0; i<intervals.length; i++) {
        	int a = intervals[i][0]; 
        	int b = intervals[i][1]; 
        	if(list.isEmpty() || list.get(list.size()-1)[1]<a ) {	//in case interval is not overlapping 
        		list.add(intervals[i]);
        	}else {
        		//interval merging is possible 
        		list.get(list.size()-1)[1] = Math.max( list.get(list.size()-1)[1] , b);
        	}
        }
        
        int[][] result = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
        	result[i] = list.get(i);
        }
        return result;
    }
	
	public static void sort(int[][] interval) {
		Arrays.sort(interval, new LC56_MergeIntervals());
	}
	
	
	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub
		if(o1[0] != o2[0]) {
			return o1[0] - o2[0];
		}else {
			return o1[1] - o2[1];
		}
	}
}








