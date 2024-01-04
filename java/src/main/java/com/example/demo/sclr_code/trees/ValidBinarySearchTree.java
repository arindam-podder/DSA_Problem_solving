/*
 * Q1. Valid Binary Search Tree
 * 
Problem Description
You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.

Assume a BST is defined as follows:
1) The left subtree of a node contains only nodes with keys less than the node's key.
2) The right subtree of a node contains only nodes with keys greater than the node's key.
3) Both the left and right subtrees must also be binary search trees.


Problem Constraints
1 <= Number of nodes in binary tree <= 105
0 <= node values <= 2^32 -1

Input Format
First and only argument is head of the binary tree A.

Output Format
Return 0 if false and 1 if true.

Example Input
Input 1:
   1
  /  \
 2    3
Input 2:
  2
 / \
1   3

Example Output
Output 1:
 0
Output 2:
 1


Example Explanation
Explanation 1:
 2 is not less than 1 but is in left subtree of 1.
Explanation 2:
 Satisfies all conditions.
 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;

public class ValidBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(55); 
		TreeNode n1 = new TreeNode(40); 
		TreeNode n2 = new TreeNode(66); 
		root.left = n1; 
		root.right = n2; 
		
		System.out.println( isValidBST(root) );
		System.out.println( isBSTRecursion(root, 0, Integer.MAX_VALUE) );
	}

	public static int isValidBST(TreeNode A) {
		ArrayList<Integer> list = new ArrayList<>(); 
        inorderTraversal(A, list); 
        Integer last = list.get(0); 
        for(int i=1; i<list.size(); i++){
            if(last > list.get(i)){
            	return 0;
            }
            last = list.get(i);
        }
        return 1; 
    }

    //find valid bst using in order traversal 
    public static void inorderTraversal(TreeNode node , ArrayList<Integer> list){
        if(node == null) return; 
        inorderTraversal(node.left, list); 
        list.add(node.val); 
        inorderTraversal(node.right, list); 
    }
    
    public static boolean isBSTRecursion(TreeNode root, int start, int end) {			//observe this
    	if(root==null) return true; 
    	if(root.val >= start && root.val<=end ) {
    		boolean lst = isBSTRecursion(root.left, start, root.val-1); 
    		boolean rst = isBSTRecursion(root.right, root.val+1, end);
    		return (lst && rst);
    	}
    	return false;
    }
	
}







