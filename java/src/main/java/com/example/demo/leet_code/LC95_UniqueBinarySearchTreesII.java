/**
 * 95. Unique Binary Search Trees II

Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes 
of unique values from 1 to n. Return the answer in any order.

Example 1:
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

Example 2:
Input: n = 1
Output: [[1]]
 

Constraints:
1 <= n <= 8

 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC95_UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		
	}
	
	
	 public static List<TreeNode> generateTrees1(int n) {
		 return generate(1, n);
		 
	 }
	 
	 
	 
	 public static List<TreeNode> generate(int l, int r){
		 List<TreeNode> list = new ArrayList<>();
		 //base case 
		 if(l>=r) {
			 if(l==r) {
				 list.add(new TreeNode(l));
			 }else {
				 list.add(null);
			 }
		 }
		 
		 for(int i=l; i<=r; i++) {
			 List<TreeNode> left = generate(l, i-1);
			 List<TreeNode> right = generate(i+1, r);
			 for(TreeNode lnode: left) {
				 for(TreeNode rnode: right) {
					 TreeNode root = new TreeNode(i);
					 root.left = lnode; 
					 root.right = rnode;
					 list.add(root);
				 }
			 } 
		 }
		 return list;
	 }
	 
	 
	 public static class TreeNode {
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










