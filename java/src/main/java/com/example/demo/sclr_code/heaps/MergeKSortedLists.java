/*
 * Q2. Merge K Sorted Lists

Problem Description
Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.

Problem Constraints
1 <= total number of elements in given linked lists <= 100000

Input Format
The first and only argument is a list containing N head pointers.

Output Format
Return a pointer to the head of the sorted linked list after merging all the given linked lists.

Example Input
Input 1:
 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
Input 2:
 10 -> 12
 13
 5 -> 6

Example Output
Output 1:
 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
Output 2:
 5 -> 6 -> 10 -> 12 ->13

Example Explanation
Explanation 1:
 The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
Explanation 2:
 The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
 */


package com.example.demo.sclr_code.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists implements Comparator<ListNode>{

	public static void main(String[] args) {
		ListNode r1 = new ListNode(10);
		ListNode n1 = new ListNode(15);
		r1.next = n1;
		
		ListNode r2 = new ListNode(4);
		ListNode n2 = new ListNode(55);
		r2.next = n2;
		
		ArrayList<ListNode> list = new ArrayList<>();
		list.add(r1);
		list.add(r2);
		
		mergeListNodes(list);
	}

	public static ListNode mergeListNodes(ArrayList<ListNode> nodeList) {
		PriorityQueue<ListNode> heap = new PriorityQueue<>(new MergeKSortedLists());
		//add all head node into heap 
		for(ListNode n : nodeList ) {
			heap.add(n);
		}
		
		ListNode root = heap.poll();
		ListNode temp = root; 
		if(temp.next != null) {
			heap.add(temp.next);
		}
		while(!heap.isEmpty()) {
			ListNode cur = heap.poll(); 
			temp.next = cur; 
			if(cur.next != null) {
				heap.add(cur.next);
			}
			temp = temp.next ; 
		}
		
		return root;
 	}
	
	
	@Override  //this comparator is to tell PriorityQueue what is the priority 
	public int compare(ListNode o1, ListNode o2) {
		if(o1.val < o2.val) {
			return -1;
		}else if(o1.val > o2.val ) {
			return 1;
		}else {
			return 0;
		}
	}
	
}


class ListNode {
	 public int val;
     public ListNode next;
	 ListNode(int x) { 
	     val = x; 
	     next = null;
     }
}     















