/*
 * Q1. Remove Nth Node from List End
Problem Description
Given a linked list A, remove the B-th node from the end of the list and return its head. For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5. NOTE: If B is greater than the size of the list, remove the first node of the list. NOTE: Try doing it using constant additional space.

Problem Constraints
1 <= |A| <= 106

Input Format
The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.

Output Format
Return the head of the linked list after deleting the B-th element from the end.

Example Input
Input 1:
A = 1->2->3->4->5
B = 2
Input 2:
A = 1
B = 1

Example Output
Output 1:
1->2->3->5
Output 2:
  
Example Explanation
Explanation 1:
In the first example, 4 is the second last element.
Explanation 2:
In the second example, 1 is the first and the last element.
 */

package com.example.demo.sclr_code;

public class RemoveNthNodeFromListEnd {

	public static void main(String[] args) {
		ListNode head = new ListNode(1); 
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		head.next = n1; 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4; 
		
		LinkedListNodeValueDisplay.displayValue( removeNthFromEnd(head, 1) );
		

	}
	
	public static ListNode removeNthFromEnd(ListNode A, int B) {
        //length of LL
        int len = 0; 
        ListNode temp = A; 
        while(temp!=null){
            len++; 
            temp = temp.next;
        }
        if(len<=B){             //here head is updated 
            return A.next; 
        }
        temp = A;
        for(int i=1; i<len-B; i++){
            temp = temp.next; 
        }
        temp.next = temp.next.next;
        return A;  
    }

}











