/*
 * Q2. Vertical Order traversal
 * 
Problem Description
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints
0 <= number of nodes <= 105



Input Format
First and only arument is a pointer to the root node of binary tree, A.



Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

      1
    /   \
   3     7
  /       \
 2         9


Example Output
Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation
Explanation 1:

 First row represent the verical line 1 and so on.
 */

package com.example.demo.sclr_code.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4); 
		TreeNode l = new TreeNode(8); 
		TreeNode r = new TreeNode(5);
		root.left = l ;
		root.right = r ;
		System.out.println( verticalOrderTraversal(root) );
	}
	
	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
	     HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
	     LinkedList<Pair> queue = new LinkedList<>(); 	//act as queue
	     Pair pair = new Pair(A, 0); 
	     queue.offerLast(pair); 
	     
	     while(queue.size() > 0) {
	    	 Pair currentPair = queue.pollFirst(); 
	    	 if(currentPair.node.left != null) {
	    		 Pair left = new Pair(currentPair.node.left, currentPair.index-1);
	    		 queue.offerLast(left);
	    	 }
	    	 if(currentPair.node.right != null) {
	    		 Pair right = new Pair(currentPair.node.right, currentPair.index+1);
	    		 queue.offerLast(right);
	    	 }
	    	 
	    	 if(hm.containsKey(currentPair.index)) {
	    		 hm.get(currentPair.index).add(currentPair.node.val);
	    	 }else {
	    		 ArrayList<Integer> list = new ArrayList<>(); 
	    		 list.add(currentPair.node.val); 
	    		 hm.put(currentPair.index, list);
	    	 }
	     }
	     
	     ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); 
	     Integer max = Collections.max(hm.keySet());
	     Integer min = Collections.min(hm.keySet());
	     
	     for(int i=min; i<=max; i++) {
	    	 ans.add(hm.get(i));
	     }
	     
	     return ans;
	}

}//class end


class Pair{
	TreeNode node; 
	Integer index; 
	Pair(TreeNode tn, Integer n) {
		this.node = tn; 
		this.index = n;
	}
}


















