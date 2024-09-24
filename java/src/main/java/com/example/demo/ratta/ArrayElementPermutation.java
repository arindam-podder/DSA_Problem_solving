/**
 * given array = [1, 2, 3]. return all the permutation. 
 * Ans: 
 * [1 2 3]
 * [1 3 2]
 * [2 1 3]
 * [2 3 1]
 * [3 1 2]
 * [3 2 1]
 * 
 * 
 * permutation count = arr.length!   [3! = 6]
 * 
 */



package com.example.demo.ratta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayElementPermutation {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		List<List<Integer>> permutationList = allPermutation(arr);
		System.out.println(permutationList);

	}
	
	public static List<List<Integer>> allPermutation(int[] arr){
		//it will set up the things and call the helper recursion func
		List<List<Integer>> result = new ArrayList<>(); 
		helperOfAllPermutation(0, arr, result);
 		return result;
	}
	
	//recursion to get all permutation
	public static void helperOfAllPermutation(int index, int[] arr, List<List<Integer>> result) {
		//base case 
		if(index == arr.length) {
			result.add(arrToList(arr));
			return; 
		}
		
		for(int i=index; i<arr.length; i++) {
			swap(arr, index, i);
			helperOfAllPermutation(index+1, arr, result);
			swap(arr, index, i);	//back track
			
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp;
	}
	
	public static List<Integer> arrToList(int[] arr){
		List<Integer> list = new ArrayList<>(); 
		for(int n : arr) {
			list.add(n);
		}
		return list;
	}

}



