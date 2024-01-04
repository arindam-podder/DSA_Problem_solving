package com.example.demo.sclr_code;

public class LinkedListNodeValueDisplay {

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		ListNode a = new ListNode(15);
		head.next = a;
		ListNode b = new ListNode(20);
		a.next = b;

		
		displayValue(head) ;

	}

	public static void displayValue(ListNode A) {
        ListNode temp = A;
        while( temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        
    //recursive    
        // if(A==null) {System.out.println(); return;}
        // System.out.print(A.val+" ");
        // solve(A.next); 
    }
}

	
//Definition for singly-linked list.
class ListNode {
  	public int val;
  	public ListNode next;
  	ListNode(int x) { val = x; next = null; }
}
 
