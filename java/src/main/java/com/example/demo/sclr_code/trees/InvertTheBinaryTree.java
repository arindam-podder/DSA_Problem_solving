/*
 * Q1. Invert the Binary Tree
Problem Description
Given a binary tree A, invert the binary tree and return it.

Inverting refers to making the left child the right child and vice versa.

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only argument is the head of the tree A.

Output Format
Return the head of the inverted tree.

Example Input
Input 1:
     1
   /   \
  2     3
Input 2: 
     1
   /   \
  2     3
 / \   / \
4   5 6   7

Example Output
Output 1:
     1
   /   \
  3     2
Output 2: 
     1
   /   \
  3     2
 / \   / \
7   6 5   4

Example Explanation
Explanation 1:
Tree has been inverted.
Explanation 2:
Tree has been inverted.
 */


package com.example.demo.sclr_code.trees;

public class InvertTheBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode n1 = new TreeNode(12);
		TreeNode n2 = new TreeNode(14);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(7);
		root.left = n1; 
		root.right = n2; 
		n1.right = n3; 
		n2.left = n4;

		invertTree(root);
	}
	
	public static void invertTree(TreeNode node) {
		if(node == null ) return ; 
		TreeNode temp = node.left; 
		node.left = node.right;
		node.right = temp;
		invertTree(node.left);
		invertTree(node.right);
	}

}
















