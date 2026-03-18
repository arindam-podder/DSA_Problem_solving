/*
 *Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */

package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.demo.leet_code.LC236_LowestCommonAncestorBinaryTree.TreeNode;

public class LC236_LowestCommonAncestorBinaryTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2;  n1.right=n3;  n3.left = n4;
		
		TreeNode lowestCommonAncestor1 = lowestCommonAncestor1(n1, n2, n4);
		System.out.println( lowestCommonAncestor1.val );
		
	}
	
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    	Map<TreeNode, TreeNode> nodeParent = new HashMap<>(); 
    	BFS(root, null, nodeParent);
    	
    	//now check close parent for both p, q, use set , add firt p's parent then chek with q parent 
    	Set<TreeNode> parents = new HashSet<>(); 
    	while(p != null) {
    		parents.add(p);
    		p = nodeParent.get(p); 	
    	}
    	
    	while(q!=null) {
    		if(parents.contains(q)) {
    			return q;
    		}
    		q = nodeParent.get(q);
    	}
    	
    	return root;
    }
    
    //this is to fill node -> parent map data 
    public static void BFS(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> nodeParent) {
    	if(node == null) return; 
    	
    	nodeParent.put(node, parent); 	//node parent map fill 
    	//left deep dive 
    	BFS(node.left, node, nodeParent);
    	//right deep dive
    	BFS(node.right, node, nodeParent);
    }
	
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
		
		@Override
		public String toString() {
			return ""+val+"";
		}
	}

}
