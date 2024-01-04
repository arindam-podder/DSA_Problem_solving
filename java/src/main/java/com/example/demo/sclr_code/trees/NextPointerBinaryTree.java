/*
 * Q2. Next Pointer Binary Tree

Problem Description
Given a binary tree,
Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return the head of the binary tree after the changes are made.

Example Input
Input 1:
     1
    /  \
   2    3
Input 2: 
        1
       /  \
      2    5
     / \  / \
    3  4  6  7

Example Output
Output 1:
        1 -> NULL
       /  \
      2 -> 3 -> NULL
Output 2: 
         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL

Example Explanation
Explanation 1:
Next pointers are set as given in the output.
Explanation 2:
Next pointers are set as given in the output.
 */


package com.example.demo.sclr_code.trees;

import java.util.LinkedList;

public class NextPointerBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void nextPointerSet(TreeLinkNode node) {		//level order traversal requiored 
		LinkedList<TreeLinkNode> que = new LinkedList<>();		//queue
		que.offerLast(node); 
		while(!que.isEmpty()) {
			int qSize = que.size(); 
			for(int i=0; i<qSize; i++) {
				TreeLinkNode cur = que.pollFirst();
				if(i != qSize-1) {
					cur.next = que.peek();
				}
				
				if(cur.left != null) {
					que.offerLast(cur.left);
				}
				if(cur.right != null) {
					que.offerLast(cur.right);
				}
			}
		}
		
	}

}

class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
}










