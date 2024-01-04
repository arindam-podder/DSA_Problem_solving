/*
 * Q3. Flatten Binary Tree to Linked List

Problem Description
Given a binary tree A, flatten it to a linked list in-place.

The left child of all nodes should be NULL.

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only argument is the head of tree A.

Output Format
Return the linked-list after flattening.

Example Input
Input 1:
     1
    / \
   2   3
   
Input 2:
         1
        / \
       2   5
      / \   \
     3   4   6


Example Output
Output 1:
1
 \
  2
   \
    3
Output 2:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

Example Explanation

Explanation 1:
 Tree flattening looks like this.

Explanation 2:
 Tree flattening looks like this.

 */


package com.example.demo.sclr_code.trees;

public class FlattenBinaryTreeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void flatten(TreeNode node) {				//not proper
		if(node==null) return ;
		
		flatten(node.left);
		flatten(node.right); 
		
		TreeNode temp = node.right;
		if(node.left != null) {
			node.right = node.left; 
			node.left = null;
			while(node.right != null) {
				node = node.right; 
			}
			node.right = temp;
		}
	}
	
	public static NodePair flattenWithPair(TreeNode root) {		// correct one 
		if(root == null ) return new NodePair(null, null);
		NodePair lpair = flattenWithPair(root.left);
		NodePair rpair = flattenWithPair(root.right);
		root.left = null; 
		if(lpair.head==null && rpair.head==null) {
			return new NodePair(root, root);
		}
		else if(lpair.head == null) {
			root.right = rpair.head;
			return new NodePair(root, rpair.tail);
		}
		else if(rpair.head == null){
			root.right = lpair.head; 
			return new NodePair(root, lpair.tail);
		}else {
			root.right = lpair.head; 
			lpair.tail.right = rpair.head;
			return new NodePair(root, rpair.tail);
		}
	}
      
}

class NodePair{
	TreeNode head;
	TreeNode tail;
	NodePair(TreeNode h, TreeNode t){
		head = h;
		tail = t;
	}
}










