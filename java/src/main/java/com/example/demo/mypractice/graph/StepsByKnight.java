/**
 * Given a square chessboard of size (n x n), the initial position and target postion of Knight are given.
 * Find out the minimum steps a Knight will take to reach the target position.

Note: The initial and the target position coordinates of Knight have been given according to 1-base indexing.

Examples:
Input: n = 3, knightPos[] = [3, 3], targetPos[]= [1, 2]
Output: 1
Explanation:
Knight takes 1 step to reach from 
(3, 3) to (1 ,2).

Input: n = 6, knightPos[] = [4, 5],targetPos[] = [1, 1]
Output: 3
Explanation:
Knight takes 3 step to reach from 
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).

Constraints:
1 <= n<= 1000
1 <= knightpos ≤ [x, y], targertpos[x, y] ≤  n 
 */


package com.example.demo.mypractice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {

	public static void main(String[] args) {
		 int n = 6, knightPos[] = {4, 5}, targetPos[]= {1, 1};
		 
		 System.out.println( minStepToReachTarget(knightPos, targetPos, n) );
	}

	public static int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        //make 0-based 
		knightPos[0] = knightPos[0]-1; knightPos[1] = knightPos[1]-1; 
		targetPos[0] = targetPos[0]-1; targetPos[1] = targetPos[1]-1;
		
		int[][] visited = new int[n][n];
		int[][] distance = new int[n][n];
		int[] moveI = {-2, -2, 2, 2, -1, 1, -1, 1};
		int[] moveJ = {-1, 1, -1, 1, -2, -2, 2, 2};
		Queue<int[]> que = new LinkedList<>();
		que.add(knightPos);
		visited[knightPos[0]][knightPos[1]] = 1;
		distance[knightPos[0]][knightPos[1]] = 0;
		int result = Integer.MIN_VALUE;
		//simple BFS
		while(!que.isEmpty()) {
			int[] curPosi = que.poll();
			int curI = curPosi[0], curJ = curPosi[1];
			int curDistance = distance[curI][curJ];
			//move knight from the current position all 8 places 
			for(int idx=0; idx<moveI.length; idx++) {
				int neighborI = curI+moveI[idx], neighborJ = curJ+moveJ[idx];
				if( (neighborI>=0 && neighborI<n && neighborJ>=0 && neighborJ<n) &&  
						visited[neighborI][neighborJ] == 0) {
					que.add(new int[] {neighborI, neighborJ});
					visited[neighborI][neighborJ] = 1;
					distance[neighborI][neighborJ] = curDistance + 1;
				}	
			}
			if(visited[targetPos[0]][targetPos[1]] == 1) {
				result = distance[targetPos[0]][targetPos[1]];
				break;
			}
		}
        
		return result;
    }
	
}
