/*
 * Q3. Equal Tree Partition

Problem Description
Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of 
values after removing exactly one edge on the original tree.

Problem Constraints
1 <= size of tree <= 100000
0 <= value of node <= 109

Input Format
First and only argument is head of tree A.

Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.

Example Input
Input 1:
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:
                1
               / \
              2   10
                  / \
                 20  2


Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Remove edge between 5(root node) and 7: 
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6    
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:
 The given Tree cannot be partitioned.
 */

package com.example.demo.sclr_code.trees;

public class EqualTreePartition {

	public static void main(String[] args) {
		
	}

}



class Solution1 {
    public int solve(TreeNode A) {
        TreeNode root = A;
        long sum = calcSum( root );
        checkEqualPartitiom( A, sum );
        return ans;
    }

    long calcSum( TreeNode root )
    {
        if( root == null ) return 0;

        long lsum = calcSum( root.left );
        long rsum = calcSum( root.right );

        return (lsum + rsum + root.val );
    }

    int ans = 0;
    void checkEqualPartitiom( TreeNode root, long totalSum )
    {
        if( root == null ) return;

        long lsum = calcSum( root.left );
        long rsum = calcSum( root.right );

        if( lsum == totalSum /2 || rsum == totalSum /2 )
            ans = 1;

        if( ans == 1 )
            return;
           
        checkEqualPartitiom( root.left, totalSum );
        checkEqualPartitiom( root.right, totalSum );
    }
}
















