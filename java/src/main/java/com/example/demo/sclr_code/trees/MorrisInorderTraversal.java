/*
 * Q2. Morris Inorder Traversal
Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.
NOTE: Using recursion and stack are not allowed.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

Example Input
Input 1:
   1
    \
     2
    /
   3
Input 2:
   1
  / \
 6   2
    /
   3

Example Output
Output 1:
 [1, 3, 2]
Output 2:
 [6, 1, 3, 2]

Example Explanation
Explanation 1:
 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:
 The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */

package com.example.demo.sclr_code.trees;

import java.util.ArrayList;

public class MorrisInorderTraversal {

	public static void main(String[] args) {
	
	}

	public static  ArrayList<Integer> morrisInOrder(TreeNode node){
		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode cur = node; 
		while(cur != null) {
			if(cur.left == null) {
				ans.add(cur.val); 
				cur = cur.right;
			}
			else {
				TreeNode temp = cur.left; 
				while(temp.right != null && temp.right!= cur) {
					temp= temp.right;
				}
				
				if(temp.right == null) {
					temp.right = cur; 
					cur = cur.left;
				}
				else if(temp.right == cur) {
					temp.right = null; 
					ans.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return ans;
	}
	
}




















