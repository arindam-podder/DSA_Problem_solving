/*
 * Q1. Least Common Ancestor

Problem Description
Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.

Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) 
is the lowest (i.e., deepest) node that has both v and w as descendants.

Problem Constraints
1 <= size of tree <= 100000
1 <= B, C <= 109

Input Format
First argument is head of tree A.
Second argument is integer B.
Third argument is integer C.

Output Format
Return the LCA.

Example Input
Input 1:
      1
     /  \
    2    3
B = 2
C = 3
Input 2:
      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5

Example Output
Output 1:
 1
Output 2:
 2

Example Explanation
Explanation 1:
 LCA is 1.
Explanation 2:
 LCA is 2.
 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;

public class LeastCommonAncestorBT {

	public static void main(String[] args) {
		ArrayList<Integer> firstPath = new ArrayList<>();
		ArrayList<Integer> secondPath = new ArrayList<>(); 
		
		TreeNode root = new TreeNode(10); 
		TreeNode n1 = new TreeNode(12); 
		TreeNode n2 = new TreeNode(44); 
		root.right = n1;
		n1.right = n2;
		
	}
	
	//get path of given value 
	public boolean pathofRoot(TreeNode node, int a, ArrayList<Integer> list) {
		if(node == null) return false; 
		if(node.val == a ) { 
			list.add(node.val);
			return true; 
		}
		if( pathofRoot(node.left, a, list) == true) {
			list.add(node.val); 
			return true;
		}
		if( pathofRoot(node.right, a, list) == true ) {
			list.add(node.val);
			return true;
		}
		return false;
	}

}




















