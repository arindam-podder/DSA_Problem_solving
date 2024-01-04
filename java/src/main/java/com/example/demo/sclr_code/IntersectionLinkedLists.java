/*
 * Q2. Intersection of Linked Lists
Problem Description
Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
NOTE:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
The custom input to be given is different than the one explained in the examples. Please be careful.

Problem Constraints
0 <= |A|, |B| <= 106

Input Format
The first argument of input contains a pointer to the head of the linked list A.
The second argument of input contains a pointer to the head of the linked list B.

Output Format
Return a pointer to the node after which the linked list is intersecting.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = [6, 3, 4, 5]
Input 2:
 A = [1, 2, 3]
 B = [4, 5]

Example Output
Output 1: 
[3, 4, 5]
Output 2:
 []

Example Explanation
Explanation 1:
 In the first example, the nodes have the same values after 3rd node in A and 2nd node in B. Thus, the linked lists are intersecting after that point. 
Explanation 2:
 In the second example, the nodes don't have the same values, thus we can return None/Null. 
 */


package com.example.demo.sclr_code;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLinkedLists {

	public static void main(String[] args) {
		ListNode A = new ListNode(2);
		ListNode n1 = new ListNode(3);
		A.next = n1;
		ListNode B = new ListNode(11);
		ListNode n2 = new ListNode(12);
		B.next = n2;
		
		ListNode n3 = new ListNode(100);
		ListNode n4 = new ListNode(1001);
		n3.next = n4;
		
		n1.next = n3;
		n2.next = n3;

		intersectionNode(A, B);
	}
	
	public static ListNode intersectionNode(ListNode A, ListNode B) {
		Set<ListNode> hs = new HashSet<>(); 
		ListNode temp = A;
		while(temp != null) {
			hs.add(temp); 
			temp = temp.next; 
		}
		
		temp = B; 
		while(temp != null) {
			if(hs.contains(temp)) {
				return temp;  
			}
			temp = temp.next;
		}
		return null; 
	}

}


















