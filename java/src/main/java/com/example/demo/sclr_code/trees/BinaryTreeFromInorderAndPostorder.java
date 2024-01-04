/*
 * Q2. Binary Tree From Inorder And Postorder

Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First argument is an integer array A denoting the inorder traversal of the tree.
Second argument is an integer array B denoting the postorder traversal of the tree.

Output Format
Return the root node of the binary tree.

Example Input
Input 1:
 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:
 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]

Example Output
Output 1:
   1
  / \
 2   3
Output 2:
   1  
  / \
 6   2
    /
   3

Example Explanation
Explanation 1:

Create the binary tree and return the root node of the tree.
 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;

public class BinaryTreeFromInorderAndPostorder {

	public static void main(String[] args) {
		
	}
	
	public TreeNode constructTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size()!=B.size()){
            return null;
        }
        TreeNode ans=builtTree(A,B, 0, A.size()-1, 0, B.size()-1);
        return ans;
    }
	
    //is:in-order start index,  ie=in-order end index, ps=post-order start index,  pe=post-order end index
    private TreeNode builtTree(ArrayList<Integer> A, ArrayList<Integer> B, int is, int ie, int ps, int pe){
        if(ps>pe || is>ie){
            return null;
        }
        //pe th value will be the root of the tree
        TreeNode rut=new TreeNode(B.get(pe));
        //search index of root node in inorder list
        int rootIndex=search(A,rut.val);
        //element on right 
        int elementsOnRight=ie-rootIndex;
        //Build tree of left side
        rut.left=builtTree(A,B,is, rootIndex - 1, ps, pe - elementsOnRight - 1);
        rut.right=builtTree(A,B,rootIndex + 1, ie, pe - elementsOnRight, pe - 1);
        return rut;
    }
    
    private int search(ArrayList<Integer> A, int target){
        for(int i=0;i<A.size();i++){
            if(A.get(i)==target){
                return i;
            }
        }
        return -1;

    }

}



















