/**
 * 51. N-Queens (Hard)

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:
1 <= n <= 9


prob guidance : https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51_NQueens {
	public static void main(String[] args) {
		
		System.out.println(solveNQueens(4));
	
	}
	
	
	public static List<List<String>> solveNQueens(int n) {
		//create n*n board 
		char[][] board = new char[n][n]; 
		for(int i=0; i<n; i++) Arrays.fill(board[i], '.');
		
		List<List<String>> res = new ArrayList<>(); 
 		//recursion(0, board, res);
		int[] rowCheck = new int[n]; 
		int[] upperDiagonalCheck = new int[2*n -1];
		int[] lowerDiagonalCheck = new int[2*n -1];	
		recursionByDiagonalLogic(0, board, res, rowCheck, upperDiagonalCheck, lowerDiagonalCheck);
		
 		return res;
    }
	
	public static void recursion(int col, char[][] board, List<List<String>> res) {
		//base 
		if(col == board.length) {
			res.add(convert(board)); 
			return; 
		}
		
		
		for(int row=0; row<board.length; row++) {
			if(isSafeToPlace(board, row, col)) {
				board[row][col] = 'Q'; 
				recursion(col+1, board, res);
				
				//back track 
				board[row][col] = '.'; 
			}
		}
		
	}
	
	
	public static boolean isSafeToPlace(char[][] board, int row, int col) {
		 int dupRow = row; 
		 int dupCol = col; 
		 
		 //form current cell to back upper diagonal
		 for(; dupRow>=0 && dupCol>=0; ) {
			 if(board[dupRow][dupCol] == 'Q') return false; 
			 dupRow--;
			 dupCol--; 
		 }
		 
		 
		 dupRow = row; 
		 dupCol = col;
		 //from current cell to back down diagonal 
		 for(; dupRow<=board.length-1 && dupCol>=0; ) {
			 if(board[dupRow][dupCol] == 'Q') return false;
			 dupRow++; 
			 dupCol--;
		 }
		 
		 
		//check backward 
		 for(int i=col; i>=0; i--) {
			 if(board[row][i] == 'Q') return false;
		 }
		 
		 return true;
	}
	
	public static List<String> convert(char[][] board){
		List<String> list = new ArrayList<>(); 
		for(int i=0; i<board.length; i++) list.add(new String(board[i]));
		return list;
	}
	
	
	//this is optimized one 
	public static void recursionByDiagonalLogic(int col, 
													char[][] board, 
													List<List<String>> res,
													int[] rowCheck, 
													int[] upperDiagonalCheck, 
													int[] lowerDiagonalCheck){
		
		//base 
		if(col == board.length) {
			res.add(convert(board)); 
			return;
		}
		
		
		//place Q in possible rows for the given col 
		// note :   board.length-1 + col-row  for back upper diagonal , 
		//			col+row for back lower diagonal 
		for(int row=0; row<board.length; row++){
			if(rowCheck[row] == 0 
					&& upperDiagonalCheck[board.length-1 + col-row] == 0 
					&& lowerDiagonalCheck[col+row] == 0) {
		
				board[row][col] = 'Q';
				rowCheck[row] = 1; 
				upperDiagonalCheck[board.length-1 + col-row] = 1;
				lowerDiagonalCheck[col+row] = 1;
				recursionByDiagonalLogic(col+1, board, res, rowCheck, upperDiagonalCheck, lowerDiagonalCheck);
				
				//backtrack 
				board[row][col] = '.';
				rowCheck[row] = 0; 
				upperDiagonalCheck[board.length-1 + col-row] = 0;
				lowerDiagonalCheck[col+row] = 0;
				
			}
		}
	}


}



 









