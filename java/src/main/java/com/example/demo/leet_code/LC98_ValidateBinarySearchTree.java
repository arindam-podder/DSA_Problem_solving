/**
 * 98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys strictly less than the node's key.
The right subtree of a node contains only nodes with keys strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:
Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */


package com.example.demo.leet_code;

import java.util.LinkedList;
import java.util.Queue;

import com.example.demo.leet_code.LC863_AllNodesDistanceKBinaryTree.TreeNode;
import com.example.demo.leet_code.LC98_ValidateBinarySearchTree.NodeRange;

public class LC98_ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2); 
		TreeNode n1 = new TreeNode(2); 
		root.left = n1; 
		
		System.out.println( isValidBST1(root) );
		

	}
	
	//play with range that a node can lies - start with root(reange - intMin to intMax)
    public static boolean isValidBST1(TreeNode root) {
    	return useBFS(root);
    }
	
    
    
    private static boolean useBFS(TreeNode root) {
    	Queue<NodeRange> que = new LinkedList<>(); 
    	que.add(new NodeRange(root, Long.MIN_VALUE, Long.MAX_VALUE)); 
    	while(!que.isEmpty()) {
    		//poll and validate node val is in the range or not
    		NodeRange poll = que.poll();
    		if(poll.node.val<= poll.min || poll.node.val >= poll.max) {
    			return false; 
    		}
    		
    		//left child 
    		if(poll.node.left != null) {
    			que.add(new NodeRange(poll.node.left, poll.min, poll.node.val)); 
    		}
    		//right child
    		if(poll.node.right != null) {
    			que.add(new NodeRange(poll.node.right, poll.node.val, poll.max)); 
    		}
    		
    	}
    	
		return true;
	}

    
    public static class NodeRange{
    	TreeNode node; 
    	long min; 
    	long max; 
    	public NodeRange(TreeNode node, long l, long r) {
    		this.node = node; 
    		min = l; 
    		max = r;
		}
    }


}
