/*
 * Q3. Add Two Numbers as Lists

Problem Description
You are given two linked lists, A and B, representing two non-negative numbers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return it as a linked list.

Problem Constraints
1 <= |A|, |B| <= 105

Input Format
The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.

Output Format
Return a pointer to the head of the required linked list.

Example Input
Input 1:
 A = [2, 4, 3]
 B = [5, 6, 4]
Input 2: 
 A = [9, 9]
 B = [1]

Example Output
Output 1: 
 [7, 0, 8]
Output 2:
 [0, 0, 1]

Example Explanation
Explanation 1:
 A = 342 and B = 465. A + B = 807. 
Explanation 2:
 A = 99 and B = 1. A + B = 100. 
 */


package com.example.demo.sclr_code;

import java.util.List;

public class AddTwoNumbersAsListNode {

	public static void main(String[] args) {
		

	}
	
	public static ListNode addNumber(ListNode A, ListNode B) {
		int carry = (A.val + B.val)/10; 
		ListNode result = new ListNode((A.val + B.val)%10);
		ListNode temp = result;
		while(A.next!=null && B.next!=null) {
			A = A.next; B = B.next; 
			ListNode node = new ListNode( (A.val+B.val+carry)%10  );
			temp.next = node ; 
			temp = node; 
			carry = (A.val+B.val+carry)/10; 
		}
	
		if(B.next == null) {
			while(A.next != null) {
				A = A.next; 
				ListNode node = new ListNode( (A.val+carry)%10); 
				temp.next = node; 
				temp=node;
				carry = (A.val+carry)/10 ; 
			}
		}
		if(A.next == null) {
			while(B.next != null) {
				B = B.next; 
				ListNode node = new ListNode( (B.val+carry)%10); 
				temp.next = node; 
				temp=node;
				carry = (B.val+carry)/10 ; 
			}
		}
		if(carry == 1) {
			ListNode node = new ListNode(carry);
			temp.next = node; 
		}
		return result;
	}

}



