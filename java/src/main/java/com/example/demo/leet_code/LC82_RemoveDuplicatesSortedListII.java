/*
 * 82. Remove Duplicates from Sorted List II

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers 
from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */

package com.example.demo.leet_code;

import java.util.HashSet;
import java.util.Set;

public class LC82_RemoveDuplicatesSortedListII {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1); 
 		ListNode n2 = new ListNode(2); 
		ListNode n3 = new ListNode(2); 
		ListNode n4 = new ListNode(3); 
		
		n1.next = n2;	n2.next = n3; 	n3.next = n4;
		
//		deleteDuplicates1(n1);
		deleteDuplicates2(n1);
		
	}
	
	//extra space 
	public static ListNode deleteDuplicates1(ListNode head) {
        Set<Integer> nodePresent = new HashSet<>(); 
        Set<Integer> duplicateNode = new HashSet<>();
        ListNode temp = head; 
        while(temp != null) {
        	int val = temp.val; 
        	if(nodePresent.contains(val)) duplicateNode.add(val);
        	else nodePresent.add(val);
        	
        	temp = temp.next;
        }
        
        nodePresent.clear();
        ListNode resultHead = null;
        ListNode lastNode = null; 
        temp = head; 
        while(temp != null) {
        	int val = temp.val; 
        	if(duplicateNode.contains(val)) {
        		if(lastNode != null) lastNode.next = null;
        		ListNode x = temp.next; 
        		temp.next = null; 
        		temp = x;
        	}else {
        		if(resultHead == null) resultHead = temp; 
        		if(lastNode != null ) lastNode.next = temp;
        		lastNode = temp; 
        		temp = temp.next;
        	}
        }
        return resultHead;
    }
	
	//no extra space
		public static ListNode deleteDuplicates2(ListNode head) {
			ListNode resultHead = null;
	        ListNode lastNode = null; 
	        ListNode t1 = head; 
	        ListNode t2 = head; 
	        
	        while(t1!= null) {
	        	if(t1.next == null || t1.next.val != t1.val) {
	        		if(resultHead == null) resultHead = t1; 
	        		if(lastNode == null) lastNode = t1;
	        		else lastNode.next = t1; 
	                lastNode = t1;
	        		t1 = t1.next;
	        	}
	        	else {
	        		t2 = t1;
		        	//with help of t2 chek continue duplicate 
		        	while(t2 != null && t2.val == t1.val) {
		        		t2 = t2.next;
		        	}
		        	t1 = t2;
	        	}
	        }
	        if(lastNode != null) lastNode.next = null;
	        return resultHead;
		}
	
	
	static public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
