package com.example.demo;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class InfoSortBasedOnWeight {

	public static void main(String[] args) {
		String[] items = {"Laptop", "TV", "Phone", "Watch"};
	    int[]  weights = {500, 1000, 250, 50};
	    
	    System.out.println( Arrays.toString(getSort(weights, items)) );
	}
	
	
	public static String[] getSort(int[] weights, String[] items) {
   
	   Map<Integer, Integer> map = new  TreeMap<>();
	   for(int i=0; i<weights.length; i++){
	       map.put(weights[i], i); 
	   }
	   
	   String[] result = new String[weights.length]; 
	   int j=0;
	   for(int i: map.values()){
	       result[j] = items[i];
	       j++;
	   }
	   
	   	return result;
   
	}
}
