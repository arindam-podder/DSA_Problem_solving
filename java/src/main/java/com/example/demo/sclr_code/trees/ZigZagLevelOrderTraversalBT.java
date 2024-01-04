/*
 * Q1. ZigZag Level Order Traversal BT
Problem Description
Given a binary tree, return the zigzag level order traversal of its nodes values. 
(ie, from left to right, then right to left for the next level and alternate between).

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

Example Input
Input 1:
    3
   / \
  9  20
    /  \
   15   7
Input 2:
   1
  / \
 6   2
    /
   3

Example Output
Output 1:
 [
   [3],
   [20, 9],
   [15, 7]
 ]
Output 2:
 [ 
   [1]
   [2, 6]
   [3]
 ]

Example Explanation
Explanation 1:
 Return the 2D array. Each row denotes the zigzag traversal of each level.

 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ZigZagLevelOrderTraversalBT {

	public static void main(String[] args) {

	}

	//go with simple level order traversal , then reverse odd position list    
		public static ArrayList<ArrayList<Integer>> zigzag(TreeNode root){
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); 
			LinkedList<TreeNode> que = new LinkedList<>();				//using it as queue 
			que.offerLast(root);
			while(!que.isEmpty()) {
				int levelSize = que.size(); 
				ArrayList<Integer> levelData = new ArrayList<>();
				for(int i=0; i<levelSize; i++) {
					TreeNode cur = que.pollFirst();
					levelData.add(cur.val);
					if(cur.left != null) {
						que.offerLast(cur.left);
					}
					if(cur.right != null) {
						que.offerLast(cur.right);
					}
				}
				ans.add(levelData);
			}
			
			//now reverse the odd idx arraylist
			for(int i=0; i<ans.size(); i++) {
				if( (i&1)==1 ) {
					Collections.reverse( ans.get(i));
				}
			}
			
			return ans;
		}
	
}






















