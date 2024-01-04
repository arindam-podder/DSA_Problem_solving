/*
 * Q1. Binary Tree From Inorder And Preorder

Problem Description
Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First argument is an integer array A denoting the preorder traversal of the tree.
Second argument is an integer array B denoting the inorder traversal of the tree.

Output Format
Return the root node of the binary tree.

Example Input
Input 1:
 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:
 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]

Example Output
Output 1:
   1
  / \
 2   3
Output 2:
   1  
  / \
 6   2
    /
   3

Example Explanation
Explanation 1:
 Create the binary tree and return the root node of the tree.

 */


package com.example.demo.sclr_code.trees;

public class BinaryTreeFromInorderAndPreorder {

	public static void main(String[] args) {
		
	}
	
	public static TreeNode constructUsingPreAndInOrder(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
		if(preStart>preEnd) return null;
		int rootData = pre[preStart];
		TreeNode root = new TreeNode(rootData);
		int idxInInOrder = searchIndex(in, rootData);
		int lstLength = idxInInOrder-inStart;
		
		root.left = constructUsingPreAndInOrder(pre, preStart+1, preStart+lstLength, in, inStart, idxInInOrder-1);
		root.right = constructUsingPreAndInOrder(pre, preStart+lstLength+1, preEnd, in, idxInInOrder+1, inEnd);
		
		return root;
	}
	
	
	public static int searchIndex(int[] in,  int data) {
		for(int i=0; i<in.length; i++) {
			if(in[i] == data) {
				return i;
			}
		}
		return -1;
	}

}

















