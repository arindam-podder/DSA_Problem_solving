/**
 * given a unsorted array , find the length of longest consecutive set of element
 * 
 * example: 
 * arr = [100, 4, 200, 1, 3, 2]
 * ans = 4
 */

package com.example.demo.preparation1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSetOfElement {

	public static void main(String[] args) {
		int[] arr = {100, 4, 200, 1, 3, 2};
		
		System.out.println(length(arr));
	}

	
	
	public static int length(int[] arr) {
		//convert into set 
		Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
		int result = 1;
		
		for(Integer i: set) {
			//ingnore if i-1 present
			if(set.contains(i-1)) continue;
			int l=1;
			Integer cur=i;
			while(set.contains(cur+1)) {
				l += 1 ;
				cur += 1;
			}
			
			result = Math.max(l, result); 
		}
		
		return result;
	}
	

}
