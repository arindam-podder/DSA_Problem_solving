/*
 * Q4. Level Order

Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return a 2D integer array denoting the level order traversal of the given binary tree.

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
   [9, 20],
   [15, 7]
 ]
Output 2:
[ 
   [1]
   [6, 2]
   [3]
 ]

Example Explanation
Explanation 1:
 Return the 2D array. Each row denotes the traversal of each level.
 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10); 
		TreeNode n1 = new TreeNode(3); 
		TreeNode n2 = new TreeNode(44); 
		
		root.left = n1; 
		root.right = n2;
		//n1.left = n2; 
		
		System.out.println(leverOrderTraversal(root));
		
	}

	public static ArrayList<ArrayList<Integer>> leverOrderTraversal(TreeNode root){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); 
		LinkedList<TreeNode> queue = new LinkedList<>(); 
		queue.add(root); 
		
		while(queue.size() > 0) {
			int size = queue.size(); 
			ArrayList<Integer> levelData = new ArrayList<>(); 
			for(int i=0; i<size; i++) {
				TreeNode node = queue.pollFirst();
				levelData.add(node.val); 
				if(node.left != null) {
					queue.offerLast(node.left);
				}
				if(node.right != null) {
					queue.offerLast(node.right);
				}		
			}
			ans.add(levelData);
		}
		
		return ans;
		
	}
	
}
















