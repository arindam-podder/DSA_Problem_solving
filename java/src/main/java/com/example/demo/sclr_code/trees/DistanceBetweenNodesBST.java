/*
 * Q2. Distance between Nodes of BST

Problem Description
Given a binary search tree.
Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.
NOTE: Distance between two nodes is number of edges between them.

Problem Constraints
1 <= Number of nodes in binary tree <= 1000000
0 <= node values <= 109

Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.

Output Format
Return an integer denoting the distance between two nodes with given two keys B and C

Example Input
Input 1:
         5
       /   \
      2     8
     / \   / \
    1   4 6   11
 B = 2
 C = 11
Input 2:
         6
       /   \
      2     9
     / \   / \
    1   4 7   10
 B = 2
 C = 6

Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:
 Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
Explanation 2:

 Path between 2 and 6 is: 2 -> 6. Distance will be 1
 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;

public class DistanceBetweenNodesBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(6);
		root.left = n1;
		n1.right = n2;
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(55);
		TreeNode n5 = new TreeNode(1);
		root.right = n3;
		n3.left = n4;
		n3.right = n5;
		
		System.out.println( totalEdgesBetweenTwo(root, 4, 10) );
	}

	//appoach : find root to data path , then check the distance of two node from LCA , add it and return (Dry run it or try to visualize this)
	public static int totalEdgesBetweenTwo(TreeNode root, int A, int B) {
		ArrayList<Integer> pathA = new ArrayList<>();
		data_to_root_path(root, A, pathA); 
		
		ArrayList<Integer> pathB = new ArrayList<>();
		data_to_root_path(root, B, pathB);
		
		int p1 = pathA.size()-1;
		int p2 = pathB.size()-1; 
		int ans = 0;
		while(p1>=0 && p2>=0) {
			if(pathA.get(p1) == pathB.get(p2)) {
				ans = p1+p2;
			}
			p1--;
			p2--;
		}
		return ans;
	}
	
	
	public static boolean data_to_root_path(TreeNode root, int data, ArrayList<Integer> path) {
		if(root==null) return false;
		
		if(root.val == data) {
			path.add(root.val); 
			return true;
		}
		
		if(data_to_root_path(root.left, data, path) == true) {
			path.add(root.val);
			return true;
		}
		
		if(data_to_root_path(root.right, data, path) == true) {
			path.add(root.val);
			return true;
		}
		
		return false;		
	}
	
	
}















