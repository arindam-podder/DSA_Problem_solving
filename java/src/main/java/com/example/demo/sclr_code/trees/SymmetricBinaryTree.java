/*
 * Q1. Symmetric Binary Tree

Problem Description
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is the root node of the binary tree.

Output Format
Return 0 / 1 ( 0 for false, 1 for true ).

Example Input
Input 1:
    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:
    1
   / \
  2   2
   \   \
   3    3

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 The above binary tree is symmetric. 
Explanation 2:
The above binary tree is not symmetric.
 */


package com.example.demo.sclr_code.trees;

public class SymmetricBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7); 
		TreeNode n1 = new TreeNode(7); 
		root.left = n1;
		
		System.out.println(checkSymmetric(root, root));	

	}
	
	public static Boolean checkSymmetric(TreeNode leftHalf, TreeNode rightHalf) {
		if(leftHalf==null || rightHalf==null) {
			return leftHalf==rightHalf;
		}
		
		if(leftHalf.val != rightHalf.val) {
			return false;
		}
		
		return checkSymmetric(leftHalf.left, rightHalf.right) && checkSymmetric(leftHalf.right, rightHalf.left);
	}

}
