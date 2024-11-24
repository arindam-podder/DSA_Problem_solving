package com.example.demo;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals. For example, given 
 *  [[1, 3], [2, 6], [6, 10], [15, 18]], the output should be [[1, 6], [8, 10], [15, 18]].
 */


public class MergeInterval {
	
	public static void main(String[] args) {
		
		List<List<Integer>> intervals  = new ArrayList<>(); 
		List<Integer> list1 = new ArrayList<>(); 
		list1.add(1);
		list1.add(3);
		List<Integer> list2 = new ArrayList<>(); 
		list2.add(2);
		list2.add(6);
		List<Integer> list3 = new ArrayList<>(); 
		list3.add(6);
		list3.add(10);
		List<Integer> list4 = new ArrayList<>(); 
		list4.add(15);
		list4.add(18);
		intervals.add(list1);
		intervals.add(list2);
		intervals.add(list3);
		intervals.add(list4);
		
		
 		System.out.println( mergeIntervals(intervals) );
		
	}

	
	public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals){
		List<List<Integer>> result = new ArrayList<>(); 
		List<Integer> temp = new ArrayList<>();
		for(List<Integer> lst : intervals) {
			if(temp.isEmpty()) temp = lst; 
			else {
				if(temp.get(1) >= lst.get(0)) {
					temp.set(0, lst.get(0)<temp.get(0)? lst.get(0):temp.get(0));
					temp.set(1, lst.get(1));
				}
				else {
					result.add(new ArrayList<>(temp)); 
					temp = lst;
				}
				
			}
				
		}
		result.add(temp);
		return result;
	}
	
}
