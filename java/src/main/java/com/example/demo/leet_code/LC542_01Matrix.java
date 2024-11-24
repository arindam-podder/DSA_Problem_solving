/**
 * 542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
 */




package com.example.demo.leet_code;

import java.util.LinkedList;
import java.util.Queue;

public class LC542_01Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//perform level order technique
	public static int[][] updateMatrix(int[][] mat) {
		int[][] visited = new int[mat.length][mat[0].length];
		Queue<Node> que = new LinkedList<>();
		//get all node with zero
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(mat[i][j] == 0) {
					visited[i][j] = 1; 
					que.add(new Node(i, j));
				}
			}
		}
		
		
		int level = -1;
		//BFS - maintain level
		while(!que.isEmpty()) {
			level += 1; 
			int curQueSize = que.size();
			for(int i=0; i<curQueSize; i++) {
				Node node = que.poll(); 
				//update mat by specifying the distance(nothing but the current level)
				mat[node.i][node.j] = level; 
				
				//top check 
				if(node.i != 0 
						&& visited[node.i-1][node.j] != 1
						&& mat[node.i-1][node.j] ==1) {
					visited[node.i-1][node.j] = 1; 
					que.add(new Node(node.i-1, node.j));
				}
				//down check 
				if(node.i != mat.length-1 
						&& visited[node.i+1][node.j] != 1
						&& mat[node.i+1][node.j] ==1) {
					visited[node.i+1][node.j] = 1; 
					que.add(new Node(node.i+1, node.j));
				}
				
				
				//left chek 
				if(node.j != 0
						&& visited[node.i][node.j-1] != 1
						&& mat[node.i][node.j-1] ==1) {
					visited[node.i][node.j-1] = 1; 
					que.add(new Node(node.i, node.j-1));
				}
				//right check 
				if(node.j != mat[0].length-1
						&& visited[node.i][node.j+1] != 1
						&& mat[node.i][node.j+1] ==1) {
					visited[node.i][node.j+1] = 1; 
					que.add(new Node(node.i, node.j+1));
				}
				
			}
		}//while end
		
		return mat;
    }
	
	
	static class Node{
		int i; 
		int j;
		public Node(int i, int j) {
			this.i = i; 
			this.j = j;
		}
	}
}


