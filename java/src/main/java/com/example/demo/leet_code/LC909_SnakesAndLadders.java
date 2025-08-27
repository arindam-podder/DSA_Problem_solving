/**
 * 909. Snakes and Ladders

You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style 
starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, 
regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or 
ladder is board[r][c]. Squares 1 and n2 are not the starting points of any snake or ladder.

Note that you only take a snake or ladder at most once per dice roll. If the destination to a snake or ladder is the 
start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the
 ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of dice rolls required to reach the square n2. If it is not possible to reach the square, 
return -1.

 

Example 1:
Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.

Example 2:
Input: board = [[-1,-1],[-1,3]]
Output: 1
 

Constraints:
n == board.length == board[i].length
2 <= n <= 20
board[i][j] is either -1 or in the range [1, n2].
The squares labeled 1 and n2 are not the starting points of any snake or ladder.
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC909_SnakesAndLadders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},
		         {-1,15,-1,-1,-1,-1}};
		
		System.out.println( snakesAndLadders1(board) );

	}
	
	public static int snakesAndLadders1(int[][] board) {
        int n = board.length;       // total = n * n
        if(n*n <= 7) return 1;
        Map<Integer, int[]> valueCellMap = valueCellMap(n);
        List<List<Integer>> graph = getGraph(board, valueCellMap);
        int[] visited = new int[n*n+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = 1;
        int level = 0;
        while(!que.isEmpty()){
            level += 1;
            int curSize = que.size();
            for(int i=0; i<curSize; i++){
                int node = que.poll();
                for(int neighbour: graph.get(node)){
                    if(neighbour == n*n) {
                        return level;
                    }
                    if( visited[neighbour] == 0) {
                        visited[neighbour] = 1;
                        que.add(neighbour);
                    }
                }
            }

        }
        return -1;
    }


    public static List<List<Integer>> getGraph(int[][] board, Map<Integer, int[]> valueCellMap){
        int n = board.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=valueCellMap.size(); i++ ){
            graph.add(new ArrayList<>());
        }
        for(int node=1; node<=valueCellMap.size(); node++){
            for(int dice=1; dice<=6; dice++){
                int neighbour = node + dice;
                if(neighbour <= n*n) {
                    int[] nextMoveCell = valueCellMap.get(neighbour);
                    if (nextMoveCell[0] >= 0 && nextMoveCell[0] < n && nextMoveCell[1] >= 0 && nextMoveCell[1] < n) {
                        graph.get(node).add(board[nextMoveCell[0]][nextMoveCell[1]] == -1 ? neighbour: board[nextMoveCell[0]][nextMoveCell[1]]);
                    }
                }
            }
        }
        return graph;
    }


    //this is for Boustrophedon style
    public static Map<Integer, int[]> valueCellMap(int n){
        int value = 1;
        int line = 0;
        Map<Integer, int[]> valueCell = new HashMap<>();
        for(int row = n-1; row>=0; row--){
            if(line%2 == 0){
                for(int col=0; col<n; col++){
                    valueCell.put(value, new int[]{row, col});
                    value += 1;
                }
            }else{
                for(int col=n-1; col>=0; col--){
                    valueCell.put(value, new int[]{row, col});
                    value += 1;
                }
            }
            line += 1;
        }
        return valueCell;
    }

	

}
