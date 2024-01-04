/*
 * in order traversal in iterative approach 
 */


package com.example.demo.sclr_code.trees;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10); 
		TreeNode n1 = new TreeNode(5); 
		TreeNode n2 = new TreeNode(12); 
		TreeNode n3 = new TreeNode(11);
		root.left = n1; 
		root.right = n2;
		n2.left = n3;
		
		System.out.println(iterativeInorder(root));
		
	}
	
	public static ArrayList<Integer> iterativeInorder(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		
		for( ; root != null || !st.isEmpty(); ) {
			if(root != null) {
				st.push(root); 
				root = root.left;
			}
			else {
				root = st.pop();
				ans.add(root.val); 
				root = root.right;
			}
		}
		
		return ans;
	}
	

}
