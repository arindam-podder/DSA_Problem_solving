/*
 * Q1. Check for BST with One Child

Problem Description
Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal 
of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.

Problem Constraints
1 <= number of nodes <= 100000

Input Format
First and only argument is an integer array denoting the preorder traversal of binary tree.

Output Format
Return a string "YES" if true else "NO".

Example Input
Input 1:
 A : [4, 10, 5, 8]
Input 2:
 A : [1, 5, 6, 4]

Example Output
Output 1:
 "YES"
Output 2:
 "NO"

Example Explanation
Explanation 1:
 The possible BST is:
            4
             \
             10
             /
             5
              \
              8
Explanation 2:
 There is no possible BST which have the above preorder traversal.
 */


package com.example.demo.sclr_code.trees;

public class CheckForBSTwithOneChild {

	public static void main(String[] args) {
		
	}

	public static boolean possibleBST(int[] arr) {
		int left = Integer.MIN_VALUE;
		int right = Integer.MAX_VALUE;
		int rootVal = arr[0]; 
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > rootVal) {
				left = rootVal;
			}else {
				right = rootVal;
			}
			
			if(arr[i] < left || arr[i] < right) {
				return false;
			}
			rootVal = arr[i]; 
		}
		return true;
				
	}
	
}

















