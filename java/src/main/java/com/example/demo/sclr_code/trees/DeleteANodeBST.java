/*
 * Q4. Delete a node in BST

Problem Description
Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.
Note - If there are multiple options, always replace a node by its in-order predecessor

Problem Constraints
2 <= No. of nodes in BST <= 105
1 <= value of nodes <= 109
Each node has a unique value

Input Format
The first argument is the root node of a Binary Search Tree A.
The second argument is the value B.

Output Format
Delete the given node if found and return the root of the BST.

Example Input
Input 1:
            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8
     B = 10

Input 2:
            8
           / \
          6  21
         / \
        1   7
     B = 6

Example Output
Output 1:
            15
          /    \
        12      20
        / \    /  \
       8  14  16  27

Output 2:
            8
           / \
          1  21
           \
            7



Example Explanation
Explanation 1:

Node with value 10 is deleted 
Explanation 2:

Node with value 6 is deleted 
 */


package com.example.demo.sclr_code.trees;

public class DeleteANodeBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(44);
		TreeNode n1 = new TreeNode(30);
		TreeNode n2 = new TreeNode(60);
		TreeNode n3 = new TreeNode(35);
		TreeNode n4 = new TreeNode(58);
		root.left = n1;
		root.right = n2; 
		n1.right = n3;
		n2.left = n4;
		
		
		
	}
	
	public static TreeNode deleteNode(TreeNode root, int k){
		if(root.val > k ) {
			root.left = deleteNode(root.left, k);
		}
		if(root.val < k) {
			root.right = deleteNode(root.right, k);
		}
		else {		//when root data and k is equal 
			//1st : when root left and right empty 
			if(root.left == null && root.right == null) {
				return null;
			}
			//2nd : when root left has value and right is null 
			if(root.left != null && root.right == null) {
				return root.left;
			}
			//3rd : when root left is null value and right is null 
			if(root.left == null && root.right != null) {
				return root.right;
			}
			//4th : when root left and right both has value 
			int value = maxNode(root.left); 
			root.val = value;
			root.left = deleteNode(root.left, value);
		}
		return root;
	}
	
	
	public static int maxNode(TreeNode node) {
		int max = node.val;
		TreeNode temp = node;
		while(temp.right != null) {
			temp = temp.right; 
			max = temp.val;
		}
		return max;
	}
}


//public TreeNode solve(TreeNode A, int B) {
//    if(A == null) {
//        return null;
//    }
//    
//    if(A.val < B) {
//        A.right = solve(A.right, B);
//    }
//    else if(A.val > B) {
//        A.left = solve(A.left, B);
//    }
//    else {
//        // case 1: when A is a leaf leaf node 
//        if(A.left == null && A.right == null) {
//            return null;
//        }
//        // case 2; when A is having a single child 
//        else if(A.left == null) {
//            return A.right;
//        }
//        else if(A.right == null) {
//            return A.left;
//        }
//        else {
//            TreeNode max_left = max_left(A.left);
//            A.val = max_left.val; // replace the node value with the value of a node
//            // which contains the maximum value on left sub tree
//            A.left = solve(A.left, max_left.val); // remove the node which contains 
//            // max value in left sub tree 
//        }
//    }
//    return A;
//}
//
//public static TreeNode max_left(TreeNode A) {
//    while(A.right != null) {
//        A = A.right;
//    }
//    return A;
//}










