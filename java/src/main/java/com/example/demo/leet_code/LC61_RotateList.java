/**
 * 61. Rotate List

Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */


package com.example.demo.leet_code;

public class LC61_RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		head.next = n1; n1.next = n2; 
		
		rotateRight(head, 4);

	}
	
	public static ListNode rotateRight(ListNode head, int k) {
        int len = lengthOfLL(head); 
        k = k%len; 
        if(k == 0) return head; 
        
        ListNode tmp = head; 
        int n =1;
        while(n<len-k) {
        	tmp = tmp.next;
        	n++;
        }
        
        ListNode newHead = tmp.next; 
        tmp.next = null;
        
        tmp = newHead; 
        while(tmp.next != null) {
        	tmp = tmp.next;
        }
        tmp.next = head; 
        
        return newHead;
    }
	
	public static int lengthOfLL(ListNode head) {
		ListNode tmp = head;
		int len = 0; 
		while(tmp != null) {
			len++; 
			tmp = tmp.next; 
		}
		return len;
	}
	
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) { 
			this.val = val; 
			this.next = next; 
		}
	}

}
