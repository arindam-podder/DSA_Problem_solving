/*
 * 863. All Nodes Distance K in Binary Tree

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes
that have a distance k from the target node.

You can return the answer in any order.

 
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

Example 2:
Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:
The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
 */



package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.example.demo.leet_code.LC863_AllNodesDistanceKBinaryTree.TreeNode;

public class LC863_AllNodesDistanceKBinaryTree {

	public static void main(String[] args) {

	}
	
	//do bfs/dfs and keep parent map 
	//then from target do BFS for distance check , when distance = k then return all node on that distance 
    public static List<Integer> distanceK1(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = parentMapUsingBFS(root);
        
        // distance check - level order BFS logic start from target
        Set<TreeNode> visited = new HashSet<>(); 
        int dis = 0 ;
        Queue<TreeNode> que = new LinkedList<>(); 
        que.add(target);
        visited.add(target);
        while(!que.isEmpty() && dis<k) {
        	int curSize  = que.size(); 
        	for(int i=0; i<curSize; i++) {
        		TreeNode node = que.poll();
        		if(node.left != null && !visited.contains(node.left)) {
        			que.add(node.left);
        			visited.add(node.left);
        		}
        		if(node.right != null && !visited.contains(node.right)) {
        			que.add(node.right);
        			visited.add(node.right);
        		}
        		//parent 
        		if(parentMap.get(node) != null && !visited.contains(parentMap.get(node))) {
        			que.add(parentMap.get(node)); 
        			visited.add(parentMap.get(node));
        		}
        	}//for end
        	dis += 1;
        	
        }//while end 
        
        //while distance = k , whatever there in queue will be 
        List<Integer> result = new ArrayList<>(); 
        while(!que.isEmpty()) {
        	result.add(que.poll().val);
        }
        return result;
     
    }
    
    
    //use queue
    public static Map<TreeNode, TreeNode> parentMapUsingBFS(TreeNode root) {
    	//child - parent 
    	Map<TreeNode, TreeNode> parentMap = new HashMap<>(); 
    	parentMap.put(root, null); 
    	Queue<TreeNode> que = new LinkedList<>(); 
    	que.add(root); 
    	while(!que.isEmpty()) {
    		TreeNode node = que.poll();
    		if(node.left != null) {
    			parentMap.put(node.left, node); 
    			que.add(node.left); 
    		}
    		if(node.right != null) {
    			parentMap.put(node.right, node);
    			que.add(node.right);
    		}
    	}
    	
    	return parentMap;
    }
    
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    

}
