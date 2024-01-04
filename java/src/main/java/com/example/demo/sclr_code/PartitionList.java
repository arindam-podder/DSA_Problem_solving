/*
 * Q1. Partition List

Problem Description
Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
You should preserve the original relative order of the nodes in each of the two partitions.

Problem Constraints
1 <= |A| <= 106
1 <= A[i], B <= 109

Input Format
The first argument of input contains a pointer to the head to the given linked list.
The second argument of input contains an integer, B.

Output Format
Return a pointer to the head of the modified linked list.

Example Input
Input 1:
A = [1, 4, 3, 2, 5, 2]
B = 3
Input 2:
A = [1, 2, 3, 1, 3]
B = 2

Example Output
Output 1:
[1, 2, 2, 4, 3, 5]
Output 2:
[1, 1, 2, 3, 3]

Example Explanation
Explanation 1:
 [1, 2, 2] are less than B wheread [4, 3, 5] are greater than or equal to B.
Explanation 2:
 [1, 1] are less than B wheread [2, 3, 3] are greater than or equal to B.

 */


package com.example.demo.sclr_code;

public class PartitionList {

	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode n1 = new ListNode(8);
		ListNode n2 = new ListNode(6);
		ListNode n3 = new ListNode(3);
		head.next = n1; 
		n1.next = n2; 
		n2.next = n3; 
		
		partionLL(head, 5);
		
	}

	public static ListNode partionLL(ListNode head, int B) {
		ListNode lowerDummy = new ListNode(Integer.MIN_VALUE); 
		ListNode greaterDummy = new ListNode(Integer.MAX_VALUE);
		ListNode ltemp = lowerDummy; 
		ListNode gtemp = greaterDummy; 
		
		//ListNode temp = head; 
		while(head != null) {
			if(head.val < B) {
				ltemp.next = head; 
				ltemp = ltemp.next; 
			}else {
				gtemp.next = head; 
				gtemp = gtemp.next;
			}
			
			ListNode prev = head; 
			head = head.next; 
			prev.next = null; 
		}
		
		if(greaterDummy.next == null) {
			return lowerDummy.next; 
		}
		if(lowerDummy.next == null) {
			return greaterDummy.next; 
		}
		
		ltemp.next = greaterDummy.next; 
		return lowerDummy.next; 
	}
	
}














