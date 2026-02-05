/**
 * 86. Partition List

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater 
than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:
The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
 */

package com.example.demo.leet_code;

import java.util.LinkedList;
import java.util.Queue;


public class LC86_PartitionList {
	public static void main(String[] args) {
		//1,4,3,2,5,2
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;	n2.next = n3; 	n3.next = n4; 	n4.next = n5; 	n5.next = n6; 
		
		int x = 3;
		
		partition1(n1, x);
		
		System.out.println( "done" );
	}
	
	//using extra space 
	public static ListNode partition1(ListNode head, int x) {
        if(head == null) return head; 
        Queue<ListNode> less = new LinkedList<>(); 
        Queue<ListNode> other = new LinkedList<>();
		ListNode temp = head; 
		while(temp != null) {
			int val = temp.val; 
			ListNode node = temp.next;
			temp.next = null;
			if(val < x) less.add(temp);  
			else other.add(temp);
			
			temp = node;
		}
		
		ListNode newHead = null; 
		temp = null;
		while(!less.isEmpty()) {
			ListNode listNode = less.poll();
			if(newHead == null) newHead = listNode;
			if(temp == null) temp = newHead;
			else {
				temp.next = listNode; 
				temp = listNode;
			}
		}
		while(!other.isEmpty()) {
			ListNode listNode = other.poll();
			if(newHead == null) newHead = listNode;
			if(temp == null) temp = newHead;
			else {
				temp.next = listNode; 
				temp = listNode;
			}
		}
		
		return newHead;
    }
	
	//without extra space 
	public static ListNode partition2(ListNode head, int x) {
		ListNode dummyLess = new ListNode(0); 
		ListNode dummyOther = new ListNode(-1);
		ListNode d1 = dummyLess; 
		ListNode d2 = dummyOther;
		
		ListNode temp =  head; 
		while(temp != null) {
			ListNode n = temp.next; 
			temp.next = null; 
			if(temp.val < x) {
				d1.next = temp; 
				d1 = temp; 
			}else {
				d2.next = temp; 
				d2 = temp;
			}
			
			temp = n;
		}
		
		d1.next = dummyOther.next;
		return dummyLess.next;
		
	}
	
	
	
	
	
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
