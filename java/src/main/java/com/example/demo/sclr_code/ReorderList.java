/*
 * Q2. Reorder List
 * 
Problem Description
Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:
 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.

Problem Constraints
1 <= |A| <= 106

Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.

Output Format
Return a pointer to the head of the modified linked list.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5] 
Input 2:
 A = [1, 2, 3, 4] 

Example Output
Output 1:
 [1, 5, 2, 4, 3] 
Output 2:
 [1, 4, 2, 3] 

Example Explanation
Explanation 1:
 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:
 The array will be arranged to [A0, An, A1, An-1, A2].
 */


package com.example.demo.sclr_code;

public class ReorderList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		head.next = n1;
		ListNode n2 = new ListNode(3);
		n1.next = n2;
		ListNode n3 = new ListNode(33);
		n2.next = n3;
		ListNode n4 = new ListNode(22);
		n3.next = n4;
		ListNode n5 = new ListNode(11);
		n4.next = n5;
		ListNode n6 = new ListNode(77);
		n5.next = n6;
	
		reOrderNode(head);
	}
	
	public static ListNode reOrderNode(ListNode head) {
		int len = 0; 
		ListNode temp = head; 
		while(temp != null) {
			len++;
			temp = temp.next; 
		}
		if(len <= 2) {
			return head;
		}
		ListNode mid = head;
		ListNode prevMid = null; 
		for(int i=1; i<= len/2; i++) {
			prevMid = mid;
			mid = mid.next; 
		}
		prevMid.next = null;
		
		ListNode prev = null; 
		while(mid != null) {
			ListNode forward = mid.next;
			mid.next = prev; 
			prev = mid; 
			mid = forward;
		}		//end of while prev is the head of reverse LL , 
		ListNode t1 = head ; 
		ListNode t2 = prev; 
		//now merging 
		while(t1!=null && t2!=null) {
			ListNode p1 =  t1.next;
			ListNode p2 = t2.next;
			t1.next = t2; 
			if(p1!= null) {
				t2.next = p1;
			}
				
			t1 = p1; 
			t2 = p2;
		}
		
		return head;
	}

}

















