/*
 * Problem Description
You are given A which is the head of a linked list. Also given is the value B and position C. Complete the function that should insert a 
new node with the said value at the given position.

Notes:
In case the position is more than length of linked list, simply insert the new node at the tail only.
In case the pos is 0, simply insert the new node at head only.
Follow 0-based indexing for the node numbering.

Problem Constraints
1 <= size of linked list <= 105
1 <= value of nodes <= 109
1 <= B <= 109
0 <= C <= 105

Input Format
The first argument A is the head of a linked list.
The second argument B is an integer which denotes the value of the new node
The third argument C is an integer which denotes the position of the new node

Output Format
Return the head of the linked list

Example Input
Input 1:
A = 1 -> 2
B = 3
C = 0
Input 2:
A = 1 -> 2
B = 3
C = 1

Example Output
Output 1:
3 -> 1 -> 2
Output 2:
1 -> 3 -> 2

Example Explanation
For Input 1:
The new node is add to the head of the linked list
For Input 2:
The new node is added after the first node of the linked list
 */

package com.example.demo.sclr_code;

public class InsertInLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(21);
		ListNode a = new ListNode(25);
		head.next = a;
		ListNode b = new ListNode(30);
		a.next = b;
		ListNode c = new ListNode(31);
		b.next = c;
		
		ListNode HeadAfterInsert =  insert(head, 999, 3);
		
		LinkedListNodeValueDisplay.displayValue(HeadAfterInsert);

	}
	
	public static ListNode insert(ListNode A, int B, int C) {
        if(C==0){
            ListNode current = new ListNode(B);
            current.next = A;
            A = current;
        }
        else{
            ListNode temp = A;
            for(int i=1; i<C && temp.next != null; i++ ){
                temp = temp.next;
            }
            ListNode current = new ListNode(B);
            current.next = temp.next;
            temp.next = current;
        }

        return A;

    }

}



//Definition for singly-linked list,   present in LinkedListNodeValueDisplay.java
//class ListNode {
//	public int val;
//	public ListNode next;
//	ListNode(int x) { val = x; next = null; }
//}