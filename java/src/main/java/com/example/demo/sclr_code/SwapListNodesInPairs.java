/*
 * Q1. Swap List Nodes in pairs
 * 
Problem Description
Given a linked list A, swap every two adjacent nodes and return its head.

NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.

Problem Constraints
1 <= |A| <= 106

Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.

Output Format
Return a pointer to the head of the modified linked list.

Example Input
Input 1:
 A = 1 -> 2 -> 3 -> 4
Input 2:
 A = 7 -> 2 -> 1

Example Output
Output 1:
 2 -> 1 -> 4 -> 3
Output 2:
 2 -> 7 -> 1

Example Explanation
Explanation 1:
 In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3
Explanation 2:
 In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped. 

 */


package com.example.demo.sclr_code;

public class SwapListNodesInPairs {

	public static void main(String[] args) {
		ListNode head = new ListNode(1); 
		ListNode n1 = new ListNode(2); 
		head.next=n1;
		ListNode n2 = new ListNode(3); 
		n1.next = n2;
		ListNode n3 = new ListNode(4); 
		n2.next = n3;
//		ListNode n4 = new ListNode(5); 
//		n3.next = n4;
		
		LinkedListNodeValueDisplay.displayValue(swapPairsInListNode(head));
		 
		
	}
	
	public static ListNode swapPairsInListNode(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
        ListNode temp = head.next;
        ListNode prev=head;
        ListNode forward = temp.next; 
        //1st swap to get new head 
        temp.next = prev; 
        prev.next = forward;
        
        head = temp; 		//this is updated head 
        
        while(forward != null && forward.next != null) {
        	temp = forward.next; 
        	forward = forward.next.next; 
        	temp.next = prev.next; 
        	prev.next.next = forward;
        	prev.next = temp; 
        	prev = temp.next; 
        }
        
        return head;
    }

}

















