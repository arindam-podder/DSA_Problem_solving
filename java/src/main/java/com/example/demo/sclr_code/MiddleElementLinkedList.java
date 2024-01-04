/*
 * Q1. Middle element of linked list

Problem Description
Given a linked list of integers, find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.


Problem Constraints
1 <= length of the linked list <= 100000
1 <= Node value <= 109

Input Format
The only argument given head pointer of linked list.

Output Format
Return the middle element of the linked list.

Example Input
Input 1:
 1 -> 2 -> 3 -> 4 -> 5
Input 2:
 1 -> 5 -> 6 -> 2 -> 3 -> 4

Example Output
Output 1:
 3
Output 2:
 2

Example Explanation
Explanation 1:
 The middle element is 3.
Explanation 2:
 The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.

 */


package com.example.demo.sclr_code;

public class MiddleElementLinkedList {

	public static void main(String[] args) {
		
	}
	
	 public static int solve(ListNode A) {
	        int length = 0 ; 		//to get length of LinkedList
	        ListNode temp = A; 
	        while(temp != null){
	            length++; 
	            temp = temp.next;
	        }
	        
	        //using slow and fast pointer 
	        ListNode s = A; 
	        ListNode f = A;  
	        while(f.next != null && f.next.next != null){
	            f = f.next.next; 
	            s = s.next;
	        }
	        if(length%2 == 0){      //for even length
	            return s.next.val; 
	        }else{                  
	            return s.val;           //for odd length
	       }
	 }

}
