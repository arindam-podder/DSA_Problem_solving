/*
 * Q3. Deserialize Binary Tree

Problem Description
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:
In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.

Problem Constraints
1 <= number of nodes <= 105
-1 <= A[i] <= 105

Input Format
Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.

Output Format
Return the root node of the Binary Tree.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2:
 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]

Example Output
Output 1:
           1
         /   \
        2     3
       / \
      4   5
Output 2:
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


Example Explanation
Explanation 1:
 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.
Explanation 2:
 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class DeserializeBinaryTree {

	public static void main(String[] args) {
		
	}
	
	public static TreeNode deserialize(ArrayList<Integer> list) {
		TreeNode root = new TreeNode(list.get(0));
		LinkedList<TreeNode> que = new LinkedList<>();
		que.offerLast(root); 
		int index = 1; 
		while(!que.isEmpty()) {
			TreeNode cur = que.pollFirst();
			if(cur==null) {
				continue;
			}
			
			int leftVal = list.get(index); 
			int rightVal = list.get(index+1);
			index += 2; 
			if(leftVal == -1) {
				cur.left = null; 
			}else {
				cur.left = new TreeNode(leftVal);
			}
			if(rightVal == -1) {
				cur.right = null;
			}else {
				cur.right = new TreeNode(rightVal);
			}
			
			que.offerLast(cur.left);
			que.offerLast(cur.right);
		}
		return root;
	}

}












