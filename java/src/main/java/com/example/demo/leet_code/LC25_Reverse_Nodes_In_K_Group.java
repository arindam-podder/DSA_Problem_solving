/**
 * 25. Reverse Nodes in k-Group (Hard)

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is 
not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 */


package com.example.demo.leet_code;

import java.util.Iterator;

import com.example.demo.leet_code.LC25_Reverse_Nodes_In_K_Group.ListNode;

public class LC25_Reverse_Nodes_In_K_Group {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2); 
		ListNode n2 = new ListNode(3); 
		ListNode n3 = new ListNode(4); 
		ListNode n4 = new ListNode(5); 
		ListNode n5 = new ListNode(6); 
		head.next = n1; n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; 
		
		//traverse(head);
		//traverse( reverse(head));
		//System.out.println(kThNode(head, 3));
		
		traverse( kGroupReverse(head, 8) );
		
	}
	
	public static ListNode kGroupReverse(ListNode head, int k) {	//require visualization 
        ListNode temp = head; 
        ListNode prevNode = null; 
        ListNode nextK = null; 
        
        while(temp != null) {
        	ListNode kThNode = kThNode(temp, k);
        	if(kThNode == null) {
        		if( prevNode!= null ) prevNode.next = temp; 
        		break; 
        	}
        	nextK = kThNode.next; 
        	kThNode.next = null; 
        	reverse(temp); 
        	if(temp == head) {
        		head = kThNode;
        	}else {
        		 prevNode.next = kThNode;
        	}
        	
        	prevNode = temp;
        	temp = nextK;
        }
        
       return head; 
    }//method kGroupReverse end 

	
	public static ListNode kThNode(ListNode temp, int k) {
		ListNode kTh = temp;  
		for(int i=1; i<k; i++) {
			 kTh = kTh != null? kTh.next: null; 
		}
		return kTh;
	}
	
	
	public static ListNode reverse(ListNode head) {
		ListNode prev = null; 
		ListNode cur = head; 
		ListNode next = head.next; 
		while(cur != null) {
			cur.next = prev;
			prev = cur; 
			cur = next; 
			if(next != null) next = next.next; 
		}
		return prev;
	}
	
	public static void traverse(ListNode head) {
		ListNode t = head; 
		System.out.print("[ ");
		while(t != null) {
			System.out.print(t.value + "  ");
			t = t.next;
		}
		
		System.out.println("]");
	}
	
	
	static class ListNode{
		int value; 
		ListNode next; 
		
		public ListNode(int v){
			this.value = v; 
			this.next = null; 
		}
		public ListNode(int v, ListNode next){
			this.value = v; 
			this.next = next; 
		}
		
	}//class ListNode end
	
}









