/*
 * Q4. Diameter of binary tree
Problem Description
Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
The diameter of a tree is the number of edges on the longest path between two nodes in the tree.

Problem Constraints
0 <= N <= 105

Input Format
First and only Argument represents the root of binary tree A.

Output Format
Return an single integer denoting the diameter of the tree.

Example Input
Input 1:
           1
         /   \
        2     3
       / \
      4   5
Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6

Example Output
Output 1:
 3
Output 2:
 4

Example Explanation
Explanation 1:
 Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
Explanation 2:
 Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
 */


package com.example.demo.sclr_code.trees;

public class DiameterBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution {
    int ans = Integer.MIN_VALUE;
    public int solve(TreeNode A) {
        height(A);
        return ans;
    }
    public int height(TreeNode A){
        if(A == null){
            return -1;
        }

        int leftHeight = height(A.left);
        int rightHeight = height(A.right);

        ans = Math.max(ans,leftHeight+rightHeight+2);
        return Math.max(leftHeight,rightHeight)+1;
    }
}

// public class Solution {
//     public int solve(TreeNode A) {
//         Pair ans =  dia(A); 
//         return ans.dia;
//     }


//     public Pair dia(TreeNode node){
//         if(node == null ) new Pair(-1, 0); 
        
//         Pair left = dia(node.left);
//         Pair right = dia(node.right); 

//         Pair np = new Pair();
//         np.ht = Math.max(left.ht, right.ht) + 1;
//         np.dia = Math.max( Math.max(left.dia, right.dia), left.ht+right.ht+2);

//         return np;
//     }
// }

// class Pair{
//     int ht; 
//     int dia; 
//     Pair(){

//     }
//     Pair(int h, int d){
//         ht = h; 
//         dia = d;
//     }
// }














