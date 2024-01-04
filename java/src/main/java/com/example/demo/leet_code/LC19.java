/*
 * 19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:
Input: head = [1], n = 1
Output: []
Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */

package com.example.demo.leet_code;

public class LC19 {
	
	public static void main(String[] args) {
		LC19ListNode n1 = new LC19ListNode(1);
		LC19ListNode n2 = new LC19ListNode(2);
		n1.next = n2; 
		LC19ListNode n3 = new LC19ListNode(3);
		n2.next = n3;
		LC19ListNode n4 = new LC19ListNode(4);
		n3.next = n4;
		LC19ListNode n5 = new LC19ListNode(5);
		n4.next = n5;
		LC19ListNode n6 = new LC19ListNode(6);
		n5.next = n6;
		LC19ListNode n7 = new LC19ListNode(7);
		n6.next = n7;
		LC19ListNode n8 = new LC19ListNode(8);
		n7.next = n8;
		LC19ListNode n9 = new LC19ListNode(9);
		n8.next = n9;
		LC19ListNode n10 = new LC19ListNode(10);
		n9.next = n10;
		
		LC19ListNode head = n1;
	
		
		LC19 obj = new LC19(); 
		obj.removeNthFromEnd(head, 1); 
	}
	
	public LC19ListNode removeNthFromEnd(LC19ListNode head, int n){
		LC19ListNode temp = head;
		int len = 0;
		while(temp != null) {
			len += 1;
			temp = temp.next;
		}
		int removeNodePosi = (len-n+1); 		//get removal node posi from front 
		temp = head;
		LC19ListNode prev = null;
		int posi = 1;
		while(posi<removeNodePosi) {
			prev = temp; 
			temp = temp.next;
			posi += 1;
		}
		
		if(prev != null) {
			prev.next = temp.next;
			temp.next = null;
		}else {
			head = temp.next; 
			temp.next = null;
		}
		
		//treaverse
		temp =  head;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		return head;
	}
	
}




//  Definition for singly-linked list.
class LC19ListNode {
      int val;
      LC19ListNode next;
      LC19ListNode() {}
      LC19ListNode(int val) { this.val = val; }
      LC19ListNode(int val, LC19ListNode next) { this.val = val; this.next = next; }
}

