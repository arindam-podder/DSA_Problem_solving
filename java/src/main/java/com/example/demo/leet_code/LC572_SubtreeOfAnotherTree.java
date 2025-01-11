/**
 * 572. Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same 
structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. 
The tree tree could also be considered as a subtree of itself.

 

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:
The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104

 */


package com.example.demo.leet_code;

public class LC572_SubtreeOfAnotherTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3); 
		TreeNode n1 = new TreeNode(4); 
		TreeNode n2 = new TreeNode(5); 
		TreeNode n3 = new TreeNode(1); 
		TreeNode n4 = new TreeNode(2); 
		root.left = n1; root.right = n2; n1.left = n3; n1.right = n4; 
		
		TreeNode sub = new TreeNode(4);  
		TreeNode s1 = new TreeNode(1); 
		TreeNode s2 = new TreeNode(2);
		sub.left = s1; sub.right = s2; 
		
		System.out.println(  preTraverseMainAndFindSub(root, sub) );
	}
	
	
	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return false; 
    }
	
	public static boolean preTraverseMainAndFindSub(TreeNode root, TreeNode sub) {
		if(root == null) return false;
		
		if(check(root, sub)) {
			 return true;
		}
		
		return preTraverseMainAndFindSub(root.left, sub) || preTraverseMainAndFindSub(root.right, sub);
	}
	
	public static boolean check(TreeNode main, TreeNode sub) {
        if (main == null && sub == null) {
            return true;
        }
        if (main == null || sub == null || main.val != sub.val) {
            return false;
        }
		
		else return check(main.left, sub.left) && check(main.right, sub.right);
		
	}
	
	
	
	//inner class 
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














