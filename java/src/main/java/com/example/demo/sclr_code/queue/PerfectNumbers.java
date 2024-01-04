/*
 * Q1. Perfect Numbers

Problem Description
Given an integer A, you have to find the Ath Perfect Number.
A Perfect Number has the following properties:

It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.


Problem Constraints
1 <= A <= 100000

Input Format
The only argument given is an integer A.

Output Format
Return a string that denotes the Ath Perfect Number.

Example Input
Input 1:
 A = 2
Input 2:
 A = 3

Example Output
Output 1:
 22
Output 2:
 1111


Example Explanation
Explanation 1:
First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 2nd Perfect number.
Explanation 2:
First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 3rd Perfect number.
 */


package com.example.demo.sclr_code.queue;

import java.util.LinkedList;

public class PerfectNumbers {

	public static void main(String[] args) {
		int num = 31;
		String half = getAthHalfSeries(num); 
		String nextHalf = new StringBuilder(half).reverse().toString();
		System.out.println(half+nextHalf);
		
		System.out.println(bF(num));			//taking too much time 
		
	}
	
	public static String getAthHalfSeries(int A){
		if(A==1) {
			return "1";
		}else if(A==2) {
			return "2";
		}
		
		LinkedList<String> queue = new LinkedList<>(); 				//taking as a queue
		queue.offerLast("1"); 
		queue.offerLast("2");
		for(int i=3; i<=A; ) {
			String current = queue.pollFirst();
			if(i==A) {
				return current+"1";
			}
			queue.offerLast(current+"1");
			i++;
			
			//current = queue.pollFirst();
			if(i == A) {
				return current+"2";
			}
			queue.offerLast(current+"2");
			i++;
		}
		return null;
    }
	
	public static long bF(int a) {
		int count = 0; 
		long num = 0;
		for(long i=10; i<Long.MAX_VALUE; i++) {
			if(consisting1and2AndEven(i) && palindrome(i)) {
				count++;
				num = i;
			}
			if(count==a) {
				return num;
			}
		}
		return num;
	}
	
	public static boolean consisting1and2AndEven(long l) {
		String n = l+"";
		if(n.length()%2 == 0) {
			for(int i=0; i<n.length(); i++) {
				char ch = n.charAt(i);
				if(ch!='1' && ch !='2') {
					return false;
				}
			}
			return true;
		}else {
			return false;
		}	
	}
	
	public static boolean palindrome(long l) {
		long temp = l ;
		long rev = 0; 
		while(temp>0) {
			long a = temp%10; 
			rev = rev*10 + a;
			temp = temp/10;
		}
		if(rev == l) {
			return true;
		}else {
			return false;
		}
	}

}
















