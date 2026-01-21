/*
 * 24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without 
modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]
Explanation:

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]

Example 4:
Input: head = [1,2,3]
Output: [2,1,3]

 

Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 
 */


package com.example.demo.leet_code;

import com.example.demo.leet_code.LC24_SwapNodesPairs.ListNode;

public class LC24_SwapNodesPairs {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		
		n1.next = n2;  n2.next = n3;  n3.next = n4;
		
		ListNode swapPairs = swapPairs(n1);
		
		System.out.println( "done" );
	}
	
	public static ListNode swapPairs(ListNode head) {
        ListNode prev = head; 
        ListNode next = head == null ? null: head.next;
        ListNode swapedLast = null; 
        while(prev != null && next != null) {
        	prev.next = next.next; 
        	next.next = prev; 
        	
        	if(swapedLast != null ) swapedLast.next = next; 
        	else {
        		head = next; 
        	}
        	
        	swapedLast = prev;
        	prev = prev.next; 
        	next = prev == null ? null: prev.next;
        }
        
        return head;
    }
	
	
	
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
