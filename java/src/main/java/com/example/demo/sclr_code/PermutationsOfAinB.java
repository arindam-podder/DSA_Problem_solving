/*
 * Q2. Permutations of A in B

Problem Description
You are given two strings, A and B, of size N and M, respectively.
You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only 
lowercase letters.

Problem Constraints
1 <= N < M <= 105

Input Format
Given two arguments, A and B of type String.

Output Format
Return a single integer, i.e., number of permutations of A present in B as a substring.

Example Input
Input 1:
 A = "abc"
 B = "abcbacabc"
Input 2:
 A = "aca"
 B = "acaa"

Example Output
Output 1:
 5
Output 2:
 2

Example Explanation
Explanation 1:
Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:
Permutations of A that are present in B as substring are:
    1. aca
    2. caa 
 */


package com.example.demo.sclr_code;

import java.util.HashMap;

public class PermutationsOfAinB {

	public static void main(String[] args) {
		String A = "abc"; 
		String B = "abcbacabc";
		
		System.out.println(countOfPermutation(A, B));
	}
	
	public static int countOfPermutation(String A, String B) {
		int len_of_A = A.length(); 
		int len_of_B = B.length();
		//freequency map for A
		HashMap<Character, Integer> hm_A = new HashMap<>(); 
		for(int i=0; i<len_of_A; i++) {
			Character ch = A.charAt(i);
			hm_A.put(ch, hm_A.getOrDefault(ch, 0)+1);
		}
		//frequecy map for B of length(A)
		HashMap<Character, Integer> hm_B = new HashMap<>();
		for(int i=0; i<len_of_A; i++) {
			Character ch = B.charAt(i); 
			hm_B.put(ch, hm_B.getOrDefault(ch, 0)+1);
		}
		int result = 0; 	
		if( compareMap(hm_A, hm_B)) {
			result++;
		}

		int L=0; int R=len_of_A-1;		//window size
		for(; R<len_of_B-1; ) {
			hm_B.put(B.charAt(L), hm_B.get(B.charAt(L))-1);			//left value subtractfrom map 
			L++; 
			R++;
			hm_B.put(B.charAt(R), hm_B.getOrDefault(B.charAt(R), 0)+1);	//right value add into map
			
			if( compareMap(hm_A, hm_B)) {
				result++;
			}
		}
		
		return result;
	}
	
	public static boolean compareMap(HashMap<Character, Integer> hm_A, HashMap<Character, Integer> hm_B) {
		for(Character ch : hm_A.keySet()) {
			if(hm_B.containsKey(ch) && hm_B.get(ch)==hm_A.get(ch)) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}

}








