/*
 * Q2. Window String

Problem Description
Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.

Note:
If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )

Problem Constraints
1 <= size(A), size(B) <= 106

Input Format
The first argument is a string A.
The second argument is a string B.

Output Format
Return a string denoting the minimum window.

Example Input
Input 1:
 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:
 A = "Aa91b"
 B = "ab"

Example Output
Output 1:
 "BANC"
Output 2:
 "a91b"

Example Explanation
Explanation 1:
 "BANC" is a substring of A which contains all characters of B.
Explanation 2:
 "a91b" is the substring of A which contains all characters of B.

 */


package com.example.demo.sclr_code;

import java.util.HashMap;

public class WindowString {

	public static void main(String[] args) {
		System.out.println(window("AAAAA", "AA"));

	}
	
	public static String window(String A, String B) {
		//frequency of B string 
		HashMap<Character, Integer> hm_b= new HashMap<>();
		for(int i=0; i<B.length(); i++) {
			hm_b.put(B.charAt(i), hm_b.getOrDefault(B.charAt(i), 0)+1 );
		}
		String result = A+B;
		int L=0; int R=0; 
		HashMap<Character, Integer> hm_a = new HashMap<>();
		hm_a.put(A.charAt(R), 1);
		while (R<A.length() && L<A.length()) {
			if(checkMap(hm_a, hm_b)) {
				result = result.length()>R-L+1 ? A.substring(L, R+1):result;
				hm_a.put(A.charAt(L), hm_a.get(A.charAt(L))-1);
				L=L+1;
			}else {
				R = R+1;
				if(R<A.length()) {
					hm_a.put(A.charAt(R), hm_a.getOrDefault(A.charAt(R),0)+1);
				}
			}
		}
		if(result.length()==A.length()+B.length()) {
			return "";
		}else {
			return result;
		}
	}
	
	public static boolean checkMap(HashMap<Character, Integer> hm_a, HashMap<Character, Integer> hm_b) {
		for(Character ch : hm_b.keySet()) {
			if(!(hm_b.get(ch)<= hm_a.getOrDefault(ch, 0))) {
				return false;
			}
		}
		return true;
	}
	
}

































