/*
 * Q1. N integers containing only 1, 2 & 3

Problem Description
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.

NOTE: All the A integers will fit in 32-bit integers.

Problem Constraints
1 <= A <= 29500

Input Format
The only argument given is integer A.

Output Format
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.

Example Input
Input 1:
 A = 3
Input 2:
 A = 7
 
Example Output
Output 1:
 [1, 2, 3]
Output 2:
 [1, 2, 3, 11, 12, 13, 21]

Example Explanation
Explanation 1:
 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
Explanation 2:
 Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */


package com.example.demo.sclr_code;

import java.util.ArrayList;
import java.util.LinkedList;

public class NintegersContainingOnly123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> solve(int A) {
        //edge case 
        if(A==1){
            ArrayList<Integer> ans = new ArrayList();
            ans.add(1); 
            return ans;
        }
        if(A==2){
            ArrayList<Integer> ans = new ArrayList();
            ans.add(1); 
            ans.add(2); 
            return ans;
        }
        if(A==3){
            ArrayList<Integer> ans = new ArrayList();
            ans.add(1); 
            ans.add(2); 
            ans.add(3); 
            return ans;
        }
        ArrayList<Integer> ans = new ArrayList(); 
        ans.add(1); 
        ans.add(2); 
        ans.add(3);
        LinkedList<Integer> que = new LinkedList();
        que.offerLast(1);
        que.offerLast(2);
        que.offerLast(3);
        while(!que.isEmpty()){
            Integer n = que.poll();
            // 1, 2 , 3 end of n
            que.offerLast( (n*10)+1 );      //1
            ans.add( (n*10)+1 );
            if(ans.size()==A){
                return ans;
            }

            que.offerLast( (n*10)+2 );      //2
            ans.add( (n*10)+2 );
            if(ans.size()==A){
                return ans;
            }

            que.offerLast( (n*10)+3 );         //3
            ans.add( (n*10)+3 );
            if(ans.size()==A){
                return ans;
            }
        }
        return null;
    }

}



















