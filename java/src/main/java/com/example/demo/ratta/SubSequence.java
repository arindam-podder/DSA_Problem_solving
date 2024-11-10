/**
 *  arr = [1, 2, 3]  
 *  ans = [ [], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]  ]
 */


package com.example.demo.ratta;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3}; 
		List<List<Integer>> result = new ArrayList<>(); 
		List<Integer> path = new ArrayList<>(); 
		subSequenceUsingRecursion(0, arr, path, result);
		
		System.out.println( result );
	}
	
	
	public static void subSequenceUsingRecursion(int index, int[] arr, List<Integer> path, List<List<Integer>> result) {
		//base 
		if(index == arr.length) {
			result.add(new ArrayList<>(path));
			return;
		}
		
		//dont pick
		subSequenceUsingRecursion(index+1, arr, path, result);
		
		//pick 
		path.add(arr[index]); 
		subSequenceUsingRecursion(index+1, arr, path, result);
		 
		//backtrack 
		path.remove(path.size()-1);
		
	}

	
	public static void usingBitApproach(int[] arr) {
		
	}
	
}//class end










