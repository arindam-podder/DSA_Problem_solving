/*
 * Q1. Common Nodes in Two BST
Problem Description
Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
In case there is no common node, return 0.

NOTE:
Try to do it one pass through the trees.

Problem Constraints
1 <= Number of nodes in the tree A and B <= 105
1 <= Node values <= 106

Input Format
First argument represents the root of BST A.
Second argument represents the root of BST B.

Output Format
Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .

Example Input
Input 1:
 Tree A:
    5
   / \
  2   8
   \   \
    3   15
        /
        9

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11
      
Input 2:
  Tree A:
    7
   / \
  1   10
   \   \
    2   15
        /
       11
 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11

Example Output
Output 1:
 17
Output 2:
 46

Example Explanation
Explanation 1:
 Common Nodes are : 2, 15
 So answer is 2 + 15 = 17
Explanation 2:
 Common Nodes are : 7, 2, 1, 10, 15, 11
 So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46


 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class CommonNodesInTwoBST {

	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(12);
		TreeNode r2 = new TreeNode(12);
		
		System.out.println(commonNodeSum(r1, r2));
	}
	
	
	//approach 1 TC : (n * log n)
	public static int commonNodeSum(TreeNode A, TreeNode B) {
		HashSet<Integer> hs = new HashSet<>(); 
		inorder(A, hs);
		int mod = 1000000007;
		long ans = 0;
		Stack<TreeNode> st = new Stack<>();
		for( ; B != null || !st.isEmpty(); ) {
			if(B != null) {
				st.push(B); 
				B = B.left;
			}
			else {
				B = st.pop();
				if(hs.contains(B.val)) {
					ans = (ans%mod + B.val%mod)%mod;
				}
				B = B.right;
			}
		}
		return (int)ans;
	}

	
	//apoproach 2 , store both separately and use two pointer TC : (M+N)
	public static int findCommonSum(TreeNode A, TreeNode B) {
		//to do 
		
		return 0;
	}
	
	
	public static void inorder(TreeNode A, HashSet<Integer> hs) {
		if(A == null ) return;
		inorder(A.left, hs);
		hs.add(A.val); 
		inorder(A.right, hs);
	}
	
	public static void inorder(TreeNode A, ArrayList<Integer> list) {
		if(A == null ) return;
		inorder(A.left, list);
		list.add(A.val); 
		inorder(A.right, list);
	}
	
	
	
}


















