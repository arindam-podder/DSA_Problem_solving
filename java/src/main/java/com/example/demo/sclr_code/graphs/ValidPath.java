/*
 * Q1. Valid Path (Day 90 - Advanced DSA : Graphs 1: Introduction with BFS & DFS -- Wed, 25 Oct 2023)

Problem Description
There is a rectangle with left bottom as (0, 0) and right up as (x, y).
There are N circles such that their centers are inside the rectangle.
Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching 
any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.

Problem Constraints
0 <= x , y, R <= 100
1 <= N <= 1000

Center of each circle would lie within the grid


Input Format
1st argument given is an Integer x , denoted by A in input.

2nd argument given is an Integer y, denoted by B in input.

3rd argument given is an Integer N, number of circles, denoted by C in input.

4th argument given is an Integer R, radius of each circle, denoted by D in input.

5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle

6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle



Output Format
Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).



Example Input
Input 1:

 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]
Input 2:

 x = 3
 y = 3
 N = 1
 R = 1
 A = [0]
 B = [3]

Example Output
Output 1:
 NO
Output 2:
 YES

Example Explanation
Explanation 1:
 There is NO valid path in this case
Explanation 2:
 There is many valid paths in this case.
 One of the path is (0, 0) -> (1, 0) -> (2, 0) -> (3, 0) -> (3, 1) -> (3, 2) -> (3, 3).
 */


package com.example.demo.sclr_code.graphs;

import java.util.ArrayList;

public class ValidPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class SolutionValidPath {
    int[] x = {-1, 0, 1, 0, -1, 1, -1, 1};
    int[] y = {0, -1, 0, 1, -1, 1, 1, -1};
    boolean[][] vis;
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        vis = new boolean[A+1][B+1];
        dfs(0,0,A,B,D,E,F);
        return vis[A][B] ? "YES" : "NO";
    }

    private void dfs(int i, int j, int A, int B, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        if(!isValid(i,j,A,B,D,E,F)) return;
        vis[i][j] = true;
        if(i==A && j==B) return;
        for(int k=0; k<8; k++) {
            int xx = i+x[k];
            int yy = j+y[k];
            dfs(xx,yy,A,B,D,E,F);
        }
    }

    private boolean isValid(int i, int j, int A, int B, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        if(i<0 || j<0 || i>A || j>B || vis[i][j]) return false;
        for(int k=0; k<E.size(); k++) {
            int dist = ((i-E.get(k)) * (i-E.get(k))) + ((j-F.get(k)) * (j-F.get(k)));
            if(dist<=(D*D)) return false;
        }
        return true;
    }
}
