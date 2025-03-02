/**
 * 1028. Recover a Tree From Preorder Traversal

We run a preorder depth-first search (DFS) on the root of a binary tree.
At each node in this traversal, we output D dashes (where D is the depth of this node), 
then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  
The depth of the root node is 0.

If a node has only one child, that child is guaranteed to be the left child.
Given the output traversal of this traversal, recover the tree and return its root.

 

Example 1:
Input: traversal = "1-2--3--4-5--6--7"
Output: [1,2,5,3,4,6,7]

Example 2:
Input: traversal = "1-2--3---4-5--6---7"
Output: [1,2,5,3,null,6,null,4,null,7]
Example 3:


Input: traversal = "1-401--349---90--88"
Output: [1,401,null,349,88,90]
 

Constraints:
The number of nodes in the original tree is in the range [1, 1000].
1 <= Node.val <= 109
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.leet_code.LC572_SubtreeOfAnotherTree.TreeNode;

public class LC1028_RecoverTreeFromPreorderTraversal {
	public static void main(String[] args) {
		String s = "1-401--349---90--88";
		System.out.println(  recoverTreeFromPreorder(s) );
	}
	
	
	//just maintain a map to maintain the all level data 
	public static TreeNode recoverTreeFromPreorder(String traversal) {
		if (traversal.charAt(0) == '-') return null; 
		
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        int n = getTheNum(0, traversal);
        TreeNode head = new TreeNode(n);
        map.put(0, new ArrayList<TreeNode>());
        map.get(0).add(head); 
        
        int d = 0;
        int i = String.valueOf(n).length();
        while(i<traversal.length()) {
        	if(traversal.charAt(i) == '-') {
        		d += 1;
        		i++;
        	}
        	else {
        		int curNum = getTheNum(i, traversal);
        		TreeNode node = new TreeNode(curNum);
        		TreeNode parent = map.get(d-1).get( map.get(d-1).size()-1 );
        		if(!map.containsKey(d)) {
        			map.put(d, new ArrayList<>());
        		}
        		map.get(d).add(node);
        		
        		if(parent.left == null) parent.left = node;
        		else parent.right = node;
        		
        		d = 0;
        		i += String.valueOf(curNum).length();
        	}
        	
        }
        
	
        return head; 
	}	
	public static int getTheNum(int i, String s) {
		String num = "";
		while(i<s.length() && s.charAt(i) != '-') {
			num += s.charAt(i);
			i++;
		}
		return Integer.valueOf(num);
	}
	
}















