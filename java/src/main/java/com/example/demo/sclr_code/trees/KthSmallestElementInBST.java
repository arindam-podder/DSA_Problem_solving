package com.example.demo.sclr_code.trees;

public class KthSmallestElementInBST {
	
	int count = 0; 
    int ans = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 
	    public int kthsmallest(TreeNode A, int B) {
	        kThValue(A, B); 
	        return ans;
	    }

	    public void kThValue(TreeNode node , int B){
	        if(node == null ) return ;
	        kThValue(node.left, B);
	        count ++ ; 
	        if(count == B){
	            ans = node.val;
	        }
	        kThValue(node.right, B);
	    }

}
