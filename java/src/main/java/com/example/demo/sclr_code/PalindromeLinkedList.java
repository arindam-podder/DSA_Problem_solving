/*
 * Q2. Palindrome List    (day 60 14 Aug 2023)

Problem Description
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.


Problem Constraints
1 <= |A| <= 105

Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.

Output Format
Return 0, if the linked list is not a palindrome.
Return 1, if the linked list is a palindrome.

Example Input
Input 1:
A = [1, 2, 2, 1]
Input 2:
A = [1, 3, 2]

Example Output
Output 1:
 1 
Output 2:
 0 

Example Explanation
Explanation 1:
 The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
Explanation 2:
 The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
 */


package com.example.demo.sclr_code;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1); 
		ListNode node1 = new ListNode(1);
		head.next = node1;
		ListNode node2 = new ListNode(6); 
		node1.next = node2; 
		ListNode node3 = new ListNode(4); 
		node2.next = node3; 
		ListNode node4 = new ListNode(1);
		node3.next = node4;
		
		System.out.println( lPalin(head) );
		
	}
	
	public static int lPalin(ListNode A) {
		int length = 0 ; 
		ListNode temp = A; 
		while(temp != null) {
			length+=1; 
			temp = temp.next; 
		}
		
		int mid = length/2; 
		ListNode midNode = A; 
		for(int i=0; i<mid; i++) {
			midNode = midNode.next; 
		}
		ListNode revMid = reverseListFromMid(midNode);
		
		ListNode node = A; 
		ListNode rev = revMid; 
		for(int i=0; i<mid; i++) {
			if(node.val != rev.val) {
				return 0;
			}
			node = node.next;
			rev = rev.next;
		}
		return 1;
	}
	
	 public static ListNode reverseListFromMid(ListNode A) {
		 ListNode previous, current, forward;
		 previous = null;
		 current = A;
		 while(current != null) {
			 forward = current.next;
			 current.next = previous; 
			 previous = current; 
			 current = forward; 
		 }
		 return previous;		//after reverse previous become head node. 
	 }

}






















