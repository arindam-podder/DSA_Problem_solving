/*
 * Q4. Top View of Binary tree

Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
Return the nodes in any order.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an array, representing the top view of the binary tree.

Example Input
Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Input 2: 
            1
           /  \
          2    3
           \
            4
             \
              5

Example Output
Output 1:
 [1, 2, 4, 8, 3, 7]
Output 2:
 [1, 2, 3]

Example Explanation
Explanation 1:
Top view is described.
Explanation 2:
Top view is described.

 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class TopViewBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Integer> topView(TreeNode node){
		//LinkedList<TreeNode> que = new LinkedList<>();
		TreeNode temp = node; 
		//que.offerLast(temp);
		ArrayList<Integer> ans = new ArrayList<>(); 
		ans.add(temp.val);
		while(temp.left != null) {
			temp = temp.left; 
			ans.add(temp.val);
		}
		temp = node;
		while(temp.right != null) {
			temp = temp.right; 
			ans.add(temp.val);
		}
		return ans;
	}
	
	
}














