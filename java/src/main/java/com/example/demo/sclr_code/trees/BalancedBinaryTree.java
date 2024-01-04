/*
 * Q3. Balanced Binary Tree
Problem Description
Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Problem Constraints
1 <= size of tree <= 100000

nput Format
First and only argument is the root of the tree A.

Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Example Input
Input 1:
    1
   / \
  2   3
Input 2:
       1
      /
     2
    /
   3

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
It is a complete binary tree.
Explanation 2:
Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
Difference = 2 > 1. 
 */


package com.example.demo.sclr_code.trees;

public class BalancedBinaryTree {

	public static boolean isBalanced = true;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10); 
		TreeNode n1 = new TreeNode(10); 
		TreeNode n2 = new TreeNode(10); 
		
		root.left = n1; 
		root.right = n2;
		//n1.left = n2; 

		checkTreeIsBalanced(root); 
		
		System.out.println(isBalanced);
	}
	
	public static int checkTreeIsBalanced(TreeNode node) {
		if(node == null) return 0;
		int lst = checkTreeIsBalanced(node.left); 
		int rst = checkTreeIsBalanced(node.right);
		
		if(Math.abs(lst-rst) > 1) {
			isBalanced = false; 
		}
		
		return (Math.max(lst,rst) + 1 ) ; 
	}
}




























