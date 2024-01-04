/*
 *Q1. Right View of Binary tree

Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an array, representing the right view of the binary tree.

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
 [1, 3, 7, 8]
Output 2:
 [1, 3, 4, 5]

Example Explanation
Explanation 1:

Right view is described.
Explanation 2:

Right view is described. 
 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class RightViewOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4); 
		TreeNode l = new TreeNode(8); 
		TreeNode r = new TreeNode(5);
		root.left = l ;
		root.right = r ;

		System.out.println(rightView(root));
		
	}
	
	public static ArrayList<Integer> rightView(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>(); 
		LinkedList<TreeNode> queue = new LinkedList<>(); 
		queue.offerLast(root); 
		while(queue.size() > 0) {
			int size = queue.size(); 
			for(int i=1; i<=size; i++) {
				TreeNode node = queue.pollFirst();
				
				if(i==size) {
					ans.add(node.val);
				}
				
				if(node.left != null) {
					queue.offerLast(node.left);
				}
				if(node.right != null) {
					queue.offerLast(node.right);
				}
			}
		}
		
		return ans; 
	}

}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
    TreeNode(int x) {
	   val = x;
	   left=null;
	   right=null;
    }
}