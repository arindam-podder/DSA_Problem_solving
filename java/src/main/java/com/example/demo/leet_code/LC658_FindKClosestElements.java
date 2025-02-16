/**
 * 658. Find K Closest Elements  (Medium)

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. 
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:
1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
 */



package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC658_FindKClosestElements {

	public static void main(String[] args) {
		int[] arr = {1,1,1,10,10,10};
		int k = 1; 
		int x= 9;
		
		System.out.println(findClosest(arr, k, x));
		
		System.out.println( findClosestUseWindow(arr, k, x) );
	}

	//using heap 
	public static List<Integer> findClosest(int[] arr, int k, int x) {
        //max heap 
		PriorityQueue<PairDiffElement> heap = new PriorityQueue<>(new PairDiffElement(0, 0));
		for(int i=0; i<arr.length; i++) {
			heap.add(new PairDiffElement(Math.abs(arr[i]-x), arr[i]));
			if(heap.size()>k) {
				heap.poll();
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		while(!heap.isEmpty()) {
			ans.add(heap.poll().ele);
		}
		Collections.sort(ans);
		
		return ans;
    }
	
	
	public static List<Integer> findClosestUseWindow(int[] arr, int k, int x){
		//build the window 
		List<int[]> window = new ArrayList<>();			//{diff, ele}
		for(int i=0; i<k; i++) {
			window.add(new int[] { Math.abs(x-arr[i]), arr[i]});
		}
		
		int i=k;
		while(i<arr.length) {
			int curDif = Math.abs(x-arr[i]);
			if(curDif<window.get(0)[0]) {
				window.add(new int[] {curDif, arr[i]});
				window.remove(0);
			}
			i++;
		}
		
		List<Integer> result = new ArrayList<>();
		for(int[] a: window) result.add(a[1]);
		return result;
	}
	
	
	
}


class PairDiffElement implements Comparator<PairDiffElement>{
	int diff;
	int ele;
	public PairDiffElement(int d, int e) {
		// TODO Auto-generated constructor stub
		this.diff = d;
		this.ele = e;
	}
	
	@Override   
	public int compare(PairDiffElement o1, PairDiffElement o2) {
		//ned desc
		if(o1.diff < o2.diff) return 1; 
		else if(o1.diff > o2.diff) return -1;
		else {
			if(o1.ele < o2.ele) return 1; 
			else if(o1.ele > o2.ele) return -1;
			else return 0;
		}
	}
	
}
















