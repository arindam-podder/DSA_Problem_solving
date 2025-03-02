/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal

Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of 
distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.

Example 1:
Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

Example 2:
Input: preorder = [1], postorder = [1]
Output: [1]
 
Constraints:
1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
All the values of preorder are unique.
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
All the values of postorder are unique.
It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.
 */


package com.example.demo.leet_code;

import java.util.Currency;

import com.example.demo.leet_code.LC572_SubtreeOfAnotherTree.TreeNode;

public class LC889_ConstructBinaryTreefromPreorderPostorderTraversal {
	private static int pre = 0; 
	private static int post = 0; 
	
	
	public static void main(String[] args) {
		
	}
	
	//100%
	public static TreeNode construct(int[] preorder, int[] postorder) {
		TreeNode node = new TreeNode(preorder[pre]);
		pre += 1;
		
		if(node.val != postorder[post]) {
			node.left = construct(preorder, postorder); 
		}
		if(node.val != postorder[post]) {
			node.right = construct(preorder, postorder);
		}
		
		post += 1; 
		return node;
	}
	
}
