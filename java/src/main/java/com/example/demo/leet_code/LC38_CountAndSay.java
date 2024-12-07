/**
 * 38. Count and Say 
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters 
(repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters 
(length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", 
replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence.


Example 1:
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = RLE of "1" = "11"
countAndSay(3) = RLE of "11" = "21"
countAndSay(4) = RLE of "21" = "1211"

Example 2:
Input: n = 1
Output: "1"
Explanation:
This is the base case.

 
Constraints:
1 <= n <= 30

Follow up: Could you solve it iteratively?
 */


package com.example.demo.leet_code;

import java.util.Stack;

public class LC38_CountAndSay {

	public static void main(String[] args) {
		
		System.out.println( getCountAndSay(9) );
	
	}
		
	public static String getCountAndSay(int n) {
		String result = "1"; 
		for(int i=2; i<=n; i++) {
			result = countSay(result);
		}
		return result;
    }
	
	
	public static String countSay(String s) {
		Stack<Character> numSt = new Stack<>(); 
		Stack<Integer> countSt = new Stack<>();
		numSt.add(s.charAt(0)); 
		countSt.add(1); 
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i) == numSt.peek()) {
				int count = countSt.pop();
				countSt.add(count+1);
			}else {
				numSt.add(s.charAt(i)); 
				countSt.add(1);
			}
		}
		
		String countSay = ""; 
		while(!numSt.isEmpty()) {
			int cnt = countSt.pop();
			char num = numSt.pop(); 
			countSay = cnt+""+num+""+countSay;
		}
		return countSay;
	}

}














