/**
 * 1261. Find Elements in a Contaminated Binary Tree

Given a binary tree with the following rules:
root.val == 0
For any treeNode:
If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

Implement the FindElements class:
FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
bool find(int target) Returns true if the target value exists in the recovered binary tree.
 

Example 1:
Input
["FindElements","find","find"]
[[[-1,null,-1]],[1],[2]]
Output
[null,false,true]
Explanation
FindElements findElements = new FindElements([-1,null,-1]); 
findElements.find(1); // return False 
findElements.find(2); // return True 

Example 2:
Input
["FindElements","find","find","find"]
[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
Output
[null,true,true,false]
Explanation
FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
findElements.find(1); // return True
findElements.find(3); // return True
findElements.find(5); // return False

Example 3:
Input
["FindElements","find","find","find","find"]
[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
Output
[null,true,false,false,true]
Explanation
FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
findElements.find(2); // return True
findElements.find(3); // return False
findElements.find(4); // return False
findElements.find(5); // return True
 

Constraints:
TreeNode.val == -1
The height of the binary tree is less than or equal to 20
The total number of nodes is between [1, 104]
Total calls of find() is between [1, 104]
0 <= target <= 106
 */



package com.example.demo.leet_code;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.leet_code.LC572_SubtreeOfAnotherTree.TreeNode;

public class LC1261_FindElementsinContaminatedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//inner class 
	class FindElements {

	    Set<Integer> elements = new HashSet();

	    public FindElements(TreeNode root) {
	        if(root != null){
	            root.val = 0;
	            elements.add(0);
	            construct(root);
	        }
	    }
	    
	    //recursion
	    private void construct(TreeNode n){
	        if(n.left != null){
	            n.left.val = 2 * n.val + 1;
	            elements.add(n.left.val);
	            construct(n.left);
	        }
	        if(n.right != null){
	            n.right.val = 2 * n.val + 2;
	            elements.add(n.right.val);
	            construct(n.right);
	        }
	    }
	    
	    public boolean find(int target) {
	        return elements.contains(target);
	    }
	}


}
