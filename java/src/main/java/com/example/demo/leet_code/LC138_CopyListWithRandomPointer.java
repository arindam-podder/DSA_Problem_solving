/*
 * 138. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 

Constraints:

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC138_CopyListWithRandomPointer {
	
	public static void main(String[] args) {
		Node n1 = new Node(7);
		Node n2 = new Node(13);
		Node n3 = new Node(11);
		Node n4 = new Node(10);
		Node n5 = new Node(1);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; 
		n2.random = n1; n3.random = n5; n4.random = n3; n5.random = n1; 
		
		
		Node deepCopy =  copyRandomList1(n1); 
		
		
		System.out.println( "Done" );
		
	}
	

	//create duplicate node for each node 1st then focus on random pointer 
	public static Node copyRandomList1(Node head) {
        Node temp = head; 
        while(temp != null) {	//for create duplicate 
        	Node n = new Node(temp.val); 
        	n.next = temp.next; 
        	temp.next = n; 
        	temp = n.next; //to actual next of original
        }
        
        //random point correctly 
        temp = head;  
        while(temp != null) {
        	temp.next.random = temp.random == null ? null: temp.random.next;
        	
        	temp = temp.next.next;
        }
        
        //now segregate actual and duplicates 
        Node resNode = head.next; 
        temp = head; 
        Node dup = head.next;
        while(temp != null) {
        	temp.next = dup.next; 
        	dup.next = temp.next == null ? null: temp.next.next;
        	
        	temp = temp.next; 
        	dup = dup.next;
        	
        }
        
        return resNode;

	} 
	
	
	
	
	static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	

}
