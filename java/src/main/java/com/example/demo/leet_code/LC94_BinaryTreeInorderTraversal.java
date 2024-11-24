/**
 * 94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]
Explanation:


Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]
Explanation:

Example 3:
Input: root = []
Output: []


Example 4:
Input: root = [1]
Output: [1]

 
Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
Follow up: Recursive solution is trivial, could you do it iteratively?

 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC94_BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		
		root.left = two; 
		root.right = three; 
		
		two.left = four; 
		two.right = five; 
		
		five.right = six;
		
		
		System.out.println( inorderTraversal(root) );
		System.out.println( morrishInorder(root) );
	}
	
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursionInOrderTraversal(root, result);
        return result;
    }
	
	
	public static void recursionInOrderTraversal(TreeNode node, List<Integer> list) {
		if(node == null ) return;
		
		recursionInOrderTraversal(node.left, list);
		list.add(node.val); 
		recursionInOrderTraversal(node.right, list);
	}
	
	
	public static List<Integer>	morrishInorder(TreeNode root){
		List<Integer> result = new ArrayList<>(); 
		TreeNode cur = root; 
		while(cur != null) {
			if(cur.left == null) {
				result.add(cur.val);
				cur = cur.right; 
			}else {
				//if left present , before moving to left, create thread(left subtree most right elemnt.right = cur)
				TreeNode temp = cur.left; 
				while(temp.right != null && temp.right != cur) {
					temp = temp.right; 
				}
				
				//create thread 
				if(temp.right == null) {
					temp.right = cur;
					cur = cur.left; 
				}else {	//if already thread created 
					temp.right = null;   //thread close 
					result.add(cur.val); 
					cur = cur.right;
				}
			}
		}//while end
		return result; 
	}
	
	
	static class TreeNode {
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
