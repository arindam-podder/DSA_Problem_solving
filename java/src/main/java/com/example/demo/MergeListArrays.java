/**
 * given list of sorted array and merge them into one 
 */

package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeListArrays {

	public static void main(String[] args) {
		int[] arr1 = {2, 6, 99};
		int[] arr2 = {25, 77, 80};
		int[] arr3 = {100};
		List<int[]> data = new ArrayList<>();
		data.add(arr1);
		data.add(arr2);
		data.add(arr3);
		
		List<Integer> list = Merger.mergeList(data);
		System.out.println(list);
	
	}
}


class Merger implements Comparator<ListData>{
	public static List<Integer> mergeList(List<int[]> data){
		PriorityQueue<ListData> minHeap = new PriorityQueue<>(new Merger());
		for(int[] arr : data){
			if(arr.length >0)
				minHeap.add(new ListData(arr, 0));
		}

		List<Integer> result = new ArrayList<>();
		while(!minHeap.isEmpty()){
			ListData listData = minHeap.poll();
			result.add(listData.arr[listData.index]); 

			if(listData.index +1 < listData.arr.length){
				minHeap.add(new ListData(listData.arr, listData.index+1));
			}
		}
		return result; 

	}//mergeList end
	
	@Override
	public int compare(ListData o1, ListData o2){
		return o1.arr[o1.index] - o2.arr[o2.index];
	}
}

class ListData{
	int[] arr; 
	int index; 
	public ListData(int[] arr, int index){
		this.arr = arr; 
		this.index = index; 
	}
	 
}
