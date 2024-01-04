/*
 * Q1. Unique Elements
Problem Description
You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.

Find the minimum number of steps.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109

Input Format
The only argument given is an Array A, having N integers.

Output Format
Return the minimum number of steps required to make all elements unique.

Example Input
Input 1:
 A = [1, 1, 3]
Input 2:
 A = [2, 4, 5]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
Explanation 2:
 All elements are distinct.
 */

package com.example.demo.sclr_code.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class UniqueElements {

	public static void main(String[] args) {
		
		System.out.println(makeUnique(new int[] {2,2,2,2,6,6}));
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(6);
		list.add(6);	
		System.out.println(makeUnique(list));
	}
	
	
	public static int makeUnique(int[] arr) {		//dry run and observe
		int result = 0 ; 
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i]>= arr[i+1]) {
				result = result + arr[i]-arr[i+1]+1;
				arr[i+1] = arr[i]+1;
			}
		}
		return result;
	}
	
	public static Integer makeUnique(ArrayList<Integer> A) {
		Collections.sort(A);
        int result = 0; 
        for(int i=1; i<A.size(); i++){
            if(A.get(i) == A.get(i-1)){
                result = result +1; 
                A.set(i, A.get(i)+1);
            }
            else if(A.get(i) < A.get(i-1)){
                result = result + (A.get(i-1)+1)-A.get(i);
                A.set(i, A.get(i-1)+1); 
            }
        }
        return result;
	}
	

}
