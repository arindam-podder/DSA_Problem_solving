/*
 * Q3. K reverse linked list

Problem Description
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.

Problem Constraints
1 <= |A| <= 103
B always divides A

Input Format
The first argument of input contains a pointer to the head of the linked list.
The second arugment of input contains the integer, B.

Output Format
Return a pointer to the head of the modified linked list.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5, 6]
 B = 2
Input 2:
 A = [1, 2, 3, 4, 5, 6]
 B = 3

Example Output
Output 1:
 [2, 1, 4, 3, 6, 5]
Output 2:
 [3, 2, 1, 6, 5, 4]

Example Explanation
Explanation 1:
 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]
Explanation 2:
 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]
 *
 */

package com.example.demo.sclr_code;

public class KReverseLinkedList {

	public static void main(String[] args) {
		
	}
	
	public ListNode reverseList(ListNode A, int B) {

        int count = 0;
        ListNode prev = A;
        ListNode curr = A;

        ListNode head = null;
        ListNode curr2 = head;

        while (curr != null)
        {
            count += 1;
            if (count == B)
            {
                ListNode temp = curr.next;
                curr.next = null;
                if (head == null)
                {
                    head = reverse(prev);
                    curr2 = head;
                }
                else
                {
                    curr2.next = reverse(prev);
                }
                while (curr2.next != null)
                {
                    curr2 = curr2.next;
                }

                curr = temp;
                prev = curr;
                count = 0;
            }
            else
            {
                curr = curr.next;
            }
        }

        return head;
    }

    public ListNode reverse(ListNode A)
    {
        ListNode curr = A;
        ListNode prev = null;

        while (curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        A = prev;
        return A;
    }

}





















