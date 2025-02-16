/**
 * 1718. Construct the Lexicographically Largest Valid Sequence

Given an integer n, find a sequence that satisfies all of the following:

The integer 1 occurs once in the sequence.
Each integer between 2 and n occurs twice in the sequence.
For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.

Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is 
always a solution. A sequence a is lexicographically larger than a sequence b (of the same length) if in the 
first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, 
[0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, 
and 9 is greater than 5.

Example 1:
Input: n = 3
Output: [3,1,2,3,2]
Explanation: [2,3,2,1,3] is also a valid sequence, but [3,1,2,3,2] is the lexicographically largest valid sequence.

Example 2:
Input: n = 5
Output: [5,3,1,4,3,5,2,4,2]
 
 
Constraints:
1 <= n <= 20
 */


package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1718_ConstructLexicographicallyLargestValidSequence {

	public static void main(String[] args) {
		int n = 5; 
		
		System.out.println( Arrays.toString( distancedSequence(n)) );
	}
	
	
	//greddy + backtrack 
	public static int[] distancedSequence(int n) {
         int[] result = new int[n*2 -1];
         Set<Integer> seen = new HashSet<>();
         backtrack(0, result, n, seen);
         return result;
    }
	
	
	public static boolean backtrack(int idx, int[] arr, int n, Set<Integer> seen) {
		if(idx == arr.length) return true;
		if(arr[idx] != 0) return backtrack(idx+1, arr, n, seen);
		
		//greedy , for each index. carefully check seen or not ,  try placing element n-0
		for(int i=n; i>=1; i--) {
			if(!seen.contains(i)) {
				if(i==1) {
					arr[idx] = i;
					seen.add(i);
					
					if(backtrack(idx+1, arr, n, seen)) {
						return true;
					}
					//back tracking 
					arr[idx] = 0;
					seen.remove(i);
				}else {
					if((idx+i) < arr.length  && arr[i+idx] == 0) {
						// two time
						arr[idx] = i;
						arr[idx + i] = i;
						seen.add(i);
	
						if (backtrack(idx + 1, arr, n, seen)) {
							return true;
						}
						// back tracking
						arr[idx] = 0;
						arr[idx + i] = 0;
						seen.remove(i);
					}
				}	
			}
		}
		return false;
	}

}










