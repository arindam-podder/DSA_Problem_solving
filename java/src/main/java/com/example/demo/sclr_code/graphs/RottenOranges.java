/*
 * Q5. Rotten Oranges (Day 94 - Advanced DSA : Graphs 4: Floyd Warshall Algorithm & Graph Coloring -- Wed, 1 Nov 2023)

Problem Description
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
Each cell can have three values:
The value 0 representing an empty cell.
The value 1 representing a fresh orange.
The value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. 
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

Problem Constraints
1 <= N, M <= 1000
0 <= A[i][j] <= 2

Input Format
The first argument given is the integer matrix A.

Output Format
Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.

Example Input
Input 1:
A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
Input 2:
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]

Example Output
Output 1:
 4
Output 2:
 -1

Example Explanation
Explanation 1:
Minute 0: [ [2, 1, 1]
            [1, 1, 0]
            [0, 1, 1] ]
Minute 1: [ [2, 2, 1]
            [2, 1, 0]
            [0, 1, 1] ]
Minute 2: [ [2, 2, 2]
            [2, 2, 0]
            [0, 1, 1] ]
Minute 3: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 1] ]
Minute 4: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 2] ]
At Minute 4, all the oranges are rotten.
Explanation 2:
The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.

 */

package com.example.demo.sclr_code.graphs;

import java.util.LinkedList;

public class RottenOranges {
	public static void main(String[] args) {
		int[][] A = {	{2, 1, 1},
		        		{0, 1, 1},
		        		{1, 0, 1},   
					};
		
		System.out.println(timeRequiredToRotten(A));
	}

	public static int timeRequiredToRotten(int[][] A) {
		LinkedList<int[]> que = new LinkedList<>();
		//traverse A matrix , add all rotten orange index(i,j) into que 
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				if(A[i][j] == 2) {
					que.add(new int[] {i,j});
				}
			}
		}
		
		int[] row = {-1, 1, 0,  0};		//top down right left
		int[] col = { 0, 0, 1, -1};
		int minute = 0 ; 
		while(!que.isEmpty()) {
			int curQSize = que.size();
			boolean rottenAnyFresh = false;
			for(int q=0; q<curQSize; q++) {
				int[] rotten = que.poll();
				//move all direction from rotten
				for(int i=0; i<row.length; i++) {
					int[] idx = {rotten[0]+row[i], rotten[1]+col[i] };
					if(idx[0]>=0 && idx[0]<A.length && idx[1]>=0 && idx[1]<A[0].length && A[idx[0]][idx[1]]!=0 && A[idx[0]][idx[1]]!=2) {
						A[idx[0]][idx[1]] = 2;
						que.add(idx);
						rottenAnyFresh = true;
					}				
				}
			}
			if(rottenAnyFresh) minute +=1;
		}
		
		//if any 1 present in A , then return -1
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				if(A[i][j] == 1) {
					return -1;
				}
			}
		}
		return minute; 
		
	}//method end
	
}











