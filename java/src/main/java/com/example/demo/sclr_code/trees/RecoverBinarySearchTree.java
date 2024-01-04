/*
 * Q4. Recover Binary Search Tree

Problem Description
Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake. 
Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).

A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?

Note: The 2 values must be returned in ascending order

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only argument is the head of the tree,A

Output Format
Return the 2 elements which need to be swapped.

Example Input
Input 1:
         1 
        / \ 
       2   3
Input 2:
         2
        / \
       3   1



Example Output
Output 1:
 [2, 1]
Output 2:
 [3, 1]

Example Explanation
Explanation 1:
Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 
Explanation 2:
Swapping 1 and 3 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 
 */


package com.example.demo.sclr_code.trees;

public class RecoverBinarySearchTree {
	
	private TreeNode left;
    private TreeNode right;
    private TreeNode prev;
    
    public static void main(String[] args) {
		
	}
    
    public int[] recoverTree(TreeNode root) {
        int[] res = new int[2];
        dfs(root);
        if (left == null) return res;
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        res[0] = left.val;
        res[1] = right.val;
        return res;
    }
    
    private void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (prev != null) {
            if (node.val < prev.val) {
                if (left == null) {
                    left = prev;
                    right = node;
                } else {
                    right = node;
                }
            }
        }
        prev = node;
        dfs(node.right);
    }
    
}














