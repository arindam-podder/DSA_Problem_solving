/**
 * 60. Permutation Sequence (Hard)

The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 
Example 1:
Input: n = 3, k = 3
Output: "213"
Example 2:
Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 

Constraints:

1 <= n <= 9
1 <= k <= n!
 */



package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC60_PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kthPermutation(3, 2));
		
		//System.out.println( 2/6 );
	}

	
	public static String kthPermutation(int n, int k) {
		//create n 1-n list
		int fact = 1;
		List<Integer> list = new ArrayList<>(); 
		for(int i=1; i<n; i++) {
			fact = fact * i;
			list.add(i);
		}
		list.add(n); 
		
		//zero based operation so k is k-1
		k = k-1;
		//play with each index , and each position will ghive cetain number of permutation 
		String result = "";
		while(true) {
			//kth permutation will start from a particular index value 
			int indexToPick = k/fact; 
			result = result + list.get(indexToPick); 
			list.remove(indexToPick); 
			if(list.size() == 0) {
				break;
			}
			
			k = k%fact;
			fact = fact/list.size();
		}
		return result;
	}
}


