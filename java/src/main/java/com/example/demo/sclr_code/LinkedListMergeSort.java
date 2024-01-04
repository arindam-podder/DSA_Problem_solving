/*
 * Q3. Sort List
Problem Description
Sort a linked list, A in O(n log n) time.

Problem Constraints
0 <= |A| = 105

Input Format
The first and the only arugment of input contains a pointer to the head of the linked list, A.

Output Format
Return a pointer to the head of the sorted linked list.

Example Input
Input 1:
A = [3, 4, 2, 8]
Input 2:
A = [1]

Example Output
Output 1:
[2, 3, 4, 8]
Output 2:
[1]

Example Explanation
Explanation 1:
 The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
Explanation 2:
 The sorted form of [1] is [1].
 */


package com.example.demo.sclr_code;

public class LinkedListMergeSort {

	public static void main(String[] args) {
		
	}

}


/*
 * solved using python 
 * 
 * # Definition for singly-linked list.
# class ListNode:
#   def __init__(self, x):
#       self.val = x
#       self.next = None
# Merge function that merges two sorted linked lists into a single sorted linked list
def merge(x, y):
    if x is None:  # If one of the lists is empty, return the other
        return y
    elif y is None:
        return x

    z = None    
    if x.val <= y.val:  # Compare the first nodes of the two lists and assign the smaller one to z
        z = x
        x = x.next
    else:
        z = y
        y = y.next

    tail = z  # Initialize a new linked list tail with the first node of the merged list
    while x is not None and y is not None:
        if x.val < y.val:  # Compare the first nodes of the remaining lists and append the smaller node to tail
            temp = x
            x = x.next
            tail.next = temp
            tail = temp
        else:
            temp = y
            y = y.next
            tail.next = temp
            tail = tail.next

    if x is not None:  # Append the remaining nodes of either list to tail
        tail.next = x
    else:
        tail.next = y

    return z

class Solution:
	# @param A : head node of linked list
	# @return the head node in the linked list
	def sortList(self, A):
        if A is None or A.next is None:  # Base condition: if the list is empty or has one node, return the list
            return A          

        # Find the middle node of the list using the two-pointer technique
        mid = A
        fast = A.next    
        while fast is not None and fast.next is not None:
            fast = fast.next.next
            mid = mid.next  

        B = mid.next  # Split the list into two halves
        mid.next = None

        # Recursively sort and merge the two halves of the list
        x = self.sortList(A)
        y = self.sortList(B)

        return merge(x, y)  # Merge the two sorted halves of the list and return the sorted list
 */














