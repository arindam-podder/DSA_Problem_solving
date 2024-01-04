/*
 * Q2. Maximum XOR Subarray

Problem Description
Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.

NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.

Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 109

Input Format
First and only argument is an integer array A.

Output Format
Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.

Example Input
Input 1:
 A = [1, 4, 3]
Input 2:
 A = [8]

Example Output
Output 1:
 [2, 3]
Output 2:
 [1, 1]


Example Explanation
Explanation 1:
 There are 6 possible subarrays of A:
 subarray            XOR value
 [1]                     1
 [4]                     4
 [3]                     3
 [1, 4]                  5 (1^4)
 [4, 3]                  7 (4^3)
 [1, 4, 3]               6 (1^4^3)

 [4, 3] subarray has maximum XOR value. So, return [2, 3].
Explanation 2:

 There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1]. 
 */


package com.example.demo.sclr_code.trie;

import java.util.ArrayList;

public class MaximumXORSubarray {

	public static void main(String[] args) {
		int[] arr = {28, 31, 13, 22, 17, 22}; 
		
		System.out.println( subarrayMaxXor(arr));
	}
	
	
	public static int subarrayMaxXor(int[] arr) {
		int ans = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				int start = i; 
				int end = j;
				int cur = arr[i]; 
				for(int k=i+1; k<=j; k++) {
					cur = cur^arr[k];
				}
				ans = Math.max(ans, cur);
			}
		}
		return ans;
	}

}




class Solution {

    class TrieNode{
        int index=-1;
        TrieNode[] nodes=new TrieNode[2];
        int data=-1;
        TrieNode(int val){
            data=val;
        };
    };
   
    public void createTree(TrieNode root,int val,int _index_){
        TrieNode curr=root;
        for(int i=31;i>=0;i--){
            int digit=(val&(1<<i));
            if(digit>=1){
                if(curr.nodes[1]==null){curr.nodes[1]=new TrieNode(1);};
                curr=curr.nodes[1];
            }else{
                if(curr.nodes[0]==null){curr.nodes[0]=new TrieNode(0);};
                curr=curr.nodes[0];
            };
        };
        curr.index=_index_;
    };

    public int[] findXor(TrieNode root,int number){
        TrieNode curr=root;
        int xor_output=0;
        for(int i=31;i>=0;i--){
                int digit=(number&(1<<i));
                if(digit>=1){

                    //If it is 1 , check for 0;
                    if(curr.nodes[0]!=null){
                        xor_output=xor_output|(1<<i);
                        curr=curr.nodes[0];
                    }else{
                        curr=curr.nodes[1];
                    };

                }else{

                    //If it is 0 ,check for 1;
                    if(curr.nodes[1]!=null){
                        xor_output=xor_output|(1<<i);
                        curr=curr.nodes[1];
                    }else{
                        curr=curr.nodes[0];
                    };

                };
            };


        int[] x=new int[2]; //1--> value 2---> index
        x[0]=xor_output;
        x[1]=curr.index;
        return x;
    };

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> prefixXor=new ArrayList<>();

        //Create a prefix Xor Array

        prefixXor.add(A.get(0));
        for(int i=1;i<A.size();i++){
            prefixXor.add(prefixXor.get(i-1)^A.get(i));
        };

        //Create a Trie and insert 0 as value with -1 as index

        TrieNode root=new TrieNode(-1);
        createTree(root,0,-1);
        int maxXor=Integer.MIN_VALUE;
        int length=-1;
        ArrayList<Integer> start_end_index=new ArrayList<Integer>(){{
            add(-1);
            add(-1);
        }};

        //Where ever we are there is the end point
        //We are iterating for every element
           // --> endpoint= current position
           // --> start point we are finding by inversing bit flip , once we got the apt one get the index
           // we can use to calculate length

        for(int i=0;i<prefixXor.size();i++){
            int[] temp=findXor(root,prefixXor.get(i));
            int xor_value=temp[0];
            int start_index=temp[1];
            //System.out.println(xor_value+" "+start_index);
            int calc_length=i-(start_index+1)+1;
            if(xor_value>maxXor){
                maxXor=xor_value;
                start_end_index.set(0,start_index+1);
                start_end_index.set(1,i);
                length=calc_length;
            }else if(xor_value==maxXor){
                if(calc_length<length){
                    start_end_index.set(0,start_index+1);
                    start_end_index.set(1,i);
                    length=calc_length;
                }else if(calc_length==length){
                    if((start_index+1)<start_end_index.get(0)){
                    start_end_index.set(0,start_index+1);
                    start_end_index.set(1,i);
                    length=calc_length;
                    };
                };
            };

            //Insert the current node
            createTree(root,prefixXor.get(i),i);
        };

        start_end_index.set(0,start_end_index.get(0)+1);
        start_end_index.set(1,start_end_index.get(1)+1);
        return start_end_index;
    };
};








