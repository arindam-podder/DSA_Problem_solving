/**
 * 104. Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest 
leaf node.

 
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2
 
Constraints:
The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */



package com.example.demo.leet_code;

import java.util.LinkedList;
import java.util.Queue;

public class LC104_MaximumDepthBinaryTree {

	public static void main(String[] args) {
		

	}
	
	
	//approach 1 : level order traversal 
	public static int levelOrder(TreeNode root) {
		if(root ==null) return 0;
		int result = 0;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root); 
		
		
		while(!que.isEmpty()) {
			result ++; 
			
			int curQueSize = que.size(); 
			//pop all element from que of curSize , append the child of all pop element 
			for(int i=1; i<=curQueSize; i++) {
				TreeNode ele = que.poll();
				if(ele.left != null) que.add(ele.left);
				if(ele.right != null) que.add(ele.right);
			}
			
		}
		
		return result; 
	} 
	
	
	//approach 2 : recursion depth wise
	public static int depthRecur(TreeNode root) {
		//base 
		if(root == null) return 0;
		
		int lhs = depthRecur(root.left);
		int rhs = depthRecur(root.right);
		
		return 1+ Math.max(lhs, rhs);
		
	}
	
	
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
		    this.left = left;
		    this.right = right;
		}
	}

}


