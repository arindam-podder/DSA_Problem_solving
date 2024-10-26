/**
 * 328. Odd Even Linked List

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes 
with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106
 */



package com.example.demo.leet_code;


public class LC328_OddEvenLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1); 
		ListNode l2 = new ListNode(2); 
		ListNode l3 = new ListNode(3); 
		ListNode l4 = new ListNode(4); 
		ListNode l5 = new ListNode(5); 
		//head.next = l2; l2.next =l3; //l3.next = l4; l4.next = l5;
		
		//display(head);
		
		display(  oddEvenListSolve(head) );
		
	}
	
	
	public static void display(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	
	public static ListNode oddEvenListSolve(ListNode head) {
		if(head == null ) return head; 
		
        ListNode oddTemp = head;  
        ListNode lastOddNode = oddTemp; 
        ListNode evenHead = oddTemp.next;
        ListNode evenTemp = evenHead; 
        
        while(oddTemp != null && evenTemp != null) {
        	lastOddNode = oddTemp; 
        	oddTemp.next = evenTemp.next; 
        	oddTemp = oddTemp.next;
        	
        	evenTemp.next = oddTemp != null ? oddTemp.next : null;
        	evenTemp = evenTemp.next;
        }
        
        
        if(oddTemp != null) {
        	lastOddNode.next = oddTemp;
        	lastOddNode = oddTemp;
        }
        
        lastOddNode.next = evenHead;
        
        return head; 
    }
	
	
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}


}//LC328_OddEvenLinkedList end