/*
 * Q2. Copy List

Problem Description :- 
You are given a linked list A
Each node in the linked list contains two pointers: a next pointer and a random pointer
The next pointer points to the next node in the list
The random pointer can point to any node in the list, or it can be NULL
Your task is to create a deep copy of the linked list A
The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
You should create a new linked list B, where each node in B has the same value as the corresponding node in A
The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)


Problem Constraints
0 <= |A| <= 106

Input Format
The first argument of input contains a pointer to the head of linked list A.

Output Format
Return a pointer to the head of the required linked list.

Example Input
Given list
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
  
Example Output
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
  
Example Explanation
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, 
but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 */


package com.example.demo.sclr_code;

public class CopyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
          return null;
      }

      RandomListNode hc=head;
      while(hc!=null){
        //Insert value at alternate place
        RandomListNode nextNode=hc.next;
        hc.next=new RandomListNode(hc.label);
        hc.next.next=nextNode;
        hc=nextNode;
      }
     
     //attach random pointer of deep LL accroding to original LL
      RandomListNode temp1=head;
      while(temp1!=null){
       //Edge case as every node dont have random pointer
        if(temp1.random!=null){
            temp1.next.random=temp1.random.next;
        }
        
        temp1=temp1.next.next;
      }

      //detach the original LL 
      RandomListNode h1=head;
      RandomListNode h2=head.next;
      RandomListNode newHead=head.next;
      while(h1!=null){
          h1.next=h1.next.next;
          if(h2.next != null){
          h2.next=h2.next.next;
          }
          h1=h1.next;
          h2=h2.next;
      }
      return newHead;    

  }
  

}

class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
}


//public RandomListNode copyRandomList(RandomListNode head) {
//     //1st: create duplicate 
//     RandomListNode temp = head;
//     while(temp != null){
//         RandomListNode node = new RandomListNode(temp.label);
//         node.next = temp.next;
//         temp.next = node; 
//         temp = temp.next.next;
//     }

//     //2nd: set random for duplicates 
//     temp = head;
//     RandomListNode duplicate = head.next;
//     while(temp != null){
//         duplicate.random = temp.random.next;
//         temp = temp.next.next; 
//         if(temp != null){
//             duplicate = temp.next;
//         }
//     }

//     //3rd: extract original and duplicates 
//     RandomListNode original = head;
//     duplicate = head.next;
//     RandomListNode resultHead = duplicate; 
//     while(original != null){
//         original.next = original.next.next; 
//         original = original.next;
//         if(duplicate != null){
//             duplicate.next = duplicate.next.next;
//             duplicate = duplicate.next;
//         }
//     }
//     return resultHead;
// }