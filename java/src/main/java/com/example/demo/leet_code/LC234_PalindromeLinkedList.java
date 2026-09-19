/**
 * 234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.


Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false 

Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
 */



package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC234_PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static boolean isPalindrome1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        //traverse ll and save in list 
        ListNode node = head; 
        while(node != null) {
        	list.add(node); 
        	node = node.next; 
        }
        
        //two pointer palin check 
        int p1=0; 
        int p2=list.size()-1; 
        while(p1<p2) {
        	if(list.get(p1).val != list.get(p2).val) return false; 
        	p1++; 
        	p2--; 
        }
        
        return true; 
    }
    
    public static class ListNode {
    	      int val;
    	      ListNode next;
    	      ListNode() {}
    	      ListNode(int val) { this.val = val; }
    	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    	 }

}
